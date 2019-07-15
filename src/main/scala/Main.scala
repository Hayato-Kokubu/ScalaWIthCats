import cats.Functor
import exercise.ch3.{Branch, Leaf, Tree}
import exercise.ch3.TreeImplicits._

object Main extends App {

  val tree = Tree.branch(
    Tree.branch(
      Tree.leaf(1),
      Tree.branch(
        Tree.leaf(2),
        Tree.branch(Tree.leaf(3), Tree.branch(Tree.leaf(4), Tree.leaf(5)))
      ),
    ),
    Tree.branch(
      Tree.branch(
        Tree.leaf(6),
        Tree.branch(
          Tree.leaf(7),
          Tree.leaf(8)
        )
      ),
      Tree.branch(
        Tree.leaf(9),
        Tree.leaf(10)
      )
    ),
  )

//  implicitly[Functor[Tree]]
//  println(tree)

  val fTree = Functor[Tree].map(tree)(i => (i * 10) + "!")
  println(fTree)



//  tree.map(_ * 2)

}
