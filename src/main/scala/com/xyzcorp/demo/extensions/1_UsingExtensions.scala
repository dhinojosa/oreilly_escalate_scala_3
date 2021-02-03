package com.xyzcorp.demo


object UsingExtensions:

  extension (x:Int)
    def isOdd:Boolean = x % 2 == 0
    def isEven:Boolean = !isOdd

  @main def assertASimpleExtensionWorks:Unit =
    println(10.isEven)
    println(isEven(3))