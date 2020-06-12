/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.services;

import com.fixit.entities.Catégorie;
import java.sql.SQLException;
import javafx.collections.ObservableList;

/**
 *
 * @author SOUHA
 */
public interface CatégorieServiceInterface {
         public void addCatégorie(Catégorie c) throws SQLException;
         public ObservableList<Catégorie> listerCatégorie(int id) throws SQLException;
         public ObservableList<Catégorie> listCatégorieOrdred(int id,String description) throws SQLException;
         public void removeCatégorie(int id) throws SQLException;
         public void updateCatégorie(Catégorie c) throws SQLException;
          
          

    
}
