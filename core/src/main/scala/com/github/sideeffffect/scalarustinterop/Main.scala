package com.github.sideeffffect.scalarustinterop

object Main {

  def main(args: Array[String]): Unit = {
    println("hello")
    val divider = new Divider(7)
    val fraction = divider.divide(3)
    println(s"fraction: $fraction")
  }
}
