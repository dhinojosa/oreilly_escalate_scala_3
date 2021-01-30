package com.xyzcorp.demo.mutiversalequality

//Turn on Strict Equality
//Can also be turned on with: -language:strictEquality at command line
import scala.language.strictEquality

class Box[T](x: T) derives CanEqual

@main def assertThatCanEqualWorks:Unit =
  //println(Box(40) == Box("Hello")) //Will not compile
  println(Box(1203) == Box(123.0)) //Will compile since there is a CanEqual[Int, Double] instance
  println(summon[CanEqual[Int, Double]]) //Show that there is an instance
  println(summon[CanEqual[Box[String], Box[String]]]) //Show that there is an instance
