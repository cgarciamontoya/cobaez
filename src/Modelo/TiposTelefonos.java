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

public class TiposTelefonos implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idTipoTelefono;

    public TiposTelefonos() {
    }

    public TiposTelefonos(Integer idTipoTelefono) {
        this.idTipoTelefono = idTipoTelefono;
    }

    public Integer getIdTipoTelefono() {
        return idTipoTelefono;
    }

    public void setIdTipoTelefono(Integer idTipoTelefono) {
        this.idTipoTelefono = idTipoTelefono;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoTelefono != null ? idTipoTelefono.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposTelefonos)) {
            return false;
        }
        TiposTelefonos other = (TiposTelefonos) object;
        if ((this.idTipoTelefono == null && other.idTipoTelefono != null) || (this.idTipoTelefono != null && !this.idTipoTelefono.equals(other.idTipoTelefono))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.TiposTelefonos[ idTipoTelefono=" + idTipoTelefono + " ]";
    }

}
