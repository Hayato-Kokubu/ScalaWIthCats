import exercise.ch2.superAdder.{Order, SuperAdder}
import exercise.ch2.superAdder.OrderImplicits._
import cats.instances.int._
import cats.instances.option._

import cats.syntax.option._

object Main extends App{


  val resultInt = new SuperAdder().add(List(1,2,3))
  val resultOptionInt = new SuperAdder().add(List(1.some,2.some,3.some, none))
  val resultOrder = new SuperAdder().add(List(Order(1.5d, 2.0d), Order(0.1d, 10.3d),Order(0d, 0d)))

  println(resultInt)
  println(resultOptionInt)

}