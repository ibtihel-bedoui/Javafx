/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import static java.sql.Types.NULL;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author pc-ibtihel
 */
public class evenement {

    public static void setText(String libelle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     private int id;
    private String nom_image;
    private String libelle;
    private String description;
    private Date datedebut ;
   private Date datefin;
   private int id_user=NULL;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_image() {
        return nom_image;
    }

    public void setNom_image(String nom_image) {
        this.nom_image = nom_image;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
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
        final evenement other = (evenement) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.id_user != other.id_user) {
            return false;
        }
        if (!Objects.equals(this.nom_image, other.nom_image)) {
            return false;
        }
        if (!Objects.equals(this.libelle, other.libelle)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.datedebut, other.datedebut)) {
            return false;
        }
        if (!Objects.equals(this.datefin, other.datefin)) {
            return false;
        }
        return true;
    }

  

    @Override
    public String toString() {
        return "evenement{" + "id=" + id + ", nom_image=" + nom_image + ", libelle=" + libelle + ", description=" + description + ", datedebut=" + datedebut + ", datefin=" + datefin + ", id_user=" + id_user + '}';
    }

    public evenement(String libelle, String description, Date datedebut, Date datefin) {
        this.libelle = libelle;
        this.description = description;
        this.datedebut = datedebut;
        this.datefin = datefin;
    }

    public evenement(String nom_image, String libelle, String description, Date datedebut, Date datefin) {
        this.nom_image = nom_image;
        this.libelle = libelle;
        this.description = description;
        this.datedebut = datedebut;
        this.datefin = datefin;
    }

    public evenement(int id, String nom_image, String libelle, String description, Date datedebut, Date datefin) {
        this.id = id;
        this.nom_image = nom_image;
        this.libelle = libelle;
        this.description = description;
        this.datedebut = datedebut;
        this.datefin = datefin;
    }

    public evenement() {
    }

    
    

    
   
   
   
   
   
    
}
