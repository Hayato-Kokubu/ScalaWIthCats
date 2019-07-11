import cats.Eq
import cats.instances.int._  // Eq[Int]で Eq[Int]が必要
import cats.syntax.eq._  // to use === or =!=
import cats.instances.option._

object Main extends App{

//  val t1 = Some(1) === None // None がOption[Int]だと見なされない
  val t2 = (Some(1) : Option[Int]) === (None : Option[Int])
  val t3 = Option(1) === Option.empty[Int] // left side: not Some , right side: empty method で型を入れられる

  // Optionの復習
  val o1 = Option(null) // null はNullのinstance なので、型はOption[Null]
  val o2 = Option(1) // Some[Int]

  val nullStr: String  = null // String のインスタンスにnull を格納
  val o3 = Option(nullStr) //
  val o4 = Option(None)    // Option[None.type]
  val o5 = Option(Some(1)) // Some はclass なので、Option[Some] となる
  val o6 = Option() // Option[Unit]


  println(o1)
  println(o2)
  println(o3)


}