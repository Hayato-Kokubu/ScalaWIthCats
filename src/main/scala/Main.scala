import java.time.LocalDate

import cats.Show
import cats.instances.int._
import cats.instances.string._
import ShowImplisits._

object Main extends App{

  val showInt = Show.apply[Int]       // implicitly[Show[Int]] と同じ
  val showString = Show.apply[String]
  val showDate = Show.apply[LocalDate]
  val showBox = Show.show[Box](b => s"box has ${b.value}.")

  val showBottle = Show.fromToString[Bottle]


  val intAsString: String = showInt.show(123)
  val stringAsString: String = showString.show("abc")
  val dateAsString: String = showDate.show(LocalDate.of(2019, 7, 10))
  val boxAsString: String = showBox.show(Box("apple")) // implicit value is difined companion object  show method
  val bottleAsString: String = showBottle.show(new Bottle("water"))

  println(s"intAsString = $intAsString")
  println(s"stringAsString = $stringAsString")
  println(s"dateAsString = $dateAsString")
  println(s"boxAsString = $boxAsString")
  println(s"bottleAsString = $bottleAsString")

}

case class Box(value: String)

class Bottle(value: String){
  override def toString: String = s"$value in the bottle"
}
