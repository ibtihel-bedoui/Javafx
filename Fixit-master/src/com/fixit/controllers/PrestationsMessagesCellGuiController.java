/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.controllers;


import com.fixit.entities.Message;
import com.fixit.entities.Prestations;
import com.fixit.services.MessageService;
import com.fixit.services.PrestationsService;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import utils.BadWords;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class PrestationsMessagesCellGuiController extends ListCell<Prestations> {
    private FXMLLoader mLLoader;

    @FXML
    private AnchorPane gridPane;
    private Label dateprestation;
    private Label nomclient;
    private Button contacter;
    private Label prix;
    @FXML
    private Button envoyer;
    @FXML
    private ComboBox<String> choix;
    @FXML
    private TableView<Message> table;
    @FXML
    private TableColumn<Message, String> mes;
    @FXML
    private TextField msg;
    @FXML
    private Label choixla;
    @FXML
    private TableColumn<Prestations, String> exp;
    File f;

    /**
     * Initializes the controller class.
     */
    protected void updateItem(Prestations student, boolean empty) {
        super.updateItem(student, empty);

        if (empty || student == null) {

            setText(null);
            setGraphic(null);

        } else {
            try {
                if (mLLoader == null) {
                    mLLoader = new FXMLLoader(getClass().getResource("/com/fixit/gui/PrestationsMessagesCellGui.fxml"));
                    mLLoader.setController(this);
                    
                    try {
                        mLLoader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    
                }
                choixla.setText(student.getNom_prestation());
                MessageService ms= new MessageService();
                ArrayList<Message> produits= (ArrayList<Message>) ms.afficher(student.getId_prestation(),LoginController.session.getId());
                ObservableList obs=FXCollections.observableArrayList(produits);
                table.setItems(obs);
                mes.setCellValueFactory(new PropertyValueFactory<>("contenu"));
                exp.setCellValueFactory(new PropertyValueFactory<>("nom"));
            } catch (SQLException ex) {
                Logger.getLogger(PrestationsMessagesCellGuiController.class.getName()).log(Level.SEVERE, null, ex);
            }
            envoyer.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    
                        Message m= new Message(LoginController.session.getFirst_name(),LoginController.session.getLast_name(),msg.getText(),student.getId_prestation(),student.getPrestataire().getId(),student.getClient().getId());
                        MessageService ms=new MessageService();
                           BadWords.loadConfigs();
           
                            try {
                                if (BadWords.filterText(msg.getText())) {
                                    
                                    Alert alert = new Alert(Alert.AlertType.ERROR);
                                    alert.setTitle("Application erreur");
                                    alert.setHeaderText("Gros mot détecté");
                                    alert.setContentText("L'application ne vous permet pas d'utiliser ce genre de termes");
                                    alert.showAndWait();
                                } else {
                                    try {
                                        ms.ajouterMessage(LoginController.session.getFirst_name(),LoginController.session.getLast_name(),msg.getText(),student.getId_prestation(),student.getPrestataire().getId(),student.getClient().getId());
                                    } catch (SQLException ex) {
                                        Logger.getLogger(PrestationsMessagesCellGuiController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                ArrayList<Message> produits= (ArrayList<Message>) ms.afficher(student.getId_prestation(),LoginController.session.getId());
                                ObservableList obs=FXCollections.observableArrayList(produits);
                                table.setItems(obs);
                                mes.setCellValueFactory(new PropertyValueFactory<>("contenu"));
                                exp.setCellValueFactory(new PropertyValueFactory<>("nom"));
                            } catch (SQLException ex) {
                                Logger.getLogger(PrestationsMessagesCellGuiController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                    }
            });
    }    
        setText(null);
        setGraphic(gridPane);
    
}}
