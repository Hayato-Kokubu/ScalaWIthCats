import cats.kernel.Monoid
import cats.instances.string._

object Main extends App{

  val s1 = Monoid[String].combine("hoge", "fuga")
  val s2 = Monoid[String].empty

  println(s1)
  println(s2)
}