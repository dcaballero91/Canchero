package com.hmi.sistema;

import com.hmi.conexiones.BD;
import com.hmi.conexiones.BDPersona;
import com.hmi.conexiones.BDUsuario;
import com.hmi.variables.Persona;
import com.hmi.variables.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import org.apache.commons.codec.digest.DigestUtils;


public class FrmMantenimientoUsuario extends javax.swing.JFrame {

    String accion = "";

    /**
     * Creates new form FrmMantenimientoUsuario
     */
    public FrmMantenimientoUsuario() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
        obtenerUltimoId();
        actualizarBusqueda();
        activarBotones(true);
        this.setLocationRelativeTo(null);
        /*
         * Para carbar la lista de Personal al combobox
         */

    }

    public void obtenerUltimoId() {
        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select max(idUserDesk) from usuarioDesk");
            while (rs.next()) {
                int lastID = rs.getInt(1);
                txtCodigoUsu.setText(String.valueOf(lastID + 1));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException error) {
            System.out.print(error);
        }
    }

    public void limpiarCajaTexto() {
        txtCodigoUsu.setText("");
        txtNomPer.setText("");
        txtApePer.setText("");
        txtUsuario.setText("");
        txtClaveUsu.setText("");
        cboPersonalUsu.setSelectedItem("Seleccionar...");
        cboEstadoUsu.setSelectedItem("Seleccionar...");
    }

    public void activarCajaTexto(boolean b) {
        txtCodigoUsu.setEditable(!b);
        txtNomPer.setEditable(!b);
        txtApePer.setEditable(!b);
        txtUsuario.setEditable(b);
        txtClaveUsu.setEditable(b);
        cboPersonalUsu.setEditable(b);
        cboEstadoUsu.setEditable(b);
    }

    public void activarBotones(boolean b) {
        btnNuevoUsu.setEnabled(b);
        btnGuardarUsu.setEnabled(!b);
        btnModificarUsu.setEnabled(b);
        btnCancelarUsu.setEnabled(!b);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtBuscarPer = new javax.swing.JTextField();
        cboParametroPer = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPersonal = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNomPer = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cboPersonalUsu = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txtCodigoUsu = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cboEstadoUsu = new javax.swing.JComboBox();
        txtClaveUsu = new javax.swing.JPasswordField();
        txtApePer = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        btnNuevoUsu = new javax.swing.JButton();
        btnGuardarUsu = new javax.swing.JButton();
        btnModificarUsu = new javax.swing.JButton();
        btnCancelarUsu = new javax.swing.JButton();
        btnMostrarUsu = new javax.swing.JButton();
        btnSalirUsu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel9.setFont(new java.awt.Font("Garamond", 1, 12)); // NOI18N
        jLabel9.setText("BUSCAR PERSONA");

        txtBuscarPer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarPerKeyReleased(evt);
            }
        });

        cboParametroPer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CI", "Nombre" }));
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
                {null, null}
            },
            new String [] {
                "Codigo", "IdUsuario"
            }
        ));
        jtPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtPersonalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtPersonal);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, 0, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(txtBuscarPer, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboParametroPer, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(11, 11, 11)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarPer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboParametroPer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jLabel2.setText("REGISTRAR USUARIO");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Dato de Usuarios"));

        jLabel4.setText("Nombre :");

        jLabel6.setText("Rol :");

        txtNomPer.setEditable(false);

        jLabel5.setText("Clave :");

        cboPersonalUsu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar...", "Administrador", "Operador", "Farmacia", "Doctor", "Enfermeria", " ", " ", " " }));
        cboPersonalUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPersonalUsuActionPerformed(evt);
            }
        });

        jLabel3.setText("Codigo :");

        txtCodigoUsu.setEditable(false);
        txtCodigoUsu.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel7.setText("Estado :");

        cboEstadoUsu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar...", "Activo", "Inactivo" }));

        txtClaveUsu.setEditable(false);
        txtClaveUsu.setText("jPasswordField1");
        txtClaveUsu.setSelectionEnd(6);
        txtClaveUsu.setSelectionStart(18);

        txtApePer.setEditable(false);

        jLabel8.setText("Apellido :");

        jLabel10.setText("Usuario :");

        txtUsuario.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboEstadoUsu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCodigoUsu, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                            .addComponent(txtNomPer)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtApePer))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtUsuario))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboPersonalUsu, 0, 98, Short.MAX_VALUE)
                            .addComponent(txtClaveUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCodigoUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNomPer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtApePer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtClaveUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cboPersonalUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cboEstadoUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        btnNuevoUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/New document.png"))); // NOI18N
        btnNuevoUsu.setText("NUEVO");
        btnNuevoUsu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevoUsu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevoUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoUsuActionPerformed(evt);
            }
        });

        btnGuardarUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/Save.png"))); // NOI18N
        btnGuardarUsu.setText("GUARDAR");
        btnGuardarUsu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardarUsu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardarUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarUsuActionPerformed(evt);
            }
        });

        btnModificarUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/Modify.png"))); // NOI18N
        btnModificarUsu.setText("MODIFICAR");
        btnModificarUsu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificarUsu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificarUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarUsuActionPerformed(evt);
            }
        });

        btnCancelarUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/Erase.png"))); // NOI18N
        btnCancelarUsu.setText("CANCELAR");
        btnCancelarUsu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelarUsu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelarUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarUsuActionPerformed(evt);
            }
        });

        btnMostrarUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/List.png"))); // NOI18N
        btnMostrarUsu.setText("MOSTRAR");
        btnMostrarUsu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMostrarUsu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMostrarUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarUsuActionPerformed(evt);
            }
        });

        btnSalirUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/Exit.png"))); // NOI18N
        btnSalirUsu.setText("SALIR");
        btnSalirUsu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalirUsu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalirUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirUsuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSalirUsu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMostrarUsu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancelarUsu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnModificarUsu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnGuardarUsu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnNuevoUsu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnNuevoUsu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardarUsu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificarUsu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelarUsu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMostrarUsu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalirUsu))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirUsuActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSalirUsuActionPerformed

    private void btnMostrarUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarUsuActionPerformed
        // TODO add your handling code here:
        JDBuscarUsuario JDBListaP = new JDBuscarUsuario(this, true, this);
        JDBListaP.setVisible(true);
    }//GEN-LAST:event_btnMostrarUsuActionPerformed

    private void btnCancelarUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarUsuActionPerformed
        // TODO add your handling code here:
        limpiarCajaTexto();
        activarCajaTexto(false);
        obtenerUltimoId();
        activarBotones(true);
    }//GEN-LAST:event_btnCancelarUsuActionPerformed

    private void btnModificarUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarUsuActionPerformed
        // TODO add your handling code here:
        accion = "Actualizar";
        activarCajaTexto(true);
        btnNuevoUsu.setEnabled(false);
        btnGuardarUsu.setEnabled(true);
        btnModificarUsu.setEnabled(false);
        btnCancelarUsu.setEnabled(true);
        btnMostrarUsu.setEnabled(true);
    }//GEN-LAST:event_btnModificarUsuActionPerformed

    private void btnGuardarUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarUsuActionPerformed
        // TODO add your handling code here:
        if (accion.equalsIgnoreCase("Guardar")) {
            if (txtNomPer.getText().compareTo("") != 0) {
                Integer idpersona = null;
                try {
                    Usuario u = new Usuario();
                    try {
                    Connection con = BD.getConnection();
                    Statement stmt = con.createStatement();

                    idpersona = (Integer.parseInt(txtCodigoUsu.getText()));
                    System.out.println("id persona a buscar  :" + idpersona);
                    ResultSet rs = stmt.executeQuery("select idPerson from usuarioDesk where idUserDesk='" + idpersona + "'");
                    System.out.println("despues del select..." + rs.next());
                    System.out.println("Id persona recuperado     " + u.getIdPaux());
                    u.setIdPaux(rs.getInt("idPerson"));
                    
                    if (rs.next()) {
                        if (u == null) {
                            u = new Usuario();
                        }
                    }
                    
                     } catch (SQLException e) {
                        System.out.println("Error BD recuperar id: " + e.getMessage());
                    }
                    Integer id = null;
                    id = u.getIdPaux();
                    if (id == 0) {
                        u.setIdPaux(idpersona);
                        System.out.println("vino null se le carga idpersona:" + u.getIdPaux());
                        u.setIdPerson(Integer.parseInt(txtCodigoUsu.getText()));
                        u.setNomPerson(txtNomPer.getText());
                        u.setApePerson(txtApePer.getText());
                        u.setcUsuId(txtUsuario.getText());
                        String pass = new String(txtClaveUsu.getPassword());
                        System.out.println("antes de encriptar");
                        String encriptMD5=DigestUtils.md5Hex(pass);
                        System.out.println("md5:"+encriptMD5);
                        u.setcUsuClave(pass);
                        
                        
                        
                        u.setAdmAux((String) cboPersonalUsu.getSelectedItem());
                        System.out.println("rol" + u.getAdmAux());
                        if (u.getAdmAux().equals("Administrador")) {
                            
                            u.setUseRol(1);
                        } else if (u.getAdmAux().equals("Operador")) {
                            u.setUseRol(2);
                        } else if (u.getAdmAux().equals("Farmacia")){
                            u.setUseRol(3);
                        } else if(u.getAdmAux().equals("Doctor")){
                            u.setUseRol(4);
                        } else if (u.getAdmAux().equals("Enfermeria")){
                            u.setUseRol(5);
                        }
                        

                        u.setcUsuEstado((String) cboEstadoUsu.getSelectedItem());
                        System.out.println("rol set numero   :" + u.getcUsuEstado() );
                        BDUsuario.insertarUsuario(u);
                        JOptionPane.showMessageDialog(null, "[ Datos Agregados ]");

                    } else {

                        JOptionPane.showMessageDialog(null, "Persona ya Registrado..!");
                    }

                } catch (SQLException e) {
                    System.out.println("Error BD: " + e.getMessage());
                }
            }
        }
        if (accion.equalsIgnoreCase("Actualizar")) {
            Usuario u;
            try {
                u = BDUsuario.buscarUsuario(Integer.parseInt(txtCodigoUsu.getText()));
                u.setcUsuId(txtUsuario.getText());
                String pass = new String(txtClaveUsu.getPassword());
                u.setcUsuClave(pass);
                u.setAdmAux((String) cboPersonalUsu.getSelectedItem());
                 u.setcUsuId(txtUsuario.getText());
                        String pass2 = new String(txtClaveUsu.getPassword());
                        System.out.println("antes de encriptar");
                        String encriptMD5=DigestUtils.md5Hex(pass2);
                        System.out.println("md5:"+encriptMD5);
                        u.setcUsuClave(encriptMD5);
                        System.out.println("para insertar  " +u.getcUsuClave());
                        System.out.println("rol" + u.getAdmAux());
                        if (u.getAdmAux().equals("Administrador")) {
                            
                            u.setUseRol(1);
                        } else if (u.getAdmAux().equals("Operador")) {
                            u.setUseRol(2);
                        }else if (u.getAdmAux().equals("Farmacia")){
                            u.setUseRol(3);
                        } else if(u.getAdmAux().equals("Doctor")){
                            u.setUseRol(4);
                        }else if (u.getAdmAux().equals("Enfermeria")){
                            u.setUseRol(5);
                        }
                        u.setcUsuEstado((String) cboEstadoUsu.getSelectedItem());
                
                BDUsuario.actualizarUsuario(u);
                
                JOptionPane.showMessageDialog(null, " [ Datos Actualizados ]");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error BD: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnGuardarUsuActionPerformed

    private void btnNuevoUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoUsuActionPerformed
        // TODO add your handling code here:

        limpiarCajaTexto();
        activarCajaTexto(true);
        activarBotones(false);
        btnMostrarUsu.setEnabled(true);
        accion = "Guardar";
        obtenerUltimoId();
    }//GEN-LAST:event_btnNuevoUsuActionPerformed

    private void jtPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtPersonalMouseClicked
        // TODO add your handling code here:
        try {

            Persona p = BDPersona.buscarPersonaCodigo(Integer.parseInt(String.valueOf(jtPersonal.getModel().getValueAt(jtPersonal.getSelectedRow(), 0))));
            txtCodigoUsu.setText(String.valueOf(p.getIdPerson()));
            txtNomPer.setText(p.getNomPerson());
            txtApePer.setText(p.getApePerson());

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jtPersonalMouseClicked

    private void cboParametroPerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboParametroPerActionPerformed
        // TODO add your handling code here:
        actualizarBusqueda();
    }//GEN-LAST:event_cboParametroPerActionPerformed

    private void txtBuscarPerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarPerKeyReleased
        // TODO add your handling code here:
        actualizarBusqueda();
    }//GEN-LAST:event_txtBuscarPerKeyReleased

    private void cboPersonalUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPersonalUsuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboPersonalUsuActionPerformed

    private void actualizarBusqueda() {
        ArrayList<Persona> result = null;
        if (String.valueOf(cboParametroPer.getSelectedItem()).equalsIgnoreCase("Ci")) {
            result = BDPersona.listarPersonaPorCi(txtBuscarPer.getText());

        } else if (String.valueOf(cboParametroPer.getSelectedItem()).equalsIgnoreCase("Nombre")) {
            result = BDPersona.listarPersonaPorNombre(txtBuscarPer.getText());
        }
        recargarTable(result);
    }

    public void recargarTable(ArrayList<Persona> list) {
        Object[][] datos = new Object[list.size()][6];
        int i = 0;
        for (Persona p : list) {

            datos[i][0] = p.getIdPerson();
            datos[i][1] = p.getNomPerson();
            datos[i][2] = p.getApePerson();
            datos[i][3] = p.getCiPersona();
            datos[i][4] = p.getNumPerson();
            datos[i][5] = p.getPersexo();

            i++;
        }
        jtPersonal.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                    "ID", "Nombre", "Apellido", "CI", "Telefono", "Sexo"
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
            java.util.logging.Logger.getLogger(FrmMantenimientoPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMantenimientoPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMantenimientoPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMantenimientoPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrmMantenimientoUsuario().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarUsu;
    private javax.swing.JButton btnGuardarUsu;
    private javax.swing.JButton btnModificarUsu;
    private javax.swing.JButton btnMostrarUsu;
    private javax.swing.JButton btnNuevoUsu;
    private javax.swing.JButton btnSalirUsu;
    public javax.swing.JComboBox cboEstadoUsu;
    private javax.swing.JComboBox cboParametroPer;
    public javax.swing.JComboBox cboPersonalUsu;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtPersonal;
    public javax.swing.JTextField txtApePer;
    private javax.swing.JTextField txtBuscarPer;
    public javax.swing.JPasswordField txtClaveUsu;
    public javax.swing.JTextField txtCodigoUsu;
    public javax.swing.JTextField txtNomPer;
    public javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
