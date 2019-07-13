package exercise.ch2.superAdder

import cats.Monoid
import cats.syntax.semigroup._

class SuperAdder[A] {
  def add(items: List[A])(implicit m: Monoid[A]): A =
    items.foldLeft( m.empty ){case (res, acc) =>
      res |+| acc
  }
}
