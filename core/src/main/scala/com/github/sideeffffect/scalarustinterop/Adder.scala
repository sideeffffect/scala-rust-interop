package com.github.sideeffffect.scalarustinterop

import ch.jodersky.jni.nativeLoader

import scala.annotation.nowarn

@nowarn("msg=(never used)|(deprecated)")
@nativeLoader("adder")
class Adder(val base: Int) {
  @native def plus(term: Int): Int // implemented in libadder0.so
}
