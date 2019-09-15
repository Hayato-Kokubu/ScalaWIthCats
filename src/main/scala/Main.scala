import exercise.{A1, A2, MonoidTester, MyTarget}

object Main extends App{

  // 2^(n^2)
  val allBooleanOperations = Seq(
    (A1, A1, A1, A1),
    (A1, A1, A1, A2),
    (A1, A1, A2, A1),
    (A1, A1, A2, A2),
    (A1, A2, A1, A1),
    (A1, A2, A1, A2),
    (A1, A2, A2, A1),
    (A1, A2, A2, A2),
    (A2, A1, A1, A1),
    (A2, A1, A1, A2),
    (A2, A1, A2, A1),
    (A2, A1, A2, A2),
    (A2, A2, A1, A1),
    (A2, A2, A1, A2),
    (A2, A2, A2, A1),
    (A2, A2, A2, A2),
  )

  // n
  val identityCandidates = Seq(A1, A2)

  def * (op : ( MyTarget, MyTarget, MyTarget, MyTarget ) ): (MyTarget, MyTarget) => MyTarget = { (x, y) =>
    (x, y) match {
      case (A1, A1) => op._1
      case (A1, A2) => op._2
      case (A2, A1) => op._3
      case (A2, A2) => op._4
      case _ => throw new IllegalArgumentException(s"invalid Target: ${(x, y)}")

    }
  }

  val booleanMonoids = for {
    op <- allBooleanOperations
    e <- identityCandidates
    if new MonoidTester(e)(*(op)).test
  } yield (op, e)

  booleanMonoids.foreach(println)
}


