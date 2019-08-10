import cats.data.State

object Main extends App {
  val a = State[Int, String] { state =>
    (state, s"The state is $state")
  }

  println(a)

  // Get the state and the result:
  val (state1, result1) = a.run(10).value
  // state: Int = 10
  // result: String = The state is 10
  println(s"${(state1, result1)}")

  // Get the state, ignore the result:
  val state2 = a.runS(10).value
  // state: Int = 10
  println(s"$state2")

  // Get the result, ignore the state:
  val result2 = a.runA(10).value
  // result: String = The state is 10
  println(s"$result2")

}
