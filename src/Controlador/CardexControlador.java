/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Exceptions.ControlEscolarException;
import Modelo.Cardex;
import Modelo.Materias;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author cgarcia
 */
public class CardexControlador extends ControladorBase {

    public CardexControlador() {
        super();
    }
    
    public Cardex consultaCardex(int idAlumno, Materias materia) {
        StringBuilder sb = new StringBuilder();
        if (!existeCardex(idAlumno, materia.getIdMateria())) {
            guardarCardexMat(idAlumno, materia.getIdMateria());
        }
        sb.append("select c.id_alumno, c.id_materia, m.nombre, c.parcial_1, c.parcial_2, c.parcial_3, c.ordinario, ")
                .append("c.extraordinario, c.titulo ")
                .append("from cardex c inner join materias m on m.idmateria = c.id_materia where c.id_alumno = ")
                .append(idAlumno)
                .append(" and c.id_materia = ")
                .append(materia.getIdMateria());
        Cardex cardex = new Cardex();
        try {
            ResultSet rs = getConnection().prepareStatement(sb.toString()).executeQuery();
            while (rs.next()) {
                cardex.setIdAlumno(rs.getInt("id_alumno"));
                cardex.setIdMateria(rs.getInt("id_materia"));
                cardex.setNombreMateria(rs.getString("nombre"));
                cardex.setParcial1(rs.getFloat("parcial_1"));
                cardex.setParcial2(rs.getFloat("parcial_2"));
                cardex.setParcial3(rs.getFloat("parcial_3"));
                cardex.setOrdinario(rs.getFloat("ordinario"));
                cardex.setExtraordinario(rs.getFloat("extraordinario"));
                cardex.setTitulo(rs.getFloat("titulo"));
            }
        } catch (SQLException e) {
        }
        return cardex;
    }
    
    private boolean existeCardex(int idAlumno, int idMateria) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("select count(*) conteo from cardex where id_alumno = ")
                    .append(idAlumno).append(" and id_materia = ").append(idMateria);
            ResultSet rs = getConnection().prepareStatement(sb.toString()).executeQuery();
            rs.next();
            return rs.getInt("conteo") > 0;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    private void guardarCardexMat(int idAlumno, int idMateria) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("insert into cardex(id_alumno, id_materia) values (")
                    .append(idAlumno)
                    .append(", ")
                    .append(idMateria)
                    .append(")");
            getConnection().prepareStatement(sb.toString()).executeUpdate();
        } catch (SQLException ex) {
            
        }
    }
    
    public void actualizarCardex(Cardex cardex) throws ControlEscolarException {
        StringBuilder sb = new StringBuilder();
        sb.append("update cardex set parcial_1 = ")
                .append(cardex.getParcial1()).append(", ")
                .append("parcial_2 = ").append(cardex.getParcial2()).append(", ")
                .append("parcial_3 = ").append(cardex.getParcial3()).append(", ")
                .append("ordinario = ").append(cardex.getOrdinario()).append(", ")
                .append("extraordinario = ").append(cardex.getExtraordinario()).append(", ")
                .append("titulo = ").append(cardex.getTitulo()).append(" ")
                .append("where id_alumno = ").append(cardex.getIdAlumno()).append(" and ")
                .append("id_materia = ").append(cardex.getIdMateria());
        try {
            getConnection().prepareStatement(sb.toString()).executeUpdate();
        } catch (SQLException ex) {
            throw new ControlEscolarException("No se pudo guardar las calificaciones del alumno");
        } 
    }
}
