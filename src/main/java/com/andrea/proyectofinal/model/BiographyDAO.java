/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrea.proyectofinal.model;

import Utils.ConnectionUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ANDREA
 */
public class BiographyDAO {

    final static String seleccion = "SELECT * FROM biography";
    final static String actualizar = "UPDATE biography SET stage_name=?, description=? WHERE stage_name=?";
    final static String insercion = "INSERT INTO biography (stage_name,description) VALUES (?,?)";

    java.sql.Connection con = ConnectionUtil.getConnection();

    public BiographyDAO(java.sql.Connection con) {
        this.con = con;
    }

    public static ArrayList<Biography> getBiografias(java.sql.Connection con) {
        ArrayList<Biography> biografias = new ArrayList<Biography>();
        PreparedStatement st = null;
        ResultSet rs = null;

        if (con != null) {
            try {
                st = con.prepareStatement(seleccion);
                rs = st.executeQuery();

                Biography bio = null;
                while (rs != null && rs.next()) {
                    bio = new Biography();
                    String stage_name = rs.getString("stage_name");
                    String description = rs.getString("description");

                    bio.setStage_name(stage_name);
                    bio.setDescription(description);

                    biografias.add(bio);
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
        return biografias;

    }

    public static boolean actualizaBiografia(java.sql.Connection con, Biography bio) {
        boolean update = false;
        PreparedStatement st = null;
        if (con != null) {
            try {
                st = con.prepareStatement(actualizar);
                st.setString(1, bio.getStage_name());
                st.setString(2, bio.getDescription());
                st.setString(3, bio.getStage_name());

                st.executeUpdate();
                update = true;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (st != null) {
                    try {
                        st.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return update;
    }
    
        public static void insert(Biography bio, java.sql.Connection con) {
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(insercion);
            ps.setString(1, bio.getStage_name());
            ps.setString(2, bio.getDescription());
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }

        }
    }
}
