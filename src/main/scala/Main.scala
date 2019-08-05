import cats.data.EitherT
import cats.instances.future._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global


object Main extends App {

  type Response[A] = EitherT[Future,String,A]

  def getPowerLevel(ally: String): Response[Int] = {
    powerLevels.get(ally) match {
      case Some(avg) => EitherT.right(Future(avg))
      case None      => EitherT.left(Future(s"$ally unreachable"))
    }
  }

  def canSpecialMove(ally1: String, ally2: String): Response[Boolean] = {
    for{
      avg1 <- getPowerLevel(ally1)
      avg2 <- getPowerLevel(ally2)
    } yield avg1 + avg2 > 15
  }

  val powerLevels = Map(
    "Jazz"      -> 6,
    "Bumblebee" -> 8,
    "Hot Rod"   -> 10
  )

  val success1 = getPowerLevel("Jazz")
  Thread.sleep(100)
  println(success1)

  val success2 = getPowerLevel("Bumblebee")
  Thread.sleep(100)
  println(success2)

  val success3 = getPowerLevel("Hot Rod")
  Thread.sleep(100)
  println(success3)

  val failure1 = getPowerLevel("xxx")
  Thread.sleep(100)
  println(failure1)


  val temp1 = canSpecialMove("Jazz", "Bumblebee")
  Thread.sleep(100)
  println(temp1)

  val temp2 = canSpecialMove("Jazz", "Hot Rod")
  Thread.sleep(100)
  println(temp2)


  val temp3 = canSpecialMove("Jazz", "xxx")
  Thread.sleep(100)
  println(temp3)
}
