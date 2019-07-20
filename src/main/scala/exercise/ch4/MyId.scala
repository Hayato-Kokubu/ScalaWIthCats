package exercise.ch4

object MyIdObject {
  type MyId [A] = A
}


import MyIdObject._

object MyId {
  def pure[A](value: A):MyId[A] = value: MyId[A]

  def map[A,B](fa: MyId[A])(f: A => B): MyId[B] = {
    val a = fa: A
    pure[B](f(a))
  }

  def flatMap[A,B](fa: MyId[A])(f: A => MyId[B]): MyId[B] = {
    val a = fa: A
    f(a)
  }

}