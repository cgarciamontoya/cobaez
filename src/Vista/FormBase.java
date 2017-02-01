/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

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
}
