package echo

import cats.effect.{ExitCode, IO, IOApp}
import echo.config.HttpConfig

object EchoApp extends IOApp {

  private val httpConfig =
    HttpConfig(
      host = "localhost",
      port = 9532
    )

  override def run(args: List[String]): IO[ExitCode] =
    new EchoHttpService[IO](httpConfig).stream.compile.drain.as(ExitCode.Success)

}
