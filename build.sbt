import Dependencies._

lazy val options = Seq(
  "-language:postfixOps",
  "-Ykind-projector",
  "-Yexplicit-nulls",
  "-source", "3.1",
  "-deprecation",
  "-encoding",
  "UTF-8",
  "-feature",
  "-unchecked",
  "-language:implicitConversions"
)

lazy val root = project
  .in(file("."))
  .settings(
    name := "tagless-final-dotty",
    version := "0.1.0",
    scalaVersion := dottyVersion,
    scalacOptions ++= options,
    libraryDependencies ++= Seq(
      scalaTest.withDottyCompat(dottyVersion)
    )
  )
