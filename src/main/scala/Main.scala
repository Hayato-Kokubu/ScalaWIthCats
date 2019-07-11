object Main extends App{


}

trait Monoid[A] {
  def combine(a1: A, a2: A): A
  def empty: A
}
