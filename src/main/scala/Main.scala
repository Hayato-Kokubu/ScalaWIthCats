object Main extends App {
  val either1: Either[String, Int] = Right(10)
  val either2: Either[String, Int] = Right(32)

  val res0 =
    for {
      a <- either1.right
      b <- either2.right
    } yield a + b
  println(res0)

  val res1 =
    for {
      a <- either1
      b <- either2
    } yield a + b
  println(res1)

  // res1: scala.util.Either[String,Int] = Right(42)
}
