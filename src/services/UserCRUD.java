/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.User;
import java.awt.AWTException;
import java.awt.SystemTray;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Database;

/**
 *
 * @author pc-ibtihel
 */
public class UserCRUD {
        private Connection con;
    private Statement ste;
      private PreparedStatement pst  ; 
     private ResultSet rs; 
    public UserCRUD() {
           con= Database.getInstance().getConnection();
    }
  
    public User findBynom(User utilisateur) {
      String req="select * from user Where email = ?";
       User c1 = new User();
         try {
             pst = con.prepareStatement(req);
             pst.setString(1, utilisateur.getEmail());
           rs = pst.executeQuery(); 
             while (rs.next())
      {
                  c1.setEmail(rs.getString("email"));
                  c1.setROLES(rs.getString("roles"));
    }
             return c1;
         } catch (SQLException ex) {
             Logger.getLogger(UserCRUD.class.getName()).log(Level.SEVERE, null, ex);
         }
           
    return c1; 
}
       public void ajouterUser(User u) {
        try {
            String requete = "INSERT INTO user(username,email,password,roles) VALUES (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(requete);
            pst.setString(1, u.getUsername());
            pst.setString(2, u.getEmail());
            pst.setString(3, u.getPassword());
            pst.setString(7, u.getROLES());
            pst.executeUpdate();
/*
//sending mail
            JavamailUtil mail = new JavamailUtil();
            try {
                mail.sendMail(u.getMail());
            } catch (Exception ex) {
                Logger.getLogger(UserCRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
            //
            */
     //notificationstart       
         if (SystemTray.isSupported()) {
                TrayIconDemo td = new TrayIconDemo();
                try {
                    td.trayAjoutU();
                } catch (AWTException ex) {
                    Logger.getLogger(UserCRUD.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                System.err.println("System tray not supported!");
            }
            //notificationend
           System.out.println("User ajouté !");
        } catch (SQLException ex) {
            if (ex.getMessage().contains("Duplicata")) {
                System.out.println("User existe deja!");
            } else {
                System.out.println(ex.getMessage());
            }
        }
    }
   public void ModifierMdpUser(User u, String password) {
        try {
            String requete = "UPDATE user SET password=? WHERE email=?";
            PreparedStatement pst = con.prepareStatement(requete);

            pst.setString(1, password);
            pst.setString(2, u.getEmail());

            pst.executeUpdate();
            System.out.println("Mot de passe modifié !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
      public void SupprimerUser(User u) {
        try {
            String requete = "DELETE FROM user WHERE email=?";
            PreparedStatement pst = con.prepareStatement(requete);

            pst.setString(1, u.getEmail());

            pst.executeUpdate();
            System.out.println("User supprimé !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public List<User> afficherUsers() {

        ArrayList<User> list = new ArrayList<>();
        try {
            String requete = "SELECT * FROM user";
            PreparedStatement pst = con.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));                   //Soit par label soit par indice 
                u.setUsername(rs.getString("nom"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("mdp"));
                u.setROLES(rs.getString("roles"));
                list.add(u);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
     public boolean loginInterface(String emaill, String password) {
        try {
            String requete = "SELECT password FROM user WHERE emaill=?";
            PreparedStatement pst = con.prepareStatement(requete);
            pst.setString(1, emaill);
            ResultSet rs = pst.executeQuery();

            if (rs.first() == false) {
                return false;
            }
            
            if(rs.getString(1).equals(password) == false || password.equals("") ) {
                return false;
            };
     
        } catch (SQLException ex) {
            if (ex.getMessage().contains("Can not issue")) {
                System.out.println("Mail/Mot de passe invalide(s)!");
            } else {
                System.out.println(ex.getMessage());
            }
        }
        return true;
    }
     
    public User RechercheUser(String rech) {

        try {
            String requete = "SELECT * FROM user WHERE email=?";
            PreparedStatement pst = con.prepareStatement(requete);

            pst.setString(1, rech);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));                   //Soit par label soit par indice 
                u.setUsername(rs.getString("nom"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("mdp"));
                u.setROLES(rs.getString("roles"));
                return u;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        User u = null;
        return u;
    }

}
