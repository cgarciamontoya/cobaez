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
package Modelo;

import java.io.Serializable;

public class Municipios implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idMunicipio;
    private String nombre;
    private Estados estadosidEstados;

    public Municipios() {
    }

    public Municipios(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public Integer getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Estados getEstadosidEstados() {
        return estadosidEstados;
    }

    public void setEstadosidEstados(Estados estadosidEstados) {
        this.estadosidEstados = estadosidEstados;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMunicipio != null ? idMunicipio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipios)) {
            return false;
        }
        Municipios other = (Municipios) object;
        if ((this.idMunicipio == null && other.idMunicipio != null) || (this.idMunicipio != null && !this.idMunicipio.equals(other.idMunicipio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Municipios[ idMunicipio=" + idMunicipio + " ]";
    }

}
