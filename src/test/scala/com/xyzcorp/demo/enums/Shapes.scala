package com.xyzcorp.demo.enums

enum Shape:
  case Triangle(width:Double, height:Double)
  case Rectangle(length:Double, height:Double)
  case Circle(radius:Double)

import Shape._
def area(s:Shape):Double = 
  s match
    case Triangle(w, h) => 0.5 * w * h
    case Rectangle(w, h) => w * h
    case Circle(r) => Math.PI * r * r

@main def assertArea:Unit = 
  println(area(Triangle(30, 10)))