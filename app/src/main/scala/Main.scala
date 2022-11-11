import common.example.Sum
import zio._

object Main extends ZIOAppDefault {
  override def run: ZIO[Environment with ZIOAppArgs with Scope, Any, Any] =
    (for {
      _ <- ZIO.logInfo("Hello World!")
      _ <- ZIO.logInfo(s"Result of 1 + 1 is ${Sum(1, 1)}")
      _ <- ZIO.logInfo(s"new code 2.0")
    } yield ()).exitCode
}
