/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.services;


import com.fixit.entities.Reponses;
import com.fixit.util.ConnectionDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Asus
 */
public class ReponseService implements ReponseServiceInterface {
     @Override
      public void addReponse (Reponses r ) throws SQLException {
           ConnectionDb db = ConnectionDb.getInstance();
         Connection cn = db.getCnx();
 String query ="INSERT INTO `reponses`(`id_reponse`, `id_client`, `id_question`, `contenu_reponse`) VALUES (?,?,?,?)";
 
         PreparedStatement st  = cn.prepareStatement(query);
                st.setInt(1, r.getId_reponse());
                st.setInt(2,r.getId_client());
                st.setInt(3,r.getId_question());
                st.setString(4,r.getContenu_reponse());
                st.execute();
            
    

    }

 
    @Override
    public void updateReponse(Reponses r) throws SQLException {
   ConnectionDb db = ConnectionDb.getInstance();
                Connection cn = db.getCnx();
                String query = "UPDATE `reponses` SET `id_reponse`=?,`id_client`=?,`id_question`=?,`contenu_reponse`=? WHERE `id_reponse` = \"+p.getId_reponse()";
		PreparedStatement st  = cn.prepareStatement(query);
                
                    st.setInt(1, r.getId_reponse());
                st.setInt(2,r.getId_client());
                st.setInt(3,r.getId_question());
                st.setString(4,r.getContenu_reponse());
                st.execute();   }

    @Override
    public void deleteReponse(int id_reponse) throws SQLException {

                ConnectionDb db = ConnectionDb.getInstance();
                Connection cn = db.getCnx();
                String query = "DELETE FROM `reponses` WHERE `id_reponse` = "+id_reponse;
		PreparedStatement st  = cn.prepareStatement(query); 
                st.execute();    }

    @Override
    public ObservableList<Reponses> listerReponses() throws SQLException {
  ConnectionDb db = ConnectionDb.getInstance();
                Connection cn = db.getCnx();
                String query = "SELECT * FROM `reponses`";
		Statement st  = cn.createStatement();
                ResultSet rs = st.executeQuery(query);
                List<Reponses> lp = new ArrayList<>();
                Reponses r = new Reponses();
                while(rs.next()){
                    r.setId_reponse(rs.getInt("id_reponse"));
                    r.setId_client(rs.getInt("id_client"));
                    r.setId_question(rs.getInt("id_question"));
                    r.setContenu_reponse(rs.getString("contenu_reponse"));
                   
                 
                    lp.add(r);
                }
                ObservableList lp_final = FXCollections.observableArrayList(lp);
                return lp_final;
        }
      }
    

