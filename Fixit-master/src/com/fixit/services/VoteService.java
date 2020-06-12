/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.services;

import com.fixit.entities.Vote_réponse;
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
public class VoteService implements voteServiceInterface {
    @Override
    public void addVote (Vote_réponse v ) throws SQLException {
        
        ConnectionDb db = ConnectionDb.getInstance();
         Connection cn = db.getCnx();
 String query ="INSERT INTO `votes_réponse`(`id_reponse`, `id_client`, `type_vote`) VALUES (?,?,?)";
 
         PreparedStatement st  = cn.prepareStatement(query);
                st.setInt(1, v.getId_reponse());
                st.setInt(2,v.getId_client());
                st.setInt(3,v.getType_vote());
               
                st.execute();
            
    
}


    @Override
    public void updateReponse(Vote_réponse v) throws SQLException {
 ConnectionDb db = ConnectionDb.getInstance();
                Connection cn = db.getCnx();
                String query = "UPDATE `votes_réponse` SET `id_reponse`=?,`id_client`=?,`type_vote`=? WHERE `id_client` = \"+p.getId_client()";
		PreparedStatement st  = cn.prepareStatement(query);
                  st.setInt(1, v.getId_reponse());
                st.setInt(2,v.getId_client());
                st.setInt(3,v.getType_vote());
                
                
                  }

    @Override
    public void deleteReponse(int id_client, int id_reponse) throws SQLException {
   ConnectionDb db = ConnectionDb.getInstance();
                Connection cn = db.getCnx();
                String query = "DELETE FROM `votes_réponse` WHERE  `id_client` = "+id_client;
		PreparedStatement st  = cn.prepareStatement(query); 
                st.execute();    }

    @Override
    public ObservableList<Vote_réponse> listerVotes() throws SQLException {
  ConnectionDb db = ConnectionDb.getInstance();
                Connection cn = db.getCnx();
                String query = "SELECT * FROM `vote_réponse`";
		Statement st  = cn.createStatement();
                ResultSet rs = st.executeQuery(query);
                List<Vote_réponse> lp = new ArrayList<>();
                Vote_réponse v = new Vote_réponse();
                while(rs.next()){
                    v.setId_reponse(rs.getInt("id_reponse"));
                    v.setId_client(rs.getInt("id_client"));
                    v.setType_vote(rs.getInt("type_vote"));
                   
                 
                    lp.add(v);
                }
                ObservableList lp_final = FXCollections.observableArrayList(lp);
                return lp_final;
        }


 }
