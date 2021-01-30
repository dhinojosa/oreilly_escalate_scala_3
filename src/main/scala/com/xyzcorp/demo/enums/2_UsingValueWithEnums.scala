package com.xyzcorp.demo.enums

/**
 * Things to notice:
 * 1. We added a field to the enum
 * 2. We have separate case statements for each of the values
 * 3. Each element extends from the base enum
 **/
enum ScalaColorValues(val hexadecimal:String):
  case RED extends ScalaColorValues("#FF0000")
  case GREEN extends ScalaColorValues("#00FF00")
  case BLUE extends ScalaColorValues("#0000FF")

object UsingValuesWithEnums:
  @main def assertThatEqualityOfEnumsCanBeMade:Unit =
    assert(ScalaColorValues.RED.hexadecimal == ScalaColorValues.RED.hexadecimal)

  @main def assertThatEqualityIsAutomatic:Unit =
    assert(ScalaColorValues.BLUE == ScalaColorValues.BLUE)