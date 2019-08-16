import cats.data.Validated


object Main extends App {
  val v = Validated.Valid(123)
  val i = Validated.Invalid(List("Badness"))

  println(v)
  println(i)



}
