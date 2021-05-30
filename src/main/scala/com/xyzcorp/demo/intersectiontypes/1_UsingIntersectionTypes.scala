package com.xyzcorp.demo.intersectiontypes

/**
 * Intersection Types are an and relationship of types.
 * These are also available in Java
 * We will using the & to represent something that has all
 * the relationships
 **/ 

trait Completeable:
  def complete(): Unit
   
trait Auditable:
  def audit(s: String): Unit
    
class ProcessListener extends Auditable with Completeable:
  def complete(): Unit = println("Complete called")
  def audit(s: String): Unit = println(s"Audit called with $s")

object UsingIntersectionTypes:
  def process(x: Completeable & Auditable, y: Int, z: Int): Int =
    x.audit(s"about to add to elements: $y and $z")
    val sum = y + z
    x.audit(s"sum found: $y and $z = $sum")
    x.complete()
    sum

@main def assertThatWeCanRunAnIntersectionType:Unit = 
  UsingIntersectionTypes.process(new ProcessListener, 10, 50)