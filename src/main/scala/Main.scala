import cats.Semigroupal
import cats.instances.future._
import cats.syntax.apply._ // for mapN

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object Main extends App {

  val futurePair = Semigroupal[Future].
    product(Future("Hello"), Future(123))

  println(futurePair)

  Await.result(futurePair, 1.second)
  println(futurePair)


  val futureCat = (
    Future{println("futureCat Name"); Thread.sleep(3000) ; "Garfield"},//("Garfield"),
    Future{println("futureCat birth"); Thread.sleep(2000) ; 1978},//(1978),
    Future{println("futureCat food "); Thread.sleep(1000) ; List("Lasagne")}//(List("Lasagne"))
  ).mapN(Cat.apply)

  println(futureCat)

  Await.result(futureCat, 3.second)
  println(futureCat)


}

case class Cat(
  name: String,
  yearOfBirth: Int,
  favoriteFoods: List[String]
)