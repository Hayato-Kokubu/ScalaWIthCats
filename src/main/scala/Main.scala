import cats.Monoid
// Symbol 版のMonoid を作る
// Symbol はCats標準のインスタンスは用意していないので
// 一度Symbol をStringで変換し、Monoid[String]で結合して Symbol で戻す

import cats.instances.string._
import cats.syntax.invariant._
import cats.syntax.monoid._

import Implicits._

object Main extends App {


  println( Monoid[Symbol].empty )
  println( 'a |+| 'few |+| 'words )

}


object Implicits {
  implicit val symbolMonoid: Monoid[Symbol] =
//    new Monoid[Symbol] {
//      def empty: Symbol = Symbol("")
//      def combine(a: Symbol, b: Symbol) = Symbol(a.toString + b.toString)
//  }
  Monoid[String].imap(Symbol.apply)(_.name)

}