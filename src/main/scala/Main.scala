import scala.concurrent._
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global


object Main extends App {

  val hostnames = List(
    "alpha.example.com",
    "beta.example.com",
    "gamma.demo.com"
  )

  def getUptime(hostname: String): Future[Int] =
    Future(hostname.length * 60) // just for demonstration

  // expected Future[List[Int]] but get List[Future[Int]]
//  val myUptimes: Future[List[Int]] =
//    hostnames.map(getUptime)

  // 途中結果のFutureを毎回剥がして結果をFutureで包むのがよくない
  val allUptimes: Future[List[Int]] =
    hostnames.foldLeft(Future(List.empty[Int])) {
      (accum, host) =>
        val uptime = getUptime(host)
        for {
          accum  <- accum
          uptime <- uptime
        } yield accum :+ uptime
    }

  val res2 = Await.result(allUptimes, 1.second)
  // res2: List[Int] = List(1020, 960, 840)

  println(res2)


  // CanBuildFrom はよくわからんが使えてる。。。
  val allUptimes2: Future[List[Int]] =
    Future.traverse(hostnames)(getUptime)

}
