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
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


/**
 *
 * @author ANDREA
 */
public class MenuartistasController implements Initializable{
        
     @FXML
    private void volverAtras() throws IOException {
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
    
         @FXML
    private void verBiografia() throws IOException {
        App.setRoot("verbiografia2");
    
    }
    
         @FXML
    private void verDiscos() throws IOException {
        App.setRoot("verdiscos2");
    
    }
    
    
    @FXML
    private TableView<Artist> table;
    @FXML
    private TableColumn<Artist, String> stage_nameColumn;
    @FXML
    private TableColumn<Artist, String> disc_numColumn;

    private ObservableList<Artist> data;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         java.sql.Connection con = ConnectionUtil.getConnection();

        this.data = FXCollections.observableArrayList();


        List<Artist> misArtistas = ArtistDAO.getArtistas(con);
        data.addAll(misArtistas);

        this.stage_nameColumn.setCellValueFactory(eachRowData -> {
            return new SimpleObjectProperty<>(eachRowData.getValue().getStage_name());
        });

        this.disc_numColumn.setCellValueFactory(eachRowData -> {
            return new SimpleObjectProperty<>(eachRowData.getValue().getDisc_num());
        });
        
        table.setItems(data);
        
    }
    
     @FXML
    private void seleccionado() throws IOException {

        ArtistDAO.artista = table.getSelectionModel().getSelectedItem();

        if (ArtistDAO.artista != null) {
            verBiografia();
        } else {

            showWarning("ERROR", "No se ha podido ver la biografía", "Seleccione un artista.");

        }
    }
      @FXML
    private void seleccionado2() throws IOException {

        ArtistDAO.artista = table.getSelectionModel().getSelectedItem();

        if (ArtistDAO.artista != null) {
            verDiscos();
        } else {

            showWarning("ERROR", "No se ha podido ver la discografía", "Seleccione un artista.");

        }
    }
    
      public void showWarning(String title, String header, String description) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(description);
        alert.showAndWait();
    }
}
