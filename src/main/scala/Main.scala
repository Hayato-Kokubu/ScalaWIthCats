import exercise.MonoidTester

object Main extends App{

  val anyBooleanTriples = Seq(
    (true, true, true),
    (true, true, false),
    (true, false, true),
    (true, false, false),
    (false, true, true),
    (false, true, false),
    (false, false, true),
    (false, false, false),
  )

  val allBooleanOperations = Seq(
    ( true,  true,  true,  true),
    ( true,  true,  true, false),
    ( true,  true, false,  true),
    ( true,  true, false, false),
    ( true, false,  true,  true),
    ( true, false,  true, false),
    ( true, false, false,  true),
    ( true, false, false, false),
    (false,  true,  true,  true),
    (false,  true,  true, false),
    (false,  true, false,  true),
    (false,  true, false, false),
    (false, false,  true,  true),
    (false, false,  true, false),
    (false, false, false,  true),
    (false, false, false, false),
  )

  val identityCandidates = Seq(true, false)

  def * (op : ( Boolean, Boolean, Boolean, Boolean ) ): (Boolean, Boolean) => Boolean = {
    case (true, true) => op._1
    case (true, false) => op._2
    case (false, true) => op._3
    case (false, false) => op._4
  }

  val booleanMonoids = for {
    op <- allBooleanOperations
    e <- identityCandidates
    if anyBooleanTriples.forall{ bt => new MonoidTester[Boolean](e, bt)(*(op)).test}
  } yield (op, e)

  booleanMonoids.foreach(println)
}