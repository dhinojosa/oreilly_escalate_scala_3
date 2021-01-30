package com.xyzcorp.demo.extensions

trait SemiGroup[T]:
  extension (x: T) def combine (y: T): T

given SemiGroup[String] with 
  extension (x: String) def combine (y: String): String  = s"$x $y"

object MyOps:
  def join[A : SemiGroup](x:A, y:A) = x.combine(y)
  
object UsingExtensionsWithTraits {
  @main def assertThatASimpleTypeClassSemigroupWorks:Unit = 
    import MyOps._
    println(MyOps.join("Hello", "World"))
}
