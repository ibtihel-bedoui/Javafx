/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author pc-ibtihel
 */
public class Commentaire {
      private int id;
    private String contenue;
    private Date datecreate ;
          private int id_evenement;
                  private int rating;

    public Commentaire(int id, String contenue, Date datecreate, int id_evenement, int rating) {
        this.id = id;
        this.contenue = contenue;
        this.datecreate = datecreate;
        this.id_evenement = id_evenement;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenue() {
        return contenue;
    }

    public void setContenue(String contenue) {
        this.contenue = contenue;
    }

    public Date getDatecreate() {
        return datecreate;
    }

    public void setDatecreate(Date datecreate) {
        this.datecreate = datecreate;
    }

    public int getId_evenement() {
        return id_evenement;
    }

    public void setId_evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "id=" + id + ", contenue=" + contenue + ", datecreate=" + datecreate + ", id_evenement=" + id_evenement + ", rating=" + rating + '}';
    }
          

    
}
