import exercise.ch6.UserInputParser

object Main extends App {

  val input = Map("name" -> "taro", "age" -> "20", "birthday" -> "12/12")

  val res = UserInputParser(input).apply

  println(res)

}
