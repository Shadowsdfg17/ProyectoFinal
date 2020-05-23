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
public class DiscsDAO {
    
    final static String insercion = "INSERT INTO discs (stage_name,album_title,song_num,duration) VALUES (?,?,?,?)";
    final static String seleccion = "SELECT * FROM discs";

     java.sql.Connection con = ConnectionUtil.getConnection();
    
    public static Discs discos;

    public DiscsDAO(java.sql.Connection con) {
        this.con = con;
    } 
    
    public static void insert(Discs discos, java.sql.Connection con) {
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(insercion);
            ps.setString(1, discos.getStage_name());
            ps.setString(2,discos.getAlbum_title());
            ps.setString(3, discos.getSong_num());
            ps.setString(4, discos.getDuration());
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
    
    public static ArrayList<Discs> getDiscos(java.sql.Connection con) {
        ArrayList<Discs> discos = new ArrayList<Discs>();
        PreparedStatement st = null;
        ResultSet rs = null;
        if (con != null) {
            try {
                st = con.prepareStatement(seleccion);
                rs = st.executeQuery();

                Discs disc = null;
                while (rs != null && rs.next()) {
                    disc = new Discs();
                    String stage_name = rs.getString("stage_name");
                    String album_title = rs.getString("album_title");
                    String song_num = rs.getString("song_num");
                    String duration = rs.getString("duration");
                 
                    disc.setStage_name(stage_name);
                    disc.setAlbum_title(album_title);
                    disc.setSong_num(song_num);
                    disc.setDuration(duration);

                    discos.add(disc);
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
        return discos;

    }
}
