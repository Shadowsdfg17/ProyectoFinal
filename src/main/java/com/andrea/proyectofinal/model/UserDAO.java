/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrea.proyectofinal.model;

import Utils.ConnectionUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ANDREA
 */
public class UserDAO {

    java.sql.Connection con = ConnectionUtil.getConnection();

    public UserDAO(java.sql.Connection con) {
        this.con = con;
    }

    public static User getUser(java.sql.Connection con) {
        
        Statement st = null;
        ResultSet rs = null;
        User aux = null;

        if (con != null) {
            try {
                st = con.createStatement();
                rs = st.executeQuery("SELECT * FROM user");

                
                while (rs != null && rs.next()) {
                    aux = new User();
                    String nick = rs.getString("nick");
                    String password = rs.getString("password");
                    
                    aux.setUser(nick);
                    aux.setPassword(password);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException ex) {
                        ex.getMessage();
                    }
                }
            }
        }
        return aux;


    }

}
