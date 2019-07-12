package exercise.ch2

object SetsUtil {

  implicit val setsMonoid = new Monoid[Set[String]]{
    override def combine(x: Set[String], y: Set[String]): Set[String] = x ++ y
    val empty = Set.empty[String]
  }

}
