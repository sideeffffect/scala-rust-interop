package com.github.sideeffffect.scalarustinterop

import zio.test.Assertion._
import zio.test._
import zio.test.environment._

object MainSpec extends DefaultRunnableSpec {
  def spec: ZSpec[TestEnvironment, Failure] =
    suite("MainSpec")(
      test("adder")(assert(new Adder(12).plus(34))(equalTo(46))),
    )
}
