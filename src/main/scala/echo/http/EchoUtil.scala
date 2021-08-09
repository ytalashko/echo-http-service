package echo.http

import org.http4s.Request

object EchoUtil {
  import EchoHttpProtocol._

  def extractEchoResponse[F[_]](request: Request[F]): EchoResponse =
    EchoResponse(
      requestPath    = extractRequestPath(request),
      requestingIp   = extractRequestingIP(request),
      requestHeaders = extractRequestHeaders(request),
      requestCookies = extractRequestCookies(request)
    )

  private def extractRequestPath[F[_]](request: Request[F]): RequestPath =
    RequestPath(request.uri.path.toString)

  private def extractRequestingIP[F[_]](request: Request[F]): Option[RequestingIP] =
    request.remoteAddr
      .map(address => RequestingIP(address.toString))

  private def extractRequestHeaders[F[_]](request: Request[F]): RequestHeaders =
    RequestHeaders(
      request.headers.headers
        .view
        .map(header => header.name.toString -> header.value)
        .toMap
    )

  private def extractRequestCookies[F[_]](request: Request[F]): RequestCookies =
    RequestCookies(
      request.cookies
        .view
        .map(cookie => cookie.name -> cookie.content)
        .toMap
    )

}
