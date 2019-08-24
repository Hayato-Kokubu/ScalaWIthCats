import cats.Traverse
import cats.instances.list._
import cats.instances.future._

import cats.syntax.traverse._

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object Main extends App {

  val hostnames = List(
    "alpha.example.com",
    "beta.example.com",
    "gamma.demo.com"
  )

  def getUptime(hostname: String): Future[Int] =
    Future(hostname.length * 60) // just for demonstration

  val totalUptime: Future[List[Int]] =
    Traverse[List].traverse(hostnames)(getUptime)

  Await.result(totalUptime, 1.second)

  println(totalUptime)

  val numbers = List(Future(1), Future(2), Future(3))

  val numbers2: Future[List[Int]] =
    Traverse[List].sequence(numbers)

  Await.result(numbers2, 1.second)

  println(numbers2)


  // syntax version of traverse, sequence
  val totalUptime3 =
    Await.result(hostnames.traverse(getUptime), 1.second)

  val numbers3 =
    Await.result(numbers.sequence, 1.second)

  println(totalUptime3)

  println(numbers3)
}
