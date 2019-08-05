import scala.language.higherKinds

import cats.Monad


object Main extends App {

  val leaf = Tree.leaf(1)
  println(leaf)

  val branch1 = Tree.branch(Tree.leaf(2), Tree.leaf(3))
  println(branch1)

  val branch2 = Tree.branch(Tree.leaf(4), Tree.leaf(5))
  println(branch2)

  val branch3 = Tree.branch(branch1, branch2)
  println(branch3)

}



sealed trait Tree[+A]
// branch doesn't have value
final case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]
final case class Leaf[A](value: A) extends Tree[A]

object Tree{
  def branch[A](left: Tree[A], right: Tree[A]): Tree[A] = Branch(left, right)
  def leaf[A](value: A): Tree[A] = Leaf(value)
}

object Implicits {
  implicit def treeMonad = {
    new Monad[Tree]{
      def pure[A](a: A): Tree[A] = Tree.leaf(a)
      def flatMap[A,B](tree: Tree[A])(f: A => Tree[B]): Tree[B] = {
        tree match {
          case Leaf(a) => f(a)
          case Branch(left, right) => Branch( this.flatMap(left)(f), this.flatMap(right)(f))
        }
      }
    }
  }
}
