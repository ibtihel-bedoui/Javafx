/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.util;

import com.fixit.entities.Prestations;
import com.fixit.entities.PropositionsPrix;
import com.fixit.services.PrestationsService;
import com.fixit.services.PropositionsPrixService;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.ObservableList;

/**
 *
 * @author dell
 */
public class testconnection {
    
    
	public static void main(String [] args) throws SQLException
	{
            try {
                ConnectionDb db = ConnectionDb.getInstance();
                Connection cn = db.getCnx();
                /*String query = "Select * From prestations";
			Statement st = cn.createStatement();
			ResultSet rst = st.executeQuery(query);
			
			if(!rst.next())
			{
				System.out.println("it's ok");	
			}*/
                PrestationsService ps = new PrestationsService();
                ObservableList<Prestations> l= ps.listerPrestations(1);
                l.forEach(p->System.out.println(p.getId_prestation()));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
        
        }
    
}