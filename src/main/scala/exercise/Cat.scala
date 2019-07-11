package exercise

import cats.Show
import printable.Printable

final case class Cat(name: String, age: Int, color: String)

object CatImplicits {
  implicit val catPrintable: Printable[Cat] = new Printable[Cat]{
    def format(value: Cat): String =
      s"${value.name} is a ${value.age} year-old ${value.color} cat."
  }

  implicit val catShow: Show[Cat] = Show.show{cat =>
    s"${cat.name} is a ${cat.age} year-old ${cat.color} cat."}
}