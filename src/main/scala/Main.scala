import cats.instances.function._
import cats.syntax.functor._

object Main extends App{

  val func1: Int => Double =
    (x: Int) => x.toDouble

  val func2: Double => Double =
    (y: Double) => y * 2

  // map が解決されないが、動く
  val res7 = (func1 map func2)(1)     // composition using map
  // res7: Double = 2.0
  println(s"res7 = $res7")

  val res8 = (func1 andThen func2)(1) // composition using andThen
  // res8: Double = 2.0
  println(s"res8 = $res8")

  val res9 = func2(func1(1))          // composition written out by hand
  // res9: Double = 2.0
  println(s"res9 = $res9")

}