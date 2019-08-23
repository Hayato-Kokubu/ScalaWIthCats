import cats.Foldable

import cats.syntax.option._

object Main extends App {

  val ints = List(1,2,3)
  val noInt = List.empty[Int]

  import cats.instances.list._ // for Foldable[List].apply
  val resInts = Foldable[List].foldLeft(ints, 0)(_ + _)
  println(resInts)
  val resNoInt = Foldable[List].foldLeft(noInt, 0)(_ + _)
  println(resNoInt)


  import cats.instances.option._
  val maybeInt = Option(123)
  val noneInt = none[Int]
  val resOpt = Foldable[Option].foldLeft(maybeInt, 10)(_ * _)
  val resNone = Foldable[Option].foldLeft(noneInt, 10)(_ * _)
  println(resOpt)
  println(resNone)
}
