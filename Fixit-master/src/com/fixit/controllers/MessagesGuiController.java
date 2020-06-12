/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.controllers;

import static com.fixit.controllers.PrestationsGuiController.data_details;
import com.fixit.entities.Message;
import com.fixit.entities.Prestations;
import com.fixit.services.PrestationsService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class MessagesGuiController implements Initializable {
    ObservableList<Prestations> data;
    @FXML
    private Button mesprestation;
    @FXML
    private Button mesmessage;
    @FXML
    private Button monavancement;
    @FXML
    private ListView<Prestations> lists;
    @FXML
    private ListView<Message> messages;
    public static List<Message> data_msg = new ArrayList<Message>();
    @FXML
    private Button mesprestation1;
    @FXML
    private Button mesmessage1;
    @FXML
    private Button monavancement1;
    @FXML
    private ComboBox<?> nomprestataire;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PrestationsService ps = new PrestationsService();
        try {
            data = ps.listerPrestations(LoginController.session.getId());
        } catch (SQLException ex) {
            Logger.getLogger(PrestationsGuiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        lists.setItems(data);
        ObservableList<Message> li = FXCollections.observableArrayList(data_msg);
        messages.setItems(li);
     lists.setCellFactory(PrestationsListView -> new PrestationsMessagesCellGuiController());
            mesmessage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Parent tableViewOpportunity=FXMLLoader.load(getClass().getResource("/com/fixit/gui/MessagesGui.fxml"));
                    Scene tableViewOpportunityScene=new Scene (tableViewOpportunity);
                    Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(tableViewOpportunityScene);
                } catch (IOException ex) {
                    Logger.getLogger(PrestationsGuiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
            mesprestation.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Parent tableViewOpportunity=FXMLLoader.load(getClass().getResource("/com/fixit/gui/PrestationsGui.fxml"));
                    Scene tableViewOpportunityScene=new Scene (tableViewOpportunity);
                    Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(tableViewOpportunityScene);
                } catch (IOException ex) {
                    Logger.getLogger(PrestationsGuiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
              monavancement.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Parent tableViewOpportunity=FXMLLoader.load(getClass().getResource("/com/fixit/gui/AvancementPersonnelGui.fxml"));
                    Scene tableViewOpportunityScene=new Scene (tableViewOpportunity);
                    Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(tableViewOpportunityScene);
                } catch (IOException ex) {
                    Logger.getLogger(PrestationsGuiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }    
    
}
