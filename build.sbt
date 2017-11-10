import Dependencies._
import sbt.Keys.libraryDependencies

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.ocono",
      scalaVersion := "2.12.3",
      version := "0.1.0-SNAPSHOT"
    )),
    name := "Hello",
    libraryDependencies ++= Seq(
      "org.apache.kafka" % "kafka_2.11" % "0.8.2.1",
      "org.apache.kafka" % "kafka-streams" % "1.0.0",
      "org.scalatest" % "scalatest_2.10" % "2.0" % "test"
)
)
