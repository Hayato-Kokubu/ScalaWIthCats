package exercise

import cats.Show
import cats.kernel.Eq
import printable.Printable

final case class Cat(name: String, age: Int, color: String)

object CatImplicits {
  implicit val catPrintable: Printable[Cat] = new Printable[Cat]{
    def format(value: Cat): String =
      s"${value.name} is a ${value.age} year-old ${value.color} cat."
  }

  implicit val catShow: Show[Cat] = Show.show{cat =>
    s"${cat.name} is a ${cat.age} year-old ${cat.color} cat."
  }

  implicit val catalogEq: Eq[Cat] = Eq.instance[Cat]{(cat1, cat2) =>
    cat1.name == cat2.name && cat1.age == cat2.age && cat1.color == cat2.color
  }
}

object CatSyntax{
  implicit class ShowOps(cat: Cat) {
    def show(implicit catShow: Show[Cat]): String = catShow.show(cat)
  }
}