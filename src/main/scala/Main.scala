import cats.Semigroupal
import cats.data.{NonEmptyVector, Validated}
import cats.syntax.apply._
import cats.syntax.validated._
import cats.instances.string._
import cats.instances.vector._

object Main extends App {

  type AllErrorsOr[A] = Validated[String, A]

  Semigroupal[AllErrorsOr]

  val t =
    (
      12.valid[String],
      //"Error 1".invalid[Int],
      "Error 2".invalid[Int]
    ).tupled // tupled がIntelliJで認識してもらえないが、動く。。。

  println(t)

  val t2 =
    (
      Vector(404).invalid[Int],
      Vector(500).invalid[Int]
    ).tupled

  println(t2)

  val t3 =
    (
      NonEmptyVector.of("Error 1").invalid[Int],
      NonEmptyVector.of("Error 2").invalid[Int]
    ).tupled

  println(t3)

}
