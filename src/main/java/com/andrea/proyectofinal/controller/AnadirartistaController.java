/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrea.proyectofinal.controller;

import Utils.ConnectionUtil;
import com.andrea.proyectofinal.App;
import com.andrea.proyectofinal.model.Artist;
import com.andrea.proyectofinal.model.ArtistDAO;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 *
 * @author ANDREA
 */
public class AnadirartistaController {

    @FXML
    private TextField stage_namefield;

    @FXML
    private TextField disc_numfield;
    
    @FXML
    private void volverAtras() throws IOException {
        App.setRoot("menuartistas2");
    }
    
    @FXML
    private void aArtista() throws IOException{
        java.sql.Connection con = ConnectionUtil.getConnection();
        
        Artist aux = new Artist(stage_namefield.getText(),disc_numfield.getText());
        
        ArtistDAO.insert(aux, con);
        
        App.setRoot("anadirartista");
    
    }
}
