import java.time.LocalDate

import cats.Show
import cats.instances.int._
import cats.instances.string._
import ShowImplisits._

object Main extends App{

  val showInt = Show.apply[Int]       // implicitly[Show[Int]] と同じ
  val showString = Show.apply[String]
  val showDate = Show.apply[LocalDate]


  val intAsString: String = showInt.show(123)
  val stringAsString: String = showString.show("abc")
  val dateAsString: String = showDate.show(LocalDate.of(2019, 7, 10))

  println(s"intAsString = $intAsString")
  println(s"stringAsString = $stringAsString")
  println(s"dateAsString = $dateAsString")
}
