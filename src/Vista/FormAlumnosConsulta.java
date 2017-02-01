/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.AlumnosControlador;
import Controlador.CatalogosControlador;
import Exceptions.ControlEscolarException;
import Modelo.Alumnos;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cgarcia
 */
public class FormAlumnosConsulta extends FormBase {

    private Alumnos alumno;
    private AlumnosControlador controlador;
    private CatalogosControlador catalogos;
    /**
     * Creates new form FormAlumnosConsulta
     */
    public FormAlumnosConsulta() {
        initComponents();
        controlador = new AlumnosControlador();
        catalogos = new CatalogosControlador();
        cargarCatalogos();
    }
    
    private void cargarCatalogos() {
        cboGrupo.setModel(new DefaultComboBoxModel(catalogos.consultaGrupos().toArray()));
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
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPaterno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMaterno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cboGrupo = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultados = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("CONSULTA ALUMNOS");
        setPreferredSize(new java.awt.Dimension(680, 450));

        jLabel1.setText("MATRICULA");

        jLabel2.setText("NOMBRE");

        jLabel3.setText("APELLIDO PATERNO");

        jLabel4.setText("APELLIDO MATERNO");

        jLabel5.setText("GRUPO");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarAlumnos(evt);
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
                "Matricula", "Nombre", "Ap. Paterno", "Ap. Materno", "Grupo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(txtMatricula)
                            .addComponent(jLabel2)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(119, 119, 119)
                                .addComponent(jLabel4))
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPaterno)
                                    .addComponent(cboGrupo, 0, 200, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(txtMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(btnLimpiar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscar)))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(btnLimpiar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarAlumnos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarAlumnos
        alumno = new Alumnos();
        limpiarTabla();
        if (filtrosValidos()) {
            try {
                List<Alumnos> resultado = controlador.buscar(alumno);
                if (resultado != null && !resultado.isEmpty()) {
                    limpiarTabla();
                    DefaultTableModel modelo = (DefaultTableModel) tblResultados.getModel();
                    for (Alumnos al : resultado) {
                        modelo.addRow(new Object[] {
                            al.getIdAlumno(), al.getNombre(), al.getApepaterno(), al.getApematerno(), 
                            (al.getGrupo().getSemestre() + " " + al.getGrupo().getGrupo())
                        });
                    }
                } else {
                    agregarMensajeAdvertencia("No se encontraron resultados");
                }
            } catch (ControlEscolarException ex) {
                agregarMensajeError("No fue posible consultar los alumnos debido a: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_buscarAlumnos

    
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
            alumno.setIdAlumno(Integer.parseInt(txtMatricula.getText()));
            contador++;
        }
        if (cboGrupo.getSelectedItem() != null && !cboGrupo.getSelectedItem().toString().isEmpty()) {
            alumno.setGrupo(catalogos.consultaGrupo(cboGrupo.getSelectedItem().toString()));
            contador++;
        }
        if (txtNombre.getText() != null && !txtNombre.getText().isEmpty()) {
            alumno.setNombre(txtNombre.getText());
            contador++;
        }
        if (txtPaterno.getText() != null && !txtPaterno.getText().isEmpty()) {
            alumno.setApepaterno(txtPaterno.getText());
            contador++;
        }
        if (txtMaterno.getText() != null && !txtMaterno.getText().isEmpty()) {
            alumno.setApematerno(txtMaterno.getText());
            contador++;
        }
        return contador > 0;
    }
    private void limpiarFormulario(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarFormulario
        txtMatricula.setText("");
        cboGrupo.setSelectedIndex(0);
        txtNombre.setText("");
        txtPaterno.setText("");
        txtMaterno.setText("");
        limpiarTabla();
    }//GEN-LAST:event_limpiarFormulario

    private void seleccionarRegistro(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seleccionarRegistro
        DefaultTableModel model = (DefaultTableModel) tblResultados.getModel();
        int idAlumno = (Integer) model.getValueAt(tblResultados.getSelectedRow(), 0);
        if (idAlumno > 0) {
            int dialogResult = JOptionPane.showConfirmDialog(null, "Desea abrir los datos del alumno?", 
                    "Advertencia", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {
                FormAlumnos als = new FormAlumnos(idAlumno);
                this.getParent().add(als);
                als.show();
                this.dispose();
            }
        }
    }//GEN-LAST:event_seleccionarRegistro


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cboGrupo;
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
    private javax.swing.JTextField txtPaterno;
    // End of variables declaration//GEN-END:variables
}
