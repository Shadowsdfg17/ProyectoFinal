/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrea.proyectofinal.model;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author ANDREA
 */
public class Artist extends Person {

    private String stage_name;
    private String disc_num;
    private Biography biography;

    public Artist() {
        
        this("","",null);
    }
    
    public Artist(String stage_name, String disc_num){
        this.stage_name = stage_name;
        this.disc_num = disc_num;
    }

    public Artist(String stage_name,String disc_num,Biography biography) {
        this.stage_name = stage_name;
        this.disc_num = disc_num;
        this.biography = biography;
    }

    public Artist(String stage_name,String disc_num, String name, String lastname, Date birthday,Biography biography) {
        super(name, lastname, birthday);
        this.stage_name = stage_name;
        this.disc_num = disc_num;
        this.biography =  biography;
    }
    

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getLastname() {
        return this.lastname;
    }

    @Override
    public Date getBirthday() {
        return this.birthday;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getStage_name() {
        return stage_name;
    }

    public void setStage_name(String stage_name) {
        this.stage_name = stage_name;
    }

    public String getDisc_num() {
        return disc_num;
    }

    public void setDisc_num(String disc_num) {
        this.disc_num = disc_num;
    }

    public Biography getBiography() {
        return biography;
    }

    public void setBiography(Biography biography) {
        this.biography = biography;
    }

    @Override
    public String toString() {
        return "Artist{" + "stage_name=" + stage_name + ", disc_num=" + disc_num + ", biography=" + biography + '}';
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
        final Artist other = (Artist) obj;

        if (!Objects.equals(this.stage_name, other.stage_name)) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public int compareTo(IPerson o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
