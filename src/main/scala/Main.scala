import cats.syntax.apply._
import cats.instances.option._


import cats.syntax.option._


object Main extends App {
  val a = (123.some, "abc".some).tupled // use Semigroupal[Option] from cats.syntax.option._
  println(a)

  val garfield =
    (
    Option("Garfield"),
    Option(1978),
    Option("Orange & black")
  ).mapN(Cats)


  println(garfield)


}


case class Cats(name: String, born: Int, color: String)
