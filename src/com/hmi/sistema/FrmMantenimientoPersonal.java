package com.hmi.sistema;

import com.hmi.conexiones.BD;
import com.hmi.conexiones.BDPersonal;
import com.hmi.variables.Persona;
import com.hmi.variables.Personal;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class FrmMantenimientoPersonal extends javax.swing.JFrame {

    String accion = "";

    public FrmMantenimientoPersonal() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
        obtenerUltimoId();
        this.setLocationRelativeTo(null);
        actualizarBusqueda();
        activarBotones(true);
        
    }

    public void obtenerUltimoId() {
        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select max(iPersonal) as Codigo from personal");
            while (rs.next()) {
                int lastID = rs.getInt(1);
                txtCodigoPer.setText(String.valueOf(lastID + 1));
            }

            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException error) {
            System.out.print(error);
        }
    }

    public void limpiarCajaTexto() {

        txtCodigoPer.setText("");
        txtCiPer.setText("");
        txtNombrePer.setText("");
        txtApellido.setText("");
        txtEspecialista.setText("");
        txtCedula.setText("");
        txtFuncionario.setText("");

    }

    public void activarCajaTexto(boolean b) {
        txtCodigoPer.setEditable(!b);
        txtCiPer.setEditable(!b);
        txtNombrePer.setEditable(!b);
        txtApellido.setEditable(!b);
        txtEspecialista.setEditable(b);
        txtCedula.setEditable(!b);
        txtFuncionario.setEditable(b);
    }

    public void activarBotones(boolean b) {
        btnNuevoPer.setEnabled(b);
        btnGuardarPer.setEnabled(!b);
        btnModificarPer.setEnabled(b);
        btnCancelarPer.setEnabled(!b);
        btnMostrarPer.setEnabled(b);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscarPer = new javax.swing.JTextField();
        cboParametroPer = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPersonal = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCodigoPer = new javax.swing.JTextField();
        txtCiPer = new javax.swing.JTextField();
        txtNombrePer = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtEspecialista = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtFuncionario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnNuevoPer = new javax.swing.JButton();
        btnGuardarPer = new javax.swing.JButton();
        btnModificarPer = new javax.swing.JButton();
        btnCancelarPer = new javax.swing.JButton();
        btnMostrarPer = new javax.swing.JButton();
        btnSalirPer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("BUSCAR PERSONAL :");

        txtBuscarPer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarPerKeyReleased(evt);
            }
        });

        cboParametroPer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ci", "Nombre" }));
        cboParametroPer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboParametroPerActionPerformed(evt);
            }
        });

        jtPersonal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ci", "Nombre"
            }
        ));
        jtPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtPersonalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtPersonal);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtBuscarPer, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboParametroPer, 0, 94, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarPer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboParametroPer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Registrar datos del Personal"));

        jLabel3.setText("ID Func :");

        jLabel4.setText("Nombre :");

        jLabel5.setText("Apllido :");

        jLabel6.setText("ID Persona: ");

        txtCodigoPer.setEditable(false);
        txtCodigoPer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoPerActionPerformed(evt);
            }
        });

        txtCiPer.setEditable(false);
        txtCiPer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCiPerActionPerformed(evt);
            }
        });
        txtCiPer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCiPerKeyTyped(evt);
            }
        });

        txtNombrePer.setEditable(false);

        txtApellido.setEditable(false);

        jLabel7.setText("Espcialista :");

        txtEspecialista.setEditable(false);

        jLabel8.setText("Nro. Func :");

        jLabel9.setText("CIº :");

        txtCedula.setEditable(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        txtFuncionario.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(txtCodigoPer, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombrePer, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEspecialista, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtCiPer, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCodigoPer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtCiPer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNombrePer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(txtEspecialista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Garamond", 1, 20)); // NOI18N
        jLabel2.setText("REGISTRAR PERSONAL");

        btnNuevoPer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/New document.png"))); // NOI18N
        btnNuevoPer.setText("NUEVO");
        btnNuevoPer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevoPer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevoPer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoPerActionPerformed(evt);
            }
        });

        btnGuardarPer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/Save.png"))); // NOI18N
        btnGuardarPer.setText("GUARDAR");
        btnGuardarPer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardarPer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardarPer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarPerActionPerformed(evt);
            }
        });

        btnModificarPer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/Modify.png"))); // NOI18N
        btnModificarPer.setText("MODIFICAR");
        btnModificarPer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificarPer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificarPer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarPerActionPerformed(evt);
            }
        });

        btnCancelarPer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/Erase.png"))); // NOI18N
        btnCancelarPer.setText("CANCELAR");
        btnCancelarPer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelarPer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelarPer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPerActionPerformed(evt);
            }
        });

        btnMostrarPer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/List.png"))); // NOI18N
        btnMostrarPer.setText("MOSTRAR");
        btnMostrarPer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMostrarPer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMostrarPer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarPerActionPerformed(evt);
            }
        });

        btnSalirPer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/Exit.png"))); // NOI18N
        btnSalirPer.setText("SALIR");
        btnSalirPer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalirPer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalirPer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirPerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnNuevoPer, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGuardarPer)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnModificarPer, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelarPer, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMostrarPer, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSalirPer, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalirPer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevoPer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardarPer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificarPer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelarPer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMostrarPer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirPerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirPerActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSalirPerActionPerformed

    private void btnNuevoPerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoPerActionPerformed
        // TODO add your handling code here:

        limpiarCajaTexto();
        activarCajaTexto(true);
        obtenerUltimoId();
        accion = "Guardar";
        activarBotones(false);
    }//GEN-LAST:event_btnNuevoPerActionPerformed

    private void btnModificarPerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarPerActionPerformed
        // TODO add your handling code here:
        activarCajaTexto(true);
        accion = "Actualizar";
        btnNuevoPer.setEnabled(false);
        btnGuardarPer.setEnabled(true);
        btnModificarPer.setEnabled(true);
        btnCancelarPer.setEnabled(true);
        btnMostrarPer.setEnabled(false);
    }//GEN-LAST:event_btnModificarPerActionPerformed

    private void btnCancelarPerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPerActionPerformed
        // TODO add your handling code here:
        limpiarCajaTexto();

        obtenerUltimoId();
        activarBotones(true);
    }//GEN-LAST:event_btnCancelarPerActionPerformed

    private void btnGuardarPerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPerActionPerformed
        // TODO add your handling code here:
        if (accion.equalsIgnoreCase("Guardar")) {
            if (txtCiPer.getText().compareTo("") != 0 && txtFuncionario.getText().compareTo("") != 0 && txtApellido.getText().compareTo("") != 0) {
                try {
                    String person = null;
                    Persona p;
                    p = new Persona();
                    try {
                        Connection con = BD.getConnection();
                        Statement stmt = con.createStatement();

                        person = txtCiPer.getText();

                        System.out.println("antes del selectci   :" + person);
                        ResultSet rs = stmt.executeQuery("select idPerson from personal where idPerson='" + person + "'");
                        System.out.println("despues del select..." + rs.next());
                        p.setPersonaux(rs.getString("idPerson"));

                        if (rs.next()) {
                            if (p == null) {
                                p = new Persona();
                            }

                        }
                        
                    } catch (SQLException e) {
                        System.out.println("Error BD recuperar idPerson: " + e.getMessage());
                    }
                    
                    String prs = null;
                    prs = p.getPersonaux();
                    if(prs == null){
                    
                    Personal ps = new Personal();
                    
                    ps.setnPerCodigo(person);
                    System.out.println("vino null se le carga codigo personal:" + ps.getnPerCodigo());
                    ps.setIdPerson(Integer.parseInt(txtCiPer.getText()));
                    ps.setiPersonal(Integer.parseInt(txtCodigoPer.getText()));
                    ps.setTipoPerson(txtEspecialista.getText());
                    ps.setnPerCodigo(txtFuncionario.getText());
                    BDPersonal.insertarPersonal(ps);
                    JOptionPane.showMessageDialog(null, "[ Datos Agregados ]");        
                    
                    
                    }else {
                            JOptionPane.showMessageDialog(null, "Personal ya Registrado..!");
                            
                            }
                    
                    
                } catch (SQLException e) {
                    System.out.println("Error BD: " + e.getMessage());
                }
                limpiarCajaTexto();
                obtenerUltimoId();
            } else {
                JOptionPane.showMessageDialog(null, "Llene Todos Los Campos..!!");
            }
        }
        if (accion.equalsIgnoreCase("Actualizar")) {
            Personal p;
            try {
                p = BDPersonal.buscarPersonalCodigo(Integer.parseInt(txtCodigoPer.getText()));

                p.setIdPerson(Integer.parseInt(txtCiPer.getText()));
                p.setiPersonal(Integer.parseInt(txtCodigoPer.getText()));
                p.setTipoPerson(txtEspecialista.getText());
                p.setnPerCodigo(txtFuncionario.getText());
                BDPersonal.actualizarPersonal(p);
                JOptionPane.showMessageDialog(null, " [ Datos Actualizados ]");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error BD: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnGuardarPerActionPerformed

    private void cboParametroPerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboParametroPerActionPerformed
        // TODO add your handling code here:
        actualizarBusqueda();
    }//GEN-LAST:event_cboParametroPerActionPerformed

    private void txtBuscarPerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarPerKeyReleased
        // TODO add your handling code here:
        actualizarBusqueda();
    }//GEN-LAST:event_txtBuscarPerKeyReleased

    private void jtPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtPersonalMouseClicked
        // TODO add your handling code here:
        //txtFuncionario.setText(p.getPerCodigo());

        try {

            Personal p = BDPersonal.buscarPersonalCodigo(Integer.parseInt(String.valueOf(jtPersonal.getModel().getValueAt(jtPersonal.getSelectedRow(), 0))));

            txtCiPer.setText(String.valueOf(p.getIdPerson()));
            txtCodigoPer.setText(String.valueOf(p.getiPersonal()));
            txtNombrePer.setText(p.getNomPerson());
            txtApellido.setText(p.getApePerson());
            txtEspecialista.setText(p.getTipoPerson());
            txtFuncionario.setText(p.getPerCodigo());
            txtCedula.setText(p.getCiPersonal());

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jtPersonalMouseClicked

    private void txtCiPerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCiPerKeyTyped
        // TODO add your handling code here:
        if (String.valueOf(evt.getKeyChar()).matches("[a-zA-Z]|\\s")) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtCiPerKeyTyped

    private void btnMostrarPerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarPerActionPerformed
        // TODO add your handling code here:
        JDBuscarPersona JDBListaR = new JDBuscarPersona(this, true, this);
        JDBListaR.setVisible(true);

    }//GEN-LAST:event_btnMostrarPerActionPerformed

    private void txtCodigoPerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoPerActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtCodigoPerActionPerformed

    private void txtCiPerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCiPerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCiPerActionPerformed

    private void actualizarBusqueda() {
        ArrayList<Personal> result = null;
        if (String.valueOf(cboParametroPer.getSelectedItem()).equalsIgnoreCase("Ci")) {
            result = BDPersonal.listarPersonalPorCi(txtBuscarPer.getText());

        } else if (String.valueOf(cboParametroPer.getSelectedItem()).equalsIgnoreCase("Nombre")) {
            result = BDPersonal.listarPersonalPorNombre(txtBuscarPer.getText());
        }
        recargarTable(result);
    }

    public void recargarTable(ArrayList<Personal> list) {
        Object[][] datos = new Object[list.size()][5];
        int i = 0;
        for (Personal p : list) {

            datos[i][0] = p.getiPersonal();
            datos[i][1] = p.getNomPerson();
            datos[i][2] = p.getApePerson();
            datos[i][3] = p.getPerCodigo();
            datos[i][4] = p.getTipoPerson();
            i++;
        }
        jtPersonal.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                    "ID", "Nombre", "Apellido", "NºFunc", "Especialista"
                }) {

                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMantenimientoPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMantenimientoPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMantenimientoPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMantenimientoPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrmMantenimientoPersonal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarPer;
    private javax.swing.JButton btnGuardarPer;
    private javax.swing.JButton btnModificarPer;
    private javax.swing.JButton btnMostrarPer;
    private javax.swing.JButton btnNuevoPer;
    private javax.swing.JButton btnSalirPer;
    private javax.swing.JComboBox cboParametroPer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtPersonal;
    public javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBuscarPer;
    public javax.swing.JTextField txtCedula;
    public javax.swing.JTextField txtCiPer;
    private javax.swing.JTextField txtCodigoPer;
    public javax.swing.JTextField txtEspecialista;
    private javax.swing.JTextField txtFuncionario;
    public javax.swing.JTextField txtNombrePer;
    // End of variables declaration//GEN-END:variables

}
