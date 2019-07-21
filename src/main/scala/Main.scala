import cats.Eval

object Main extends App {
  val ans = for {
    a <- Eval.later { println("Calculating A"); 40 }
    b <- Eval.always { println("Calculating B"); 2 }
  } yield {
    println("Adding A and B")
    a + b
  }


  println("----------")
  ans.value
  println("----------")
  ans.value
  println("----------")

}
