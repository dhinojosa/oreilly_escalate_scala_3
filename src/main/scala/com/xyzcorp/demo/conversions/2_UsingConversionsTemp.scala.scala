package com.xyzcorp.demo.conversions

import scala.language.implicitConversions

case class Fahrenheit(value:Int):
  override def toString = s"$value°F"

case class Celcius(value:Int):
  override def toString = s"$value°C"

object Temperature:
  given Conversion[Fahrenheit, Celcius] = 
    (f:Fahrenheit) => Celcius(((f.value.toDouble - 32) * (5.0/9.0)).round.toInt)

  given Conversion[Celcius, Fahrenheit] = 
    (c:Celcius) => Fahrenheit(((c.value.toDouble * (9.0/5.0)) + 32).round.toInt)

@main def assertThatTemperatureCanBeConverted:Unit =
  import Temperature.given
  val f:Fahrenheit = Celcius(0) 
  println(f)