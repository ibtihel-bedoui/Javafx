/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;




import entities.evenement;
import entities.participant;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import services.evenementCRUD;
import services.participantCRUD;
import utils.Database;


/**
 * FXML Controller class
 *
 * @author pc-ibtihel
 */
public class AfficheDetailsController implements Initializable {
  @FXML
    private TextField txtnom;
    @FXML
    private TextField txtprenom;
    @FXML
    private TextField txtnum;
    @FXML
    private Button ajout;
     @FXML
    private Button txtcancel;
 
    
    private Event event;
   
    @FXML
    private TableColumn<participant, String> txtname;
    @FXML
    private TableColumn<participant, String> txtlast;
    @FXML
    private TableColumn<participant,Integer> txtnumber;
       @FXML
    private TableView<participant> tableUser;
    private TextField txtlibelle;
    private TextField txtdebut;
    private TextField txtfin;
    private TextField txtdescription;
    @FXML
    private Button supp;
    @FXML
    private Button accuei;
    private TextField txtimage;
 
       
    /**
     * Initializes the controller class.
     * @param url
     */
    
      @Override
    public void initialize(URL url, ResourceBundle rb) {
   

        
        
 participantCRUD ps = new participantCRUD();
     Database db = Database.getInstance();
    Connection con = db.getConnection();

         ArrayList<participant> pers = (ArrayList<participant>) ps.afficherParticipant();
        ObservableList<participant> obs = FXCollections.observableArrayList(pers);
        tableUser.setItems(obs);

         txtname.setCellValueFactory(new PropertyValueFactory<>("nom"));
         txtlast.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        txtnumber.setCellValueFactory(new PropertyValueFactory<>("numdossard"));
       
    //   txtname.setSortType(TableColumn.SortType.DESCENDING);
      //  txtlast.setSortType(TableColumn.SortType.DESCENDING);
        // txtnumber.setSortType(TableColumn.SortType.DESCENDING);
   ajout.setOnAction(((event) -> {

       if (txtnom.getText().isEmpty() || txtprenom.getText().isEmpty() || txtnum.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("il faut remplir tous les champs");
                alert.showAndWait();
            } else if (txtprenom.getText().matches("^[0-9\\\\s]*$") || txtnom.getText().matches("^[0-9\\\\s]*$") ) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("le nom , le prenom   doivent etre des chaines de characteres");
                alert.showAndWait();
            } else if (txtnum.getText().matches("^[a-z A-Z\\\\s]*$")) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("num dossard  doivent etre des nombres");
                alert.showAndWait();

            } else
           
            {
                
                
                int i  ;
                participant p = new participant();
                i= Integer.parseInt(txtnum.getText());
                p.setNumdossard(i);
                p.setNom(txtnom.getText());
                p.setPrenom(txtprenom.getText());
                ps.ajouterParticipant(p);
    

               
               
    

            }  
        }));
   }  


    @FXML
    private void cancel(ActionEvent event) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficheEve.fxml"));
        try {
            Parent root = loader.load();
            AfficheEveController apc = loader.getController();
            txtcancel.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
 private void refreshTable(List<participant> a) {
        ObservableList<participant> obs;
        obs = FXCollections.observableArrayList();
        obs.addAll(a);
        tableUser.setItems(obs);
        FilteredList<participant> filteredData = new FilteredList<>(obs, b -> true);
     
       SortedList<participant> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableUser.comparatorProperty());
        tableUser.setItems(sortedData);
//        System.out.println(obs);

    } 
    @FXML
    private void delete(ActionEvent event) {
        
                participant u = tableUser.getSelectionModel().getSelectedItem();
                participantCRUD userC = new participantCRUD();
                userC.deleteParticipant(u);
            JOptionPane.showMessageDialog(null, "Delete Event ");
            refreshTable(userC.afficherParticipant());
    }

    @FXML
    private void accueil(ActionEvent event) {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
        try {
            Parent root = loader.load();
            AfficheEveController apc = loader.getController();
            txtcancel.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        
    }
    }




    void initData(evenement e){
       txtimage.setText(e.getNom_image());
       txtlibelle.setText(e.getLibelle());
        txtdescription.setText(e.getDescription());
        txtdebut.setText(e.getDatedebut().toString());
       txtfin.setText(e.getDatefin().toString());
               }

 


    
}