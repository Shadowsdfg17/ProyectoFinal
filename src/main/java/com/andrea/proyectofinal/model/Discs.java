/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrea.proyectofinal.model;

import java.util.Objects;

/**
 *
 * @author ANDREA
 */
public class Discs {
    private String stage_name;
    private String album_title;
    private String song_num;
    private String duration;

    public Discs() {
        
        this("","","","");
    }

    public Discs(String stage_name, String album_title, String song_num, String duration) {
        this.stage_name = stage_name;
        this.album_title = album_title;
        this.song_num = song_num;
        this.duration = duration;
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

    public String getSong_num() {
        return song_num;
    }

    public void setSong_num(String song_num) {
        this.song_num = song_num;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Discs{" + ", stage_name=" + stage_name + ", album_title=" + album_title + ", song_num=" + song_num + ", duration=" + duration + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Discs other = (Discs) obj;
        if (this.song_num != other.song_num) {
            return false;
        }
        
        if (!Objects.equals(this.stage_name, other.stage_name)) {
            return false;
        }
        if (!Objects.equals(this.album_title, other.album_title)) {
            return false;
        }
        if (!Objects.equals(this.duration, other.duration)) {
            return false;
        }
        return true;
    }
    
    
}
