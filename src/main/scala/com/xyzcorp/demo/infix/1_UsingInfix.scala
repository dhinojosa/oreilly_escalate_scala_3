package com.xyzcorp.demo.infix

case class Foo(value:Int):
  infix def addThenAddOne(y:Int) = Foo(value + y + 1)
  def + (y:Foo) = Foo(value + y.value)

@main def assertThatInfixWorks:Unit =
  val result = Foo(40) addThenAddOne 20
  assert(result == Foo(61))

  val result2 = Foo(40) + Foo(50)
  assert(result2 == Foo(90))