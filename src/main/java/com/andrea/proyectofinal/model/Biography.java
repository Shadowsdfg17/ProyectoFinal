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
public class Biography {

    private String stage_name;
    private String description;

    public Biography() {
    }
    
    public Biography(String description){
        this.description = description;
    }

    public Biography(String stage_name, String description) {
        this.stage_name = stage_name;
        this.description = description;
    }

    public String getStage_name() {
        return stage_name;
    }

    public void setStage_name(String stage_name) {
        this.stage_name = stage_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Biography{" + "stage_name=" + stage_name + ", description=" + description + '}';
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
        final Biography other = (Biography) obj;
        if (!Objects.equals(this.stage_name, other.stage_name)) {
            return false;
        }
        return true;
    }

}
