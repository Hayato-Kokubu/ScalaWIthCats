import scala.language.higherKinds

import cats.Monad


object Main extends App {

}


trait MySemigroupal[F[_]] {
  def product[A, B](fa: F[A], fb: F[B]): F[(A, B)]
}


object optionImplicits {
  implicit def mySemigroup = {
    new MySemigroupal[Option] {
      def product[A, B](fa: Option[A], fb: Option[B]): Option[(A,B)] = {
        for{
          a <- fa
          b <- fb
        } yield (a,b)
      }
    }
  }
}