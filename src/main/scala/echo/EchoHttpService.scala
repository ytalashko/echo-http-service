package echo

import cats.effect.Async
import echo.config.HttpConfig
import echo.http.EchoHttpRoute
import fs2.Stream
import org.http4s.blaze.server.BlazeServerBuilder
import org.http4s.syntax.kleisli._

import scala.concurrent.ExecutionContext

class EchoHttpService[F[_]: Async](httpConfig: HttpConfig) {

  def stream: Stream[F, Unit] =
    for {
      echoRoute  <- Stream.emit(new EchoHttpRoute[F].httpRoute)
      echoHttpApp = echoRoute.orNotFound
      _          <-
        BlazeServerBuilder[F](ExecutionContext.global)
          .bindHttp(httpConfig.port, httpConfig.host)
          .withHttpApp(echoHttpApp)
          .serve
    } yield ()

}
