/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.controllers;

import com.fixit.entities.Prestations;
import com.fixit.services.PrestationsService;
import com.teknikindustries.bulksms.SMS;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class PrestationNonTraiteCellGuiController extends ListCell<Prestations> {

    @FXML
    private AnchorPane gridPane;
    @FXML
    private Label dateprestation;
    @FXML
    private Label nomclient;
    @FXML
    private Button contacter;private FXMLLoader mLLoader;
    @FXML
    private Button details;
    @FXML
    private Label prix;

    /**
     * Initializes the controller class.
     */
    @Override
   protected void updateItem(Prestations student, boolean empty) {
        super.updateItem(student, empty);

        if (empty || student == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/com/fixit/gui/PrestationsCellGui.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(student.getÉtat_prestation()==0){
            nomclient.setText(student.getClient().getFirst_name()+" "+ student.getClient().getLast_name());
            dateprestation.setText(student.getDate_prestation().toString());
            prix.setText(String.valueOf(student.getPrix()));}

        

            details.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent t) {
                   
                    PrestationsGuiController.data_details.removeAll(PrestationsGuiController.data_details);
                    PrestationsGuiController.data_details.add(student);
                    Parent tableViewPrestations;
                        try {
                            tableViewPrestations = FXMLLoader.load(getClass().getResource("/com/fixit/gui/PrestationsGui.fxml"));
                            Scene tableViewContractScene = new Scene(tableViewPrestations);
                            Stage window = (Stage) ((Node) t.getSource()).getScene().getWindow();
                            window.setScene(tableViewContractScene);
                        } catch (IOException ex) {
                            
                        }
                    

                    
                    

                }

            }
                    
            );
            
                     contacter.setOnAction(new EventHandler<ActionEvent>() { 
                @Override
                public void handle(ActionEvent event) {
                    try {
                        PrestationsService ps= new PrestationsService();
                        if(ps.updateEtat(student.getId_prestation())){
                            SMS smstut =new SMS();
                            smstut.SendSMS("balkissbalkiss ", "balkiss123", "Le prestataire a modifié l'état de votre prestation", "21654483350", "https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");
                        }
                        else{
                          TrayNotification tray =new TrayNotification();
            tray.setTitle("Erreur");
        tray.setMessage("La prestation a été déjà traitée");
        tray.setAnimationType(AnimationType.POPUP);
        tray.setNotificationType(NotificationType.INFORMATION);
        tray.showAndWait();}
                    } catch (SQLException ex) {
                        Logger.getLogger(PrestationsCellGuiController.class.getName()).log(Level.SEVERE, null, ex);
                    }
}
                     
                                
                                
                           });
    
                    

                
                

            
            
        
    
        setText(null);
        setGraphic(gridPane);
    }

    

    }
    
}
