package com.xyzcorp.demo.targetname

  import scala.annotation.targetName

  case class Fraction(numerator:Int, denominator: Int):
  
  def toDouble = 
    numerator.toDouble / denominator.toDouble

  @targetName("add") def + (other: Fraction):Fraction = 
    if (this.denominator == other.denominator) then
      Fraction(this.numerator + other.numerator, this.denominator) 
    else 
      val target = this.denominator max other.denominator
      Fraction((target / this.denominator) *  this.numerator, target) 
        + Fraction((target / other.denominator) * other.numerator, target) 
    end if

  def reduce:Fraction =
     if (numerator < 2) then this
     else 
       (this.numerator to 2 by -1)
         .find(n => numerator % n == 0 && denominator % n == 0)
         .map(candidate => Fraction(this.numerator / candidate, this.denominator / candidate))
         .getOrElse(this)

@main def assertThatWeCanAddFraction:Unit =
  val addition = Fraction(1,4) + Fraction(1,4)
  println(addition.reduce)

  val addition2 = Fraction(1,4) + Fraction(1,2)
  println(addition2.reduce)

  val addition3 = Fraction(3,20) + Fraction(2,20)
  println(addition3.reduce)

  val addition4 = Fraction(10, 20).reduce
  println(addition4.reduce)

  val addition5 = Fraction(-1,4) + Fraction(5,12)
  println(addition5.reduce)

  val addition6 = Fraction(-0,4) + Fraction(5,12)
  println(addition6.reduce)

//Here we can disambiguate two function that without the @targetName
//would be the same, due to type erasure

@targetName("f_string")
def f(x: => String): Int = x.length
def f(x: => Int): Int = x + 1  // OK

