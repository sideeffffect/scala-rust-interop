import ch.jodersky.sbt.jni.build._
import sbt._

import java.io.File
import scala.sys.process._

object Cargo extends BuildTool {

  override def name: String = "cargo"

  override def detect(baseDirectory: File): Boolean =
    baseDirectory.list().contains("Cargo.toml")

  override protected def templateMappings: Seq[(String, String)] = List()

  override def getInstance(baseDirectory: File, buildDirectory: File, logger: sbt.Logger): Instance =
    new Instance {

      // IntelliJ friendly logger, it doesn't start tests a line is printed as "error"
      private val log = new ProcessLogger {
        def out(s: => String): Unit = logger.info(s)
        def err(s: => String): Unit = logger.warn(s)
        def buffer[T](f: => T): T = f
      }

      def clean(): Unit =
        Process("cargo clean", baseDirectory) ! log

      def library(targetDirectory: File): File = {
        val ev =
          Process(s"cargo build --target-dir ${targetDirectory.getAbsolutePath}", baseDirectory) ! log
        if (ev != 0) sys.error(s"Building native library failed. Exit code: $ev")

        val products: List[File] =
          (targetDirectory / "debug" * ("*.so" | "*.dylib")).get.filter(_.isFile).toList

        // only one produced library is expected
        products match {
          case Nil =>
            sys.error(
              s"No files were created during compilation, " +
                s"something went wrong with the ${name} configuration.",
            )
          case head :: Nil =>
            head
          case head :: _ =>
            logger.warn(
              "More than one file was created during compilation, " +
                s"only the first one (${head.getAbsolutePath}) will be used.",
            )
            head
        }
      }

    }
}
