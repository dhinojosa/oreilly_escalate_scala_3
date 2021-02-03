package com.xyzcorp.demo.extensions

trait SemiGroup[T]:
  extension (x: T) def combine (y: T): T

given SemiGroup[String] with
  extension (x: String) def combine (y: String): String  = s"$x $y"

given SemiGroup[Int] with
  extension (x: Int) def combine (y: Int): Int  = x + y

given [A](using sg: SemiGroup[A]):SemiGroup[List[A]] with
  extension (x:List[A]) def combine (y:List[A]) = x.zip(y).map(_ combine _)
   
object MyOps:
  def join[A : SemiGroup](x:A, y:A) = x.combine(y)  //Semigroup[A]

@main def assertThatASimpleTypeClassSemigroupWorks:Unit = 
  import MyOps._
  println(join("Hello", "World"))
  println(join(10, 40))
  println(join(List(1,2,3), List(5,6,7))) //Whoa!