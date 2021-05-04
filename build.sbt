lazy val root = project
  .in(file("."))
  .settings(commonSettings)
  .settings(
    name := "scala-rust-interop",
    publish / skip := true,
  )
  .aggregate(
    core,
    native,
  )

lazy val native = project
  .in(file("native"))
  .settings(commonSettings)
  .settings(
    name := "scala-rust-interop-native",
    nativeBuildTool := Cargo,
    nativeCompile / sourceDirectory := sourceDirectory.value,
    libraryDependencies ++= List(
    ),
  )
  .enablePlugins(JniNative)

lazy val core = project
  .in(file("core"))
  .settings(commonSettings)
  .settings(
    name := "scala-rust-interop-core",
    Compile / mainClass := Some("com.github.sideeffffect.scalarustinterop.Main"),
    javah / target := (native / nativeCompile / sourceDirectory).value / "include",
    scalacOptions --= List("-Xfatal-warnings"),
    libraryDependencies ++= List(
      //      Dependencies.doobie,
      //      Dependencies.circe,
      //      Dependencies.commonsLang,
      //      Dependencies.emil,
      //      Dependencies.http4sCirce,
      //      Dependencies.http4sDsl,
      //      Dependencies.http4sServer,
      //      Dependencies.liquibase,
      //      Dependencies.logback,
      //      Dependencies.mariadb,
      //      Dependencies.snakeyaml,
      Dependencies.zio,
      //      Dependencies.zioCats,
      //      Dependencies.zioConfig,
      //      Dependencies.zioConfigMagnolia,
      //      Dependencies.zioMagic,
      // Test
      //      Dependencies.testcontainers % Test,
      Dependencies.zioTest % Test,
      Dependencies.zioTestSbt % Test,
    ),
  )
  .dependsOn(native % Runtime)

lazy val commonSettings: List[Def.Setting[_]] = /* DecentScala.decentScalaSettings ++ */ List(
  organization := "com.github.sideeffffect",
  homepage := Some(url("https://github.com/sideeffffect/scala-rust-interop")),
  licenses := List("GPLv3" -> url("https://www.gnu.org/licenses/gpl-3.0.en.html")),
  developers := List(
    Developer(
      "sideeffffect",
      "Ondra Pelech",
      "ondra.pelech@gmail.com",
      url("https://github.com/sideeffffect"),
    ),
  ),
  scalaVersion := crossScalaVersions.value.head,
  crossScalaVersions := List("2.13.5"),
//  crossScalaVersions := List(DecentScala.decentScalaVersion213),
//  ThisBuild / scalafixDependencies ++= List(
//    Dependencies.zioMagicComments,
//  ),
  testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework"),
//  missinglinkExcludedDependencies ++= List(
//    moduleFilter(organization = "ch.qos.logback", name = "logback-classic"),
//    moduleFilter(organization = "ch.qos.logback", name = "logback-core"),
//    moduleFilter(organization = "com.zaxxer", name = "HikariCP"),
//    moduleFilter(organization = "org.slf4j", name = "slf4j-api"),
//  ),
//  mimaReportBinaryIssues := {},
  // https://github.com/olafurpg/sbt-ci-release/issues/181
  sonatypeCredentialHost := "s01.oss.sonatype.org",
  sonatypeRepository := "https://s01.oss.sonatype.org/service/local",
)

addCommandAlias("ci", "; javah; check; +publishLocal")
