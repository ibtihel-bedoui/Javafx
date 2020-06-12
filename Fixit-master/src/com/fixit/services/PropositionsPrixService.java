/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.services;

import com.fixit.entities.PropositionsPrix;
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
 * @author dell
 */
public class PropositionsPrixService implements PropositionsPrixServiceInterface {
@Override
    public void addPropositionPrix(PropositionsPrix pp) throws SQLException {
         ConnectionDb db = ConnectionDb.getInstance();
         Connection cn = db.getCnx();
         String query="INSERT INTO `propositions_prix` (`id_prestation` , `prix`, `état) VALUES (?,?,?)";
         PreparedStatement st  = cn.prepareStatement(query);
                st.setInt(1, pp.getId_prestation());
                st.setInt(2,pp.getPrix());
                st.setInt(3,pp.getÉtat());
                st.execute();
            
    }
    @Override
    public ObservableList<PropositionsPrix> listerPropositionsPrix() throws SQLException {


                ConnectionDb db = ConnectionDb.getInstance();
                Connection cn = db.getCnx();
                String query = "SELECT * FROM `propositions_prix`";
		Statement st  = cn.createStatement();
                ResultSet rs = st.executeQuery(query);
                List<PropositionsPrix> lpp = new ArrayList<PropositionsPrix>();
                PropositionsPrix pp = new PropositionsPrix();
                while(rs.next()){
                    pp.setId_prestation(rs.getInt("id_prestation"));
                    pp.setPrix(rs.getInt("prix"));
                    pp.setÉtat(rs.getInt("état"));
                    lpp.add(pp);
                }
                ObservableList lpp_final = FXCollections.observableArrayList(lpp);
                return lpp_final;
    }
 @Override
    public void deletePropositionPrix(int id_prestation) throws SQLException {

                ConnectionDb db = ConnectionDb.getInstance();
                Connection cn = db.getCnx();
                String query = "DELETE FROM `propositions_prix` WHERE `id_prestation` = "+id_prestation;
		PreparedStatement st  = cn.prepareStatement(query); 
                st.execute();


    }
    @Override
    public void updatePropositionPrix(PropositionsPrix pp) throws SQLException {

                ConnectionDb db = ConnectionDb.getInstance();
                Connection cn = db.getCnx();
                String query = "UPDATE `propositions_prix` SET `prix`=?,`état`=? WHERE `id_prestation` = "+pp.getId_prestation();
		PreparedStatement st  = cn.prepareStatement(query);
                
                st.setInt(1, pp.getPrix());
                st.setInt(2, pp.getÉtat());
                st.execute();

    }

}
