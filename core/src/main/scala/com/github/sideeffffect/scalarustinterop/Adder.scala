package com.github.sideeffffect.scalarustinterop

import com.github.ghik.silencer.silent
import com.github.sbt.jni.nativeLoader

@nativeLoader("adder")
@silent("never used")
class Adder(val base: Int) {
  @native def plus(term: Int): Int // implemented in libadder.so
}
