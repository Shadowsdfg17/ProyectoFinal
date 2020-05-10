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
public class Artist extends Person {

    private String stage_name;
    private String id_biography;
    private int song_num;
    private int disc_num;

    public Artist() {
    }

    public Artist(String stage_name, String id_biography, int song_num, int disc_num) {
        this.stage_name = stage_name;
        this.id_biography = id_biography;
        this.song_num = song_num;
        this.disc_num = disc_num;
    }

    public Artist(String stage_name, String id_biography, int song_num, int disc_num, String name, String lastname, Date birthday) {
        super(name, lastname, birthday);
        this.stage_name = stage_name;
        this.id_biography = id_biography;
        this.song_num = song_num;
        this.disc_num = disc_num;
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

    public String getId_biography() {
        return id_biography;
    }

    public void setId_biography(String id_biography) {
        this.id_biography = id_biography;
    }

    public int getSong_num() {
        return song_num;
    }

    public void setSong_num(int song_num) {
        this.song_num = song_num;
    }

    public int getDisc_num() {
        return disc_num;
    }

    public void setDisc_num(int disc_num) {
        this.disc_num = disc_num;
    }

    @Override
    public int compareTo(IPerson o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
