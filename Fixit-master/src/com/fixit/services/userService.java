/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.services;

import com.fixit.entities.user;
import com.fixit.util.ConnectionDb;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mehdi
 */
public class userService {

    Connection cnx;

    public userService() {
        this.cnx = ConnectionDb.getInstance().getCnx();
    }

    public void ajouterAlaBase(user p) throws SQLException {
        try {
            System.out.println("connexion établie");
            Statement stm = cnx.createStatement();
            String req = "INSERT INTO `fos_users`(`username`,`email`,`password` ,`roles`,`first_name`,`last_name`,`birth_date`,`address`,`phone`) VALUES ('" + p.getUsername() + "','" + p.getEmail() + "','" + p.getPassword() + "','" + p.getRoles() + "','" + p.getFirst_name() + "','" + p.getLast_name() + "','" + p.getBirth_date() + "','" + p.getAddress() + "','" + p.getPhone() + "',)";
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(userService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet chercherDansLaBase(String nom, String prenom) throws SQLException {

        Statement stm = cnx.createStatement();
        String req = "select * from fos_users where first_name='" + nom + "'and last_name='" + prenom + "'";
        ResultSet rs = stm.executeQuery(req);
        return rs;
    }
    public boolean chercherUser(String username, String password) throws SQLException {

        boolean exist=false;
        Statement stm = cnx.createStatement();
        String req = "select * from fos_users ";
        ResultSet rs = stm.executeQuery(req);
        while(rs.next()){
            if((rs.getString("username").equals(username))&&rs.getString("password").equals(password)){
                exist=true;
        //user u =new user(rs.getString("username"),rs.getString("email"),rs.getString("password"),rs.getString("roles"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("address"),rs.getInt("id"),rs.getInt("phone"),rs.getDate("birth_date"));
        }}
            
       return exist;
    }
public user donnerUser(String username, String password) throws SQLException {

       user u =new user();
        Statement stm = cnx.createStatement();
        String req = "select * from fos_users where username='" + username + "'and password='" + password + "'";
        ResultSet rs = stm.executeQuery(req);
        if(rs.next()){
            
         u.setId(rs.getInt("id"));
            u.setFirst_name(rs.getString("first_name"));
            u.setLast_name(rs.getString("last_name"));
            u.setEmail(rs.getString("mail"));
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("password"));
            u.setBirth_date(rs.getDate("birth_date"));
            u.setPhone(rs.getInt("phone"));
            u.setRoles(rs.getString("roles"));
            u.setAddress(rs.getString("address"));   
        
        }
            
      return u;
    }
    public void supprimerDeLaBase(int id) throws SQLException {

        try {
            Statement stm = cnx.createStatement();
            String query = "delete from fos_users where id='" + id + "'";

            System.out.println(stm);
            stm.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void modifierNom(int id, String nom) {

        try {
            String query = "UPDATE fos_user SET first_name='" + nom + "' WHERE id='" + id + "'";
            Statement stm = cnx.createStatement();

            System.out.println(stm);
            stm.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public user get_user_by_id(int id) throws SQLException{
         Statement stm = cnx.createStatement();
        String req = "select * from fos_users where id="+id;
        ResultSet rs = stm.executeQuery(req);
        user u =new user();
        while(rs.next()){
            u.setId(rs.getInt("id"));
            u.setFirst_name(rs.getString("first_name"));
            u.setLast_name(rs.getString("last_name"));
            u.setEmail(rs.getString("mail"));
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("password"));
            u.setBirth_date(rs.getDate("birth_date"));
            u.setPhone(rs.getInt("phone"));
            u.setRoles(rs.getString("roles"));
            u.setAddress(rs.getString("address"));      
        }
        return u;
    }
public int Salaire(int id) throws SQLException
{
    
     int salaire=0;
      
           
            Statement stm = cnx.createStatement();
            String req = "SELECT sum(prix) from prestations WHERE id_prestataire="+id;
            ResultSet rs = stm.executeQuery(req);
            System.out.println(req);
            while(rs.next()){
                System.out.println(rs);
                salaire=rs.getInt(1);
                return salaire;
}
        return 0;
            
            
            
            
        
       
}public int NombrePrestations(int id) throws SQLException
{
    
     int nbr=0;
      
           
            Statement stm = cnx.createStatement();
            String req = "SELECT COUNT(*) from prestations WHERE `id_prestataire`="+id;
            ResultSet rs = stm.executeQuery(req);
            System.out.println(req);
            while(rs.next()){
                System.out.println(rs);
                nbr=rs.getInt(1);
                return nbr;
}
        return 0;
            
            
            
            
        
       
}
}

