/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrea.proyectofinal.model;

import java.util.Date;

/**
 *
 * @author ANDREA
 */
public class Biography {

    private String id_artist;
    private String stage_name;
    private String name;
    private String lastname;
    private Date birthday;
    private String description;

    public Biography() {
    }

    public Biography(String id_artist, String stage_name, String name, String lastname, Date birthday, String description) {
        this.id_artist = id_artist;
        this.stage_name = stage_name;
        this.name = name;
        this.lastname = lastname;
        this.birthday = birthday;
        this.description = description;
    }

    public String getId_artist() {
        return id_artist;
    }

    public void setId_artist(String id_artist) {
        this.id_artist = id_artist;
    }

    public String getStage_name() {
        return stage_name;
    }

    public void setStage_name(String stage_name) {
        this.stage_name = stage_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
