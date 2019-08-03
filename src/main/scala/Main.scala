import scala.language.higherKinds
import Implicits._


import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success, Try}


object Main extends App {

  val mOp = implicitly[Monad[Option]]
  val mFut = implicitly[Monad[Future]]

  val futureOption1 = mFut.pure( mOp.pure(1) )
  val futureOption2 = mFut.pure( mOp.pure(2) )



   // compile error
  val resX =
    for {
      opt1 <- futureOption1
      n1 <- opt1
      opt2 <- futureOption2
      n2 <- opt2
    } yield n1 + n2

  // 二重for式つらみ
  val res = for{
    opt1 <- futureOption1
    opt2 <- futureOption2
    res = for{
      n1 <- opt1
      n2 <- opt2
    } yield n1 + n2
  } yield res

  println(res)
}



// map は、pure と flatMap から作成可能
trait Monad[F[_]] {
  def pure[A](a: A): F[A]

  def flatMap[A,B](fa: F[A])(f: A => F[B]): F[B]
}

object Implicits {

  implicit val optionMonad: Monad[Option] = {
    new Monad[Option]{
      def pure[A](a: A): Option[A] = Option(a)

      def flatMap[A,B](fa: Option[A])(f: A => Option[B]): Option[B] = {
        fa match {
          case Some(a) => f(a)
          case None => None
//          case Option.empty[A] => Option.empty[B]
        }
      }
    }
  }

  type MyEither[T] = Either[Error,T]
  implicit val eitherMonad: Monad[MyEither] = {
    new Monad[MyEither]{
      def pure[A](a: A): MyEither[A] = Right(a)

      def flatMap[A,B](fa: MyEither[A])(f: A => MyEither[B]): MyEither[B] ={
        fa match {
          case Right(a) => f(a)
          case Left(e)  => Left(e)
        }
      }
    }
  }

  implicit val futureMonad: Monad[Future] ={
    new Monad[Future] {
      def pure[A](a: A): Future[A] = Future(a)

      // Future のflatMap実装そのまま
      def flatMap[A,B](fa: Future[A])(f: A => Future[B]): Future[B] = {
        fa.transformWith{
          case Success(a) => f(a)
          case Failure(e) => Future.failed[B](e)
        }
      }
    }
  }

}