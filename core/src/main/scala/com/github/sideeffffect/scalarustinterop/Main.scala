package com.github.sideeffffect.scalarustinterop

import scala.io.StdIn
import scala.util.control.NonFatal

object Main {

  def main(args: Array[String]): Unit = {
    println("Provide numerator:")
    val numerator = StdIn.readLine().toInt
    val divider = new Divider(numerator)
    println("Provide denominator:")
    val denominator = StdIn.readLine().toInt
    try {
      val fraction = divider.divideBy(denominator)
      println(s"Fraction: $fraction")
    } catch {
      case NonFatal(t) =>
        println(s"Unexpected error: ${t.getMessage}")
    }
  }
}
