import cats.Eq
import cats.instances.int._  // Eq[Int]で Eq[Int]が必要


object Main extends App{
  val eqInt = Eq[Int]


  val t1 = eqInt.eqv(123, 123)
  val t2 = eqInt.eqv(123, 234)
//  val t3 = eqInt.eqv(123, "234") // compile error

  println(t1)
  println(t2)


}