import javafx.fxml.{FXML, Initializable}
import javafx.scene.control.TextField

import java.util.ResourceBundle
import com.sun.corba.se.impl.util.Utility.printStackTrace
import javafx.event.ActionEvent
import javafx.scene.control.Button
import javafx.scene.image.{Image, ImageView}
import javafx.scene.layout.AnchorPane
import javafx.scene.{Parent, Scene}
import javafx.stage.Stage

import java.net.URL
import java.util.ResourceBundle
import java.awt.Desktop
import java.io.File
import java.nio.file.Paths
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.pdmodel.PDPage
import org.apache.pdfbox.pdmodel.PDPageContentStream
import org.apache.pdfbox.pdmodel.font.PDType1Font
import saission.CaissierSaission



class CaissierForm extends Initializable {
  var productName,quantity,price,orderNumber:String=null
  @FXML  var productNameField: TextField = _
  @FXML var quantityField: TextField = _
  @FXML var priceField: TextField = _
  @FXML var orderNumberField: TextField = _

  override def initialize(location: URL, resources: ResourceBundle): Unit = {
    // Initialisation du formulaire (optionnel)
  }

  def handleSubmit(event: ActionEvent): Unit = {
     productName = productNameField.getText
     quantity = quantityField.getText
     price = priceField.getText
     orderNumber = orderNumberField.getText
    pdfFichier()

    def pdfFichier(): Unit ={
      val username = CaissierSaission.userName.toString


      val generator = new InvoiceGenerator()
      generator.generateInvoice("123456", username, Seq((productName, price.toDouble, quantity.toInt)), (quantity.toInt*price.toInt) )
      /** Traitement des données saisies
      val fileName = "form.pdf"
      val file = new File(fileName)
      val document = new PDDocument()
      val page = new PDPage()
      document.addPage(page)

      val font = PDType1Font.HELVETICA_BOLD
      val fontSize = 12
      val lineHeight = 1.5f * fontSize

      val contentStream = new PDPageContentStream(document, page)
      contentStream.beginText()
      contentStream.setFont(font, fontSize)
      contentStream.newLineAtOffset(50, 700)

      contentStream.showText("Nom du produit : " + productName)
      contentStream.newLineAtOffset(0, -lineHeight)
      contentStream.showText("Quantité : " + quantity)
      contentStream.newLineAtOffset(0, -lineHeight)
      contentStream.showText("Prix : " + price)
      contentStream.newLineAtOffset(0, -lineHeight)
      contentStream.showText("Numéro de commande : " + orderNumber)

      contentStream.endText()
      contentStream.close()

      document.save(file)
      document.close()

      println("Le fichier PDF a été enregistré dans " + file.getAbsolutePath)
      Desktop.getDesktop.open(file)
      **/
    }
  }
}