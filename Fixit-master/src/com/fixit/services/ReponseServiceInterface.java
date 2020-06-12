/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.services;

import com.fixit.entities.Reponses;
import java.sql.SQLException;
import javafx.collections.ObservableList;

/**
 *
 * @author Asus
 */
public interface ReponseServiceInterface {
    public void addReponse(Reponses r) throws SQLException;
    public void updateReponse (Reponses r) throws SQLException ;
    public void deleteReponse (int id_reponse) throws SQLException ;
    public ObservableList<Reponses> listerReponses() throws SQLException ;
}
