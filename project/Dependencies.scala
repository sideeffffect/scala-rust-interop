import sbt._

object Dependencies {

  object Versions {

    val doobie = "0.13.1"
    val circe = "0.13.0"
    val commonsLang = "3.12.0"
    val emil = "0.9.1"
    val http4s = "0.21.22"
    val liquibase = "4.3.5"
    val logback = "1.2.3"
    val mariadb = "2.7.2"
    val snakeyaml = "1.28"
    val zio = "1.0.7"
    val zioCats = "2.4.1.0"
    val zioConfig = "1.0.4"
    val zioMagic = "0.3.0"

    // Test
    val testcontainers = "0.39.3"

    // Scalafix plugins
    val zioMagicComments = "0.1.0"
  }

  val doobie = "org.tpolecat" %% "doobie-hikari" % Versions.doobie
  val circe = "io.circe" %% "circe-generic" % Versions.circe
  val commonsLang = "org.apache.commons" % "commons-lang3" % Versions.commonsLang
  val emil = "com.github.eikek" %% "emil-doobie" % Versions.emil
  val http4sCirce = "org.http4s" %% "http4s-circe" % Versions.http4s
  val http4sDsl = "org.http4s" %% "http4s-dsl" % Versions.http4s
  val http4sServer = "org.http4s" %% "http4s-blaze-server" % Versions.http4s
  val liquibase = "org.liquibase" % "liquibase-core" % Versions.liquibase
  val logback = "ch.qos.logback" % "logback-classic" % Versions.logback
  val mariadb = "org.mariadb.jdbc" % "mariadb-java-client" % Versions.mariadb
  val snakeyaml = "org.yaml" % "snakeyaml" % Versions.snakeyaml
  val zio = "dev.zio" %% "zio" % Versions.zio
  val zioCats = "dev.zio" %% "zio-interop-cats" % Versions.zioCats
  val zioConfig = "dev.zio" %% "zio-config-typesafe" % Versions.zioConfig
  val zioConfigMagnolia = "dev.zio" %% "zio-config-magnolia" % Versions.zioConfig
  val zioMagic = "io.github.kitlangton" %% "zio-magic" % Versions.zioMagic
  val zioTest = "dev.zio" %% "zio-test" % Versions.zio
  val zioTestSbt = "dev.zio" %% "zio-test-sbt" % Versions.zio

  // Test
  val testcontainers = "com.dimafeng" %% "testcontainers-scala-postgresql" % Versions.testcontainers

  // Scalafix plugins
  val zioMagicComments = "com.timushev" %% "zio-magic-comments" % Versions.zioMagicComments
}
