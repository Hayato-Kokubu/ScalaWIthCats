import cats.syntax.either._

object Main extends App {
  val res11 = "Error".asLeft[Int].getOrElse(0)
  println(res11)

  val res12 = 12.asRight[String].getOrElse(0)
  println(res12)

  val res13 = "Error".asLeft[Int].orElse(2.asRight[String])
  println(res13)

  val res14 = 12.asRight[Int].orElse(2.asRight[String])
  // 12.asRight[Int]: Either[Int, Int] となるが
  // res14: Either[String, Int] となる。
  // Left の型が変わる
  println(res14)

  val ensureTestFailure = (-1).asRight[String].ensure("Must be non-negative!")(_ > 0)
  println(ensureTestFailure)

  val ensureRight = 1.asRight[String].ensure("Must be non-negative!")(_ > 0)
  println(ensureRight)

  val ensureLeft = "error".asLeft[Int].ensure("Must be non-negative!")(_ > 0)
  println(ensureLeft)


  val recoverLeft = "error".asLeft[Int].recover {
    case _: String => -1
  }
  println(recoverLeft)

  val recoverRight = 12.asRight[String].recover {
    case _: String => -1
  }
  println(recoverRight)

  val recoverWithLeft = "error".asLeft[Int].recoverWith {
    case _: String => Right(-1)
  }
  println(recoverWithLeft)

  val recoverWithRight = 12.asRight[String].recoverWith {
    case _: String => Right(-1)
  }
  println(recoverWithRight)

  val leftMapLeft = "foo".asLeft[Int].leftMap(_.reverse)
  println(leftMapLeft)

  val leftMapRight = 12.asRight[String].leftMap(_.reverse)
  println(leftMapRight)

  val bimapRight = 6.asRight[String].bimap(_.reverse, _ * 7)
  println(bimapRight)

  val bimapLeft = "bar".asLeft[Int].bimap(_.reverse, _ * 7)
  println(bimapLeft)

  val mapRitht = 6.asRight[String].map(_ * 7)
  println(mapRitht)

  val mapLeft = "bar".asLeft[Int].map(_ * 7)
  println(mapLeft)

  val strInt = 123.asRight[String]
  println(strInt)

  val swapStrInt = strInt.swap
  println(swapStrInt)

}
