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
package Util;

import Modelo.Alumnos;
import Modelo.Docentes;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ValidacionesUtil {

    public static List<String> validarAlumno(Alumnos al) {
        List<String> errores = new ArrayList<>();
        if (al.getNombre() == null || al.getNombre().isEmpty()) {
            errores.add("NOMBRE REQUERIDO");
        }
        if (al.getApepaterno() == null || al.getApepaterno().isEmpty()) {
            errores.add("APELLIDO PATERNO REQUERIDO");
        }
        if (al.getFechaNacimiento() != null) {
            Calendar fechaActual = Calendar.getInstance();
            Calendar fn = Calendar.getInstance();
            fn.setTime(al.getFechaNacimiento());
            if (al.getFechaNacimiento().after(fechaActual.getTime())) {
                errores.add("FECHA DE NACIMIENTO MAYOR A FECHA ACTUAL");
            }
            if ((fechaActual.get(Calendar.YEAR) - fn.get(Calendar.YEAR)) < 15) {
                errores.add("EL ALUMNO DEBE TENER EDAD MAYOR A 15");
            }
        }
        if (al.getTelefono() != null && !al.getTelefono().isEmpty()) {
            if (al.getTelefono().length() > 10) {
                errores.add("EL TELEFONO DEBE CONTENER 10 DIGITOS O MENOS");
            }
            if (!al.getTelefono().matches("^[\\d]*$")) {
                errores.add("EL TELEFONO DEBE CONTENER SOLO NUMEROS");
            }
        }
        if (al.getCurp() != null && !al.getCurp().isEmpty()) {
            if (al.getCurp().length() > 18) {
                errores.add("CURP MAYOR A 18 CARACTERES");
            }
        }
        if (al.getNumImss() != null && !al.getNumImss().isEmpty()) {
            if (al.getNumImss().length() > 11) {
                errores.add("EL NUMERO IMSS NO DEBE EXCEDER LOS 11 CARACTERES");
            }
            if (!al.getNumImss().matches("^[\\d]*$")) {
                errores.add("EL NUMERO IMSS DEBE SER NUMERICO");
            }
        }
        if (al.getTutor() == null || al.getTutor().isEmpty()) {
            errores.add("EL TUTOR ES REQUERIDO");
        }
        
        return errores;
    }
    
    public static List<String> validarDocente(Docentes doc) {
        List<String> errores = new ArrayList<>();
        if (doc.getNumEmpleados() == null || doc.getNumEmpleados().isEmpty()) {
            errores.add("EL NUMERO DE EMPLEADO ES REQUERIDO");
        }
        if (doc.getNombre() == null || doc.getNombre().trim().isEmpty()) {
            errores.add("EL NOMBRE ES REQUERIDO");
        }
        if (doc.getApepaterno() == null || doc.getApepaterno().trim().isEmpty()) {
            errores.add("EL APELLIDO PATERNO ES REQUERIDO");
        }
        if (doc.getTelefono() == null || doc.getTelefono().trim().isEmpty()) {
            errores.add("EL TELEFONO ES REQUERIDO");
        } else {
            if (!doc.getTelefono().matches("^[\\d]*$")) {
                errores.add("EL TELEFONO DEBE SER NUMERICO");
            }
            if (doc.getTelefono().trim().length() > 10) {
                errores.add("EL TELEFONO NO DEBE EXCEDER LOS 1O DIGITOS");
            }
        }
        if (doc.getCorreo() == null || doc.getCorreo().isEmpty()) {
            errores.add("EL CORREO ELECTRONICO ES REQUERIDO");
        }
        return errores;
    }
}
