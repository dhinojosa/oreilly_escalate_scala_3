package com.xyzcorp.demo.typeclasses

trait Show[A]: 
  def show(a:A):String

object Show:
  def show[A](a:A)(using shower:Show[A]):String =
    shower.show(a)

object Strings:
  given stringShow:Show[Int] with
    def show(a:Int):String = a.toString

case class Employee(firstName:String, lastName:String)
object Employee:
  given employeeShowFirstNameFirst:Show[Employee] with
    def show(e:Employee):String = s"${e.firstName} ${e.lastName}"

  given employeeShowLastNameFirst:Show[Employee] with
    def show(e:Employee):String = s"${e.lastName} ${e.firstName}"

@main def assertShowIntRepresents:Unit =
  import Strings.given
  import Employee.employeeShowLastNameFirst

  assert(Show.show(123) == "123")
  println(Show.show(Employee("Laser", "Cloud"))) 