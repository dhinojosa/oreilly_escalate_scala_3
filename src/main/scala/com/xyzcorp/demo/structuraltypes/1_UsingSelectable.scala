package com.xyzcorp.demo.selectable

/**
 * https://dotty.epfl.ch/docs/reference/changed-features/structural-types.html
 *
 * We are looking at Programmatic Structural Types Used for things like databases accessibility where we make elements
 * look like dynamic methods The key difference though is that
 */

object WeatherFinder:
  case class Record(attributes: (String, Any)*) extends Selectable:
    def selectDynamic(name: String): Any =
      println(s"finding $name")
      attributes.find(_._1 == name).get._2

  //describe the type from raw untyped elements
  type Weather = Record {
    val temperature: Int
    val humidity: Int
    val windMpg: Int
    val heatIndex: Int
  }

  def findByCity(city: String): Weather =
    val result =
      if city == "Atlanta" then Record("temperature" -> 90, "humidity" -> 88)
      else Record("temperature" -> 80, "humidity" -> 7)
    result.asInstanceOf[Weather]

@main def findByCity: Unit =
  val temp = WeatherFinder.findByCity("Atlanta").temperature
  println(s"Temperature in Atlanta is $temp")
