package com.xyzcorp.demo.typeclasses

trait Show[A]: 
  def show(a:A):String

object Show:
  def show[A](a:A)(using shower:Show[A]):String =
    shower.show(a)

  given stringShow:Show[Int] with
    def show(a:Int):String = a.toString

object UsingShow:
  @main def assertShowIntRepresents:Unit =
    import Show.stringShow
    assert(Show.show(123) == "123") 