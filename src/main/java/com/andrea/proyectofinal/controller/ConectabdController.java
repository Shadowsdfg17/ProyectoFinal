package com.andrea.proyectofinal.controller;

import com.andrea.proyectofinal.App;
import java.io.IOException;
import javafx.fxml.FXML;


public class ConectabdController {

   

    @FXML
    private void volverAtras() throws IOException {
        App.setRoot("menubd");
    }
}
