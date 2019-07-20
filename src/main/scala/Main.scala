import cats.syntax.either._

object Main extends App {
  // 特定の例外がわかるときに、
  // 成功 => Right , 特定の例外 => Left とできる
  // それ以外の例外はthrow される。。。
  val res0 = Either.catchOnly[NumberFormatException]("foo".toInt)
  println(res0)
  val res1 = Either.catchOnly[NumberFormatException]("123".toInt)
  println(res1)
  val res2 = Either.catchOnly[NumberFormatException](12/0)
  println(res2)
}
