import javafx.fxml.{FXML, FXMLLoader, Initializable}
import javafx.scene.control.{Button, Label,TextField, PasswordField}
import javafx.scene.{Parent, Scene}
import javafx.stage.Stage

import java.net.URL
import java.util.ResourceBundle

import java.io.IOException


class MyApplication extends Initializable {



  override def initialize(location: URL, resources: ResourceBundle): Unit = {
  /**  val button: Button = new Button
    button.setText("Click me!")
    button.setOnAction(_ => println("Button clicked!"))

  */
  button.setOnAction(_ =>userLogIn() )
  }



  @FXML
  private var button: Button = _
  @FXML
  private var wrongLogIn: Label = _
  @FXML
  private var username: TextField  = _
  @FXML
  private var password: PasswordField = _

  @throws[IOException]
  def userLogIn(): Unit = {
    checkLogin()
  }

  @throws[IOException]
  private def checkLogin(): Unit = {

    if (username.getText.toString.equals("soufiane") && password.getText.toString.equals("123")) {
      wrongLogIn.setText("Success!")
      println("bravooooooooooooooooooooooooooooo")
    }
    else if (username.getText.isEmpty && password.getText.isEmpty) wrongLogIn.setText("Please enter your data.")
    else wrongLogIn.setText("Wrong username or password!")
  }




}