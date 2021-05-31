package com.xyzcorp.demo.tuples

/**
 * The following is different in Scala 3, since we do not need {case (x,y) => x * y}, we can just treat the tuple as
 * separate arguments, this is called parameter untupling
 */
@main def assertUsingTuplesInFunctions: Unit =
  val xs = List(1.0, 4.0)
  val ys = List(10.0, 50.0)
  println(xs.zip(ys).map(_ * _).sum)
