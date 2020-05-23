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
public class MenuanadirartistasController {
   @FXML
    private void anadirBiografia() throws IOException {
        App.setRoot("anadirbiografia");
    }
     @FXML
    private void anadirArtistas2() throws IOException {
        App.setRoot("anadirartista");
    }
     @FXML
    private void anadirDiscos() throws IOException {
        App.setRoot("anadirdiscos");
    }
    
        @FXML
    private void volverAtras() throws IOException {
        App.setRoot("iniciasesion");
    }
}
