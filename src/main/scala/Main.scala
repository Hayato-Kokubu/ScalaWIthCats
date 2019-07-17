import cats.Monad
import cats.syntax.flatMap._
import cats.syntax.functor._
import scala.language.higherKinds

object Main extends App {

  def sumSquare[F[_]: Monad](a: F[Int], b: F[Int]): F[Int] =
//    a.flatMap(x => b.map(y => x*x + y*y))
  for {
    x <- a
    y <- b
  } yield x * x + y * y


  import cats.instances.option._ // for Monad
  import cats.instances.list._ // for Monad
  val res8 = sumSquare(Option(3), Option(4))
  // res8: Option[Int] = Some(25)
  println(res8)
  val res9 = sumSquare(List(1, 2, 3), List(4, 5))
  // res9: List[Int] = List(17, 26, 20, 29, 25, 34)
  println(res9)

}