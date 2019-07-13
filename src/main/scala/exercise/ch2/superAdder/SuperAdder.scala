package exercise.ch2.superAdder

import cats.Monoid
import cats.syntax.semigroup._

class SuperAdder {
  def add[A: Monoid](items: List[A]): A =
    items.foldLeft( Monoid[A].empty ){case (res, acc) =>
      res |+| acc
  }
}
