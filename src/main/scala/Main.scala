import cats.Eq
import cats.instances.int._  // Eq[Int]で Eq[Int]が必要
import cats.syntax.eq._  // to use === or =!=
import cats.instances.option._
import cats.syntax.option._

object Main extends App{

//  val t1 = Some(1) === None // None がOption[Int]だと見なされない
  val t2 = (Some(1) : Option[Int]) === (None : Option[Int])
  val t3 = Option(1) === Option.empty[Int] // left side: not Some , right side: empty method で型を入れられる

  val b1 = 1.some === none[Int]
  val b2 = 1.some =!= none[Int]

  println(b1)
  println(b2)

}