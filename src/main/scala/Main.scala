object Main extends App {

  def show[A](list: List[A]): String =
    list.foldLeft("nil")((accum, item) => s"$item then $accum")

  val a = show(Nil)
  // res0: String = nil
  println(a)

  val b = show(List(1, 2, 3))
  // res1: String = 3 then 2 then 1 then nil
  println(b)


}
