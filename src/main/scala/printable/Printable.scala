package printable

trait Printable[A] {
  def format(value: A): String
}

object Printable {
  def format[A](value: A)(implicit printable: Printable[A]): String = format(value)

  def print[A](value: A)(implicit printable: Printable[A]): Unit = println(format(value))
}


object PrintableInstances{

  implicit object StringPrintable extends Printable[String] {
    override def format(value: String): String = value
  }

  implicit object IntPrintable extends Printable[Int] {
    override def format(value: Int): String = value.toString
  }
}


