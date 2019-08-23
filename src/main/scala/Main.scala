import cats.{Eval, Foldable}

import cats.instances.stream._


object Main extends App {


  def bigData = (1 to 100000).toStream

  // cause StackOverFlow
  // bigData.foldRight(0L)(_ + _)


  val eval: Eval[Long] = {
    Foldable[Stream].foldRight(bigData, Eval.now(0L)){ (num, eval) =>
      eval.map(_ + num)
    }
  }

  val res = eval.value
  println(res)

}
