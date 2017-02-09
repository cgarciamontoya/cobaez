/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author cgarcia
 */
public class Cardex {
    
    private Integer idAlumno;
    private Integer idMateria;
    private String nombreMateria;
    private Float parcial1;
    private Float parcial2;
    private Float parcial3;
    private Float ordinario;
    private Float extraordinario;
    private Float titulo;

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public Float getParcial1() {
        return parcial1;
    }

    public void setParcial1(Float parcial1) {
        this.parcial1 = parcial1;
    }

    public Float getParcial2() {
        return parcial2;
    }

    public void setParcial2(Float parcial2) {
        this.parcial2 = parcial2;
    }

    public Float getParcial3() {
        return parcial3;
    }

    public void setParcial3(Float parcial3) {
        this.parcial3 = parcial3;
    }

    public Float getOrdinario() {
        return ordinario;
    }

    public void setOrdinario(Float ordinario) {
        this.ordinario = ordinario;
    }

    public Float getExtraordinario() {
        return extraordinario;
    }

    public void setExtraordinario(Float extraordinario) {
        this.extraordinario = extraordinario;
    }

    public Float getTitulo() {
        return titulo;
    }

    public void setTitulo(Float titulo) {
        this.titulo = titulo;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }
    
    
}
