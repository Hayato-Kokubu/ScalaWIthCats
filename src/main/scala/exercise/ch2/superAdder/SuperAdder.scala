package exercise.ch2.superAdder

import cats.Monoid

import cats.instances.int._
import cats.syntax.semigroup._

class SuperAdder {
  def add(items: List[Int]): Int =
    items.foldLeft(0){case (res, acc) =>
      res |+| acc
  }
}
