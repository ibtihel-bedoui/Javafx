/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.services;

import com.fixit.entities.Question;
import java.sql.SQLException;
import javafx.collections.ObservableList;

/**
 *
 * @author Asus
 */
public interface QuestionServiceInterface {
    
    
    public void addQuestion(Question q) throws SQLException;
    public void updateQuestion (Question q) throws SQLException ;
    public void deleteQuestion (int id_question) throws SQLException ;
    public ObservableList<Question> listerQuestion() throws SQLException ;

    
}
