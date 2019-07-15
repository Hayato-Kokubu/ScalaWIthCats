import cats.Functor
import exercise.ch3.{Branch, Leaf, Tree}
import exercise.ch3.TreeImplicits._

object Main extends App {

  val tree = Branch(
    Branch(
      Leaf(1),
      Branch(
        Leaf(2),
        Branch(Leaf(3), Branch(Leaf(4), Leaf(5)))
      ),
    ),
    Branch(
      Branch(
        Leaf(6),
        Branch(
          Leaf(7),
          Leaf(8)
        )
      ),
      Branch(
        Leaf(9),
        Leaf(10)
      )
    ),
  )

  implicitly[Functor[Tree]]
  println(tree)

  val fTree = Functor[Tree].map(tree)(i => (i * 10) + "!")
  println(fTree)

}
