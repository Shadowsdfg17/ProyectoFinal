/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrea.proyectofinal.controller;

import Utils.ConnectionUtil;
import com.andrea.proyectofinal.App;
import com.andrea.proyectofinal.model.User;
import com.andrea.proyectofinal.model.UserDAO;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author ANDREA
 */
public class IniciasesionController {

    @FXML
    public TextField user;
    public PasswordField password;

    @FXML

    private void login() throws IOException {

        java.sql.Connection con = ConnectionUtil.getConnection();
        User aux = new User();
        aux = UserDAO.getUser(con);

        if (aux.getUser().equals(user.getText()) && aux.getPassword().equals(password.getText())) {
            iniciaSesion();
        } else {
            showWarning("ERROR", "No se ha podido iniciar sesión", "Intentelo más tarde.");
        }

    }

    public void showWarning(String title, String header, String description) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(description);
        alert.showAndWait();
    }

    @FXML
    private void iniciaSesion() throws IOException {
        App.setRoot("menuartistas2");
    }

    @FXML
    private void volverAtras() throws IOException {
        App.setRoot("menubd");
    }
}
