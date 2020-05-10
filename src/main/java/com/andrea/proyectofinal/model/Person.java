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
public abstract class Person implements IPerson {
    protected String name;
    protected String lastname;
    protected Date birthday;

    public Person() {
    }

    public Person(String name, String lastname, Date birthday) {
        this.name = name;
        this.lastname = lastname;
        this.birthday = birthday;
    }

    
    
}
