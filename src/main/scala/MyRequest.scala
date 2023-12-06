import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec

case class MyRequest()

object MyRequest {
  implicit val codec: Codec[MyRequest] = deriveCodec
}