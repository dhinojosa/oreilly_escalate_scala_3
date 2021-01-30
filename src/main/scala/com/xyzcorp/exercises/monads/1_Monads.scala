package com.xyzcorp.exercises.monads

trait Monad[F[_]]:
  def pure[A](a:A):F[A]
  def flatMap[A,B](fa:F[A])(f:A => F[B]):F[B]

object Monad:
  def apply[F[_]](using monad:Monad[F]):Monad[F] = monad

case class MyBox[A](value:A)

@main def assertThatMyBoxMonadWorks:Unit =
  println("Remove this line and put your own")