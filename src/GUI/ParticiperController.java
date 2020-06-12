/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.participant;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
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
import javafx.stage.Stage;
import services.participantCRUD;
import utils.Database;

/**
 * FXML Controller class
 *
 * @author pc-ibtihel
 */
public class ParticiperController implements Initializable {

    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtprenom;
    @FXML
    private TextField txtnum;
    @FXML
    private Button ajout;
 @FXML
    private TableColumn<participant, String> txtname;
    @FXML
    private TableColumn<participant, String> txtlast;
    @FXML
    private TableColumn<participant,Integer> txtnumber;
       @FXML
    private TableView<participant> tableUser;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   participantCRUD ps = new participantCRUD();
     Database db = Database.getInstance();
    Connection con = db.getConnection();

       
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
    private void retour(ActionEvent event) throws IOException {
                     
              Parent root = FXMLLoader.load(getClass().getResource("Comment.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
    }
    
}
