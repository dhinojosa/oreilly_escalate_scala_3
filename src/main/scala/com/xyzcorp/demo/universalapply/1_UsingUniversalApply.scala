package com.xyzcorp.demo.universalapply

class Person(firstName: String, lastName: String):
  def this() = this("John", "Doe")
  override def toString = s"Person {firstName = $firstName, lastName = $lastName}"

@main def assertThatWeDontRequireNewKeyword: Unit =
  val person = Person("Albert", "Einstein")
  val person1 = Person()
  println(person)
  println(person1)

@main def assertThatWeCanCallJavaCommandsWithoutNew: Unit =
  val m = java.util.ArrayList[Int]() //Whoa!
  m.add(30)
  m.add(20)
  println(m)
