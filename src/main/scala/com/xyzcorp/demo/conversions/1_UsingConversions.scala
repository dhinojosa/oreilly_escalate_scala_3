package com.xyzcorp.demo.conversions

import scala.language.implicitConversions

object UsingConversions:
   case class Currency(value:Int)
  
   given Conversion[Int, Currency] = Currency(_)

   @main def assertASimpleCurrencyConversion:Unit =
     val currency:Currency = 40
     println(currency)