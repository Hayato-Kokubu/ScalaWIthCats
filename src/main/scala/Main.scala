import cats.Semigroupal
import cats.instances.list._

object Main extends App {

  val res = Semigroupal[List].product(List(1,2), List(3,4))
  println(res)
}
