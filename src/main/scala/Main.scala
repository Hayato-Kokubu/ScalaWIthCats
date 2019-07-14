import cats.instances.function._
import cats.syntax.functor._

object Main extends App{

  val func1 = (a: Int) => a + 1
  val func2 = (a: Int) => a * 2
  val func3 = (a: Int) => a + "!"

  val func4 = func1.map(func2).map(func3)

  val func5 = func1.andThen(func2).andThen(func3)

  val res1 = func4(10)
  val res2 = func5(10)
  println(res1)
  println(res2)
}