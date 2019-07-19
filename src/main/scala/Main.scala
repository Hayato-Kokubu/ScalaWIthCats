import cats.syntax.either._ // for asRight, asLeft

object Main extends App {

  val a = 3.asRight[String]
  // a: Either[String,Int] = Right(3)

  val b = 4.asRight[String]
  // b: Either[String,Int] = Right(4)

   val res4 =
     for {
       x <- a
       y <- b
     } yield x*x + y*y
  // res4: scala.util.Either[String,Int] = Right(25)
  println(res4)


//  def countPositive(nums: List[Int]) =
//    nums.foldLeft(Right(0)) { (accumulator, num) =>
//      if(num > 0) {
//        // foldLeft の 初期値がRight であるのに対し、 mapでは Either が返るため エラー
//        // また、Right.apply では 左側の型指定ができない
//        accumulator.map(_ + 1)
//      } else {
//        Left("Negative. Stopping!")
//      }
//    }

  def countPositive(nums: List[Int]) =
    nums.foldLeft(0.asRight[String]) { (accumulator, num) =>
      if(num > 0) {
        accumulator.map(_ + 1)
      } else {
        Left("Negative. Stopping!")
      }
    }

  val res5 = countPositive(List(1, 2, 3, 4))
  println(res5)

  val res6 = countPositive(List(1, -2, 3, 4))
  println(res6)

  val res7 = "string".asLeft[Int]

}
