import cats.Eq
import cats.instances.int._  // Eq[Int]で Eq[Int]が必要
import cats.syntax.eq._  // to use === or =!=

object Main extends App{

  val t1 = 123 === 123
  val t2 = 123 =!= 234


  println(t1)
  println(t2)


}