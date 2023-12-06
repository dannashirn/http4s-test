import cats.effect.IO
import cats.effect.unsafe.implicits.global
import org.http4s.client.Client

object App extends App {

  import org.http4s.client.JavaNetClientBuilder

  // for REPL or mdoc use only!
  val httpClient: Client[IO] = JavaNetClientBuilder[IO].create
  val myClient = new MyClient[IO](httpClient)

  myClient.sth(MyRequest()).unsafeRunSync()
}
