/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.entities;

import java.util.Objects;

/**
 *
 * @author Asus
 */
public class Reponses {
    private int id_reponse ;
    private int id_client ;
    private int id_question ;
    private String contenu_reponse ;

    public Reponses(int id_reponse, int id_client, int id_question, String contenu_reponse) {
        this.id_reponse = id_reponse;
        this.id_client = id_client;
        this.id_question = id_question;
        this.contenu_reponse = contenu_reponse;
    }

    public Reponses(int id_client, int id_question, String contenu_reponse) {
        this.id_client = id_client;
        this.id_question = id_question;
        this.contenu_reponse = contenu_reponse;
    }

    public Reponses() {
    }

    public int getId_reponse() {
        return id_reponse;
    }

    public void setId_reponse(int id_reponse) {
        this.id_reponse = id_reponse;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getId_question() {
        return id_question;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

    public String getContenu_reponse() {
        return contenu_reponse;
    }

    public void setContenu_reponse(String contenu_reponse) {
        this.contenu_reponse = contenu_reponse;
    }

    @Override
    public String toString() {
        return "Reponses{" + "id_reponse=" + id_reponse + ", id_client=" + id_client + ", id_question=" + id_question + ", contenu_reponse=" + contenu_reponse + '}';
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reponses other = (Reponses) obj;
        if (this.id_reponse != other.id_reponse) {
            return false;
        }
        if (this.id_client != other.id_client) {
            return false;
        }
        if (this.id_question != other.id_question) {
            return false;
        }
        if (!Objects.equals(this.contenu_reponse, other.contenu_reponse)) {
            return false;
        }
        return true;
    }
    
    
}
