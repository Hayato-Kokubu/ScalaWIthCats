import exercise.ch2.Monoid
import exercise.ch2.SetsUtil._

object Main extends App{


  val s1 = Set("hello", "world")
  val s2 = Set("hoge", "fuga")

  val sm = implicitly[Monoid[Set[String]]]

  val s3 = sm.combine(s1, s2)

  println(s3)



}