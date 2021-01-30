package com.xyzcorp.exercises.typeclasses

trait Sample[A]:
  def sample:A

object Samples:
 
  import scala.util.Random

  given Sample[Int] with
    def sample:Int = Random.nextInt

  given Sample[Double] with
    def sample:Double = Random.nextDouble

  given Sample[String] with
    def sample:String = Random.nextString(1 + Random.nextInt(20))
  
  given Sample[Long] with
    def sample:Long = Random.nextLong

  given [T](using sm: => Sample[T]):Sample[List[T]] with 
    def sample:List[T] = 
      LazyList.fill(1 + Random.nextInt(20))(sm.sample).toList

  def drawSample[A](using s:Sample[A]) = s.sample

@main def testSample:Unit =
  import Samples.given
  println(Samples.drawSample[Int])
  println(Samples.drawSample[Double])
  println(Samples.drawSample[String])
  println(Samples.drawSample[List[String]])
  println(Samples.drawSample[List[Long]])