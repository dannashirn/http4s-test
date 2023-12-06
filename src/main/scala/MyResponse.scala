import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec

case class MyResponse()

object MyResponse {
  implicit val codec: Codec[MyResponse] = deriveCodec
}