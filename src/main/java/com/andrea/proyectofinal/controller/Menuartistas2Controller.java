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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 *
 * @author ANDREA
 */
public class Menuartistas2Controller implements Initializable {

    @FXML
    private void volverAtras() throws IOException {
        App.setRoot("menubd");
    }
    
    @FXML
    private void refrescar() throws IOException {
        App.setRoot("menuartistas2");
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

    private void editarArtista() throws IOException {
        App.setRoot("editarartistas");
    }

    @FXML

    private void menuAnadir() throws IOException {
        App.setRoot("menuanadirartistas");
    }

    @FXML

    private void verBiografia() throws IOException {
        App.setRoot("verbiografia");
    }

    @FXML

    private void verDiscos() throws IOException {
        App.setRoot("verdiscos");
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

        disc_numColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        disc_numColumn.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Artist, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Artist, String> t) {

                Artist selected = (Artist) t.getTableView().getItems().get(
                        t.getTablePosition().getRow());

                selected.setDisc_num(t.getNewValue());

                ArtistDAO.actualizaArtista(con, selected);

            }
        }
        );
        table.setEditable(true);
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

    @FXML
    private void borrado() throws IOException {

        java.sql.Connection con = ConnectionUtil.getConnection();

        Artist aux = table.getSelectionModel().getSelectedItem();

        boolean resultado = ArtistDAO.borrarArtista(con, aux);
        
        if(!resultado){
            showWarning("ERROR", "No se ha podido borrar el artista", "Intentelo de nuevo.");
        }
        
        App.setRoot("menuartistas2");
    }

    public void showWarning(String title, String header, String description) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(description);
        alert.showAndWait();
    }
}
