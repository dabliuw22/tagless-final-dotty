import sbt._

object Dependencies {
  lazy val scalaTest: ModuleID = "org.scalatest" %% "scalatest" % "3.0.8" % Test
  lazy val jUnit: ModuleID = "com.novocode" % "junit-interface" % "0.11" % Test
  lazy val dottyVersion = "0.27.0-RC1"
}
