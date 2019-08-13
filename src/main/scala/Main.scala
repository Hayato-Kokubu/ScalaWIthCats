import cats.Monoid

import cats.instances.string._
import cats.instances.int._
import cats.instances.list._

import cats.syntax.apply._
import cats.instances.invariant._


object Main extends App {

  val tupleToCat: (String, Int, List[String]) => Cat = Cat.apply _

  val catToTuple: Cat => (String, Int, List[String]) = { cat =>
    (cat.name, cat.yearOfBirth, cat.favoriteFoods)
  }

  implicit val catMonid: Monoid[Cat] = (
    Monoid[String],
    Monoid[Int],
    Monoid[List[String]]
  ).imapN(tupleToCat)(catToTuple)

}


case class Cat(
                name: String,
                yearOfBirth: Int,
                favoriteFoods: List[String]
              )