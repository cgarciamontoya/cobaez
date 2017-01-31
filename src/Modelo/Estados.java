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
import java.util.List;

public class Estados implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idEstados;
    private String nombre;
    private List<Municipios> municipiosList;

    public Estados() {
    }

    public Estados(Integer idEstados) {
        this.idEstados = idEstados;
    }

    public Integer getIdEstados() {
        return idEstados;
    }

    public void setIdEstados(Integer idEstados) {
        this.idEstados = idEstados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Municipios> getMunicipiosList() {
        return municipiosList;
    }

    public void setMunicipiosList(List<Municipios> municipiosList) {
        this.municipiosList = municipiosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstados != null ? idEstados.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estados)) {
            return false;
        }
        Estados other = (Estados) object;
        if ((this.idEstados == null && other.idEstados != null) || (this.idEstados != null && !this.idEstados.equals(other.idEstados))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Estados[ idEstados=" + idEstados + " ]";
    }

}
