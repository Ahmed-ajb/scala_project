import java.sql.{Connection,DriverManager}

object ScalaJdbcConnectSelect extends App {
  // connect to the database named "mysql" on port 8889 of localhost
  val url = "jdbc:mysql://localhost:8888/scala"
  val driver = "com.mysql.jdbc.Driver"
  val username = "root"
  val password = "root"
  var connection:Connection = _
  try {
    Class.forName(driver)
    connection = DriverManager.getConnection(url, username, password)
    val statement = connection.createStatement
    val rs = statement.executeQuery("SELECT Login, passeword FROM admin")
    while (rs.next) {
      val host = rs.getString("Login")
      val user = rs.getString("passeword")
      println("Login = %s, passeword = %s")
    }
  } catch {
    case e: Exception => e.printStackTrace
  }
  connection.close
}