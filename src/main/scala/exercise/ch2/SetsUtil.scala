package exercise.ch2

object SetsUtil {

  implicit def setsMonoid[T] = new Monoid[Set[T]]{
    override def combine(x: Set[T], y: Set[T]): Set[T] = x ++ y
    val empty = Set.empty[T]
  }

}