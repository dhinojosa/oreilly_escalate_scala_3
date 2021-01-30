package com.xyzcorp.exercises.objects

enum Shape:
  case Triangle(base:Double, height:Double)
  case Rectangle(width:Double, height:Double)
  case Circle(radius:Double)

import Shape._
def area(s:Shape):Double =
  s match
    case Triangle(b, h) => 0.5 * b * h
    case Rectangle(w, h) => w * h
    case Circle(r) => scala.math.Pi * r * r

@main def assertThatAreaWorks:Unit =
  println(Triangle(10, 3))
  println(Rectangle(10, 3))
  println(Circle(10))