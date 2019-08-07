import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object Main extends App {

  def slowly[A](body: => A) =
    try body finally Thread.sleep(100)

  def factorial(n: Int): Int = {
    val ans = slowly(if(n == 0) 1 else n * factorial(n - 1))
    println(s"fact $n $ans")
    ans
  }

  val res =
    Await.result(
      Future.sequence(
        Vector(
          Future(factorial(3)),
          Future(factorial(3))
        )
      ),
      5.seconds
    )

  println(res)

}


