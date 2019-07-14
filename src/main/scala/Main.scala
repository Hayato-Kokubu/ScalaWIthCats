import cats.Functor

import cats.instances.list._
import cats.instances.option._

object Main extends App{

  val list1 = List(1, 2, 3)
  // list1: List[Int] = List(1, 2, 3)

  val list2 = Functor[List].map(list1)(_ * 2)
  // need cats.Functor, cats.instances.list._
  // list2: List[Int] = List(2, 4, 6)
  println(list2)

  val option1 = Option(123)
  // option1: Option[Int] = Some(123)

  val option2 = Functor[Option].map(option1)(_.toString + "!")
  // option2: Option[String] = Some(123)
  // need cats.instances.option._
  println(option2)

}