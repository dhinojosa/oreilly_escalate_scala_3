package com.xyzcorp.demo.givenusing

object UsingGivenParameters:
  case class Rate(value:Int)
  case class Hours(value:Int)

  given Rate = Rate(100) //binding Rate.class = Rate(100)

  def calculateTimeSheet(x:Hours)(using r:Rate) =
    x.value * r.value

@main def assertWeGetTheImplicitValue:Unit =
  import UsingGivenParameters._  
  assert(calculateTimeSheet(Hours(40)) == 4000)

  val currentRate:Rate = summon[Rate]
  println(currentRate)
