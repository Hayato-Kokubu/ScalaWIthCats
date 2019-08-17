package exercise.ch6

import cats.data.Validated
import cats.syntax.option._
import cats.syntax.either._

import cats.syntax.apply._
import cats.instances.either._
import cats.instances.list._

case class UserInputParser(input: Map[String, String]) {
  type FormData = Map[String, String]
  type FailFast[A] = Either[List[String], A]
  type FailSlow[A] = Validated[List[String], A]


  def apply: FailSlow[User] = {
    (
      readName(input).toValidated,
      readAge(input).toValidated
    ).mapN(User.apply) // mapN はIntelliJ で認識されない

  }

  def getValue(name: String)(data: FormData):FailFast[String] = {
    data.get(name).toRight[List[String]](List(s"$name field not specified"))
  }

  def parseInt(name: String)(data: String): FailFast[Int] = {
    Either.catchOnly[NumberFormatException](data.toInt).leftMap(_ =>
      List(s"$name must be an integer!")
    )
  }

  def validateNonBlank(name: String)(data: String): FailFast[String] = {
    data.asRight[List[String]].ensure(List(s"$name must not brank"))(_.nonEmpty)
  }

  def validateNonNegative(name: String)(data: Int): FailFast[Int] = {
    data.asRight[List[String]].ensure(List(s"$name must non negative"))(_ >= 0)
  }

  def readName(data: Map[String, String]): FailFast[String] = {
    for {
      name <- getValue("name")(data)
      nonBlankName <- validateNonBlank("name")(name)
    } yield nonBlankName
  }

  def readAge(data: Map[String, String]): FailFast[Int] = {
    for {
      age <- getValue("age")(data)
      nonBlankAge <- validateNonBlank("name")(age)
      nonNegativeAge <- parseInt("age")(nonBlankAge)
      validatedAge <- validateNonNegative("name")(nonNegativeAge)
    } yield validatedAge

  }



}

case class User(name: String, age: Int)
