ThisBuild / turbo := true

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
    nativeCompile / sourceDirectory := baseDirectory.value,
  )
  .enablePlugins(JniNative)

lazy val core = project
  .in(file("core"))
  .settings(commonSettings)
  .settings(
    name := "scala-rust-interop-core",
    Compile / mainClass := Some("com.github.sideeffffect.scalarustinterop.Main"),
    libraryDependencies ++= List(
      Dependencies.zio,
      // Test
      Dependencies.zioTest % Test,
      Dependencies.zioTestSbt % Test,
    ),
    sbtJniCoreScope := Compile,
  )
  .dependsOn(native % Runtime)

lazy val commonSettings: List[Def.Setting[_]] = DecentScala.decentScalaSettings ++ List(
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
  crossScalaVersions := List(DecentScala.decentScalaVersion213, DecentScala.decentScalaVersion212),
  testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework"),
  missinglinkExcludedDependencies ++= List(
  ),
  mimaReportBinaryIssues := {},
)

addCommandAlias("ci", "; check; +publishLocal")
