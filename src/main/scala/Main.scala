import cats.Eval

object Main extends App {


  def factorial(n: BigInt): Eval[BigInt] =
    if(n == 1) {
      Eval.now(n)
    } else{
      Eval.defer {factorial(n - 1).map(_ * n) }
    }

  val res = factorial(1000000).value

  println(res)
}
