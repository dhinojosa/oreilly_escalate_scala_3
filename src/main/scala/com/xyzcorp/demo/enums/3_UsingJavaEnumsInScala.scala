package com.xyzcorp.demo.enums

/**
 * Things to notice:
 * 1. Planet.MARS is not from Scala, but from Java
 * 2. Seemless Integration in Scala
 */
@main def assertThatWeCanUseJavaEnumsInScala:Unit =
    println(Planet.MARS.surfaceGravity())

