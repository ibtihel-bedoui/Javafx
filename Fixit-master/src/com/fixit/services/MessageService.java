/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.services;

import com.fixit.entities.Message;
import com.fixit.util.ConnectionDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell
 */
public class MessageService {
     public List<Message> afficher(int d, int a)throws SQLException
    {
List <Message> messages= new ArrayList<>();
 ConnectionDb db = ConnectionDb.getInstance();
         Connection cn = db.getCnx();
         String query ="SELECT * FROM `message` WHERE id_prestation="+d+" AND id_prestataire="+a;
          
          Statement st  = cn.createStatement();
                ResultSet rst = st.executeQuery(query);
       
        while (rst.next()){
            Message m= new Message(rst.getInt("id"),rst.getString("nom"),rst.getString("prenom"),rst.getString("contenu"));
            messages.add(m);
            System.out.println(m.toString());
        }
        return messages;
    }
     public void ajouterMessage(String n,String p,String c,int i, int ir, int idr) throws SQLException{
         ConnectionDb db = ConnectionDb.getInstance();
         Connection cn = db.getCnx();
 String req="INSERT INTO `message`(`nom`, `prenom`, `contenu`,`id_prestation`, `id_prestataire`, `id_client`)VALUES (?,?,?,?,?,?);";
 PreparedStatement ps=cn.prepareStatement(req);
 ps.setString(1,n);
 ps.setString(2,p);
        ps.setString(3,c);
        ps.setInt(4,i);
        ps.setInt(5,ir);
        ps.setInt(6,idr);
       
        ps.executeUpdate();
}
}
