import Dependencies._

lazy val options = Seq(
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
