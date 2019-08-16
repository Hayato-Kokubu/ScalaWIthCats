import cats.Semigroupal
import cats.data.Validated
import cats.instances.list._ // ないとエラーは検知してくれないが、Validated の色が変わる
import cats.instances.either._

object Main extends App {

  type AllErrorsOr[A] = Validated[List[String], A]

  val a =
    Semigroupal[AllErrorsOr].product(
      Validated.invalid(List("Error 1")),
      Validated.invalid(List("Error 2"))
  )

  println(a)

  type ErrorsOr[A] = Either[List[String], A]

  val b =
    Semigroupal[ErrorsOr].product(
      Left(List("Error 1")),
      Left(List("Error 2"))
    )

  println(b)

}
