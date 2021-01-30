package com.xyzcorp.demo.algebraicdatatypes

//ADT - Algebraic Data Type
enum Tree[+T] {
  case Branch(left: Tree[T], right:Tree[T])
  case Leaf(value: T)
}

import Tree._
@main def assertTreeCreation:Unit = 
  val tree = 
     Branch(left = Branch(left = Leaf(40), 
              right = Branch(left = Leaf(20), Leaf(100))) 
              , right = Branch(left = Leaf(20), right = Leaf(60)))
  println(tree)

  tree match
    case Branch(Branch(x, _), _) => println(s"Got inner value $x")
    case _ => println("Other match pattern")

//GADT - Generalized Algebraic Data Types
//* Unable to really do with previous versions of Scala
//* Expr is a GADT because each of its cases extends Expr 
//  with different type arguments. 
//
//Source: http://lptk.github.io/files/%5Bv.2.0.1%5D%20scala19_gadt.pdf

enum Expr[A]:
  case Var[A](a: A) extends Expr[A]
  case Lit(n: Int) extends Expr[Int]
  case Plus(lhs: Expr[Int], rhs: Expr[Int]) extends Expr[Int]
  case Fun[A, B](fun: Expr[A] => Expr[B]) extends Expr[A => B]
  case App[A, B](fun: Expr[A => B], arg: Expr[A]) extends Expr[B]

import Expr._
def eval[A](e: Expr[A]): A = e match {
  case Var(x) => x 
  case Lit(n) => n
  case Plus(a,b) => eval(a) + eval(b)
  case f: Fun[a,b] => (x: a) => eval(f.fun(Var(x)))
  case App(fun,arg) => eval(fun)(eval(arg))
}

@main def assertThatWeCanWeUseAGADT:Unit =
  println(eval(Plus(Lit(4), Lit(5))))
  println(eval(Fun(a => Plus(a, Lit(5)))))
  println(eval(App(Fun(a => Plus(a, Lit(5))), Lit(10))))