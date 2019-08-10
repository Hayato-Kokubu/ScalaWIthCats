import cats.Semigroupal
import cats.instances.option._
import cats.syntax.option._

object Main extends App {

  val a = Semigroupal[Option].product(12.some, "abc".some)
  println(a)

  val tuple3 = Semigroupal.tuple3(3.some, "hello".some,2L.some)
  println(tuple3)

  val map3 = Semigroupal.map3(2.some, 4.some, 6.some)(_ + _ * _)
  println(map3)

}

