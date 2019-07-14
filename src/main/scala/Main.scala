import cats.Functor
import scala.language.higherKinds

import cats.syntax.functor._

object Main extends App{

  def doMath[F[_]](start: F[Int])
                  (implicit functor: Functor[F]): F[Int] =
    start.map(n => n + 1 * 2)

  import cats.instances.option._ // for Functor
  import cats.instances.list._   // for Functor

  val o1 = doMath(Option(20))
  // res3: Option[Int] = Some(22)
  println(o1)


  val l1 = doMath(List(1, 2, 3))
  // res4: List[Int] = List(3, 4, 5)
  println(l1)
}