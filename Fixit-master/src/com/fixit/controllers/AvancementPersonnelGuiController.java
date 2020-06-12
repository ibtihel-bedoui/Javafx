/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.controllers;

import com.fixit.entities.Prestations;
import com.fixit.entities.user;
import com.fixit.services.userService;
import com.fixit.util.ConnectionDb;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.jfree.data.xy.XYSeries;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class AvancementPersonnelGuiController implements Initializable {

    @FXML
    private Button mesprestation;
    @FXML
    private Button mesmessage;
    @FXML
    private Button monavancement;
    @FXML
    private Label salaire;
  userService u = new userService();
    int f,f1;
    float pri;
    @FXML
    private Label nbrprest;
    @FXML
    private Label pack1;
    @FXML
    private Label pack2;
    @FXML
    private Label pack3;
    @FXML
    private Label pack;
    @FXML
    private Label prime;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      
        try {
            f = u.Salaire(LoginController.session.getId());
            salaire.setText(""+f);
        } catch (SQLException ex) {
            Logger.getLogger(AvancementPersonnelGuiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            f1 = u.NombrePrestations(LoginController.session.getId());
            nbrprest.setText(""+f1);
        } catch (SQLException ex) {
            Logger.getLogger(AvancementPersonnelGuiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(f<500){
            pack.setText("Low pack");
            pri=(f*5)/100;
            prime.setText(String.valueOf(pri));
            pack1.setStyle("-fx-font-size:12;-fx-text-fill:#FF0080;");
        }
        if((f>500)&&(f<1000)){
            pack.setText("Meduim pack");
            pri=(f*10)/100;
            prime.setText(String.valueOf(pri));
            pack2.setStyle("-fx-font-size:12;-fx-text-fill:#FF0080;");
        }
        if(f>1000){
            pack.setText("High pack");
            pri=(f*15)/100;
            prime.setText(String.valueOf(pri));
            pack3.setStyle("-fx-font-size:12;-fx-text-fill:#FF0080;");
        }
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


        
    
   

