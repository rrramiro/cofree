scalaVersion := "2.13.4"

scalacOptions ++= Seq(
  "-encoding", "UTF-8", // 2 args
  "-feature",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-unchecked",
  "-Xlint",
  "-Ywarn-dead-code",
  "-Ywarn-value-discard"
)

val filterConsoleScalacOptions = { options: Seq[String] =>
  options.filterNot(
    Set(
      "-Ywarn-dead-code",
      "-Ywarn-value-discard",
      "-Xlint"
    )
  )
}

scalacOptions in (Compile, console) ~= filterConsoleScalacOptions
scalacOptions in (Test, console) ~= filterConsoleScalacOptions

val doobieVersion = "0.10.0-M2"
val attoVersion = "0.8.0"

libraryDependencies ++= Seq(
  "org.tpolecat"  %% "doobie-core"       % doobieVersion,
  "org.tpolecat"  %% "doobie-postgres"   % doobieVersion,
  "org.tpolecat"  %% "atto-core"         % attoVersion
)

addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.11.2" cross CrossVersion.full)

enablePlugins(MdocPlugin)

initialCommands := """
  |import atto._
  |import Atto._
  |import cats._
  |import cats.free._
  |import cats.implicits._
  |import cats.effect._
  |import doobie._
  |import doobie.implicits._
  |import doobie.postgres.implicits._
  """.stripMargin.trim

Global / onChangedBuildSource := ReloadOnSourceChanges
