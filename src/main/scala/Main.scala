import exercise.ch2.superAdder.SuperAdder
import cats.instances.int._
import cats.instances.option._

import cats.syntax.option._

object Main extends App{


  val resultInt = new SuperAdder[Int].add(List(1,2,3))
  val resultOptionInt = new SuperAdder[Option[Int]].add(List(1.some,2.some,3.some, none))

  println(resultInt)
  println(resultOptionInt)

}