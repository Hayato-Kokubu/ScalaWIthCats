import cats.Monoid
import cats.instances.string._
import cats.instances.int._
import cats.instances.option._
import cats.syntax.option._

object Main extends App{
  val m1 = Monoid[String].combine("hoge", "fuga")
  println(m1)

  val m2 = Monoid[Int].combine(20, 30)
  println(m2)

  val m3 = Monoid[Option[Int]].combine(3.some , 10.some)

}