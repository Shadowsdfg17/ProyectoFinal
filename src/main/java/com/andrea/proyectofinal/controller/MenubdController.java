package com.andrea.proyectofinal.controller;

import com.andrea.proyectofinal.App;
import java.io.IOException;
import javafx.fxml.FXML;

public class MenubdController {

    @FXML
    private void retrocederVentana() throws IOException {
        App.setRoot("conectabd");
    }
    
    @FXML
     private void verArtista() throws IOException {
        App.setRoot("menuartistas");
    
    }
      @FXML
    private void verArtista2() throws IOException {
        App.setRoot("menuartistas2");
    
    }
    
      @FXML
    private void iniciaSesion2() throws IOException {
        App.setRoot("iniciasesion");
    
    }
}