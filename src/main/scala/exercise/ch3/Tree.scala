package exercise.ch3

import cats.Functor

sealed trait Tree[+A]

final case class Branch[A](left: Tree[A], right: Tree[A])
  extends Tree[A]

final case class Leaf[A](value: A) extends Tree[A]


object TreeImplicits {
  implicit def treeFunctor:Functor[Tree] = {
    new Functor[Tree] {
      def map[A,B](fa: Tree[A])(f: A => B): Tree[B] = {
        fa match{
          case Leaf(value) => Leaf(f(value))
          case Branch(left, right) => Branch(this.map(left)(f), this.map(right)(f))
        }
      }
    }
  }
}

object Tree {
  def branch[A](left: Tree[A], right: Tree[A]): Tree[A] =
    Branch(left, right)

  def leaf[A](value: A): Tree[A] =
    Leaf(value)
}