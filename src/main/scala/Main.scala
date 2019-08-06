import Implicits._

object Main extends App {

  val ps = implicitly[Printable[String]]
  val pb = implicitly[Printable[Boolean]]

  println( ps.format("hello") )
  println( pb.format(true) )

}


// self => という書き方は何？
// 自分型アノテーション というmixin の1つ
// https://docs.scala-lang.org/ja/tour/self-types.html
trait Printable[A] { self =>
  def format(value: A): String
  def contramap[B](func: B => A): Printable[B] =
    new Printable[B] {
      def format(value: B): String ={
        self.format(func(value))
      }
    }
}

object Printable{
  def format[A](value: A)(implicit p: Printable[A]): String =
    p.format(value)

}

object Implicits {
  implicit val stringPrintable: Printable[String] =
    new Printable[String] {
      def format(value: String): String =
        "\"" + value + "\""
    }

  implicit val booleanPrintable: Printable[Boolean] =
    new Printable[Boolean] {
      def format(value: Boolean): String =
        if(value) "yes" else "no"
    }

  implicit def boxPrintable[A](implicit pa: Printable[A]): Printable[Box[A]] = {
    new Printable[Box[A]] {
      def format(box: Box[A]): String = {
        pa.format(box.value)
      }
    }
  }
}

final case class Box[A](value: A)