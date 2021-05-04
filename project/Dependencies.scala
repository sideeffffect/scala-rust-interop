import sbt._

object Dependencies {

  object Versions {
    val zio = "1.0.7"
  }

  val zio = "dev.zio" %% "zio" % Versions.zio
  val zioTest = "dev.zio" %% "zio-test" % Versions.zio
  val zioTestSbt = "dev.zio" %% "zio-test-sbt" % Versions.zio
}
