import cats.Semigroupal
import cats.instances.either._ // for SemiGroupal[Either]

object Main extends App {
  type ErrorOr[A] = Either[Vector[String], A]

  val a =
    Semigroupal[ErrorOr].product(
      Right("hello!"),
      Left(Vector("Error 1"))
    )
  println(a)
}
