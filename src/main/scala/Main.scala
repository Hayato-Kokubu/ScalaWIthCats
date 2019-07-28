import cats.Eval

object Main extends App {
  def foldRight[A, B](as: List[A], acc: B)(fn: (A, B) => B): Eval[B] =
    as match {
      case head :: tail =>
        fn(head, foldRight(tail, acc)(Eval.defer()))
//        fn(head, foldRight(tail, acc)(fn))
      case Nil =>
        Eval.now(acc)
//        acc
    }
}
