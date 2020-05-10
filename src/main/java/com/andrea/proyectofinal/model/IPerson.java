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
public interface IPerson extends Comparable<IPerson>{
    String getName();
    String getLastname();
    Date getBirthday();
    void setName(String name);
    void setLastname(String lastname);
    void setBirthday(Date birthday);
}
