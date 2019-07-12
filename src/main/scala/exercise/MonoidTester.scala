package exercise

class MonoidTester[A](e: A, anyTriples : (A,A,A) )( * : (A, A) => A ) {

  val (a1, a2, a3) = anyTriples

  def assosiativeLow: Boolean = *( *(a1, a2), a3) == *(a1, *(a2, a3))

  def identityLow: Boolean = {
    *(a1 , e) == a1 && *(e , a1) == a1 &&
    *(a2 , e) == a2 && *(e , a2) == a2 &&
    *(a3 , e) == a3 && *(e , a3) == a3
  }

  def test = assosiativeLow && identityLow
}
