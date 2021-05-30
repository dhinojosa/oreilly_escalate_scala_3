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

enum DebugLevel:
  case FATAL, ERROR, WARN, INFO, DEBUG, TRACE, OFF

case class LogItem(level:DebugLevel, msg:String)

trait DebugThreshold(val threshold:DebugLevel)

trait LogStack(depth:Int) extends DebugThreshold:
  import scala.collection.mutable.Queue
  private val queue = Queue.empty[LogItem]
  def add(logItem:LogItem) =
    if logItem.level.ordinal <= threshold.ordinal then
      queue.enqueue(logItem)
    if queue.size > depth then queue.dequeue
  def elements = queue.toList

case class Account(accountNumber: String, balance:Long) extends LogStack(5) with DebugThreshold(DebugLevel.WARN):
  def deposit(amount:Long) =
    add(LogItem(DebugLevel.DEBUG, s"Depositing $amount"))
  def withdrawal(amount:Long) =
    add(LogItem(DebugLevel.DEBUG, s"Attempt withdrawal of $amount"))
    if !(balance - amount < 0) then
      add(LogItem(DebugLevel.DEBUG,s"Withdrawal $amount successful"))

@main def assertThatWeCanUseTraitParameters:Unit =
  val account = Account("12-40-590903", 1203)
  println(account.elements)
  account.deposit(40)
  account.deposit(400)
  account.withdrawal(100)
  account.withdrawal(1200)
  account.withdrawal(1300)
  account.withdrawal(1400)
  println(account.elements)
