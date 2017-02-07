/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author cgarcia
 */
public class FormBase extends javax.swing.JInternalFrame {
    
    public void agregarMensajeExito(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje,
                    "Exito", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void agregarMensajeError(String error) {
        JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public void agregarMensajeAdvertencia(String advertencia) {
        JOptionPane.showMessageDialog(this, advertencia, "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
    
    public String mensajeValidacion(List<String> errores) {
        String error = "No se puede guardar el registro por los siguientes errores de validación: \n\r";
        for (String er : errores) {
            error += "\t* " + er + "\n\r";
        }
        return error;
    }
}
