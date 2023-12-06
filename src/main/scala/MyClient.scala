import cats.Applicative
import cats.effect.Concurrent
import cats.implicits.{catsSyntaxApplicativeError, catsSyntaxApplicativeId}
import org.http4s.{Method, Request, Status}
import org.http4s.client.Client
import org.http4s.implicits.http4sLiteralsSyntax
import org.http4s.circe.CirceEntityEncoder._
import io.circe.syntax.EncoderOps
import org.http4s.Status.ClientError


class MyClient[F[_]: Concurrent: Applicative](client: Client[F]) {
  def sth(reqBody: MyRequest) = {
    val request: Request[F] =
      Request[F](
        method = Method.POST,
        uri = uri"https://google.com"
      ).withEntity(reqBody.asJson)

    client.expect[Unit](request).redeem(
      error => println("Got an error")
      ,
      result => result
    )
  }
}
