/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.services;

import com.fixit.util.ConnectionDb;
import com.fixit.entities.Sscatégorie;
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
 * @author SOUHA
 */
public class SscatégorieServiceImpl implements SscatégorieServiceInterface {

    @Override
    public void addSscatégorie(Sscatégorie sc) throws SQLException {
        com.fixit.util.ConnectionDb db = com.fixit.util.ConnectionDb.getInstance();
        Connection cn = db.getCnx();
        String query = "INSERT INTO `sous_catégories` (`id_sous_catégorie`, `id_catégorie` , `nom_sous_catégorie` , `description_sous_catégorie`, `urgence` ) VALUES (?,?,?,?,?)";
        PreparedStatement st = cn.prepareStatement(query);
        st.setInt(1, sc.getIdSs());
        st.setInt(2, sc.getId());
        st.setString(3, sc.getNomSs());
        st.setString(4, sc.getDescriptionSs());
        st.setInt(5, sc.getUrgence());
        st.executeUpdate();
    }

    public ObservableList<Sscatégorie> listerAllSscatégorie() throws SQLException {
        ConnectionDb db = ConnectionDb.getInstance();
        Connection cn = db.getCnx();
        String query = "SELECT * FROM `sous_catégories`";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(query);
        List<Sscatégorie> lc = new ArrayList<>();

        while (rs.next()) {
            Sscatégorie sc = new Sscatégorie();
            sc.setIdSs(rs.getInt("id_sous_catégorie"));
            sc.setId(rs.getInt("id_catégorie"));
            sc.setNomSs(rs.getString("nom_sous_catégorie"));
            sc.setDescriptionSs(rs.getString("description_sous_catégorie"));
            sc.setUrgence(rs.getInt("urgence"));

            lc.add(sc);
        }

        ObservableList lc_final = FXCollections.observableArrayList(lc);
        return lc_final;

    }

    @Override
    public ObservableList<Sscatégorie> listerSscatégorie(int id) throws SQLException {
        com.fixit.util.ConnectionDb db = com.fixit.util.ConnectionDb.getInstance();
        Connection cn = db.getCnx();
        String query = "SELECT * FROM sous_catégories where id_catégorie =" + id;
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(query);
        List<Sscatégorie> lsc = new ArrayList<Sscatégorie>();

        while (rs.next()) {
            Sscatégorie sc = new Sscatégorie();
            sc.setId(rs.getInt("id_sous_catégorie"));
            sc.setId(rs.getInt("id_catégorie"));
            sc.setNomSs(rs.getString("nom_sous_catégorie"));
            sc.setDescriptionSs(rs.getString("description_sous_catégorie"));
            sc.setUrgence(rs.getInt("urgence"));
            lsc.add(sc);

        }
        ObservableList lsc_final = FXCollections.observableArrayList(lsc);
        return lsc_final;

    }

    @Override
    public ObservableList<Sscatégorie> listSscatégorieOrdred(int id, int urgence) throws SQLException {
        com.fixit.util.ConnectionDb db = com.fixit.util.ConnectionDb.getInstance();
        Connection cn = db.getCnx();
        String query = "SELECT * FROM `sous_catégories` WHERE `urgence` = " + urgence;
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(query);
        List<Sscatégorie> lsc = new ArrayList<Sscatégorie>();
        Sscatégorie sc = null;
        while (rs.next()) {
            sc.setId(rs.getInt("id_sous_catégorie"));
            sc.setId(rs.getInt("id_catégorie"));
            sc.setNomSs(rs.getString("nom_sous_catégorie"));
            sc.setDescriptionSs(rs.getString("description_sous_catégorie"));
            sc.setUrgence(rs.getInt("urgence"));

        }
        ObservableList lsc_final = FXCollections.observableArrayList(lsc);
        return lsc_final;
    }

    @Override
    public void removeSscatégorie(int id) throws SQLException {
        com.fixit.util.ConnectionDb db = com.fixit.util.ConnectionDb.getInstance();
        Connection cn = db.getCnx();
        String query = "DELETE FROM `sous_catégories` WHERE `id_sous_catégorie` = " + id;
        PreparedStatement st = cn.prepareStatement(query);
        st.execute();
    }

    @Override
    public void updateSscatégorie(Sscatégorie sc) throws SQLException {
        com.fixit.util.ConnectionDb db = com.fixit.util.ConnectionDb.getInstance();
        Connection cn = db.getCnx();
        String query = "UPDATE `sous_catégories` SET `nom_sous_catégorie`=?,`description_sous_catégorie`=?, urgence=? WHERE `id_sous_catégorie` = " + sc.getIdSs();
        PreparedStatement st = cn.prepareStatement(query);
        st.execute();

        st.setString(1, sc.getNomSs());
        st.setString(2, sc.getDescriptionSs());
        st.setInt(3, sc.getUrgence());
    }

}
