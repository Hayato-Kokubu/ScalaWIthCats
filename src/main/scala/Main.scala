import exercise._

object Main extends App{
  val t = System.currentTimeMillis

  // 2^(n^2)
  val allTargetOperations =
    for {
      // 現状、n^2個書かないといけないのは辛い。
      a11 <- MyTarget.values
      a12 <- MyTarget.values
      a13 <- MyTarget.values
      a21 <- MyTarget.values
      a22 <- MyTarget.values
      a23 <- MyTarget.values
      a31 <- MyTarget.values
      a32 <- MyTarget.values
      a33 <- MyTarget.values
    } yield { (a1: MyTarget, a2: MyTarget) =>
      (a1, a2) match {
        case (A1, A1) => a11
        case (A1, A2) => a12
        case (A1, E)  => a13
        case (A2, A1) => a21
        case (A2, A2) => a22
        case (A2, E)  => a23
        case (E, A1)  => a31
        case (E, A2)  => a32
        case (E, E)   => a33
        case _ => throw new IllegalArgumentException(s"invalid Target: ${(a1, a2)}")
      }
    }

  val targetMonoids = for {
    op <- allTargetOperations
    if new MonoidTester(op).test
  } yield op

  targetMonoids.foreach{case op => printMonoid(op)}
  println(s"${System.currentTimeMillis - t} msc")

  def printMonoid(op: (MyTarget, MyTarget) => MyTarget): Unit = {
    for{
     x <- MyTarget.values
     y <- MyTarget.values
    }yield{
      println("### start ###")
      println(s"  | A1 A2 E")
      println(s"--|------------")
      println(s"A1| ${op(A1, A1)} ${op(A1, A2)} ${op(A1, E)}")
      println(s"A2| ${op(A2, A1)} ${op(A2, A2)} ${op(A2, E)}")
      println(s"E | ${op(E, A1)} ${op(E, A2)} ${op(E, E)}")
      println("###  end  ###")
    }

  }

}


