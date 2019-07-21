import cats.Eval

object Main extends App {

  val now = Eval.now({println("now!"); math.random + 1000})

  val later = Eval.later({println("later!"); math.random + 2000})

  val always = Eval.always({println("always!"); math.random + 3000})


  println("-------------")


  println(now.value)
  println(later.value)
  println(always.value)

  println("-------------")

  println(now.value)
  println(later.value)
  println(always.value)
}
