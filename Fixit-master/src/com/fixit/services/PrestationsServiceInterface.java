/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.services;

import com.fixit.entities.Prestations;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;



/**
 *
 * @author dell
 */

public interface PrestationsServiceInterface {
    
    public void addPrestation(Prestations p) throws SQLException;
    public void updatePrestation (Prestations p) throws SQLException ;
    public void deletePrestation (int id_prestation) throws SQLException ;
    public ObservableList<Prestations> listerPrestations(int id) throws SQLException ;
}