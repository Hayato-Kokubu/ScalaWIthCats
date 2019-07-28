import cats.Monad
import cats.syntax.applicative._ // for pure
import cats.syntax.flatMap._     // for flatMap
import scala.language.higherKinds


// Hypothetical example. This won't actually compile:
object Main extends App {

  def compose[M1[_]: Monad, M2[_]: Monad] = {
    type Composed[A] = M1[M2[A]]

    new Monad[Composed] {
      def pure[A](a: A): Composed[A] =
        a.pure[M2].pure[M1]

      def flatMap[A, B](fa: Composed[A])
                       (f: A => Composed[B]): Composed[B] =
      // Problem! How do we write flatMap?
        ???
    }
  }

}
