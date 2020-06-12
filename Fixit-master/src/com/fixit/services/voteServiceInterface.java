/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.services;

import com.fixit.entities.Vote_réponse;
import java.sql.SQLException;
import javafx.collections.ObservableList;

/**
 *
 * @author Asus
 */
public interface voteServiceInterface {
     public void addVote(Vote_réponse v) throws SQLException;
    public void updateReponse (Vote_réponse v) throws SQLException ;
    public void deleteReponse (int id_client, int id_reponse) throws SQLException ;
    public ObservableList<Vote_réponse> listerVotes() throws SQLException ;
    
}
