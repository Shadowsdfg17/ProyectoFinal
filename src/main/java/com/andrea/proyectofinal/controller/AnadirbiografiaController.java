/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrea.proyectofinal.controller;

import Utils.ConnectionUtil;
import com.andrea.proyectofinal.App;
import com.andrea.proyectofinal.model.Biography;
import com.andrea.proyectofinal.model.BiographyDAO;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author ANDREA
 */
public class AnadirbiografiaController {

    @FXML
    private TextField stage_namefield;

    @FXML

    private TextArea descriptionarea;
    
     @FXML
    private void volverAtras() throws IOException {
        App.setRoot("menuartistas2");
    }
    
    @FXML
    private void aBiografía() throws IOException{
        java.sql.Connection con = ConnectionUtil.getConnection();
        
        Biography aux = new Biography(stage_namefield.getText(),descriptionarea.getText());
        
        BiographyDAO.insert(aux, con);
        
        App.setRoot("menuartistas2");
    
    }

}
