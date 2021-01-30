package com.xyzcorp.demo.uniontypes

object UsingUnionTypes:
  
  type Pad = Int | String

  def padding(s:String, pad:Pad):String =
    pad match
      case x:Int => 
        val r = " ".repeat(x)
        s"$r$s$r"
      case y:String =>
        s"$y$s$y"
  
  @main def assertThatUnionTypesWork:Unit =
    assert(padding("Hello", 3) == "   Hello   ")
    assert(padding("Hello", "~~~") == "~~~Hello~~~")