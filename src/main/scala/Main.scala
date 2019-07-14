import cats.Functor

object Main extends App{

  def myMethod[F[_]] = {
    val functor = Functor.apply[F]
  }

}