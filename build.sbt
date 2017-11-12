// The simplest possible sbt build file is just one line:

scalaVersion := "2.12.3"

name := "game-of-life"
organization := "ch.epfl.scala"
version := "1.0"
libraryDependencies += "org.typelevel" %% "cats" % "0.9.0"
libraryDependencies += "org.scalafx" %% "scalafx" % "8.0.144-R12"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.4" % "test"
