/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import GUI.DashboardController;
import GUI.FrontPageController;
import entities.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.UserCRUD;
import services.evenementCRUD;

/**
 * FXML Controller class
 *
 * @author pc-ibtihel
 */
public class LoginController implements Initializable {

   @FXML
    private TextField txtmail;
    @FXML
    private PasswordField txtpassword;
    @FXML
    private Button btnsignin;
    private Button txtsignup;
    @FXML
    private Label outputlogin;
    @FXML
    private Button btnsignup;
    @FXML
    private Label txtoublie;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 @FXML
    private void onlogin(ActionEvent event) {
        
        String mailP = txtmail.getText();
        String mdpP = txtpassword.getText();

        UserCRUD userC = new UserCRUD();
        User u = new User();

        if (userC.loginInterface(mailP, mdpP) == false) {
            JOptionPane.showMessageDialog(null, "Mail/mot de passe incorrect(s)!");
        }

        System.out.println(userC.loginInterface(mailP, mdpP));
        System.out.println(userC.RechercheUser(mailP).getROLES().equals("client"));

        if (userC.loginInterface(mailP, mdpP) && userC.RechercheUser(mailP).getROLES().equals("client")) {

            System.out.println("Vous êtes connecté !");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FrontPage.fxml"));
            try {
                Parent root = loader.load();
                FrontPageController lc = loader.getController();
                txtmail.getScene().setRoot(root);

            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (userC.loginInterface(mailP, mdpP) && userC.RechercheUser(mailP).getROLES().equals("admin")) {

            System.out.println("Vous êtes connecté !");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("admininterface.fxml"));
            try {
                Parent root = loader.load();
                txtmail.getScene().setRoot(root);

            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }


    @FXML
    private void oublie(MouseEvent event) {
    }

    @FXML
    private void signup(ActionEvent event) {
    }
    }
     /*  User u ; 
        User x; 
        evenementCRUD el = new evenementCRUD(); 

        UserCRUD  uti = new UserCRUD(); 
       String n = txtmail.getText(); 
        String m = txtpassword.getText(); 
         u = new User(n); 
        x = uti.findBynom(u); 
           System.out.println("ofogi"); 
        if (x != null)
        {
         if((x.getROLES().equalsIgnoreCase("a:1:{i:0;s:10:\"ROLE_ADMIN\";}")) ) {
         System.out.println("il s'agit de role admin ");
           // System.out.println("adminn");
      
  FXMLLoader loader = new FXMLLoader();
              loader.setLocation(LoginController.class.getResource("Dashboard.fxml"));
            Parent root = null;   
              try {
                  root = loader.load(); 
              } catch(IOException ex){} 
              Scene sc = new Scene(root); 
              Stage second = new Stage();
              second.setScene(sc);
              second.show();
              Stage first = (Stage)txtmail.getScene().getWindow();
              first.close();
    } else if(x.getROLES().equals("client")) {
              FXMLLoader loader = new FXMLLoader();
              loader.setLocation(LoginController.class.getResource("FrontPage.fxml"));
              Parent root = null; 
              try {
                  root = loader.load(); 
              } catch(IOException ex){} 
              Scene sc = new Scene(root); 
              Stage second = new Stage();
              second.setScene(sc);
              second.show();
              Stage first = (Stage)txtmail.getScene().getWindow();
              first.close();
                } 
    else if(x.getROLES().equalsIgnoreCase("a:1:{i:0;s:15:\"ROLE_ENSEIGNANT\";}")) {
   
  FXMLLoader loader = new FXMLLoader();
              loader.setLocation(LoginController.class.getResource("FrontPage.fxml"));
              Parent root = null; 
              try {
                  root = loader.load(); 
              } catch(IOException ex){} 
              Scene sc = new Scene(root); 
              Stage second = new Stage();
              second.setScene(sc);
              second.show();
              Stage first = (Stage)txtmail.getScene().getWindow();
              first.close();
    }
        }   
    }
    
    @FXML
    private void exit(MouseEvent event) {
           Platform.exit();
    }

    @FXML
    private void oublie(MouseEvent event) {

    
    }



    @FXML
    private void signup(ActionEvent event) {
               
               
 try {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("signup.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));  
            stage.show();
    } catch(Exception e) {
       e.printStackTrace();
      }
    }
    
}*/
