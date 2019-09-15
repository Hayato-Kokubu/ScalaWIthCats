package exercise


class MonoidTester( * : (MyTarget, MyTarget) => MyTarget ) {

  def assosiativeLow: Boolean =
    (
      for {
        x <- MyTarget.values
        y <- MyTarget.values
        z <- MyTarget.values
      } yield (x, y, z)
    ).forall{case (xx, yy, zz) => *( *(xx, yy), zz) == *(xx, *(yy, zz))}


  def identityLow: Boolean =
    MyTarget.values.forall{a => *(a , E) == a && *(E , a) == a}

  def test = assosiativeLow && identityLow
}

sealed trait MyTarget {
}
case object E  extends MyTarget
case object A1 extends MyTarget
case object A2 extends MyTarget

object MyTarget{
  // いちいち定義しないでやりたい。。。
  val values: Seq[MyTarget] = Seq(E, A1, A2)
}