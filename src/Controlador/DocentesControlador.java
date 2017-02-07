/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Exceptions.ControlEscolarException;
import Modelo.Docentes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author cgarcia
 */
public class DocentesControlador extends ControladorBase {
    
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public DocentesControlador() {
        super();
    }
    
    public Docentes guardar(Docentes docente) throws ControlEscolarException {
        StringBuilder sb = new StringBuilder();
        if (docente.getIdDocente() == null || docente.getIdDocente() == 0) {
            sb.append("insert into docentes(nombre, apepaterno, apematerno, telefono, num_empleados, correo, activo, fecha_registro) ")
                    .append("values ('")
                    .append(docente.getNombre().toUpperCase()).append("', '")
                    .append(docente.getApepaterno().toUpperCase()).append("', '")
                    .append(docente.getApematerno() != null && !docente.getApematerno().isEmpty() ? docente.getApematerno().toUpperCase() : "").append("','")
                    .append(docente.getTelefono()).append("','")
                    .append(docente.getNumEmpleados()).append("','")
                    .append(docente.getCorreo()).append("', 1,'")
                    .append(sdf.format(new Date())).append("')");
        } else {
            sb.append("update docentes set nombre = '")
                    .append(docente.getNombre().toUpperCase()).append("', ")
                    .append("apepaterno = '").append(docente.getApepaterno().toUpperCase()).append("', ")
                    .append("apematerno = ");
            if (docente.getApematerno() != null && !docente.getApematerno().isEmpty()) {
                sb.append("'").append(docente.getApematerno().toUpperCase()).append("', ");
            } else {
                sb.append("null, ");
            }
            sb.append("telefono = '").append(docente.getTelefono()).append("', ")
                    .append("num_empleados = '").append(docente.getNumEmpleados()).append("', ")
                    .append("correo = '").append(docente.getCorreo()).append("' ")
                    .append("where iddocente = ").append(docente.getIdDocente());
        }
        try {
            Connection con = getConnection();
            PreparedStatement ps = null;
            if (docente.getIdDocente()!= null && docente.getIdDocente()> 0) {
                ps = con.prepareStatement(sb.toString());
                ps.executeUpdate();
                return getById(docente.getIdDocente());
            } else {
                ps = con.prepareStatement(sb.toString(), Statement.RETURN_GENERATED_KEYS);
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                return getById(rs.getInt(1));
            }
        } catch(SQLException e) {
            throw new ControlEscolarException("No fue posible guardar el registro del docente");
        }
    }
    
    public Docentes getById(Integer id) throws ControlEscolarException {
        StringBuilder sb = new StringBuilder();
        sb.append("select iddocente, nombre, apepaterno, apematerno, telefono, num_empleados, correo, activo, fecha_registro ")
                .append("from docentes where activo = 1 and iddocente = ").append(id);
        Docentes doc = null;
        try {
            ResultSet rs = getConnection().prepareStatement(sb.toString()).executeQuery();
            while(rs.next()) {
                doc = new Docentes();
                doc.setIdDocente(rs.getInt("iddocente"));
                doc.setNombre(rs.getString("nombre"));
                doc.setApepaterno(rs.getString("apepaterno"));
                doc.setApematerno(rs.getString("apematerno"));
                doc.setTelefono(rs.getString("telefono"));
                doc.setNumEmpleados(rs.getString("num_empleados"));
                doc.setCorreo(rs.getString("correo"));
                doc.setActivo(rs.getInt("activo") > 0);
                doc.setFechaRegistro(rs.getDate("fecha_registro"));
            }
            return doc;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public void eliminar(Integer id) throws ControlEscolarException {
        StringBuilder sb = new StringBuilder();
        sb.append("update docentes set activo = 0 where iddocente = ").append(id);
        try {
            getConnection().prepareStatement(sb.toString()).executeUpdate();
        } catch (SQLException ex) {
            throw new ControlEscolarException("No fue posible eliminar el docente");
        }
    }
    
    public List<Docentes> buscar(Docentes docs) throws ControlEscolarException {
        StringBuilder sb = new StringBuilder();
        List<Docentes> lista = new ArrayList<>();
        if (docs.getIdDocente() != null && docs.getIdDocente() > 0) {
            Docentes doc = getById(docs.getIdDocente());
            if (doc != null && doc.getIdDocente() != null && doc.getIdDocente() > 0) {
                lista.add(doc);
            }
        } else {
            sb.append("select iddocente, nombre, apepaterno, apematerno, telefono, num_empleados, correo, activo, fecha_registro ")
                    .append("from docentes where ");
            if (docs.getNumEmpleados() != null && !docs.getNumEmpleados().isEmpty()) {
                sb.append("num_empleados = '")
                        .append(docs.getNumEmpleados().trim()).append("' ");
            }
            if (docs.getNombre() != null && !docs.getNombre().isEmpty()) {
                if (sb.toString().endsWith("where ")) {
                    sb.append("and ");
                }
                sb.append("nombre = '").append(docs.getNombre().trim().toUpperCase()).append("' ");
            }
            if (docs.getApepaterno() != null && !docs.getApepaterno().isEmpty()) {
                if (sb.toString().endsWith("where ")) {
                    sb.append("and ");
                }
                sb.append("apepaterno = '").append(docs.getApepaterno().trim().toUpperCase()).append("', ");
            }
            if (docs.getApematerno() != null && !docs.getApematerno().isEmpty()) {
                if (sb.toString().endsWith("where ")) {
                    sb.append("and ");
                }
                sb.append("apematerno = '").append(docs.getApematerno().trim().toUpperCase()).append("' ");
            }
            sb.append(" and activo = 1");
            try {
                ResultSet rs = getConnection().prepareStatement(sb.toString()).executeQuery();
                while (rs.next()) {
                    Docentes doc = new Docentes();
                    doc.setIdDocente(rs.getInt("iddocente"));
                    doc.setNombre(rs.getString("nombre"));
                    doc.setApepaterno(rs.getString("apepaterno"));
                    doc.setApematerno(rs.getString("apematerno"));
                    doc.setTelefono(rs.getString("telefono"));
                    doc.setNumEmpleados(rs.getString("num_empleados"));
                    doc.setCorreo(rs.getString("correo"));
                    doc.setActivo(rs.getInt("activo") > 0);
                    doc.setFechaRegistro(rs.getDate("fecha_registro"));
                    lista.add(doc);
                }
            } catch (SQLException ex) {
                return null;
            }
        }
        return lista;
    }
}
