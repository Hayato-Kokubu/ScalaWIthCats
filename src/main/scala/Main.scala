import cats.Functor

import cats.instances.option._

import cats.syntax.option._

object Main extends App{

  val func: Int => Int = x => x + 1

  val liftedFunc = Functor[Option].lift(func)

  val r1 = liftedFunc(3.some)
  val r2 = liftedFunc(none)

  println(r1)
  println(r2)

}