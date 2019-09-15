import exercise.{A1, A2, MonoidTester, MyTarget}

object Main extends App{
  val t = System.currentTimeMillis

  // 2^(n^2)
  val allTargetOperations =
    for {
      // 現状、n^2個書かないといけないのは辛い。
      a11 <- MyTarget.values
      a12 <- MyTarget.values
      a21 <- MyTarget.values
      a22 <- MyTarget.values
    } yield { (a1: MyTarget, a2: MyTarget) =>
      (a1, a2) match {
        case (A1, A1) => a11
        case (A1, A2) => a12
        case (A2, A1) => a21
        case (A2, A2) => a22
        case _ => throw new IllegalArgumentException(s"invalid Target: ${(a1, a2)}")
      }
    }

  // n
  val identityCandidates = Seq(A1, A2)

  val targetMonoids = for {
    op <- allTargetOperations
    e <- identityCandidates
    if new MonoidTester(e)(op).test
  } yield (op, e)

  targetMonoids.foreach{case(op, e) =>
    (
      for {
        x <- MyTarget.values
        y <- MyTarget.values
      }yield s"${(x, y)} -> ${op(x,y)}, "
    ).foreach(print)
    println()
    println(s"enpty = $e")
  }
  println(s"${System.currentTimeMillis - t} msc")

}


