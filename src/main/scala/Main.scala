import cats.data.Validated
import cats.syntax.validated._

object Main extends App {
  val v = Validated.Valid(123)
  val i = Validated.Invalid(List("Badness"))

  println(v)
  println(i)


  val v2 = 123.valid[List[String]]
  val i2 = List("Badness").invalid[Int]

  println(v)
  println(i)
}
