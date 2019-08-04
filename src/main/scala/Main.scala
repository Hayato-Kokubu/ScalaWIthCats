import cats.data.OptionT

import scala.language.higherKinds
//import cats.instances.option._
import cats.instances.future._
import cats.syntax.applicative._

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Main extends App {

  // F = Futureであることは、import cats.instances.future._ 内のApplicative で判断
  // ※ cats.instances.option._ をimport すると、F = Option となる
  // implicit探索の順番の話 今回は略
  val futureOpt1 = OptionT.pure(1)
  val futureOpt2 = OptionT.pure(1)

  val res =
    for{
      n1 <- futureOpt1
      n2 <- futureOpt2
    } yield n1 + n2

  Thread.sleep(100)
  println(res)
}



