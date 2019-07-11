package printable

trait Printable[A] {
  def format(value: A): String
}

object Printable {
  def format[A](value: A)(implicit printable: Printable[A]): String = printable.format(value)

  def print[A](value: A)(implicit printable: Printable[A]): Unit = println(format(value))
}


//object PrintableInstancesWithObject{
//
//  implicit object StringPrintable extends Printable[String] {
//    override def format(value: String): String = value
//  }
//
//  implicit object IntPrintable extends Printable[Int] {
//    override def format(value: Int): String = value.toString
//  }
//}


object PrintableImplicits {

  implicit val stringPrintable = new Printable[String] {
    override def format(value: String): String = value
  }

  implicit val intPrintable = new Printable[Int]{
    override def format(value: Int): String = value.toString
  }
}

object PrintableSyntax{
  implicit class PrinatableOps[A](value: A){
    def format(implicit printable: Printable[A]): String = printable.format(value)
    def print(implicit printable: Printable[A]): Unit = println(format)
  }
}

