package com.xyzcorp.demo.uniontypes

object UsingUnionTypesWithObjects:
  case class Assigned(username: String)
  case object WontFix
  case object Fixed
  case object Unassigned

  type BugTrackingStatus = Assigned | WontFix.type | Fixed.type | Unassigned.type

  def logStatus(x: BugTrackingStatus): String =
    x match
      case Assigned(x) => s"Assigned to $x"
      case WontFix     => "Won't Fix"
      case Fixed       => "Fixed"
      case Unassigned  => "Unassigned"

  @main def assertThatUnionTypesWorkWithObjects: Unit =
    println(logStatus(Assigned("Daniel")))
    println(logStatus(WontFix))
    println(logStatus(Fixed))
    println(logStatus(Unassigned))
