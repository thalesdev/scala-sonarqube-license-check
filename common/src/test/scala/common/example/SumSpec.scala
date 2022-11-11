package common.example

import zio.test._
import zio._

object SumSpec extends ZIOSpecDefault {
  override def spec: Spec[TestEnvironment with Scope, Any] = suite("SumSpec")(
    test("Ensure eval is correct") {
      val result = for {
        evaluation <- ZIO.succeed(Sum(1, 1).eval)
      } yield assertTrue(evaluation == 2)
      result
    }
  )
}
