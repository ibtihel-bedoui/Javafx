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
public class Sscatégorie {
     private int id_sous_catégorie;
     private int id_catégorie;
    private String nom_sous_catégorie;
    private String description_sous_catégorie;
    private int urgence;
    
    
  public Sscatégorie() {
    }

    public void setId_catégorie(int id_catégorie) {
        this.id_catégorie = id_catégorie;
    }
  
    public Sscatégorie(int id_catégorie, String nom_sous_catégorie, String description_sous_catégorie, int urgence) {
         this.id_catégorie= id_catégorie;
         this.nom_sous_catégorie = nom_sous_catégorie;
        this.description_sous_catégorie = description_sous_catégorie;
        this.urgence=urgence;
    }

    public Sscatégorie(int id_sous_catégorie, int id_catégorie, String nom_sous_catégorie, String description_sous_catégorie, int urgence) {
        this.id_sous_catégorie = id_sous_catégorie;
        this.id_catégorie=id_catégorie;
        this.nom_sous_catégorie = nom_sous_catégorie;
        this.description_sous_catégorie = description_sous_catégorie;
        this.urgence=urgence;
    }
   
    
 public int getIdSs() {
        return id_sous_catégorie;
    }
    public int getId() {
        return id_catégorie;
    }

    public void setIdSs(int id_sous_catégorie) {
        this.id_sous_catégorie = id_sous_catégorie;
    }
     public void setId(int id_catégorie) {
        this.id_catégorie = id_catégorie;
    }

    public String getNomSs() {
        return nom_sous_catégorie;
    }

    public void setNomSs(String nom_sous_catégorie) {
        this.nom_sous_catégorie = nom_sous_catégorie;
    }

    public String getDescriptionSs() {
        return description_sous_catégorie;
    }

    public void setDescriptionSs(String description_sous_catégorie) {
        this.description_sous_catégorie = description_sous_catégorie;
    }
     public int getUrgence() {
        return urgence;
    }

    public void setUrgence(int urgence) {
        this.urgence = urgence;
    }

    @Override
    public String toString() {
        return "Sous Catégorie{" + "id_sous_catégorie=" + id_catégorie + "," + "id_sous_catégorie=" + id_catégorie + ", nom_sous_catégorie=" + nom_sous_catégorie + ", description_sous_catégorie=" + description_sous_catégorie +  ", urgence=" + urgence+  '}';
    }
    
    
    
}

