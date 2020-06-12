/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.evenement;
import java.awt.AWTException;
import java.awt.SystemTray;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import utils.Database;


/**
 *
 * @author pc-ibtihel
 */
public class evenementCRUD {
    private Connection con;
    private Statement ste;
    private Object SingletonNavigation;

    public evenementCRUD() {
                con= Database.getInstance().getConnection();

    }
    
   public void ajouterEvenement(evenement e) {
        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO evenement (nom_image,libelle, datedebut, datefin, description) VALUES (?,?,?,?,?)");
            pst.setString(1, e.getNom_image());
            pst.setString(2, e.getLibelle());
            pst.setDate(3, (java.sql.Date) e.getDatedebut());
            pst.setDate(4, (java.sql.Date) e.getDatefin());
            pst.setString(5, e.getDescription());            
            pst.executeUpdate();
              //notificationstart       
            if (SystemTray.isSupported()) {
                TrayIconDemo td = new TrayIconDemo();
                try {
                    td.trayAjout();
                } catch (AWTException ex) {
                    Logger.getLogger(evenementCRUD.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                System.err.println("System tray not supported!");
            }
            //notificationend
            System.out.println("Event added");
        } catch (SQLException ex) {
               if (ex.getMessage().contains("Duplicata")) {
                System.out.println("Event already exist");
            } else {
                System.out.println(ex.getMessage());
            }
        }
    } 
   
    public void supprimerEvenement(int id){
        try {
            PreparedStatement pst = con.prepareStatement("delete from evenement where id = ?");
            pst.setInt(1,id);
            pst.executeUpdate();
            System.out.println("Event deleted");
        } catch (SQLException ex) {
        System.out.println("Event not deleted");

            Logger.getLogger(evenementCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public List<evenement> afficherEvenement() {

        ArrayList<evenement> list = new ArrayList<>();
        try {
            String requete = "SELECT * FROM evenement";
            PreparedStatement pst = con.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                evenement u = new evenement();
               
                u.setId(rs.getInt("id"));                   //Soit par label soit par indice 
                u.setNom_image(rs.getString("nom_image"));
                u.setLibelle(rs.getString("libelle"));
                u.setDescription(rs.getString("description"));
                u.setDatedebut(rs.getDate("datedebut"));
                u.setDatedebut(rs.getDate("datefin"));
                u.setId_user(rs.getInt("id_user"));
           
                list.add(u);
            }
        } catch (SQLException ex) {
            System.out.println("ERREUR");
            System.out.println(ex.getMessage());
        }
        return list;
    }
     
      public void modifierEvenement(evenement e){
        try {
            PreparedStatement pst = con.prepareStatement("update evenement set libelle= ? , description = ?, datedebut = ?, datefin = ? where id = ?");
            pst.setString(1, e.getLibelle());
            pst.setString(2, e.getDescription());
          
            pst.setDate(3, (java.sql.Date) e.getDatedebut());
            pst.setDate(4, (java.sql.Date) e.getDatefin());
            
            pst.setInt(5, e.getId());
            
            pst.executeUpdate();
            System.out.println("Event updated");
        } catch (SQLException ex) {
            Logger.getLogger(ex.getMessage());
        }
    }
    
      public void ModifierLibelleEvenement(evenement u , String libelle ) {
        try {
            String requete = "UPDATE evenement SET libelle=? WHERE id=?";
            PreparedStatement pst = con.prepareStatement(requete);

            pst.setString(1, libelle );
            pst.setInt(2, u.getId());

            pst.executeUpdate();
            System.out.println("Libelle modified");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
      
       public void deleteEvenement(evenement u) {
        try {
            String requete = "DELETE FROM evenement WHERE libelle=?";
            PreparedStatement pst = con.prepareStatement(requete);

            pst.setString(1, u.getLibelle());

            pst.executeUpdate();
            System.out.println("Event deleted!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

   public int getId(String s)
{
    int x = 0;
    try {
            String requete = "SELECT id FROM evenement WHERE nom_image = '"+s+"'";
            PreparedStatement pst = con.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
               x = rs.getInt("id");
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    return x;
}

    public evenement getSelectedRowFromGrid(int id, String nom_image, String description, Date datedebut, Date datefin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  



 
      
    
}
