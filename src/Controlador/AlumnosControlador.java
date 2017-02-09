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
import Modelo.Grupos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AlumnosControlador extends ControladorBase {
    
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public AlumnosControlador() {
        super();
    }
    
    public Alumnos guardar(Alumnos al) throws ControlEscolarException {
        StringBuilder query = new StringBuilder();
        if (al.getIdAlumno() == null || al.getIdAlumno() == 0) {
            query.append("insert into alumnos (grupos_idgrupo, nombre, apepaterno, apematerno, fecha_nacimiento, telefono, curp, ")
                    .append("tutor, tipo_sangre, num_imss, sexo, fecha_registro, fecha_actualizacion, activo) values(");

            query.append(al.getGrupo().getIdGrupo()).append(", '")
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
            query.append("'").append(sdf.format(new Date())).append("', '")
                    .append(sdf.format(new Date())).append("', 1)");
        } else {
            query.append("update alumnos set grupos_idgrupo = ").append(al.getGrupo().getIdGrupo()).append(", ")
                    .append("nombre = '").append(al.getNombre().trim().toUpperCase()).append("', ")
                    .append("apepaterno = '").append(al.getApepaterno().trim().toUpperCase()).append("', ");
            if (al.getApematerno() != null && !al.getApematerno().isEmpty()) {
                query.append("apematerno = '").append(al.getApematerno().trim().toUpperCase()).append("', ");
            } else {
                query.append("apematerno = null, ");
            }
            if (al.getFechaNacimiento() != null) {
                query.append("fecha_nacimiento = '").append(sdf.format(al.getFechaNacimiento())).append("', ");
            } else {
                query.append("fecha_nacimiento = null, ");
            }
            if (al.getTelefono() != null && !al.getTelefono().isEmpty()) {
                query.append("telefono = '").append(al.getTelefono().trim()).append("', ");
            } else {
                query.append("telefono = null ");
            }
            if (al.getCurp() != null && !al.getCurp().isEmpty()) {
                query.append("curp = '").append(al.getCurp().trim().toUpperCase()).append("', ");
            } else {
                query.append("curp = null, ");
            }
            query.append("tutor = '").append(al.getTutor().trim().toUpperCase()).append("', ");
            if (al.getTipoSangre() != null && !al.getTipoSangre().isEmpty()) {
                query.append("tipo_sangre = '").append(al.getTipoSangre().trim().toUpperCase()).append("', ");
            } else {
                query.append("tipo_sangre = null, ");
            }
            if (al.getNumImss() != null && !al.getNumImss().isEmpty()) {
                query.append("num_imss = '").append(al.getNumImss().trim().toUpperCase()).append("', ");
            } else {
                query.append("num_imss = null, ");
            }
            query.append("sexo = '").append(al.getSexo().trim().toUpperCase()).append("', ")
                    .append("fecha_actualizacion = '").append(sdf.format(new Date())).append("', ")
                    .append("activo = ").append(al.isActivo() ? "1" : "0")
                    .append(" where idalumno = ").append(al.getIdAlumno());
        }
        try {
            Connection con = getConnection();
            PreparedStatement ps = null;
            if (al.getIdAlumno() != null && al.getIdAlumno() > 0) {
                ps = con.prepareStatement(query.toString());
                ps.executeUpdate();
                return getById(al.getIdAlumno());
            } else {
                ps = con.prepareStatement(query.toString(), Statement.RETURN_GENERATED_KEYS);
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                return getById(rs.getInt(1));
            }
            
        } catch (SQLException e) {
            throw new ControlEscolarException(CodigoError.ALUMNO_ERROR_GUARDAR, "No fue posible guardar el alumno");
        }
    }
    
    public Alumnos getById(int id) {
        Alumnos al = new Alumnos();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(buildSelectAlumnos())
                    .append("where a.activo = 1 and a.idAlumno = ")
                    .append(id);
            ResultSet rs = getConnection().prepareStatement(sb.toString()).executeQuery();
            while(rs.next()) {
                al.setIdAlumno(rs.getInt("idAlumno"));
                Grupos gpo = new Grupos();
                gpo.setIdGrupo(rs.getInt("idgrupo"));
                gpo.setSemestre(rs.getString("semestre"));
                gpo.setGrupo(rs.getString("grupo"));
                al.setGrupo(gpo);
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
        StringBuilder sb = new StringBuilder();
        sb.append("update alumnos set activo = 0 where idalumno = ").append(idAlumno); 
        try {
            getConnection().prepareStatement(sb.toString()).executeUpdate();
        } catch (SQLException ex){
            throw new ControlEscolarException(CodigoError.ALUMNO_ERROR_ELIMINAR, "Ocurrió un error al eliminar el alumno");
        }
    }
    
    public List<Alumnos> buscar(Alumnos filtro) throws ControlEscolarException {
        List<Alumnos> als = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(buildSelectAlumnos());
        if (filtro.getIdAlumno() != null && filtro.getIdAlumno() > 0) {
            als.add(getById(filtro.getIdAlumno()));
        } else {
            sb.append("where ");
            if (filtro.getGrupo() != null && filtro.getGrupo().getIdGrupo() != null && filtro.getGrupo().getIdGrupo() > 0) {
                sb.append("g.idgrupo = ")
                        .append(filtro.getGrupo().getIdGrupo()).append(" ");
            }
            if (filtro.getNombre() != null && !filtro.getNombre().isEmpty()) {
                if (!sb.toString().endsWith("where ")) {
                    sb.append("and ");
                }
                sb.append("a.nombre = '").append(filtro.getNombre().trim().toUpperCase()).append("' ");
            }
            if (filtro.getApepaterno() != null && !filtro.getApepaterno().isEmpty()) {
                if (!sb.toString().endsWith("where ")) {
                    sb.append("and ");
                }
                sb.append("a.apepaterno = '").append(filtro.getApepaterno().trim().toUpperCase()).append("' ");
            }
            if (filtro.getApematerno() != null && !filtro.getApematerno().isEmpty()) {
                if (!sb.toString().endsWith("where ")) {
                    sb.append("and ");
                }
                sb.append("a.apematerno = '").append(filtro.getApematerno().trim().toUpperCase()).append("' ");
            }
            sb.append("and a.activo = 1 order by a.nombre, a.apepaterno, a.apematerno");
            try {
                ResultSet rs = getConnection().prepareStatement(sb.toString()).executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        Alumnos al = new Alumnos();
                        al.setIdAlumno(rs.getInt("idAlumno"));
                        Grupos gpo = new Grupos();
                        gpo.setIdGrupo(rs.getInt("idgrupo"));
                        gpo.setSemestre(rs.getString("semestre"));
                        gpo.setGrupo(rs.getString("grupo"));
                        al.setGrupo(gpo);
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
                        als.add(al);
                    }
                }
            } catch (SQLException ex) {
                return null;
            }
        }
        return als;
    }
    
    private String buildSelectAlumnos() {
        StringBuilder sb = new StringBuilder();
            sb.append("select a.idAlumno, g.idgrupo, g.semestre, g.grupo, a.nombre, a.apepaterno, a.apematerno, a.fecha_nacimiento, a.telefono, a.curp, ")
                    .append("a.tutor, a.tipo_sangre, a.num_imss, a.sexo, a.fecha_registro, a.fecha_actualizacion, a.activo from alumnos a ")
                    .append("inner join grupos g on g.idgrupo = a.grupos_idgrupo ");
        return sb.toString();
    }
    
    public List<String> consultaNombreAlumnos(int grupo) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("select idalumno, concat(apepaterno, ' ', apematerno, ' ', nombre) nombre from alumnos ")
                    .append("where grupos_idgrupo = ")
                    .append(grupo)
                    .append(" order by nombre");
            ResultSet rs = getConnection().prepareStatement(sb.toString()).executeQuery();
            List<String> als = new ArrayList<>();
            while (rs.next()) {
                als.add(rs.getInt("idalumno") + " - " + rs.getString("nombre"));
            }
            return als;
        } catch (SQLException ex) {
            return null;
        }
    }
}
