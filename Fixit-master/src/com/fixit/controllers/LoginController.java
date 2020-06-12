/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.controllers;

import com.fixit.entities.user;
import com.fixit.services.userService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class LoginController implements Initializable {
    static user session;
    @FXML
    private TextField usernametextfield;
    @FXML
    private TextField passwordtextfield;
    @FXML
    private ImageView image1;
    @FXML
    private Button LoginButton;
    @FXML
    private Button ExitButton;
    @FXML
    private Label error;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void LoginConnectMouseClicked(MouseEvent event) throws SQLException, IOException {
        boolean b= false;
        
        userService us= new userService();
        user u=new user();
        if(us.chercherUser(usernametextfield.getText(), passwordtextfield.getText()))
        {
            
                u =us.donnerUser(usernametextfield.getText(), passwordtextfield.getText());
                session=u;
                
                Parent tableViewOpportunity=FXMLLoader.load(getClass().getResource("/com/fixit/gui/PrestationsGui.fxml"));
                Scene tableViewOpportunityScene=new Scene (tableViewOpportunity);
                Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(tableViewOpportunityScene);
               
        
        }
        
        else{
             TrayNotification tray =new TrayNotification();
            tray.setTitle("Erreur");
        tray.setMessage("Veuillez saisir vos coordonnées à nouveux");
        tray.setAnimationType(AnimationType.POPUP);
        tray.setNotificationType(NotificationType.INFORMATION);
        tray.showAndWait();}
       
       
    }

    
}
