/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.controllers;

import com.fixit.entities.Prestations;
import com.fixit.entities.user;
import com.fixit.services.PrestationsService;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.ZapfDingbatsList;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.javafx.scene.control.skin.ColorPalette;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class DetailsCellGuiController extends ListCell<Prestations> {
  @FXML
    private AnchorPane gridPane;
    @FXML
    private TextField nomclient;
    @FXML
    private TextField catégorie;
    @FXML
    private DatePicker date;
    @FXML
    private TextField etat;
    @FXML
    private TextField prix;
    @FXML
    private TextField description;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private Button extraire;
    private FXMLLoader mLLoader;
    
    

    /**
     * Initializes the controller class.baaaaaaaaaaaaaaalbel
     */
    
@Override
    protected void updateItem(Prestations student, boolean empty) {
        super.updateItem(student, empty);

        if (empty || student == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/com/fixit/gui/DetailsCellGui.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            nomclient.setStyle("-fx-text-inner-color: #fade53; -fx-background-color: #3a4455;");
            prix.setStyle("-fx-text-inner-color: #fade53; -fx-background-color: #3a4455;");
            catégorie.setStyle("-fx-text-inner-color: #fade53; -fx-background-color: #3a4455;");
            description.setStyle("-fx-text-inner-color: #fade53; -fx-background-color: #3a4455;");
            etat.setStyle("-fx-text-inner-color: #fade53; -fx-background-color: #3a4455;");
            nomclient.setText(student.getClient().getFirst_name()+" "+ student.getClient().getLast_name());
          
           date.setPromptText(student.getDate_prestation().toString());
            prix.setText(String.valueOf(student.getPrix()));
            catégorie.setText(String.valueOf(student.getId_sous_catégorie()));
            description.setText(student.getDescription_prestation());
            if(student.getÉtat_prestation()==0)
            {
            etat.setText("Pas encore traitée");
            }
            else
            {
            etat.setText("traitée");
            }    
            extraire.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                    Font Font1 = FontFactory.getFont(FontFactory.HELVETICA, 22, Font.NORMAL);
                    Font1.setColor(250,222,83);
                    try {
                        //System.out.println(LoginController.session.getFirst_name());
                    Rectangle pageSize = new Rectangle(PageSize.A4);
                    pageSize.setBackgroundColor(new BaseColor(58,68,85));
                    Document document = new Document( pageSize );                        
                        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Prestation.pdf"));
                        document.open();
                        Image img = Image.getInstance("logo.png");
                        img.setAbsolutePosition(450f, 700f);
                        
                        document.add(img);
                        document.add(new Paragraph("Détails prestation ",Font1));
                        Paragraph p1= new Paragraph(nomclient.getText());
                        
                        document.add(p1);
                       
                        
                        document.close();
                    } catch (DocumentException ex) {
                        Logger.getLogger(DetailsCellGuiController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(DetailsCellGuiController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(DetailsCellGuiController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    
            TrayNotification tray =new TrayNotification();
            tray.setTitle("Succès");
        tray.setMessage("La prestation a été exportée en PDF");
        tray.setAnimationType(AnimationType.POPUP);
        tray.setNotificationType(NotificationType.INFORMATION);
        tray.showAndWait();}
            
            
           
           
            
            
        
                
                
            });
        supprimer.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                  if (alertConfirmation() == true) {
                        try {
                            PrestationsService ps = new PrestationsService();
                            ps.deletePrestation(student.getId_prestation());

                        } catch (SQLException ex) {
                            Logger.getLogger(DetailsCellGuiController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        Parent tableViewPrestations;
                        try {
                            tableViewPrestations = FXMLLoader.load(getClass().getResource("/com/fixit/gui/PrestationsGui.fxml"));
                            Scene tableViewPrestationScene = new Scene(tableViewPrestations);
                            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            window.setScene(tableViewPrestationScene);
                        } catch (IOException ex) {
                            Logger.getLogger(DetailsCellGuiController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                
                }

               
        });
        modifier.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                       
                           
                            if(date.getValue()==null)
                   {
                       TrayNotification tray =new TrayNotification();
            tray.setTitle("Erreur");
        tray.setMessage("Veuillez remplir tous les champs");
        tray.setAnimationType(AnimationType.POPUP);
        tray.setNotificationType(NotificationType.INFORMATION);
        tray.showAndWait();}
                   
                            else{
                                try {
                                     PrestationsService ps = new PrestationsService();
                            student.setDate_prestation(java.sql.Date.valueOf(date.getValue()));
                            student.setPrix(Integer.parseInt(prix.getText()));
                                    ps.updatePrestation(student);
                                } catch (SQLException ex) {
                                    Logger.getLogger(DetailsCellGuiController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            Parent tableViewPrestations;
                            try {
                                tableViewPrestations = FXMLLoader.load(getClass().getResource("/com/fixit/gui/PrestationsGui.fxml"));
                                Scene tableViewPrestationScene = new Scene(tableViewPrestations);
                                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                window.setScene(tableViewPrestationScene);
                            } catch (IOException ex) {
                                Logger.getLogger(DetailsCellGuiController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }

                
                
            
                });
        

 
//        setText(null);
        setGraphic(gridPane);
        }}
    
    
private boolean alertConfirmation() {
        Alert a1 = new Alert(Alert.AlertType.CONFIRMATION);
        a1.setTitle("CONFIRMATION DIALOG");
        a1.setHeaderText("SUPPRESSION CONFIRMATION");
        a1.setContentText("Voullez vous vraiment supprimer cette prestation?");
        Optional<ButtonType> result = a1.showAndWait();
        if (result.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }

    }

}
