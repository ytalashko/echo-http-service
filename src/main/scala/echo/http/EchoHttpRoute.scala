package echo.http

import cats.Monad
import org.http4s.HttpRoutes
import org.http4s.dsl.Http4sDsl

class EchoHttpRoute[F[_]: Monad] extends Http4sDsl[F] {
  import EchoHttpProtocol._, org.http4s.circe.CirceEntityEncoder._

  val httpRoute: HttpRoutes[F] =
    HttpRoutes.of[F] {
      case request @ _ -> Root / "echo" =>
        Ok(EchoUtil.extractEchoResponse(request))
    }

}
