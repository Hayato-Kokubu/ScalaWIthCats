import cats.data.{EitherT, OptionT}

import scala.language.higherKinds
import cats.instances.either._
import cats.syntax.applicative._
import cats.syntax.either._

object Main extends App {

  type MyEither[A]  = Either[Error, A]
  type MyEitherT[A] = EitherT[Option, Error, A]

  val eitherOpt = OptionT.pure[MyEither](1)

  println(eitherOpt)

  val optEither = swap2(eitherOpt)

  println(optEither)


  def swap1[A](eOpt: MyEitherT[A]): OptionT[MyEither, A] = {
    import cats.instances.option._
    eOpt.value  match {
      case Some(Right(a)) => OptionT[MyEither,A]( a.pure[Option].pure[MyEither])
      case Some(Left(e))  => OptionT[MyEither,A]( e.asLeft[Option[A]])
      case None           => OptionT[MyEither,A]( Option.empty[A].pure[MyEither])
    }
  }

  def swap2[A](optE: OptionT[MyEither,A]): MyEitherT[A] = {
    import cats.instances.option._
    optE.value match {
      case Right(Some(a)) => EitherT[Option,Error,A](a.asRight[Error].pure[Option])
      case Right(None)      => EitherT[Option,Error,A](Option.empty[Either[Error,A]])
      case Left(e)          => EitherT[Option,Error,A](e.asLeft[A].pure[Option])
    }
  }

}



