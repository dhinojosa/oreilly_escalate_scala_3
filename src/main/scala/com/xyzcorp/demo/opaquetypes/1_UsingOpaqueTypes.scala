package com.xyzcorp.demo.opaquetypes

object UsingOpaqueTypes:
  opaque type Currency = String
  object Currency:
    def apply(s: String): Currency = s

  def onlyAcceptCurrency(curr: Currency): Unit = {}

@main def assertThatTheNewTypeCanBeUsedAsString: Unit =
  import UsingOpaqueTypes.*
  val a: Currency = Currency("Dollars")
  //val b:Currency = "Yuan" //Not Valid
  onlyAcceptCurrency(a)
