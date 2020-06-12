/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import entities.evenement;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import services.evenementCRUD;
import utils.Database;

/**
 * FXML Controller class
 *
 * @author pc-ibtihel
 */
public class EventFrontController implements Initializable {

     @FXML
    private TableColumn<evenement, String> txtimage;
    @FXML
    private TableColumn<evenement, String> txtlibelle;
    @FXML
    private TableColumn<evenement,Date> txtdebut;
    @FXML
    private TableColumn<evenement,Date> txtfin;
    @FXML
    private TableColumn<evenement, String> txtdescription;
    @FXML
    private TextField searchBar;
  @FXML
    private Button retou;
    @FXML
    private TableView<evenement> tableUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        
         txtimage.setCellValueFactory(new PropertyValueFactory<evenement, String>("nom_image"));
       txtlibelle.setCellValueFactory(new PropertyValueFactory<evenement, String>("libelle"));
        txtdescription.setCellValueFactory(new PropertyValueFactory<evenement, String>("description"));
        txtdebut.setCellValueFactory(new PropertyValueFactory<evenement, Date>("datedebut"));
       txtfin.setCellValueFactory(new PropertyValueFactory<evenement, Date>("datefin"));
       
        
        evenementCRUD uc = new evenementCRUD();
        refreshTable(uc.afficherEvenement());
        

    }    
      

  private void refreshTable(List<evenement> a) {
        ObservableList<evenement> obs;
        obs = FXCollections.observableArrayList();
        obs.addAll(a);
        tableUser.setItems(obs);
        FilteredList<evenement> filteredData = new FilteredList<>(obs, b -> true);
        searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(aff -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (aff.getLibelle().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches first name.
                } else {
                    return false; // Does not match.
                }
            });
        });
       SortedList<evenement> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableUser.comparatorProperty());
        tableUser.setItems(sortedData);
  }
    
     @FXML
    private void afficher(ActionEvent event) throws IOException {
     
  Parent root = FXMLLoader.load(getClass().getResource("Comment.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
     
    }

    @FXML
    private void retour(ActionEvent event)throws IOException {
                     
              Parent root = FXMLLoader.load(getClass().getResource("FrontPage.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
    }

   
    
}

   