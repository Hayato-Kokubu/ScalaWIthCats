import scala.language.higherKinds
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import cats.Applicative
import cats.instances.future._
import cats.syntax.applicative._
import cats.syntax.apply._




object Main extends App {

  val hostnames = List(
    "alpha.example.com",
    "beta.example.com",
    "gamma.demo.com"
  )

  def getUptime(hostname: String): Future[Int] =
    Future(hostname.length * 60) // just for demonstration

  val totalUptime = listTraverse(hostnames)(getUptime)

  // 3 seconds だと よくわからないエラーとなる。。。
  Await.result(totalUptime, 3.seconds)
  println(totalUptime)


  def listTraverse[F[_]: Applicative, A, B]
  (list: List[A])(func: A => F[B]): F[List[B]] =
    list.foldLeft(List.empty[B].pure[F]) { (accum, item) =>
      (accum, func(item)).mapN(_ :+ _)
    }

  def listSequence[F[_]: Applicative, B]
  (list: List[F[B]]): F[List[B]] =
    listTraverse(list)(identity)
}
