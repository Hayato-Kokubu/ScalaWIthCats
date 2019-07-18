import cats.Id
import exercise.ch4.MyId

object Main extends App {

  val a = MyId.pure(1)

  println(a)

  val s = MyId.map(a)(_ * 10.0d)

  println(s)
}
