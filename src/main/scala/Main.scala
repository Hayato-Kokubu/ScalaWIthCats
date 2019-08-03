import scala.language.higherKinds
import cats.instances.option._
import cats.instances.future._
import cats.syntax.applicative._


import scala.concurrent.Future // for pure
import scala.concurrent.ExecutionContext.Implicits.global

object Main extends App {


  // use import cats.syntax.applicative._
  // use import cats.instances.option._
  val futureOption1 = 2.pure[Option].pure[Future]
  val futureOption2 = 3.pure[Option].pure[Future]

  val res =
    for{
      opt1 <- futureOption1
      opt2 <- futureOption2
    } yield {
      for{
        n1 <- opt1
        n2 <- opt2
      }yield n1 + n2
    }

  Thread.sleep(100)
  println(res)
}



