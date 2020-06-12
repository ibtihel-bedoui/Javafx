/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.services;

import com.fixit.entities.PropositionsPrix;
import java.sql.SQLException;
import javafx.collections.ObservableList;

/**
 *
 * @author dell
 */
public interface PropositionsPrixServiceInterface {
    public void addPropositionPrix(PropositionsPrix pp) throws SQLException;
    public void updatePropositionPrix (PropositionsPrix pp) throws SQLException ;
    public void deletePropositionPrix (int id_prestation) throws SQLException ;
    public ObservableList<PropositionsPrix> listerPropositionsPrix() throws SQLException ;
}
