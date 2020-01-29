ThisBuild / scalaVersion := "2.13.1"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.example"
ThisBuild / organizationName := "example"

resolvers += Resolver.sonatypeRepo("releases")

scalacOptions ++= Seq(
  "-encoding", "UTF-8", // source files are in UTF-8
  "-deprecation", // warn about use of deprecated APIs
  "-unchecked", // warn about unchecked type parameters
  "-feature", // warn about misused language features
  "-language:higherKinds", // allow higher kinded types without `import scala.language.higherKinds`
  "-Xlint", // enable handy linter warnings
  "-Xfatal-warnings", // turn compiler warnings into errors
  "-Yrangepos" // Use range positions for syntax trees.
)

val http4sVersion = "0.21.0-M5"
val tsecVersion = "0.2.0-M2"
val logbackVersion = "1.2.3"
val catsEffectVersion = "2.0.0"
val catsVersion = "2.0.0"
val circeVersion = "0.12.1"
val catsLogVersion = "1.0.1"

val spec2Version = "4.6.0"

lazy val root = (project in file("."))
  .settings(
    name := "securing api",
    scalacOptions in Test ++= Seq("-Yrangepos"),
    libraryDependencies ++= Seq(
      "org.slf4j" % "slf4j-simple" % "1.7.30",

      "org.typelevel" %% "cats-effect" % catsEffectVersion,
      "org.typelevel" %% "cats-core" % catsVersion,

      "org.http4s" %% "http4s-dsl" % http4sVersion,
      "org.http4s" %% "http4s-blaze-server" % http4sVersion,
      "org.http4s" %% "http4s-blaze-client" % http4sVersion,
      "org.http4s" %% "http4s-circe" % http4sVersion,

      "io.circe" %% "circe-generic" % circeVersion,
      "io.circe" %% "circe-literal" % circeVersion,

      "io.github.jmcardon" % "tsec-http4s_2.13" % tsecVersion,

      "org.specs2" %% "specs2-core" % spec2Version % Test,
    )
  )