import javafx.fxml.{FXML, FXMLLoader, Initializable}
import javafx.scene.control.{Button, Label, PasswordField, TextField}
import javafx.scene.{Parent, Scene}
import javafx.stage.Stage

import java.net.URL
import java.util.ResourceBundle
import java.io.IOException
import baseDonne.DBConnection
import javafx.scene.layout.AnchorPane
import saission.CaissierSaission

class CaissierUser extends Initializable {



  override def initialize(location: URL, resources: ResourceBundle): Unit = {
  /**  val button: Button = new Button
    button.setText("Click me!")
    button.setOnAction(_ => println("Button clicked!"))

  */
  button.setOnAction(_ =>userLogIn() )
  }

  @FXML
  private var anchorPane: AnchorPane = _

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
    else if (username.getText.isEmpty && password.getText.isEmpty) wrongLogIn.setText("svp entre les information.")
    else  if (DBConnection.isValidCredentials(username.getText, password.getText)) {
      wrongLogIn.setText("bounjour soufiane !")
      CaissierSaission.userName = Some(username.getText)

      // Chargez la deuxième page lorsque le bouton est cliqué
      val fxmlLoader = new FXMLLoader(getClass.getResource("caissierForm.fxml"))
      val root = fxmlLoader.load[Parent]
      val scene = new Scene(root)
      val stage = anchorPane.getScene.getWindow.asInstanceOf[Stage]
      stage.setScene(scene)

    }




}}