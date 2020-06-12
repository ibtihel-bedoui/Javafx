/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.services;

import com.fixit.entities.Question;
import com.fixit.util.ConnectionDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;




/**
 *
 * @author Asus
 */
public class QuestionService implements QuestionServiceInterface
{
    private Object p;
    @Override
    public void addQuestion (Question q ) throws SQLException {
        
        ConnectionDb db = ConnectionDb.getInstance();
         Connection cn = db.getCnx();
 String query ="INSERT INTO `questions`(`id_question`, `id_client`, `titre_question`, `description_question`, `état_question`) VALUES (?,?,?,?,?)";
 
         PreparedStatement st  = cn.prepareStatement(query);
                st.setInt(1, q.getId_question());
                st.setInt(2,q.getId_client());
                st.setString(3,q.getTitre_question());
                st.setString(4,q.getDescription_question());
                st.setInt(5,q.getÉtat_question());
                st.execute();
            
    

    }

    @Override
    public void updateQuestion(Question q) throws SQLException {
     

                ConnectionDb db = ConnectionDb.getInstance();
                Connection cn = db.getCnx();
                String query = "UPDATE `questions` SET `id_question`=?,`id_client`=?,`titre_question`=?,`description_question`=?,`état_question`=? WHERE `id_question` = \"+p.getId_question()";
		PreparedStatement st  = cn.prepareStatement(query);
                
                
                st.setInt(1, q.getId_question());
                st.setInt(2,q.getId_client());
                st.setString(3,q.getTitre_question());
                st.setString(4,q.getDescription_question());
                st.setInt(5,q.getÉtat_question());
                st.execute();

    }


    
    @Override
    public void deleteQuestion(int id_question) throws SQLException {
        

                ConnectionDb db = ConnectionDb.getInstance();
                Connection cn = db.getCnx();
                String query = "DELETE FROM `questions` WHERE `id_question` = "+id_question;
		PreparedStatement st  = cn.prepareStatement(query); 
                st.execute();


    }

    @Override
    public ObservableList<Question> listerQuestion() throws SQLException {
        


                ConnectionDb db = ConnectionDb.getInstance();
                Connection cn = db.getCnx();
                String query = "SELECT * FROM `questions`";
		Statement st  = cn.createStatement();
                ResultSet rs = st.executeQuery(query);
                List<Question> lp = new ArrayList<>();
                Question q = new Question();
                while(rs.next()){
                    q.setId_question(rs.getInt("id_question"));
                    q.setId_client(rs.getInt("id_client"));
                    q.setTitre_question(rs.getString("titre_question"));
                    q.setDescription_question(rs.getString("description_question"));
                    q.setÉtat_question(rs.getInt("état_question"));
                   
                 
                    lp.add(q);
                }
                ObservableList lp_final = FXCollections.observableArrayList(lp);
                return lp_final;
    }

    }

   

