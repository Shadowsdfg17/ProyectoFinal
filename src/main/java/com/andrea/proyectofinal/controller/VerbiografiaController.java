/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrea.proyectofinal.controller;

import Utils.ConnectionUtil;
import com.andrea.proyectofinal.App;
import com.andrea.proyectofinal.model.ArtistDAO;
import com.andrea.proyectofinal.model.Biography;
import com.andrea.proyectofinal.model.BiographyDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 *
 * @author ANDREA
 */
public class VerbiografiaController implements Initializable {
    
    @FXML
    private TextFlow texto;
    
    @FXML
    private void volverAtras() throws IOException {
        App.setRoot("menuartistas2");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        java.sql.Connection con = ConnectionUtil.getConnection();
        
        ArrayList<Biography> biografias = new ArrayList<>();
        
        biografias = BiographyDAO.getBiografias(con);
        
        String biografia = "";
        
        for(Biography bio:biografias){
            if(bio.getStage_name().equals(ArtistDAO.artista.getStage_name())){
                biografia = bio.getDescription();
            }
        }
        Text aux = new Text(biografia);
        texto.getChildren().add(aux);
        texto.setPadding(new Insets(10.0));
                
    }
    
    
}
