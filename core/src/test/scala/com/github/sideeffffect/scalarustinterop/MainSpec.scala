package com.github.sideeffffect.scalarustinterop

import zio.Task
import zio.test.Assertion._
import zio.test._
import zio.test.environment._

object MainSpec extends DefaultRunnableSpec {
  def spec: ZSpec[TestEnvironment, Failure] =
    suite("MainSpec")(
      test("successful division") {
        val actual = new Divider(37).divideBy(12)
        val expected = 3
        assert(actual)(equalTo(expected))
      },
      testM("division by 0 trows") {
        val divisionByZero = Task(new Divider(36).divideBy(0))
        val expected = fails(isSubtype[RuntimeException](hasMessage(equalTo("attempt to divide by zero"))))
        for {
          actual <- divisionByZero.run
        } yield assert(actual)(expected)
      },
    )
}
