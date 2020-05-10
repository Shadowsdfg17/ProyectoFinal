/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrea.proyectofinal.model;

/**
 *
 * @author ANDREA
 */
public class Songs {
   
    private String id_song;
    private String stage_name;
    private String duration;
    private String disc_name;

    public Songs() {
    }

    public Songs(String id_song, String stage_name, String duration, String disc_name) {
        this.id_song = id_song;
        this.stage_name = stage_name;
        this.duration = duration;
        this.disc_name = disc_name;
    }

    public String getId_song() {
        return id_song;
    }

    public void setId_song(String id_song) {
        this.id_song = id_song;
    }

    public String getStage_name() {
        return stage_name;
    }

    public void setStage_name(String stage_name) {
        this.stage_name = stage_name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDisc_name() {
        return disc_name;
    }

    public void setDisc_name(String disc_name) {
        this.disc_name = disc_name;
    }
    
    
}
