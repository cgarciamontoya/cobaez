/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Descripción:
 * Fecha: 30/01/2017
 * Autor: Carlos A. García M.
 */
package Controlador;

import Modelo.Grupos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatalogosControlador extends ControladorBase {

    public CatalogosControlador() {
        super();
    }

    public List<String> consultaGrupos() {
        List<String> gpos = new ArrayList<>();
        try {
            ResultSet rs = getConnection().prepareStatement("select semestre, grupo from grupos").executeQuery();
            
            while(rs.next()) {
                gpos.add(rs.getString("semestre") + " " + rs.getString("grupo"));
            }
        } catch (SQLException e) {
            return null;
        }
        return gpos;
    }
    
    public Grupos consultaGrupo(String nombre) {
        try {
            String[] datos = nombre.split(" ");
            String query = "select idgrupo, grupo, semestre from grupos where semestre = '" + datos[0] + 
                    "' and grupo = '" + datos[1].toUpperCase() + "'";
            
            ResultSet rs = getConnection().prepareStatement(query).executeQuery();
            Grupos gpo = new Grupos();
            while (rs.next()) {
                gpo.setIdGrupo(rs.getInt("idgrupo"));
                gpo.setGrupo(rs.getString("grupo"));
                gpo.setSemestre(rs.getString("semestre"));
            }
            return gpo;
        } catch (SQLException e) {
            return null;
        }
    }
    
    public List<String> consultarHoras() {
        List<String> datos = new ArrayList<>();
        try {
            ResultSet rs = getConnection().prepareStatement("select concat(id, ' - ', inicio, ' - ', fin) nombre from horas").executeQuery();
            while (rs.next()) {
                datos.add(rs.getString("nombre"));
            }
            return datos;
        } catch (SQLException ex) {
            return null;
        }
    }
}
