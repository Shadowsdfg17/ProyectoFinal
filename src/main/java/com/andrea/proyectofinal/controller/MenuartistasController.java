/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrea.proyectofinal.controller;

import com.andrea.proyectofinal.App;
import java.io.IOException;
import javafx.fxml.FXML;

/**
 *
 * @author ANDREA
 */
public class MenuartistasController {
     @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("menubd");
    }
    
    @FXML
    private void verArtista() throws IOException {
        App.setRoot("menuartistas");
    
    }
         @FXML
    private void verArtista2() throws IOException {
        App.setRoot("menuartistas2");
    
    }
}
