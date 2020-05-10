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
public class Discs {
    private String id_disc;
    private String stage_name;
    private String album_title;
    private int song_num;
    private String duration;

    public Discs() {
    }

    public Discs(String id_disc, String stage_name, String album_title, int song_num, String duration) {
        this.id_disc = id_disc;
        this.stage_name = stage_name;
        this.album_title = album_title;
        this.song_num = song_num;
        this.duration = duration;
    }

    public String getId_disc() {
        return id_disc;
    }

    public void setId_disc(String id_disc) {
        this.id_disc = id_disc;
    }

    public String getStage_name() {
        return stage_name;
    }

    public void setStage_name(String stage_name) {
        this.stage_name = stage_name;
    }

    public String getAlbum_title() {
        return album_title;
    }

    public void setAlbum_title(String album_title) {
        this.album_title = album_title;
    }

    public int getSong_num() {
        return song_num;
    }

    public void setSong_num(int song_num) {
        this.song_num = song_num;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    
    
}
