package com.github.sideeffffect.scalarustinterop

import com.github.ghik.silencer.silent
import com.github.sbt.jni.syntax.NativeLoader

@silent("never used")
class Divider(val numerator: Int) extends NativeLoader("divider") {
  @native def divideBy(denominator: Int): Int // implemented in libdivider.so
}
