import exercise.{A1, A2, MonoidTester, MyTarget}

object Main extends App{

  // 2^(n^2)
  val allTargetOperations =
    for {
      x <- MyTarget.values
      y <- MyTarget.values
      z <- MyTarget.values
      w <- MyTarget.values
    } yield { (a1: MyTarget, a2: MyTarget) =>
      (a1, a2) match {
        case (A1, A1) => x
        case (A1, A2) => y
        case (A2, A1) => z
        case (A2, A2) => w
        case _ => throw new IllegalArgumentException(s"invalid Target: ${(x, y)}")
      }
    }

  // n
  val identityCandidates = Seq(A1, A2)

  val targetMonoids = for {
    op <- allTargetOperations
    e <- identityCandidates
    if new MonoidTester(e)(op).test
  } yield (op, e)

  targetMonoids.foreach(println)
}


