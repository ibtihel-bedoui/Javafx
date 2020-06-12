/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.services;

import com.fixit.entities.Sscatégorie;
import java.sql.SQLException;
import javafx.collections.ObservableList;

/**
 *
 * @author SOUHA
 */
public interface SscatégorieServiceInterface {
              public void addSscatégorie(Sscatégorie sc) throws SQLException;
                  public ObservableList<Sscatégorie> listerSscatégorie(int id) throws SQLException;
                      public ObservableList<Sscatégorie> listSscatégorieOrdred(int id,int urgence) throws SQLException;
                          public void removeSscatégorie(int id) throws SQLException;
                              public void updateSscatégorie(Sscatégorie sc)throws SQLException;





}
