package com.github.sideeffffect.scalarustinterop

import com.github.ghik.silencer.silent
import com.github.sbt.jni.nativeLoader

@nativeLoader("divider")
@silent("never used")
class Divider(val numerator: Int) {
  @native def divide(denominator: Int): Int // implemented in libdivider.so
}
