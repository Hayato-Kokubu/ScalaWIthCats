import scala.language.higherKinds

import cats.Functor

import cats.instances.int._
import cats.instances.int._
import cats.instances.list._

import BoxImplicits._

object Main extends App{

  val intFunctor = implicitly[Functor[List]]

  val box = Box[Int](123)

  box.map(value => value + 1)

  val i = implicitly[Functor[Box[Int]]]
}

final case class Box[X](value: X){
//  implicit class FunctorOps(src: Box[X]) extends Functor[Box]{
//    override def map[A, B](fa: Box[A])(f: A => B): Box[B] = Box(f(fa.value))
//  }
}

object BoxImplicits {
  implicit class FunctorOps[A](src: Box[A]) extends Functor[Box]{
    override def map[A, B](fa: Box[A])(f: A => B): Box[B] = Box(f(fa.value))
  }
}

//object BoxImplicits {
//  implicit def boxFunctor[A]: Functor[Box] = {
//    new Functor[Box]{
//      def map[B](fa: Box[A])(f: A => B): Box[B] ={
//        val Box(a) = fa
//        Box(f(a))
//      }
//    }
//  }
//}
