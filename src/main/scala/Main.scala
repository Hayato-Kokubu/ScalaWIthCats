import scala.language.higherKinds
import cats.Monad
import cats.syntax.functor._
import cats.syntax.flatMap._
import cats.syntax.applicative._
import cats.instances.option._
import cats.instances.list._
import cats.instances.future._
import scala.concurrent.ExecutionContext.Implicits.global

import scala.concurrent.Future


object Main extends App {
  def sumSquare[F[_]: Monad](a: F[Int], b: F[Int]): F[Int] =
    for {
      x <- a
      y <- b
    } yield x*x + y*y

//  val optx = 2.pure[Option]
//  val opty = 3.pure[Option]
//
//  val optRes = sumSquare[Option](optx, opty)
//  println(optRes)

//  val listx = 2.pure[List]
//  val listy = 3.pure[List]
//
//  val listRes = sumSquare(listx, listy)
//  println(listRes)


//  val futx = 2.pure[Future]
//  val futy = 3.pure[Future]
//
//  val futRes = sumSquare(futx, futy)
//  println(futRes)
//  Thread.sleep(100L)
//  println(futRes)


    // no type parameter と怒られる。。。
//    val idRes = sumSquare(2, 3)
//    println(idRes)

}
