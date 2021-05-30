name := "oreilly_escalate_scala_3"

version := "1.0-SNAPSHOT"

description := "Material for O'Reilly Escalate Scala 3 Training"

scalaVersion := "3.0.0"

fork := true

scalacOptions ++= Seq(
  "-Xfatal-warnings",
  "-feature",
  "-deprecation",
  "-Yexplicit-nulls"
)

libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"
