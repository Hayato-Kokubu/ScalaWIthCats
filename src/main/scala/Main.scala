import JsonWriterInstances._

object Main extends App{

  Json.toJson(Person("Dave", "dave@example.com"))

}
