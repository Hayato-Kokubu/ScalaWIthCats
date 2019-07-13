package exercise.ch2.superAdder

import cats.Monoid
import cats.syntax.semigroup._
import cats.instances.double._

case class Order(totalCost: Double, quantity: Double)

object OrderImplicits {
  implicit val orderMonoid: Monoid[Order] = new Monoid[Order]{
    def combine(o1: Order, o2: Order): Order =
      Order(o1.totalCost |+| o2.totalCost, o1.quantity |+| o2.quantity)
    val empty = Order(0d, 0d)
  }
}