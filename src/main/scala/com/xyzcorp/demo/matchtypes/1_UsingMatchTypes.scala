package com.xyzcorp.demo.matchtypes

/**
 * Source https://dotty.epfl.ch/docs/reference/new-types/match-types.html
 * 
 * A match type reduces to one of its right-hand sides, depending
 * on the type of its scrutinee. What that means is that we are defining the types
 * we should get for the inputs.
 * 
 */
type Possible[X] = X match
  case String => Char
  case Array[t] => Possible[t]
  case AnyVal => X

def compute[X](x: X): Possible[X] = x match 
  case x: String      => x.charAt(0)
  case x: Array[t]    => compute(x(2))
  case x: AnyVal      => x

@main def assertStandardMatchType:Unit =
  val a:Possible[String] = compute("Hello")
  val b:Possible[Int] = compute(Array(1,2,3,4))
  val c:Possible[Char] = compute('c')  
  val d:Char = c
  println(a)
  println(b)
  println(c)
  println(d)

import scala.compiletime.ops.int.%

type HCF[A <: Int, B <: Int] <: Int = B match {
    case 0 => A
    case _ => HCF[B, A % B]
}

//A: 50, B: 10
//HCF[10, 0]
//10

//A:25, B:10
//HCF[10, 5]
//A:10, B:5
//HCF[5, 0]

//Source: https://medium.com/@knoldus/match-types-in-dotty-3c1ee76868af

@main def assertThatAbilityToChangeTypes:Unit = 
  val a:HCF[50, 10] = 10
  val b:HCF[100, 0] = 100
  val c:HCF[25, 10] = 5
  val d:5 = 5 //5 is a type
  