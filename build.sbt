name := "main.scala.Drawing"

version := "1.0"

scalaVersion := "2.9.3"

scalacOptions += "-deprecation"

scalacOptions += "-unchecked"

retrieveManaged := true

libraryDependencies ++= Seq(
   "org.specs2" %% "specs2" % "1.12.4.1" % "test",
   "org.mockito" % "mockito-all" % "1.9.5"
)
