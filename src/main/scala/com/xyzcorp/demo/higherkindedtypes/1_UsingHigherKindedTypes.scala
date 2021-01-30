package com.xyzcorp.demo.higherkindedtypes

trait Functor[F[_]]:
  def fmap[A,B](fa:F[A])(f: A => B):F[B]

object Functor:
  def apply[F[_]](using fun:Functor[F]):Functor[F] = fun 

object ListTypeClasses:
  given Functor[List] with 
    def fmap[A,B](fa:List[A])(f:A => B) = 
      fa.map(f)

case class MyBox[A](value:A)
object MyBox:
  given Functor[MyBox] with
    def fmap[A,B](ba:MyBox[A])(f:A => B):MyBox[B] =
      MyBox(f(ba.value))

object EitherTypeClasses:
  given Functor[[A] =>> Either[String,A]] with
    def fmap[A,B](se:Either[String,A])(f:A => B):Either[String,B] =
      se match
        case Left(x) => Left(x)
        case Right(y) => Right(f(y))

@main def assertUsingAHigherKindedTypeWorksWithList:Unit =
  import ListTypeClasses.given
  val result:List[Int] = Functor[List].fmap(List(1,2,3))(_ * 2)
  println(result)

@main def assertUsingAHigherKindedTypeWorksWithCustom:Unit =
  import MyBox.given
  val result:MyBox[Int] = Functor[MyBox].fmap(MyBox("Hello"))(_.length)
  println(result)

@main def assertUsingWithAnEither:Unit = 
  import EitherTypeClasses.given
  val result = Functor[[A] =>> Either[String,A]].fmap(Right(30))(_ * 2)
  println(result)

trait Monad[F[_]]:
  def pure[A](a:A):F[A]
  def flatMap[A,B](fa:F[A])(f:A => F[B]):F[B]

object Monad:
  def apply[F[_]](using monad:Monad[F]):Monad[F] = monad

object ListTypeClassesPlus:
  given Monad[List] with
    def pure[A](a:A) = List(a)
    def flatMap[A,B](fa:List[A])(f:A => List[B]) = fa.flatMap(f)

@main def assertUsingFlatMapInAMonad:Unit =
  import ListTypeClassesPlus.given
  println(Monad[List].flatMap(List(1,2,3,4))(x => List(-x, x, x + 3)))