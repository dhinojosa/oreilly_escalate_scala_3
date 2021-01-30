package com.xyzcorp.demo.targetname;

public class UsingTargetNameFromJava {
  public static void main(String[] args) {
     Fraction fraction1 = new Fraction(3, 10);
     Fraction fraction2 = new Fraction(5, 20);
     System.out.println(fraction1.add(fraction2).reduce());
  }
}