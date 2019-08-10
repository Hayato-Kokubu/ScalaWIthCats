import cats.{Contravariant, Show}
import cats.instances.string._
import cats.syntax.contravariant._

import scala.language.higherKinds

import Implicits._


object Main extends App {

  val dC = implicitly[Codec[Double]]

  println( dC.encode(123.4) )

}

trait Codec[A] { self =>
  def encode(value: A): String
  def decode(value: String): A

  def imap[B](dec: A => B, enc: B => A): Codec[B] =
    new Codec[B] {
      def encode(value: B): String = self.encode(enc(value))
      def decode(value: String): B = dec(self.decode(value))
    }
}


object Implicits {
  implicit val stringCodec: Codec[String] = {
    new Codec[String]{
      def encode(value: String): String = value
      def decode(value: String): String = value
    }
  }

  implicit val intCodec: Codec[Int] = stringCodec.imap[Int](_.toInt, _.toString)
  implicit val booleanCodec: Codec[Boolean] = stringCodec.imap[Boolean](_.toBoolean, _.toString)

  implicit val doubleCodec: Codec[Double] = stringCodec.imap[Double](_.toDouble, _.toString)
  implicit def boxCodec[A](implicit  codecA: Codec[A]): Codec[Box[A]] =
//    stringCodec.imap[Box[A]](value => Box(codecA.decode(value)), _.toString)
  codecA.imap(Box(_), _.value)


}


case class Box[A](value: A)