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
import com.andrea.proyectofinal.model.Discs;
import com.andrea.proyectofinal.model.DiscsDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author ANDREA
 */
public class Verdiscos2Controller implements Initializable {
     @FXML
    private void volverAtras() throws IOException {
        App.setRoot("menuartistas");
    }
    
     @FXML
    private TableView<Discs> table;
    @FXML
    private TableColumn<Discs, String> stage_nameColumn;
    @FXML
    private TableColumn<Discs, String> album_titleColumn;
    @FXML
    private TableColumn<Discs, String> song_numColumn;
    @FXML
    private TableColumn<Discs, String> durationColumn;

    private ObservableList<Discs> data;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        java.sql.Connection con = ConnectionUtil.getConnection();

        this.data = FXCollections.observableArrayList();

        List<Discs> misDiscos = DiscsDAO.getDiscos(con);
        ArrayList<Discs> disco = new ArrayList<>();
                
        for(Discs discos:misDiscos){
            if(discos.getStage_name().equals(ArtistDAO.artista.getStage_name())){
                 disco.add(discos);
            }
        }
        data.addAll(disco);

        this.stage_nameColumn.setCellValueFactory(eachRowData -> {
            return new SimpleObjectProperty<>(eachRowData.getValue().getStage_name());
        });

        this.album_titleColumn.setCellValueFactory(eachRowData -> {
            return new SimpleObjectProperty<>(eachRowData.getValue().getAlbum_title());
        });

        this.song_numColumn.setCellValueFactory(eachRowData -> {
            return new SimpleObjectProperty<>(eachRowData.getValue().getSong_num());
        });

        this.durationColumn.setCellValueFactory(eachRowData -> {
            return new SimpleObjectProperty<>(eachRowData.getValue().getDuration());
        });
        
        table.setItems(data);

    }

    }
    

