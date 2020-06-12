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
public class Question {
    private int id_question ;
    private int id_client;
    private String titre_question;
    private String description_question;
    private int état_question;

    public Question(int id_question, int id_client, String titre_question, String description_question, int état_question) {
        this.id_question = id_question;
        this.id_client = id_client;
        this.titre_question = titre_question;
        this.description_question = description_question;
        this.état_question = état_question;
    }

    public Question() {
    }

    public Question(int id_client, String titre_question, String description_question, int état_question) {
        this.id_client = id_client;
        this.titre_question = titre_question;
        this.description_question = description_question;
        this.état_question = état_question;
    }

    public int getId_question() {
        return id_question;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getTitre_question() {
        return titre_question;
    }

    public void setTitre_question(String titre_question) {
        this.titre_question = titre_question;
    }

    public String getDescription_question() {
        return description_question;
    }

    public void setDescription_question(String description_question) {
        this.description_question = description_question;
    }

    public int getÉtat_question() {
        return état_question;
    }

    public void setÉtat_question(int état_question) {
        this.état_question = état_question;
    }

    @Override
    public String toString() {
        return "Question{" + "id_question=" + id_question + ", id_client=" + id_client + ", titre_question=" + titre_question + ", description_question=" + description_question + ", \u00e9tat_question=" + état_question + '}';
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Question other = (Question) obj;
        if (this.id_question != other.id_question) {
            return false;
        }
        if (this.id_client != other.id_client) {
            return false;
        }
        if (!Objects.equals(this.titre_question, other.titre_question)) {
            return false;
        }
        if (!Objects.equals(this.description_question, other.description_question)) {
            return false;
        }
        if (!Objects.equals(this.état_question, other.état_question)) {
            return false;
        }
        return true;
    }



}