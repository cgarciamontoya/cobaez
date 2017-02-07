/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.DocentesControlador;
import Exceptions.ControlEscolarException;
import Modelo.Alumnos;
import Modelo.Docentes;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cgarcia
 */
public class FormDocentesConsulta extends FormBase {

    private DocentesControlador controlador;
    private Docentes doc;
    /**
     * Creates new form FormDocentesConsulta
     */
    public FormDocentesConsulta() {
        initComponents();
        controlador = new DocentesControlador();
        doc = new Docentes();
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
        txtMatricula = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNumEmpleado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPaterno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMaterno = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultados = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("CONSULTA DOCENTES");

        jLabel1.setText("MATRICULA");

        jLabel2.setText("NUMERO EMPLEADO");

        jLabel3.setText("NOMBRE");

        jLabel4.setText("APELLIDO PATERNO");

        jLabel5.setText("APELLIDO MATERNO");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarDocentes(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparFormulario(evt);
            }
        });

        tblResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricula", "No. Empleado", "Nombre", "Ap. Paterno", "Ap. Materno"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
                seleccionarRegistro(evt);
            }
        });
        jScrollPane1.setViewportView(tblResultados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(159, 159, 159)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(txtMatricula, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLimpiar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                                .addComponent(btnBuscar))
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumEmpleado, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPaterno, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(btnLimpiar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarDocentes(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarDocentes
        doc = new Docentes();
        limpiarTabla();
        if (filtrosValidos()) {
            try {
                List<Docentes> resultado = controlador.buscar(doc);
                if (resultado != null && !resultado.isEmpty()) {
                    limpiarTabla();
                    DefaultTableModel modelo = (DefaultTableModel) tblResultados.getModel();
                    for (Docentes al : resultado) {
                        modelo.addRow(new Object[] {
                            al.getIdDocente(), al.getNumEmpleados(), al.getNombre(),
                            al.getApepaterno(), al.getApematerno()
                        });
                    }
                } else {
                    agregarMensajeAdvertencia("No se encontraron resultados");
                }
            } catch (ControlEscolarException ex) {
                agregarMensajeError("No fue posible consultar los alumnos debido a: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_buscarDocentes
    private void limpiarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tblResultados.getModel();
        while(modelo.getRowCount() != 0) {
            modelo.removeRow(modelo.getRowCount() - 1);
        }
    }
    private boolean filtrosValidos() {
        int contador = 0;
        if (txtMatricula.getText() != null && !txtMatricula.getText().isEmpty() &&
                txtMatricula.getText().matches("^[\\d]*$")) {
            doc.setIdDocente(Integer.parseInt(txtMatricula.getText()));
            contador++;
        }
        if (txtNumEmpleado.getText() != null && !txtNumEmpleado.getText().isEmpty()) {
            doc.setNumEmpleados(txtNumEmpleado.getText());
            contador++;
        }
        if (txtNombre.getText() != null && !txtNombre.getText().isEmpty()) {
            doc.setNombre(txtNombre.getText());
            contador++;
        }
        if (txtPaterno.getText() != null && !txtPaterno.getText().isEmpty()) {
            doc.setApepaterno(txtPaterno.getText());
            contador++;
        }
        if (txtMaterno.getText() != null && !txtMaterno.getText().isEmpty()) {
            doc.setApematerno(txtMaterno.getText());
            contador++;
        }
        return contador > 0;
    }
    private void limparFormulario(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparFormulario
        limpiarTabla();
        txtMatricula.setText("");
        txtNumEmpleado.setText("");
        txtNombre.setText("");
        txtPaterno.setText("");
        txtMaterno.setText("");
    }//GEN-LAST:event_limparFormulario

    private void seleccionarRegistro(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seleccionarRegistro
        DefaultTableModel model = (DefaultTableModel) tblResultados.getModel();
        int id = (Integer) model.getValueAt(tblResultados.getSelectedRow(), 0);
        if (id > 0) {
            int dialogResult = JOptionPane.showConfirmDialog(null, "Desea abrir los datos del Docente?", 
                    "Advertencia", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {
                FormDocentes docs = new FormDocentes(id);
                this.getParent().add(docs);
                docs.show();
                this.dispose();
            }
        }
    }//GEN-LAST:event_seleccionarRegistro


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResultados;
    private javax.swing.JTextField txtMaterno;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumEmpleado;
    private javax.swing.JTextField txtPaterno;
    // End of variables declaration//GEN-END:variables
}