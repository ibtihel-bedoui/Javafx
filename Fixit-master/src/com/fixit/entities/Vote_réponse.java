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
public class Vote_réponse {
    private int id_reponse  ;
    private int id_client;
    private int type_vote;

    public Vote_réponse(int id_reponse, int id_client, int type_vote) {
        this.id_reponse = id_reponse;
        this.id_client = id_client;
        this.type_vote = type_vote;
    }

    public Vote_réponse(int id_client, int type_vote) {
  
        this.type_vote = type_vote;
    }

    public Vote_réponse() {
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

    public int getType_vote() {
        return type_vote;
    }

    public void setType_vote(int type_vote) {
        this.type_vote = type_vote;
    }

    @Override
    public String toString() {
        return "Vote_r\u00e9ponse{" + "id_reponse=" + id_reponse + ", id_client=" + id_client + ", type_vote=" + type_vote + '}';
    }


    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vote_réponse other = (Vote_réponse) obj;
        if (this.id_reponse != other.id_reponse) {
            return false;
        }
        if (this.id_client != other.id_client) {
            return false;
        }
        if (!Objects.equals(this.type_vote, other.type_vote)) {
            return false;
        }
        return true;
    }
    
    
}
