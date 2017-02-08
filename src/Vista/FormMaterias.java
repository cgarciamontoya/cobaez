/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.MateriasControlador;
import Exceptions.ControlEscolarException;
import Modelo.Materias;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cgarcia
 */
public class FormMaterias extends FormBase {
    
    private MateriasControlador controlador;
    private Materias materia;

    /**
     * Creates new form FormMaterias
     */
    public FormMaterias() {
        initComponents();
        controlador = new MateriasControlador();
        lblActualizando.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultados = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cboSemestre = new javax.swing.JComboBox<>();
        lblActualizando = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("MATERIAS");

        jLabel1.setText("NOMBRE");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarRegistro(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarMateria(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarMateria(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarFormulario(evt);
            }
        });

        tblResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Semestre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblResultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarMateria(evt);
            }
        });
        jScrollPane1.setViewportView(tblResultados);

        jLabel2.setText("SEMESTRE");

        cboSemestre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6" }));

        lblActualizando.setText("Actualizando...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblActualizando, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLimpiar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cboSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar)
                    .addComponent(btnBuscar)
                    .addComponent(btnLimpiar)
                    .addComponent(lblActualizando))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarMateria(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarMateria
        if (txtNombre.getText() == null || txtNombre.getText().isEmpty()) {
            agregarMensajeAdvertencia("EL NOMBRE ES REQUERIDO");
            return;
        }
        if (materia == null) {
            materia = new Materias();
        }
        materia.setNombre(txtNombre.getText());
        materia.setSemestre(Integer.parseInt(cboSemestre.getSelectedItem().toString()));
        
        try {
            materia = controlador.guardar(materia);
            agregarMensajeExito("La materia se guardo correctamente");
        } catch (ControlEscolarException ex) {
            agregarMensajeError(ex.getMessage());
        }
        
    }//GEN-LAST:event_guardarMateria

    private void limpiarFormulario(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarFormulario
        limpiarTabla();
        materia = null;
        txtNombre.setText("");
        cboSemestre.setSelectedIndex(0);
        lblActualizando.setVisible(false);
    }//GEN-LAST:event_limpiarFormulario

    private void editarMateria(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarMateria
        DefaultTableModel model = (DefaultTableModel) tblResultados.getModel();
        int idMat = (Integer) model.getValueAt(tblResultados.getSelectedRow(), 0);
        if (idMat > 0) {
            int dialogResult = JOptionPane.showConfirmDialog(null, "Desea editar la materia?", 
                    "Advertencia", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {
                materia = new Materias();
                materia.setIdMateria(idMat);
                txtNombre.setText((String) model.getValueAt(tblResultados.getSelectedRow(), 1));
                cboSemestre.setSelectedIndex(((Integer) model.getValueAt(tblResultados.getSelectedRow(), 2)) - 1);
                lblActualizando.setVisible(true);
            }
        }
    }//GEN-LAST:event_editarMateria

    private void buscarMateria(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarMateria
        materia = new Materias();
        if (txtNombre.getText() != null && !txtNombre.getText().isEmpty()) {
            materia.setNombre(txtNombre.getText());
        }
        materia.setSemestre(Integer.parseInt(cboSemestre.getSelectedItem().toString()));
        try {
            limpiarTabla();
            List<Materias> materias = controlador.buscar(materia);
            if (materias != null && !materias.isEmpty()) {
                DefaultTableModel model = (DefaultTableModel) tblResultados.getModel();
                for (Materias mat : materias) {
                    model.addRow(new Object[] {mat.getIdMateria(), mat.getNombre(), mat.getSemestre()});
                }
            } else {
                agregarMensajeAdvertencia("No se encontraron resultados");
            }
        } catch (ControlEscolarException ex) {
            agregarMensajeError(ex.getMessage());
        }
    }//GEN-LAST:event_buscarMateria

    private void cerrarRegistro(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarRegistro
        this.dispose();
    }//GEN-LAST:event_cerrarRegistro

    private void limpiarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tblResultados.getModel();
        while(modelo.getRowCount() != 0) {
            modelo.removeRow(modelo.getRowCount() - 1);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cboSemestre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblActualizando;
    private javax.swing.JTable tblResultados;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
