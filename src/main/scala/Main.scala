import cats.syntax.validated._

object Main extends App {
  val a = 123.valid.map(_ * 100)
  val b = "?".invalid.leftMap(_.toString) // toString 意味ある？
  println(b)
  val b_ = "?".invalid
    println(b_)


  val c = 123.valid[String].ensure("Negative")(_ > 0)
  println(c)
  val c1 = (-123).valid[String].ensure("Negative")(_ > 0)
  println(c1)

}
