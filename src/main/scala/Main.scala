import java.time.LocalDateTime

import cats.syntax.eq._
import EqImplicits._

object Main extends App{

  val x = LocalDateTime.of(2019, 7, 11, 13, 10, 0)
  val y = LocalDateTime.of(2019, 7, 11, 13, 10, 1)

  val b1 = x.equals(y)
  val b2 = x === y

  println(b1)  // 普通に比較するとfalse
  println(b2)  // EqImplicits の比較方法ではtrue

}