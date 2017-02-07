/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Exceptions.ControlEscolarException;
import Modelo.Materias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cgarcia
 */
public class MateriasControlador extends ControladorBase {

    public MateriasControlador() {
        super();
    }
    
    public Materias guardar(Materias mat) throws ControlEscolarException {
        StringBuilder sb = new StringBuilder();
        if (mat.getIdMateria() == null || mat.getIdMateria() == 0) {
            sb.append("insert into materias(nombre, semestre) values ('")
                    .append(mat.getNombre().trim().toUpperCase()).append("', ")
                    .append(mat.getSemestre()).append(")");
        } else {
            sb.append("update materias set nombre = '")
                    .append(mat.getNombre().trim().toUpperCase()).append("', ")
                    .append("semestre = ").append(mat.getSemestre())
                    .append(" where idmateria = ").append(mat.getIdMateria());
        }
        try {
            Connection con = getConnection();
            PreparedStatement ps = null;
            if (mat.getIdMateria()!= null && mat.getIdMateria()> 0) {
                ps = con.prepareStatement(sb.toString());
                ps.executeUpdate();
                return getById(mat.getIdMateria());
            } else {
                ps = con.prepareStatement(mat.toString(), Statement.RETURN_GENERATED_KEYS);
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                return getById(rs.getInt(1));
            }
        } catch (SQLException ex) {
            throw new ControlEscolarException("No fue posible guardar la materia");
        }
    }
    
    public Materias getById(int id) throws ControlEscolarException {
        Materias mat = null;
        try {
            ResultSet rs = getConnection().
                    prepareStatement("select idmateria, nombre, semestre from materias where idmateria = " + id)
                    .executeQuery();
            while (rs.next()) {
                mat = new Materias();
                mat.setIdMateria(rs.getInt("idmateria"));
                mat.setNombre(rs.getString("nombre"));
                mat.setSemestre(rs.getInt("semestre"));
            }
        } catch (SQLException e) {
            return null;
        }
        return mat;
    }
    
    public void eliminar(int id) throws ControlEscolarException {
        try {
            getConnection().prepareStatement("delete materias where idmateria = " + id).executeUpdate();
        } catch (SQLException ex) {
            throw new ControlEscolarException("No fue posible elminar la materia");
        }
    }
    
    public List<Materias> buscar(Materias mat) throws ControlEscolarException {
        StringBuilder sb = new StringBuilder();
        sb.append("select idmateria, nombre, semestre from materias where semestre = ")
                .append(mat.getSemestre());
        if (mat.getNombre() != null && !mat.getNombre().trim().isEmpty()) {
            sb.append(" and nombre = '")
                    .append(mat.getNombre().trim().toUpperCase()).append("'");
        }
        sb.append(" order by nombre");
        try {
            List<Materias> lista = new ArrayList<>();
            ResultSet rs = getConnection().prepareStatement(sb.toString()).executeQuery();
            while (rs.next()) {
                Materias res = new Materias();
                res.setIdMateria(rs.getInt("idmateria"));
                res.setNombre(rs.getString("nombre"));
                res.setSemestre(rs.getInt("semestre"));
                lista.add(res);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }
    }
}
