import cats.instances.string._
import cats.syntax.semigroup._

object Main extends App{
  //Monoid[String].combine("hoge", "fuga")
  val m1 =  "hoge" |+| "fuga"

  println(m1)


}