import cats.Monad
import cats.syntax.applicative._ // for pure
import cats.syntax.flatMap._     // for flatMap
import scala.language.higherKinds
import cats.instances.option._
import cats.syntax.option._


object Main extends App {

  // Hypothetical example. This won't actually compile:
  def compose[M2[_]: Monad] = {
//    type Composed[A] = Option[M2[A]]

    new Monad[Option[M2]] {
      def pure[A](a: A): Option[M2[A]] =
        a.pure[M2].pure[Option]

      def flatMap[A, B](fa: Option[M2[A]])
        (f: A => Option[M2[B]]): Option[M2[B]] =
        fa.flatMap(_.fold(None.pure[M2])(f))
    }
  }

}

