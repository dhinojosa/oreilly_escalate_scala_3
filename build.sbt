name := "oreilly_escalate_scala_3"

version := "1.0-SNAPSHOT"

description := "Material for O'Reilly Escalate Scala 3 Training"

scalaVersion := "3.0.0-M3"

fork := true

scalacOptions ++= Seq(
  "-Xfatal-warnings",
  "-feature",
  "-deprecation",
  "-Yexplicit-nulls",
  "-Ycheck-init"
)

libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"