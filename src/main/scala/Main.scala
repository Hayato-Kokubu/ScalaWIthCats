import cats.Monad
import cats.instances.option._

import scala.concurrent.Future // for Monad

object Main extends App{
  val opt = Monad[Option].flatMap(Option(1))(a => Option(a*2))
  // opt: Option[Int] = Some(2)
  println(opt)



  import cats.instances.list._ // for Monad

  val list = Monad[List].flatMap(List(1, 2, 3))(a => List(a, a*10))
  // list: List[Int] = List(1, 10, 2, 20, 3, 30)
  println(list)

  import cats.instances.vector._ // for Monad


  val vec = Monad[Vector].flatMap(Vector(1, 2, 3))(a => Vector(a, a*10))
  // vec: Vector[Int] = Vector(1, 10, 2, 20, 3, 30)
  println(vec)


  import cats.instances.future._  // <- catsStdInstancesForFuture
  import scala.concurrent.ExecutionContext.Implicits.global // <- EcecutuionContext
  import scala.concurrent._
  import scala.concurrent.duration._


  val fm = Monad[Future]

  val future = fm.flatMap(fm.pure(1))(x => fm.pure(x + 2))

  val res = Await.result(future, 1.second)
  println(res)

}
