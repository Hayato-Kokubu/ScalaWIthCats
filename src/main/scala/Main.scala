import cats.syntax.either._

object Main extends App {
  // 特定の例外がわかるときに、
  // 成功 => Right , 特定の例外 => Left とできる
  // それ以外の例外はthrow される。。。
  val res0 = Either.catchOnly[NumberFormatException]("foo".toInt)
  println(res0)
  val res1 = Either.catchOnly[NumberFormatException]("123".toInt)
  println(res1)
//  val res2 = Either.catchOnly[NumberFormatException](12/0)
//  println(res2)

  val res3 = Either.catchNonFatal(sys.error("Badness"))
  println(res3)

  val res4 = Either.fromTry(scala.util.Try("foo".toInt))
  println(res4)

  val res5 = Either.fromOption[String, Int](None, "Badness")
  println(res5)

}
