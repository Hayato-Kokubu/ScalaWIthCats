import cats.data.Reader

import cats.syntax.applicative._


object Main extends App {
  type DbReader[A] = Reader[Db, A]

  val users = Map(
    1 -> "dade",
    2 -> "kate",
    3 -> "margo"
  )

  val passwords = Map(
    "dade"  -> "zerocool",
    "kate"  -> "acidburn",
    "margo" -> "secret"
  )

  val db = Db(users, passwords)

  val a = checkLogin(1, "zerocool").run(db)
  val b = checkLogin(4, "davinci").run(db)

  println(a)
  println(b)
  println(checkLogin(1, "zerocool"))

  def findUsername(userId: Int): DbReader[Option[String]] =
    Reader[Db, Option[String]](db => db.usernames.get(userId))

  def checkPassword(
    username: String,
    password: String
  ): DbReader[Boolean] = {
    Reader[Db, Boolean] { db =>
      db.passwords.get(username).contains(password)
    }
  }

  def checkLogin(
    userId: Int,
    password: String
  ): DbReader[Boolean] = {
      for {
        username <- findUsername(userId)
        passwordOk <- username.map { username =>
          checkPassword(username, password)
        }.getOrElse {
          false.pure[DbReader]
        }
      } yield passwordOk
    }
  }

case class Db(
  usernames: Map[Int, String],
  passwords: Map[String, String]
)
