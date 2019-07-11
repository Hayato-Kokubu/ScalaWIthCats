import exercise.Cat
import exercise.CatImplicits._
import printable.Printable


object Main extends App{

  val tora = Cat("Tora", 2, "black")
  val mike = Cat("Mike", 1, "blown")
  val tama = Cat("Tama", 4, "blown")

  Printable.print(tora)
  Printable.print(mike)
  Printable.print(tama)
}
