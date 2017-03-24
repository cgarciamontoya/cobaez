/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Descripción:
 * Fecha: 23/03/2017
 * Autor: Carlos A. García M.
 */
package Controlador;

import Exceptions.ControlEscolarException;
import Modelo.Horario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HorariosControlador extends ControladorBase {

    public HorariosControlador() {
        super();
    }
    
    public boolean existeMateriaHora(int idMateria, int idHora, String dia) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("select count(*) conteo from horario where ")
                    .append("id_materia = ").append(idMateria).append(" ")
                    .append("and id_hora = ").append(idHora).append(" ")
                    .append("and dia = '").append(dia.toUpperCase()).append("'");
            ResultSet rs = getConnection().prepareStatement(sb.toString()).executeQuery();
            rs.next();
            return rs.getInt("conteo") > 0;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public void limpiarHorarioGrupo(int idGrupo) throws ControlEscolarException {
        try {
            getConnection().prepareStatement("delete from horario where id_grupo = " + idGrupo).execute();
        } catch (SQLException ex) {
            throw new ControlEscolarException("No es posible limpiar el horario para el grupo");
        }
    }
    
    public void guardarHorario(int idGrupo, List<Horario> horario) throws ControlEscolarException {
        StringBuilder sb = new StringBuilder();
        sb.append("insert into horario (id_hora, id_grupo, id_materia, dia) values ");
        for (Horario hr : horario) {
            sb.append("(").append(hr.getIdHora()).append(", ").append(idGrupo).append(", ").append(hr.getIdMateria())
                    .append(", '").append(hr.getDia()).append("'),");
        }
        try {
            getConnection().prepareStatement(sb.toString().substring(0, (sb.toString().length() - 1))).execute();
        } catch (SQLException ex) {
            throw new ControlEscolarException("No fue posible guardar el horario del grupo");
        }
    }

    public List<Horario> consultarHorario(Integer idGrupo) {
        StringBuilder sb = new StringBuilder();
        sb.append("select hr.id_hora, hr.id_grupo, hr.id_materia, concat(hr.id_hora, ' - ', m.nombre) materia, hr.dia ")
                .append("from horario hr inner join materias m on m.idMateria = hr.id_materia ")
                .append("where hr.id_grupo = ")
                .append(idGrupo);
        List<Horario> hrs = new ArrayList<>();
        try {
            ResultSet rs = getConnection().prepareStatement(sb.toString()).executeQuery();
            while (rs.next()) {
                Horario hr = new Horario();
                hr.setDia(rs.getString("dia"));
                hr.setIdGrupo(rs.getInt("id_grupo"));
                hr.setIdHora(rs.getInt("id_hora"));
                hr.setIdMateria(rs.getInt("id_materia"));
                hr.setNombreMateria(rs.getString("materia"));
                hrs.add(hr);
            }
            return hrs;
        } catch (SQLException ex) {
            return null;
        }
    }
}
