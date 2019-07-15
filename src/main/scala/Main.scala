object Main extends App {

  def parseInt(str: String): Option[Int] =
    scala.util.Try(str.toInt).toOption

  def divide(a: Int, b: Int): Option[Int] =
    if(b == 0) None else Some(a / b)

//  def stringDivideBy(aStr: String, bStr: String): Option[Int] =
//    parseInt(aStr).flatMap { aNum =>
//      parseInt(bStr).flatMap { bNum =>
//        divide(aNum, bNum)
//      }
//    }

    def stringDivideBy(aStr: String, bStr: String): Option[Int] =
      for {
        aNum <- parseInt(aStr)
        bNum <- parseInt(bStr)
        ans  <- divide(aNum, bNum)
      } yield ans


  val res1 = stringDivideBy("6", "2")
  // res1: Option[Int] = Some(3)

  val res2 = stringDivideBy("6", "0")
  // res2: Option[Int] = None

  val res3 = stringDivideBy("6", "foo")
  // res3: Option[Int] = None

  val res4 = stringDivideBy("bar", "2")
  // res4: Option[Int] = None

  println(res1)
  println(res2)
  println(res3)
  println(res4)

}
