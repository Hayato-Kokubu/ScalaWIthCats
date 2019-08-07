import cats.data.Writer
import cats.instances.vector._ // for Monoid
import cats.syntax.applicative._ // for pure
import cats.syntax.writer._    // for tell apply, writer など

object Main extends App {

  type Logged[A] = Writer[Vector[String], A]

  val x = 123.pure[Logged]

  val y = Vector("msg1", "msg2", "msg3").tell

  println(x)
  println(y)

  val a = Writer(Vector("msg1", "msg2", "msg3"), 123)
  val b = 123.writer(Vector("msg1", "msg2", "msg3"))

  println(a)
  println(b)

  val aResult: Int = a.value
  val aLog: Vector[String] = a.written

  println(aResult)
  println(aLog)
}


