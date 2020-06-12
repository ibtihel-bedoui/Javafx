/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author pc-ibtihel
 */
public class participant {
    
     int id;
    private String nom;
    private String prenom;
    int numdossard;
    int id_evenement;



    public participant(String nom, String prenom, int numdossard) {
        this.nom = nom;
        this.prenom = prenom;
        this.numdossard = numdossard;
    }

    public participant() {
    }

    public participant(String nom, String prenom, String numdossard) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public int getNumdossard() {
        return numdossard;
    }

    public void setNumdossard(int numdossard) {
        this.numdossard = numdossard;
    }

    public int getId_evenement() {
        return id_evenement;
    }

    public void setId_evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }

    public participant(int id, String nom, String prenom, int numdossard, int id_evenement) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.numdossard = numdossard;
        this.id_evenement = id_evenement;
    }

    @Override
    public String toString() {
        return "participant{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", numdossard=" + numdossard + ", id_evenement=" + id_evenement + '}';
    }
    
}
