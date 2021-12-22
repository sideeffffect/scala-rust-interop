package com.github.sideeffffect.scalarustinterop

import zio.test.Assertion._
import zio.test._
import zio.test.environment._

object MainSpec extends DefaultRunnableSpec {
  def spec: ZSpec[TestEnvironment, Failure] =
    suite("MainSpec")(
      test("divider")(assert(new Divider(36).divide(12))(equalTo(3))),
    )
}
