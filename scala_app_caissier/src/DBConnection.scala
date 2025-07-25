import scala.util.Try

object DBConnection {
  private var connection: DBConnection = _

  def getConnection: DBConnection = {
    if (connection == null) {
      connection = new DBConnection
    }
    connection
  }

  def closeConnection(): Try[Unit] = {
    Try {
      connection.close()
      connection = null
    }
  }
}

