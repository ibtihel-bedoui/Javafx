/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import entities.participant;
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
public class participantCRUD {
     private Connection con;
    private Statement ste;
 public participantCRUD() {
                con= Database.getInstance().getConnection();

    }
 public void ajouterParticipant(participant e) {
        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO participant (nom , prenom, numdossard) VALUES (?,?,?)");
            pst.setString(1, e.getNom());
            pst.setString(2, e.getPrenom());         
            pst.setInt(3, e.getNumdossard());            
            pst.executeUpdate();
            
      
            
              //notificationstart       
            if (SystemTray.isSupported()) {
                TrayIconDemo td = new TrayIconDemo();
                try {
                    td.trayAjoutP();
                } catch (AWTException ex) {
                    Logger.getLogger(participantCRUD.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                System.err.println("System tray not supported!");
            }
            //notificationend
            System.out.println("Participant added");
        } catch (SQLException ex) {
               if (ex.getMessage().contains("Duplicata")) {
                System.out.println("Participant already exist");
            } else {
                System.out.println(ex.getMessage());
            }
        }
    } 
   
    
 
     public List<participant> afficherParticipant() {

        ArrayList<participant> list = new ArrayList<>();
        try {
            String requete = "SELECT * FROM participant";
            PreparedStatement pst = con.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                participant u = new participant();
               
                                //Soit par label soit par indice 
                u.setNom(rs.getString("nom"));
                u.setPrenom(rs.getString("prenom"));
                u.setNumdossard(rs.getInt("numdossard"));
             
           
                list.add(u);
            }
        } catch (SQLException ex) {
            System.out.println("ERREUR");
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
         public void supprimerParticipant(int id){
        try {
            PreparedStatement pst = con.prepareStatement("delete from Participation where idParticipation = ?");
            pst.setInt(1,id);
            pst.executeUpdate();
            System.out.println("Participation deleted");
        } catch (SQLException ex) {
            Logger.getLogger(participantCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
             public void modifierParticipant(participant p){
        try {
            PreparedStatement pst = con.prepareStatement("update Partner  Nom = ?, Prenom = ?, Numdossard = ? where Nom = ?");
            
            pst.setString(1, p.getNom());
            pst.setString(2, p.getPrenom());
            pst.setInt(3, p.getNumdossard());
            
            pst.executeUpdate();
            System.out.println("Partner updated");
        } catch (SQLException ex) {
            Logger.getLogger(participantCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
               public void deleteParticipant(participant u) {
        try {
            String requete = "DELETE FROM participant WHERE nom=?";
            PreparedStatement pst = con.prepareStatement(requete);

            pst.setString(1, u.getNom());

            pst.executeUpdate();
            System.out.println("Participant deleted!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
