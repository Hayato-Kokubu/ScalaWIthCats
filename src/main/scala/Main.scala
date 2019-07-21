import cats.Eval

object Main extends App {
  val greeting = Eval.
    now { println("Step 1"); "Hello" }.
    map { str => println("Step 2"); s"$str world" }

  println("--------------")
  println(greeting.value)
  println("--------------")
  println(greeting.value)


}
