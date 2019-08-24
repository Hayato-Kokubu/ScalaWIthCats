import scala.language.higherKinds

import cats.Applicative
import cats.syntax.applicative._
import cats.syntax.apply._
import cats.instances.vector._
import cats.instances.option._

import cats.data.Validated
import cats.instances.list._

object Main extends App {

  val listVecs = List(Vector(1, 2), Vector(3, 4))
  val res1 = listSequence(listVecs)

  println(res1)
  // Vector(List(1, 3), List(1, 4), List(2, 3), List(2, 4)) ???

  val listVecs2 = List(Vector(1, 2), Vector(3, 4), Vector(5, 6))
  val res2 = listSequence(listVecs2)
  println(res2)


  def process(inputs: List[Int]):Option[List[Int]] =
    listTraverse(inputs)(n => if(n % 2 == 0) Some(n) else None)

  val o1 = process(List(2, 4, 6))
  println(s"o1 = $o1")
  val o2 = process(List(1, 2, 3))
  println(s"o2 = $o2")

  type ErrorsOr[A] = Validated[List[String], A]

  def process2(inputs: List[Int]): ErrorsOr[List[Int]] =
    listTraverse(inputs) { n =>
      if(n % 2 == 0) {
        Validated.valid(n)
      } else {
        Validated.invalid(List(s"$n is not even"))
      }
    }

  val ov1 = process2(List(2, 4, 6))
  println(s"o1 = $ov1")
  val ov2 = process2(List(1, 2, 3))
  println(s"o2 = $ov2")


  def listTraverse[F[_]: Applicative, A, B]
  (list: List[A])(func: A => F[B]): F[List[B]] =
    list.foldLeft(List.empty[B].pure[F]) { (accum, item) =>
      (accum, func(item)).mapN(_ :+ _)
    }

  def listSequence[F[_]: Applicative, B]
  (list: List[F[B]]): F[List[B]] =
    listTraverse(list)(identity) // identity(x:A):A = x




}
