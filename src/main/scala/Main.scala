import cats.data.State
import exercise.ch4.PostOrderCalculator

object Main extends App {

  val a = PostOrderCalculator.evalOne("42").runA(Nil).value
  println(a)

  val program = for {
    _ <- PostOrderCalculator.evalOne("1")
    _ <- PostOrderCalculator.evalOne("2")
    ans <- PostOrderCalculator.evalOne("+")
  }yield ans
  val res = program.runA(Nil).value
  println(res)

  val program2 = PostOrderCalculator.evalAll(List("1", "2", "+", "3", "*"))
  val res2 = program2.run(Nil).value
  println(res2)

  val program3 = for {
    _   <- PostOrderCalculator.evalAll(List("1", "2", "+"))
    _   <- PostOrderCalculator.evalAll(List("3", "4", "+"))
    ans <- PostOrderCalculator.evalOne("*")
  } yield ans
  val res3 = program3.run(Nil).value
  println(res3)

  val program4 = PostOrderCalculator.evalInput("1 2 + 3 4 + *")
  println(program4)


}
