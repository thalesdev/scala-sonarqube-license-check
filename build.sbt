ThisBuild / scalaVersion := "2.13.8"
ThisBuild / scapegoatVersion := "1.4.17"
ThisBuild / version := "0.1.3"
ThisBuild / organization := "thalesdev"
ThisBuild / organizationName := "Thales"
ThisBuild / testFrameworks := Seq(new TestFramework("zio.test.sbt.ZTestFramework"))

ThisBuild / scalacOptions := Seq(
  "-language:higherKinds",
  "-deprecation",
  "-encoding",
  "utf-8",
  "-explaintypes",
  "-feature",
  "-language:existentials",
  "-language:implicitConversions",
  "-unchecked",
  "-Xfatal-warnings",
  "-Xlint:infer-any",
  "-Xlint:type-parameter-shadow",
  "-Ywarn-dead-code",
  "-Ywarn-extra-implicit",
  "-Ywarn-unused:implicits",
  "-Ywarn-unused:imports",
  "-Ywarn-unused:locals",
  "-Ywarn-unused:params",
  "-Ywarn-unused:patvars",
  "-Ywarn-unused:privates",
  "-Ywarn-value-discard"
)
Scapegoat / scalacOptions += "-P:scapegoat:overrideLevels:all=Warning"
scapegoatReports := Seq("xml")
fork := true

val deeps = libraryDependencies ++= Seq(
  "dev.zio" %% "zio"          % "2.0.3",
  "dev.zio" %% "zio-test"     % "2.0.3" % Test,
  "dev.zio" %% "zio-test-sbt" % "2.0.3" % Test
)

lazy val common = (project in file("common"))
  .settings(deeps)

lazy val app = (project in file("app"))
  .dependsOn(common)
  .aggregate(common)
  .settings(deeps)
  .enablePlugins(JavaAppPackaging)

run := (app / Compile / runMain).toTask(" Main").value

sonarUseExternalConfig := true
Test / coverageEnabled := true
