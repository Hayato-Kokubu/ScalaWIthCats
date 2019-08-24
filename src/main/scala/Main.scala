import scala.concurrent._
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global


import cats.syntax.applicative._
import cats.instances.future._
import cats.syntax.apply._ // use mapN

object Main extends App {

  val hostnames = List(
    "alpha.example.com",
    "beta.example.com",
    "gamma.demo.com"
  )

  def getUptime(hostname: String): Future[Int] =
    Future(hostname.length * 60) // just for demonstration


  List.empty[Int].pure[Future]

  def oldCombine(
    accum : Future[List[Int]],
    host  : String
  ): Future[List[Int]] = {
    val uptime = getUptime(host)
    for {
      accum  <- accum
      uptime <- uptime
    } yield accum :+ uptime
  }

  def newCombine(
    accum: Future[List[Int]],
    host: String
  ): Future[List[Int]] =
    (accum, getUptime(host)).mapN(_ :+ _)
}
