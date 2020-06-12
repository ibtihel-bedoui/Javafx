/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class MyMapViewController implements Initializable {
    WebEngine engine;
    public static String Location;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private WebView aWebView;
    @FXML
    private Label locationLbl;
    @FXML
    private Button retour;
    
    
   
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         engine = aWebView.getEngine();
         engine.load("https://www.google.tn/maps/");
    }

    @FXML
    private void setLocationClicked(ActionEvent event) {
        
        System.out.println("aaaaa");
        System.out.println(engine.getLocation());
        String codejs = "document.getElementById(\"searchboxinput\").value";
        System.out.println(engine.executeScript(codejs));
        locationLbl.setText(engine.getLocation());
        Location = (String) engine.executeScript(codejs);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CompetitionsPage.fxml"));
        Stage mapWindow = (Stage) rootPane.getScene().getWindow();
        if (!"".equals(Location))
        mapWindow.close();
    }

    @FXML
    private void Retour(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AjouterEve.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
    }

}
