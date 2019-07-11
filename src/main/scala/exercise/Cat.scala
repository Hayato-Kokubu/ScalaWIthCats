package exercise

import printable.Printable

final case class Cat(name: String, age: Int, color: String)

object CatImplicits {
  implicit val catPrintable: Printable[Cat] = new Printable[Cat]{
    def format(value: Cat): String =
      s"${value.name} is a ${value.age} year-old ${value.color} cat."
  }
}
