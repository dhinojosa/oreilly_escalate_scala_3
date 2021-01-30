package com.xyzcorp.demo.optionalbraces

case class Ounces(value:Int):
  def toMilliliters = value * 29.5735
    
case class Beverage(name:String, 
  suggestedServing:Ounces, 
  isAlcoholic:Boolean)

object UsingOptionalBraces extends App:
  val cocaCola = Beverage("Coca Cola", Ounces(12), false)
  println(cocaCola)