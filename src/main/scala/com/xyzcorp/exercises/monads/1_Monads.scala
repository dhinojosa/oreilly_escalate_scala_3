package com.xyzcorp.exercises.monads

trait Monad[F[_]]:
  def pure[A](a:A):F[A]
  def flatMap[A,B](fa:F[A])(f:A => F[B]):F[B]

object Monad:
  def apply[F[_]](using monad:Monad[F]):Monad[F] = monad

case class MyBox[A](value:A)

object MyBox:
  given Monad[MyBox] with
    def pure[A](a:A):MyBox[A] = MyBox(a)
    def flatMap[A,B](fa:MyBox[A])(f:A => MyBox[B]) = f(fa.value)
      
@main def assertThatMyBoxMonadWorks:Unit =
   println(Monad[MyBox].flatMap(MyBox(302))(a => MyBox(a + 1230)))
    