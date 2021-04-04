package com.xyzcorp.demo.traitparameters


/**
* trait is like a Java interface
* Arguments to a trait parameters are evaluated 
* immediately before the trait is initialized.
*
* What is the difference between the abstract and
* trait then? Abstract has a "is-a-relationship"
* Traits offer I am "adding in a feature"
**/

trait Transaction(amt:Int, currency:String):
  def log:String = 
     s"Transaction of $amt $currency was processed"

case class Deposit(amt:Int, currency:String) extends Transaction(amt, currency)
case class Withdrawal(amt:Int, currency:String) extends Transaction(amt, currency)

@main def assertThatTraitCanContainParams:Unit = 
  val deposit = Deposit(100, "Yen")
  println(deposit.log)

  val deposit2 = Deposit(500, "Euro")
  println(deposit2.log)