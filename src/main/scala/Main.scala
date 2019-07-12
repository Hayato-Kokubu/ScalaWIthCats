import cats.syntax.eq._
import exercise.Cat
import exercise.CatImplicits._
import exercise.CatSyntax._

object Main extends App{

  val tora = Cat("Tora", 2, "black")
  val mike = Cat("Mike", 1, "blown")
  val tama = Cat("Tama", 4, "blown")
  val tora$ = Cat("Tora", 2, "black")

  println(tora.show)
  println(mike.show)
  println(tama.show)

  val b1 = tora === mike
  val b2 = tora === tora$

  println(b1)
  println(b2)

}
