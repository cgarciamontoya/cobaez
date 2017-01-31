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

import Exceptions.CodigoError;
import Exceptions.ControlEscolarException;
import Modelo.Alumnos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AlumnosControlador extends ControladorBase {
    
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public AlumnosControlador() {
        super();
    }
    
    public Alumnos guardar(Alumnos al) throws ControlEscolarException {
        StringBuilder query = new StringBuilder();
        query.append("inser into alumnos (grupos_idgrupo, nombre, apepaterno, apematerno, fecha_nacimiento, telefono, curp, ")
                .append("tutor, tipo_sangre, num_imss, sexo, fecha_registro, activo) values(");

        query.append(al.getGrupo()).append(", '")
                .append(al.getNombre().toUpperCase()).append("', '")
                .append(al.getApepaterno().toUpperCase()).append("', ");
        if(al.getApematerno() != null && !al.getApematerno().isEmpty()) {
            query.append("'").append(al.getApematerno().toUpperCase()).append("', ");
        } else {
            query.append("null, ");
        }
        query.append("'").append(sdf.format(al.getFechaNacimiento())).append("', ");
        if (al.getTelefono() != null && !al.getTelefono().isEmpty()) {
            query.append("'").append(al.getTelefono()).append("', ");
        } else {
            query.append("null, ");
        }
        if (al.getCurp() != null && !al.getCurp().isEmpty()) {
            query.append("'").append(al.getCurp().toUpperCase()).append("', ");
        } else {
            query.append("null, ");
        }
        query.append("'").append(al.getTutor().toUpperCase()).append("', ");
        if (al.getTipoSangre() != null && !al.getTipoSangre().isEmpty()) {
            query.append("'").append(al.getTipoSangre().toUpperCase()).append("', ");
        } else {
            query.append("null, ");
        }
        if (al.getNumImss() != null && !al.getNumImss().isEmpty()) {
            query.append("'").append(al.getNumImss().toUpperCase()).append("', ");
        } else {
            query.append("null, ");
        }
        if (al.getSexo()!= null && !al.getSexo().isEmpty()) {
            query.append("'").append(al.getSexo().toUpperCase()).append("', ");
        } else {
            query.append("null, ");
        }
        query.append("'").append(sdf.format(new Date())).append("', 1)");
        
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(query.toString(), Statement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return getById(rs.getInt(1));
        } catch (SQLException e) {
            throw new ControlEscolarException(CodigoError.ALUMNO_ERROR_GUARDAR, "No fue posible guardar el alumno");
        }
    }
    
    public Alumnos getById(int id) {
        Alumnos al = new Alumnos();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("select a.idAlumno, a.grupos_idgrupo, a.nombre, a.apepaterno, a.apematerno, a.fecha_nacimiento, a.telefono, a.curp, ")
                    .append("a.tutor, a.tipo_sangre, a.num_imss, a.sexo, a.fecha_registro, a.fecha_actualizacion, a.activo from alumnos a ")
                    .append("inner join grupos g on g.idgrupo = a.grupos_idgrupo ")
                    .append("where a.idAlumno = ")
                    .append(id);
            ResultSet rs = getConnection().prepareStatement(sb.toString()).executeQuery();
            while(rs.next()) {
                al.setIdAlumno(rs.getInt("idAlumno"));
                al.setGrupo(rs.getInt("grupos_idgrupo"));
                al.setNombre(rs.getString("nombre"));
                al.setApepaterno(rs.getString("apepaterno"));
                al.setApematerno(rs.getString("apematerno"));
                al.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                al.setTelefono(rs.getString("telefono"));
                al.setCurp(rs.getString("curp"));
                al.setTutor(rs.getString("tutor"));
                al.setTipoSangre(rs.getString("tipo_sangre"));
                al.setNumImss(rs.getString("num_imss"));
                al.setSexo(rs.getString("sexo"));
                al.setFechaRegistro(rs.getDate("fecha_registro"));
                al.setFechaActualizacion(rs.getDate("fecha_actualizacion"));
                al.setActivo(rs.getInt("activo") > 0);
            }
        } catch (SQLException e) {
            return null;
        }
        return al;
    }
    
    public void eliminar(int idAlumno) throws ControlEscolarException {
        
    }
    
    public List<Alumnos> buscar(Alumnos filtro) throws ControlEscolarException {
        
        return null;
    }
}
