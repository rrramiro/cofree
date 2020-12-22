import doobie._
import doobie.implicits._
import cats._
import cats.free.Cofree
import cats.implicits._


/** Some helpers that would be distracting if they were in the main class. */
trait Extras {

  /** Draw a Cofree value to stdout. This uses universal .toString, sorry. . */
  def draw[F[_]: Traverse, A](fa: Cofree[F, A], indent: Int = 0): ConnectionIO[Unit] =
    for {
      _ <- HC.delay(print(" " * indent))
      _ <- HC.delay(println(s"${fa.head} :< ${fa.tail}"))
      _ <- fa.tail.map(_.traverse(draw(_, indent + 1))).sequence_
    } yield ()

  def drawLine: ConnectionIO[Unit] = HC.delay(println("-" * 100))

  // This is not inferable for mysterious reasons
  //implicit val optionIntWrite = Write.option[JdbcType.JdbcInteger, String, Int]

}
