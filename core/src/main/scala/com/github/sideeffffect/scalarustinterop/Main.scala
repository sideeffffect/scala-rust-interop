package com.github.sideeffffect.scalarustinterop

object Main {

  def main(args: Array[String]): Unit = {
    println("hello")
    val adder = new Adder(1)
    val sum = adder.plus(2)
    println(s"sum: $sum")
  }
}
