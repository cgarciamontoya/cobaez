/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.CatalogosControlador;
import Controlador.HorariosControlador;
import Controlador.MateriasControlador;
import Exceptions.ControlEscolarException;
import Modelo.Grupos;
import Modelo.Horario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class FormHorario extends FormBase {
    private static final long serialVersionUID = 7508556886236289065L;
    
    private final CatalogosControlador catalogos;
    private final MateriasControlador materias;
    private final HorariosControlador horarios;

    /**
     * Creates new form FormHorario
     */
    public FormHorario() {
        initComponents();
        catalogos = new CatalogosControlador();
        materias = new MateriasControlador();
        horarios = new HorariosControlador();
        
        cargarCatalogos();
    }
    
    private void cargarCatalogos() {
        cboGrupo.setModel(new DefaultComboBoxModel(catalogos.consultaGrupos().toArray()));
        Grupos gpo = catalogos.consultaGrupo(cboGrupo.getSelectedItem().toString());
        cboMaterias.setModel(new DefaultComboBoxModel(materias.consultarPorSemestre(Integer.parseInt(gpo.getSemestre())).toArray()));
        List<String> horas = catalogos.consultarHoras();
        cboHoras.setModel(new DefaultComboBoxModel(horas.toArray()));
        
        DefaultTableModel tabla = (DefaultTableModel) tblHorario.getModel();
        int i = 0;
        for (String hr : horas) {
            tabla.setValueAt(hr, i++, 0);
        }
        
        cargarHorario();
    }
    
    private void cargarHorario() {
        DefaultTableModel tabla = (DefaultTableModel) tblHorario.getModel();
        Grupos gpo = catalogos.consultaGrupo(cboGrupo.getSelectedItem().toString());
        List<Horario> horarioGpo = horarios.consultarHorario(gpo.getIdGrupo());
        
        for (int i = 1; i < tabla.getColumnCount(); i++) {
            for (int j = 0; j < tabla.getRowCount(); j++) {
                tabla.setValueAt(null, j, i);
            }
        }
        
        if (horarioGpo != null && !horarioGpo.isEmpty()) {
            for (Horario hr : horarioGpo) {
                int idDia = getIdDia(hr.getDia());
                tabla.setValueAt(hr.getNombreMateria(), (hr.getIdHora() - 1), idDia);
            }
        }
    }
    
    private int getIdDia(String dia) {
        switch (dia) {
            case("LU"): {
                return 1;
            }
            case("MA"): {
                return 2;
            }
            case("MI"): {
                return 3;
            }
            case("JU"): {
                return 4;
            }
            default: {
                return 5;
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cboGrupo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cboDias = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cboMaterias = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cboHoras = new javax.swing.JComboBox();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHorario = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setResizable(true);
        setTitle("HORARIO");
        setPreferredSize(new java.awt.Dimension(790, 393));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("GRUPO");

        cboGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarGrupo(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("DIA");

        cboDias.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "LU", "MA", "MI", "JU", "VI" }));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("MATERIA");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("HORA");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarMateria(evt);
            }
        });

        tblHorario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "HR", "LU", "MA", "MI", "JU", "VI"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHorario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quitarMateria(evt);
            }
        });
        jScrollPane1.setViewportView(tblHorario);
        if (tblHorario.getColumnModel().getColumnCount() > 0) {
            tblHorario.getColumnModel().getColumn(0).setResizable(false);
            tblHorario.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblHorario.getColumnModel().getColumn(1).setResizable(false);
            tblHorario.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblHorario.getColumnModel().getColumn(2).setResizable(false);
            tblHorario.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblHorario.getColumnModel().getColumn(3).setResizable(false);
            tblHorario.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblHorario.getColumnModel().getColumn(4).setResizable(false);
            tblHorario.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblHorario.getColumnModel().getColumn(5).setResizable(false);
            tblHorario.getColumnModel().getColumn(5).setPreferredWidth(100);
        }

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarHorario(evt);
            }
        });

        btnSalir.setText("Cerrar");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarVentana(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboGrupo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboDias, 0, 80, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboHoras, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(363, 363, 363)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addGap(43, 43, 43)
                        .addComponent(btnSalir)
                        .addGap(296, 296, 296))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAgregar)
                        .addGap(292, 292, 292))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(cboHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnAgregar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnSalir))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarMateria(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarMateria
        String materia = cboMaterias.getSelectedItem().toString();
        int idxDia = cboDias.getSelectedIndex() + 1;
        String[] hora = cboHoras.getSelectedItem().toString().split("-");
        int idHora = (Integer.parseInt(hora[0].trim())) - 1;
        
        DefaultTableModel tabla = (DefaultTableModel) tblHorario.getModel();
        if (tabla.getValueAt(idHora, idxDia) != null) {
            agregarMensajeAdvertencia("La hora seleccionada ya se encuentra asignada");
            return;
        }
        
        for (int i = 0; i < 7; i++) {
            if (tabla.getValueAt(i, idxDia) != null &&
                    tabla.getValueAt(i, idxDia).toString().contains(materia)) {
                agregarMensajeAdvertencia("La materia ya se encuentra asignada en el dia");
                return;
            }
        }
        
        boolean existe = horarios.existeMateriaHora(Integer.parseInt(materia.split("-")[0].trim()), 
                Integer.parseInt(hora[0].trim()),
                cboDias.getSelectedItem().toString());
        if (existe) {
            agregarMensajeAdvertencia("La materia ya se encuentra asignada en la hora seleccionada para otro grupo");
            return;
        }
        tabla.setValueAt(materia, idHora, idxDia);
    }//GEN-LAST:event_agregarMateria

    private void cerrarVentana(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarVentana
        this.dispose();
    }//GEN-LAST:event_cerrarVentana

    private void guardarHorario(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarHorario
        Grupos grupo = catalogos.consultaGrupo(cboGrupo.getSelectedItem().toString());
        List<Horario> lista = new ArrayList<>();
        DefaultTableModel tabla = (DefaultTableModel) tblHorario.getModel();
        for (int i = 0; i < 7; i++) {
            for (int j = 1; j < tabla.getColumnCount(); j++) {
                if (tabla.getValueAt(i, j) != null) {
                    Horario hr = new Horario();
                    hr.setIdGrupo(grupo.getIdGrupo());
                    hr.setDia(tabla.getColumnName(j));
                    hr.setIdHora(i + 1);
                    hr.setIdMateria(Integer.parseInt(tabla.getValueAt(i, j).toString().split("-")[0].trim()));
                    lista.add(hr);
                }
            }
        }
        try {
            horarios.limpiarHorarioGrupo(grupo.getIdGrupo());
            
            horarios.guardarHorario(grupo.getIdGrupo(), lista);
            agregarMensajeExito("Se guardó correctamente el horario");
        } catch (ControlEscolarException ex) {
            agregarMensajeError(ex.getMessage());
        }
    }//GEN-LAST:event_guardarHorario

    private void cargarGrupo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarGrupo
        cargarHorario();
    }//GEN-LAST:event_cargarGrupo

    private void quitarMateria(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quitarMateria
        if (SwingUtilities.isRightMouseButton(evt)) {
            int dialogResult = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar la materia?", 
                    "Advertencia", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {
                DefaultTableModel model = (DefaultTableModel) tblHorario.getModel();
                if (tblHorario.getSelectedColumn() > 0) {
                    if (model.getValueAt(tblHorario.getSelectedRow(), tblHorario.getSelectedColumn()) != null) {
                        model.setValueAt(null, tblHorario.getSelectedRow(), tblHorario.getSelectedColumn());
                    } else {
                        agregarMensajeAdvertencia("El horario no se encuentra asignado");
                    }
                } else {
                    agregarMensajeAdvertencia("Debe seleccionar una materia");
                }
            }
        }
    }//GEN-LAST:event_quitarMateria


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cboDias;
    private javax.swing.JComboBox cboGrupo;
    private javax.swing.JComboBox cboHoras;
    private javax.swing.JComboBox cboMaterias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHorario;
    // End of variables declaration//GEN-END:variables
}