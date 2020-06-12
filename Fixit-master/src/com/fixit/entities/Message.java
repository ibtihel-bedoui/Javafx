/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.entities;

/**
 *
 * @author dell
 */
public class Message {
    private int id;
    private String nom , prenom , contenu;
    private int id_prestation;
    private int id_prestataire;
    private int id_user;

    public Message() {
    }

    @Override
    public String toString() {
        return "Message{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", contenu=" + contenu + '}';
    }

    public Message(int id, String nom, String prenom, String contenu) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.contenu = contenu;
    }

    public Message(int id, String nom, String prenom, String contenu, int id_prestation, int id_prestataire, int id_user) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.contenu = contenu;
        this.id_prestation = id_prestation;
        this.id_prestataire = id_prestataire;
        this.id_user = id_user;
    }

    public Message(String nom, String prenom, String contenu, int id_prestation, int id_prestataire, int id_user) {
        this.nom = nom;
        this.prenom = prenom;
        this.contenu = contenu;
        this.id_prestation = id_prestation;
        this.id_prestataire = id_prestataire;
        this.id_user = id_user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public int getId_prestation() {
        return id_prestation;
    }

    public void setId_prestation(int id_prestation) {
        this.id_prestation = id_prestation;
    }

    public int getId_prestataire() {
        return id_prestataire;
    }

    public void setId_prestataire(int id_prestataire) {
        this.id_prestataire = id_prestataire;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    
}
