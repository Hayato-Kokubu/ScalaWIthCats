import cats.data.State
import State._

object Main extends App {
  val step1 = State[Int,String] { num =>
    val ans = num + 1
    (ans, s"Result of step1: $ans")
  }

  val step2 = State[Int, String] { num =>
    val ans = num * 2
    (ans, s"Result of step2: $ans")
  }

  val both = for {
    a <- step1
    b <- step2
  } yield (a, b)

  val (state, result) = both.run(20).value
  println(s"${(state, result)}")

  println("##################")

  val getDemo = State.get[Int] // State[Int,Int]
  val rGet = getDemo.run(10).value
  println(rGet)

  val setDemo = State.set[Int](30) //State[Int, Unit]
  val rSet = setDemo.run(10).value
  println(rSet)

  val pureDemo = State.pure[Int, String]("Result") //State[Int, String]
  val rPure = pureDemo.run(10).value
  println(rPure)

  val inspectDemo = State.inspect[Int, String](_ + "!") //State[Int, String]
  val rInspect = inspectDemo.run(10).value
  println(rInspect)

  val modifyDemo = State.modify[Int](_ + 1) //State[Int, Unit]
  val rModify = modifyDemo.run(10).value
  println(rModify)


  println("#####################")


  val program: State[Int, (Int, Int, Int)] = for {
    a <- get[Int]
    _ <- set[Int](a + 1)
    b <- get[Int]
    _ <- modify[Int](_ + 1)
    c <- inspect[Int, Int](_ * 1000)
  } yield (a, b, c)

  val (stateProgram, resultProgram ) = program.run(1).value
  println(s"${(stateProgram, resultProgram )}")
}
