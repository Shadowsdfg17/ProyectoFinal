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
public class ArtistDAO {


    final static String insercion = "INSERT INTO artist (stage_name,disc_num) VALUES (?,?)";
    final static String seleccion = "SELECT * FROM artist";
    final static String actualizar = "UPDATE artist SET stage_name=?, disc_num=? WHERE stage_name=?";
    final static String deletear = "DELETE FROM artist WHERE stage_name=?";


    java.sql.Connection con = ConnectionUtil.getConnection();

    public static Artist artista;

    public ArtistDAO(java.sql.Connection con) {
        this.con = con;
    }

    public static void insert(Artist artist, java.sql.Connection con) {
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(insercion);
            ps.setString(1, artist.getStage_name());
            ps.setString(2, artist.getDisc_num());
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

    public static ArrayList<Artist> getArtistas(java.sql.Connection con) {
        ArrayList<Artist> artistas = new ArrayList<Artist>();
        PreparedStatement st = null;
        ResultSet rs = null;
        ArrayList<Biography> listaAux = new ArrayList<>();
        if (con != null) {
            try {
                st = con.prepareStatement(seleccion);
                rs = st.executeQuery();

                Artist art = null;
                while (rs != null && rs.next()) {
                    Biography aux = null;
                    listaAux = BiographyDAO.getBiografias(con);
                    art = new Artist();
                    String stage_name = rs.getString("stage_name");
                    String disc_num = rs.getString("disc_num");
                    for (Biography a : listaAux) {
                        if (a.getStage_name().equals(stage_name)) {
                            aux = a;
                            break;
                        }
                    }
                    art.setStage_name(stage_name);
                    art.setDisc_num(disc_num);
                    art.setBiography(aux);

                    artistas.add(art);
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
        return artistas;

    }

    public static boolean actualizaArtista(java.sql.Connection con, Artist art) {
        boolean update = false;
        PreparedStatement ps = null;
        if (con != null) {
            try {
                ps = con.prepareStatement(actualizar);
                ps.setString(1, art.getStage_name());
                ps.setString(2, art.getDisc_num());
                ps.setString(3, art.getStage_name());
                ps.executeUpdate();
                update = true;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return update;
    }

    public static boolean borrarArtista(java.sql.Connection con, Artist art) {
        boolean borrar = false;
        PreparedStatement ps = null;
        if (con != null) {
            try {
                ps = con.prepareStatement(deletear);
                ps.setString(1, art.getStage_name());
                ps.executeUpdate();
                borrar = true;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return borrar;
    }

}
