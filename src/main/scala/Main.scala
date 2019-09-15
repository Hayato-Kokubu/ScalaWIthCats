import exercise.MonoidTester

object Main extends App{

  // n^3
  val anyBooleanTriples = Seq(
    (A1, A1, A1),
    (A1, A1, A2),
    (A1, A2, A1),
    (A1, A2, A2),
    (A2, A1, A1),
    (A2, A1, A2),
    (A2, A2, A1),
    (A2, A2, A2),
  )

  // 2^(n^2)
  val allBooleanOperations = Seq(
    ( A1,  A1,  A1,  A1),
    ( A1,  A1,  A1, A2),
    ( A1,  A1, A2,  A1),
    ( A1,  A1, A2, A2),
    ( A1, A2,  A1,  A1),
    ( A1, A2,  A1, A2),
    ( A1, A2, A2,  A1),
    ( A1, A2, A2, A2),
    (A2,  A1,  A1,  A1),
    (A2,  A1,  A1, A2),
    (A2,  A1, A2,  A1),
    (A2,  A1, A2, A2),
    (A2, A2,  A1,  A1),
    (A2, A2,  A1, A2),
    (A2, A2, A2,  A1),
    (A2, A2, A2, A2),
  )

  // n
  val identityCandidates = Seq(A1, A2)

  def * (op : ( Target, Target, Target, Target ) ): (Target, Target) => Target = {(x, y) =>
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
    if anyBooleanTriples.forall{ bt => new MonoidTester[Target](e, bt)(*(op)).test}
  } yield (op, e)

  booleanMonoids.foreach(println)
}


trait Target 
case object A1 extends Target
case object A2 extends Target
