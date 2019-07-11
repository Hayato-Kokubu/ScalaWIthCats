import cats.Show
import exercise.Cat
import exercise.CatImplicits._

object Main extends App{

  val tora = Cat("Tora", 2, "black")
  val mike = Cat("Mike", 1, "blown")
  val tama = Cat("Tama", 4, "blown")

  val catsShow = implicitly[Show[Cat]]
  println(catsShow.show(tora))
  println(catsShow.show(mike))
  println(catsShow.show(tama))
}
