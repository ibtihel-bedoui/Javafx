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
public class PropositionsPrix {
    private int id_prestation;
    private int prix;
    private int état;

    public PropositionsPrix(int id_prestation, int prix, int état) {
        this.id_prestation = id_prestation;
        this.prix = prix;
        this.état = état;
    }

    public PropositionsPrix() {
    }
    

    public PropositionsPrix(int prix, int état) {
        this.prix = prix;
        this.état = état;
    }

    public int getId_prestation() {
        return id_prestation;
    }

    public void setId_prestation(int id_prestation) {
        this.id_prestation = id_prestation;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getÉtat() {
        return état;
    }

    public void setÉtat(int état) {
        this.état = état;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PropositionsPrix other = (PropositionsPrix) obj;
        if (this.id_prestation != other.id_prestation) {
            return false;
        }
        if (this.prix != other.prix) {
            return false;
        }
        if (this.état != other.état) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PropositionsPrix{" + "id_prestation=" + id_prestation + ", prix=" + prix + ", \u00e9tat=" + état + '}';
    }
    
    
}
