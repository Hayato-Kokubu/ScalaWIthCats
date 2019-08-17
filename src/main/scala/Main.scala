import cats.data.Validated
import cats.syntax.option._

object Main extends App {
  val a = Validated.catchOnly[NumberFormatException]("foo".toInt)
  println(a)

  val a1 = Validated.catchOnly[NumberFormatException]("123".toInt)
  println(a1)


//  val a2 = Validated.catchOnly[NullPointerException]("foo".toInt)
//  println(a2)

  // sys.error creates new RuntimeException
  val b = Validated.catchNonFatal(sys.error("Badness"))
  println(b)

  val c = Validated.fromEither[String, Int](Left("Badness"))
  println(c)
  val c1 = Validated.fromEither[String, Int](Right(1234))
  println(c1)

  val d = Validated.fromOption[String, Int](None, "Badness")
  println(d)
  val d1 = Validated.fromOption[String, Int](12345.some, "Badness")
  println(d1)

}
