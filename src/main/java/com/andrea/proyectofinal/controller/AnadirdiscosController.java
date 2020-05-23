/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrea.proyectofinal.controller;

import Utils.ConnectionUtil;
import com.andrea.proyectofinal.App;
import com.andrea.proyectofinal.model.Discs;
import com.andrea.proyectofinal.model.DiscsDAO;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 *
 * @author ANDREA
 */
public class AnadirdiscosController {
    
     @FXML
    private void volverAtras() throws IOException {
        App.setRoot("menuartistas2");
    }
    
    @FXML
    
    private TextField stage_namefield;
    
    @FXML
    
    private TextField album_titlefield;
    
    @FXML
    
    private TextField num_songfield;
    
    @FXML
    
    private TextField durationfield;
    
     @FXML
    private void aDiscografía() throws IOException{
        java.sql.Connection con = ConnectionUtil.getConnection();
        
         Discs aux = new Discs(stage_namefield.getText(),album_titlefield.getText(),num_songfield.getText(),durationfield.getText());
        
        DiscsDAO.insert(aux, con);
        
        App.setRoot("menuartistas2");
    
    }
}
