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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tipos_calificaciones")
@NamedQueries({
    @NamedQuery(name = "TiposCalificaciones.findAll", query = "SELECT t FROM TiposCalificaciones t")})
public class TiposCalificaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipo_Calificacion")
    private Integer idTipoCalificacion;
    @Column(name = "Nombre")
    private String nombre;

    public TiposCalificaciones() {
    }

    public TiposCalificaciones(Integer idTipoCalificacion) {
        this.idTipoCalificacion = idTipoCalificacion;
    }

    public Integer getIdTipoCalificacion() {
        return idTipoCalificacion;
    }

    public void setIdTipoCalificacion(Integer idTipoCalificacion) {
        this.idTipoCalificacion = idTipoCalificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoCalificacion != null ? idTipoCalificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposCalificaciones)) {
            return false;
        }
        TiposCalificaciones other = (TiposCalificaciones) object;
        if ((this.idTipoCalificacion == null && other.idTipoCalificacion != null) || (this.idTipoCalificacion != null && !this.idTipoCalificacion.equals(other.idTipoCalificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.TiposCalificaciones[ idTipoCalificacion=" + idTipoCalificacion + " ]";
    }

}
