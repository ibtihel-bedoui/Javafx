package com.fixit.entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SOUHA
 */
public class Catégorie {
     private int id_catégorie;
    private String nom_catégorie;
    private String description_catégorie;
    private String Categorie_photo ;

    public String getCategorie_photo() {
        return Categorie_photo;
    }

    public void setCategorie_photo(String Categorie_photo) {
        this.Categorie_photo = Categorie_photo;
    }
    
    

    public Catégorie() {
    }
    
    

    public Catégorie(String nom_catégorie, String description_catégorie) {
        this.nom_catégorie = nom_catégorie;
        this.description_catégorie = description_catégorie;
    }

    public Catégorie(int id_catégorie, String nom_catégorie, String description_catégorie) {
        this.id_catégorie = id_catégorie;
        this.nom_catégorie = nom_catégorie;
        this.description_catégorie = description_catégorie;
    }

    public int getId() {
        return id_catégorie;
    }

    public void setId(int id_catégorie) {
        this.id_catégorie = id_catégorie;
    }

    public String getNom() {
        return nom_catégorie;
    }

    public void setNom(String nom_catégorie) {
        this.nom_catégorie = nom_catégorie;
    }

    public String getDescription() {
        return description_catégorie;
    }

    public void setDescription(String description_catégorie) {
        this.description_catégorie = description_catégorie;
    }

    @Override
    public String toString() {
        return "Catégorie{" + "id_catégorie=" + id_catégorie + ", nom_catégorie=" + nom_catégorie + ", description_catégorie=" + description_catégorie + '}';
    }
    
    
    
}

