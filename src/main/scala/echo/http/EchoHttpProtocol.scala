package echo.http

import io.circe.Encoder
import io.circe.generic.extras.Configuration
import io.circe.generic.extras.semiauto.{deriveConfiguredEncoder, deriveUnwrappedEncoder}

object EchoHttpProtocol {

  case class RequestPath(value: String) extends AnyVal

  case class RequestingIP(value: String) extends AnyVal

  case class RequestHeaders(value: Map[String, String]) extends AnyVal

  case class RequestCookies(value: Map[String, String]) extends AnyVal

  case class EchoResponse(
    requestPath: RequestPath,
    requestingIp: Option[RequestingIP],
    requestHeaders: RequestHeaders,
    requestCookies: RequestCookies
  )

  private implicit val encoderConfiguration: Configuration =
    Configuration.default.withDefaults.withSnakeCaseMemberNames

  implicit val requestPathEncoder: Encoder[RequestPath] =
    deriveUnwrappedEncoder

  implicit val requestingIPEncoder: Encoder[RequestingIP] =
    deriveUnwrappedEncoder

  implicit val requestHeadersEncoder: Encoder[RequestHeaders] =
    deriveUnwrappedEncoder

  implicit val requestCookiesEncoder: Encoder[RequestCookies] =
    deriveUnwrappedEncoder

  implicit val echoResponseEncoder: Encoder[EchoResponse] =
    deriveConfiguredEncoder

}
