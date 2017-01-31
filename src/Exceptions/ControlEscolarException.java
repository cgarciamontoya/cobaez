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
package Exceptions;

public class ControlEscolarException extends Throwable {

    private static final long serialVersionUID = 8935387365861510899L;

    private int codigoError;

    public ControlEscolarException() {
    }

    public ControlEscolarException(Throwable cause) {
        super(cause);
    }
    
    public ControlEscolarException(int codigoError, String mensajeError) {
        super(mensajeError);
        this.codigoError = codigoError;
    }

    public ControlEscolarException(int codigoError, String mensajeError, Throwable throwable) {
        super(mensajeError, throwable);
        this.codigoError = codigoError;
    }

    public int getCodigoError() {
        return codigoError;
    }

    public void setCodigoError(int codigoError) {
        this.codigoError = codigoError;
    }
    
    
}
