import JsonWriterInstances._

object Main extends App{

  val json1 = Json.toJson(Person("Dave", "dave@example.com"))
  println(json1)

  val json2 = Json.toJson(Option("A string"))
  println(json2)

  val json3 = Json.toJson(None)
  println(json3)


}
