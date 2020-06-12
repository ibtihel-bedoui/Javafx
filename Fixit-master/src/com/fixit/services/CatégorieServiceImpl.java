

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SOUHA
 */

package com.fixit.services;
import com.fixit.entities.Catégorie;
import com.fixit.util.ConnectionDb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class CatégorieServiceImpl implements CatégorieServiceInterface{

    @Override
    public void addCatégorie(Catégorie c) throws SQLException {
com.fixit.util.ConnectionDb db = com.fixit.util.ConnectionDb.getInstance();
         Connection cn = db.getCnx();
         String query="INSERT INTO `catégories` (`id_Catégorie` , `nom_Catégorie` , `description_Catégorie`,`photo`) VALUES (?,?,?,? )";
         PreparedStatement st  = cn.prepareStatement(query);
          st.setInt(1, c.getId());       
                st.setString(2, c.getNom());
                st.setString(3,c.getDescription()); 
                st.setString(4, c.getCategorie_photo());
                st.execute();
    }

    @Override
    public ObservableList<Catégorie> listerCatégorie(int id) throws SQLException {
                ConnectionDb db = ConnectionDb.getInstance();
                Connection cn = db.getCnx();
                String query = "SELECT * FROM `catégories`";
		Statement st  = cn.createStatement();
                ResultSet rs = st.executeQuery(query);
                List<Catégorie> lc = new ArrayList<Catégorie>();
                Catégorie c = null;
                while(rs.next()){
                    c.setId(rs.getInt("id_catégorie"));
                    c.setNom(rs.getString("nom_catégorie"));
                    c.setDescription(rs.getString("description_catégorie"));
                    }
                   
                 ObservableList lc_final = FXCollections.observableArrayList(lc);
                return lc_final;
    
            }
        public ObservableList<Catégorie> listerAllCatégorie() throws SQLException {
                ConnectionDb db = ConnectionDb.getInstance();
                Connection cn = db.getCnx();
                String query = "SELECT * FROM `catégories`";
		Statement st  = cn.createStatement();
                ResultSet rs = st.executeQuery(query);
                List<Catégorie> lc = new ArrayList<>();
                
                while(rs.next()){
                    Catégorie c = new Catégorie();
                    c.setId(rs.getInt("id_catégorie"));
                    c.setNom(rs.getString("nom_catégorie"));
                    c.setDescription(rs.getString("description_catégorie"));
                    c.setCategorie_photo(rs.getString("photo"));
                    lc.add(c);
                    }
                   
                 ObservableList lc_final = FXCollections.observableArrayList(lc);
                return lc_final;
    
            }
    
    

    @Override
    public ObservableList<Catégorie> listCatégorieOrdred(int id,String description) throws SQLException {
                ConnectionDb db = ConnectionDb.getInstance();
                Connection cn = db.getCnx();
                String query = "SELECT * FROM `catégories` WHERE `description` = "+description;
		Statement st  = cn.createStatement();
                ResultSet rs = st.executeQuery(query);
                List<Catégorie> lc = new ArrayList<Catégorie>();
                Catégorie c = null;
                while(rs.next()){
                    c.setId(rs.getInt("id_catégorie"));
                    c.setNom(rs.getString("nom_catégorie"));
                    c.setDescription(rs.getString("description_Catégorie"));
                 
                }
               ObservableList lc_final = FXCollections.observableArrayList(lc);
                return lc_final;    }
    
    @Override
    public void removeCatégorie(int id) throws SQLException {

                ConnectionDb db = ConnectionDb.getInstance();
                Connection cn = db.getCnx();
                String query = "DELETE FROM `catégories` WHERE `id_catégorie` = "+id;
		PreparedStatement st  = cn.prepareStatement(query); 
                 st.execute();


    }
    
     @Override
    public void updateCatégorie(Catégorie c)throws SQLException {

                ConnectionDb db = ConnectionDb.getInstance();
                Connection cn = db.getCnx();
                String query = "UPDATE `catégories` SET `nom_catégorie`=?,`description_catégorie`=? ,photo = ? WHERE `id_catégorie` = "+c.getId();
		PreparedStatement st  = cn.prepareStatement(query);
                st.setString(1, c.getNom());
                st.setString(2, c.getDescription());
                st.setString(3, c.getCategorie_photo());
                        st.execute();
                
                        // st.setString(1, c.getNom());
                //st.setString(2, c.getDescription());
               

    }
    
    
    

    
}
