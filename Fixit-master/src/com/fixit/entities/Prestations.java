/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.entities;

import java.sql.Date;

/**
 *
 * @author dell
 */
public class Prestations {
    private int id_prestation ;
    private user client ;
    private user prestataire ;
    private int id_sous_catégorie ;
    private Date date_prestation;
    private int état_prestation ;
    private String nom_prestation ;
    private String description_prestation ;
    private int prix ;

    public Prestations(user client, user prestataire, int id_sous_catégorie, Date date_prestation, int état_prestation, String nom_prestation, String description_prestation, int prix) {
        this.client = client;
        this.prestataire = prestataire;
        this.id_sous_catégorie = id_sous_catégorie;
        this.date_prestation = date_prestation;
        this.état_prestation = état_prestation;
        this.nom_prestation = nom_prestation;
        this.description_prestation = description_prestation;
        this.prix = prix;
    }

    

    public Prestations(int id_prestation, user client, user prestataire, int id_sous_catégorie, Date date_prestation, int état_prestation, String nom_prestation, String description_prestation, int prix) {
        this.id_prestation = id_prestation;
        this.client = client;
        this.prestataire = prestataire;
        this.id_sous_catégorie = id_sous_catégorie;
        this.date_prestation = date_prestation;
        this.état_prestation = état_prestation;
        this.nom_prestation = nom_prestation;
        this.description_prestation = description_prestation;
        this.prix = prix;
    }

    public Prestations() {
        client = new user();
        prestataire = new user();
        
    }

   
    

    public int getId_prestation() {
        return id_prestation;
    }

    public void setId_prestation(int id_prestation) {
        this.id_prestation = id_prestation;
    }

    public user getClient() {
        return client;
    }

    public void setClient(user client) {
        this.client = client;
    }

    public user getPrestataire() {
        return prestataire;
    }

    public void setPrestataire(user prestataire) {
        this.prestataire = prestataire;
    }

    public int getId_sous_catégorie() {
        return id_sous_catégorie;
    }

    public void setId_sous_catégorie(int id_sous_catégorie) {
        this.id_sous_catégorie = id_sous_catégorie;
    }

    public Date getDate_prestation() {
        return date_prestation;
    }

    public void setDate_prestation(Date date_prestation) {
        this.date_prestation = date_prestation;
    }

    public int getÉtat_prestation() {
        return état_prestation;
    }

    public void setÉtat_prestation(int état_prestation) {
        this.état_prestation = état_prestation;
    }

    public String getNom_prestation() {
        return nom_prestation;
    }


    public void setNom_prestation(String nom_prestation) {
        this.nom_prestation = nom_prestation;
    }

    public String getDescription_prestation() {
        return description_prestation;
    }

    public void setDescription_prestation(String description_prestation) {
        this.description_prestation = description_prestation;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

}
