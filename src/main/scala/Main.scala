import cats.{Contravariant, Show}
import cats.instances.string._
import cats.syntax.contravariant._

import scala.language.higherKinds

object Main extends App {
  val showString = Show[String]
  val showSymbol = Contravariant[Show].contramap(showString){
    (sym: Symbol) => s"${sym.name}"
  }
  println(showSymbol.show('dave))

  showString.contramap[Symbol](_.name).show('dave)
}