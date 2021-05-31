package com.xyzcorp.demo.enums

enum ScalaColor:
  case RED, GREEN, BLUE

@main def assertThatWeCanCreateEnums: Unit =
  println(ScalaColor.RED)
  println(ScalaColor.BLUE)

@main def assertThatWeCanCreateEnumsFromValues: Unit =
  val redColor: ScalaColor = ScalaColor.valueOf("RED")
  println(s"The color we parsed was $redColor")

@main def assertGettingValuesOfAnEnumInOrder: Unit =
  val colorFound = ScalaColor.values(1)
  assert(colorFound == ScalaColor.GREEN)
