package com.xyzcorp.demo.extensions

import java.time._

object UsingExtensionsWithGenerics:

  case class Employee(firstName:String, 
                      lastName:String, 
                      employees:List[Employee])

  extension [A](a:A)
     def toDatedString:String =
       "[%s] %s".format(LocalDateTime.now, a.toString)

  extension[A](a:A)(using numeric:Numeric[A])
    def cubed:A =   
      numeric.times(a, numeric.times(a, a))
    def beforeAndAfter(b:A):(A,A,A) = 
      (numeric.minus(a,b), a, numeric.plus(a,b))
     
  @main def assertThatAnExtensionGenerically:Unit =
    val employee = Employee("James", "Gosling", Nil)
    println(employee.toDatedString)
    
    println(3.cubed)    
    println(5.0.cubed)
    println((440.3f).beforeAndAfter(10.0f))