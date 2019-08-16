import cats.data.Validated

import cats.syntax.applicative._
import cats.syntax.applicativeError._

import cats.instances.list._

object Main extends App {
  type ErrorsOr[A] = Validated[List[String], A]

  val v = 123.pure[ErrorsOr]
  val i = List("Badness").raiseError[ErrorsOr, Int]

}
