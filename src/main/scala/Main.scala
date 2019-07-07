import cats.Show

import cats.instances.int._
import cats.instances.string._


object Main extends App{

  val showInt = Show.apply[Int]
  val showString = Show.apply[String]


  val intAsString: String = showInt.show(123)
  val stringAsString: String = showString.show("abc")

  println(s"intAsString = $intAsString")
  println(s"stringAsString = $stringAsString")
}
