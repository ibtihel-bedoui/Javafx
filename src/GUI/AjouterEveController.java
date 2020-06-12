/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import entities.evenement;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import services.evenementCRUD;

/**
 * FXML Controller class
 *
 * @author pc-ibtihel
 */
public class AjouterEveController implements Initializable {

    @FXML
    private TextField txtlibelle;
    @FXML
    private TextField txtdescription;
    @FXML
    private DatePicker txtdebut;
    @FXML
    private DatePicker txtfin;
    @FXML
    private Button imageEvent;
     @FXML
    private ImageView iv;
       @FXML
    private Label lblMsg;
   
    @FXML
    private Button accuei;
    @FXML
    private Button ajout;
    @FXML
    private Button ajout1;
       
       
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    @FXML
     public String handle() {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

        //Show open file dialog
        File file = fileChooser.showOpenDialog(null);
        String filePath = file.getAbsolutePath();
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            iv.setImage(image);

        } catch (IOException ex) {
            System.err.println(ex);
        }

        return filePath;
    }
     private boolean Validation(ActionEvent event) {
        boolean result = true;
       if (txtlibelle.getText().equals("")){
            lblMsg.setText("Libelle ne peut pas être vide!");    
            result = false ; 
            txtlibelle.setStyle("-fx-text-box-border: #B22222; -fx-focus-color: #B22222;");
        }else if(txtdebut.getValue().equals("")){
            lblMsg.setText("Date debut ne peut pas être vide !"); 
            result = false ; 
            txtdebut.setStyle("-fx-text-box-border: #B22222; -fx-focus-color: #B22222;");
        }else if(txtfin.getValue().equals("")){
            lblMsg.setText("Date fin ne peut pas être vide !"); 
            result = false ; 
            txtfin.setStyle("-fx-text-box-border: #B22222; -fx-focus-color: #B22222;");
        }else if(txtdescription.getText().equals("")){
            lblMsg.setText("Description ne peut pas être vide !"); 
            result = false ; 
            txtdescription.setStyle("-fx-text-box-border: #B22222; -fx-focus-color: #B22222;");
        }
        return result;
    }
  @FXML
    private void ajouter(ActionEvent event) {
         String path ="./assets/img/";
        if (Validation(event)) {
            lblMsg.setText(""); 
        
        String image = imageEvent.getText();
        String libelle = txtlibelle.getText();
        String description = txtdescription.getText();
        Date debut = java.sql.Date.valueOf(txtdebut.getValue());
        Date fin = java.sql.Date.valueOf(txtfin.getValue());
        
        
        evenementCRUD ec = new evenementCRUD();
        evenement e = new evenement(image , libelle, description , debut, fin );
    
              ec.ajouterEvenement(e);

           FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficheEve.fxml"));  
            try {
                Parent root = loader.load();
                AfficheEveController lc = loader.getController();
                txtlibelle.getScene().setRoot(root);

            } catch (IOException ex) {
                Logger.getLogger(AjouterEveController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
   



    @FXML
    private void accueil(ActionEvent event)throws IOException {
                     
              Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
    }

  /*  @FXML
    private void afficher(ActionEvent event) throws IOException {
                     
               Parent root;

            root = FXMLLoader.load(getClass().getResource("AfficheEve.fxml"));

            affiche.getScene().setRoot(root);
    }
*/

    @FXML
    private void Map(ActionEvent event) throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("myMapView.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
    }
 
}


     
 