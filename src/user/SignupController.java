/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import entities.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import services.UserCRUD;

/**
 * FXML Controller class
 *
 * @author pc-ibtihel
 */
public class SignupController implements Initializable {

    @FXML
    private Button txtlogout;
    @FXML
    private Label outputlogin;

    @FXML
    private Button btnajouter;
    @FXML
    private TextField txtmail;

    @FXML
    private PasswordField txtmdp;
    @FXML
    private TextField txtnom;
    @FXML
    private Button txtcancel;
    @FXML
    private TextField txtrole;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     @FXML
      private void ajouter(ActionEvent event) {
        String username = txtnom.getText();

        String password = txtmdp.getText();

        String email = txtmail.getText();

        String ROLES = "client";
      // String  roleP = txtrole.getText();
        
        UserCRUD userC = new UserCRUD();
        User u = new User(username, email, password, ROLES);
                  FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        try {
            Parent root = loader.load();
            LoginController apc = loader.getController();
            txtmail.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

      }
        

    @FXML
    private void logout(ActionEvent event) {
                 FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        try {
            Parent root = loader.load();
            LoginController apc = loader.getController();
            txtmail.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

 

    @FXML
    private void cancel(ActionEvent event) {
             Platform.exit();
        System.exit(0);
    }
    
}
