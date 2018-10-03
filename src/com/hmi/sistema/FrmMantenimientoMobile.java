package com.hmi.sistema;

import com.hmi.conexiones.BD;
import com.hmi.conexiones.BDMobile;
import static com.hmi.conexiones.sendPostRequest.sendPostRequest;
import com.hmi.variables.Mobile;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class FrmMantenimientoMobile extends javax.swing.JFrame {

    String accion = "";

    /**
     * Creates new form FrmMantenimientoUsuario
     */
    public FrmMantenimientoMobile() {
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
            ResultSet rs = stmt.executeQuery("select max(idmobile) from usermobile");
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

        cboPersonalUsu.setSelectedItem("Seleccionar...");

    }

    public void activarCajaTexto(boolean b) {
        txtCodigoUsu.setEditable(!b);
        txtNomPer.setEditable(!b);
        txtApePer.setEditable(!b);
        txtUsuario.setEditable(b);
        txtClaveUsu.setEditable(!b);
        cboPersonalUsu.setEditable(b);

    }

    public void activarBotones(boolean b) {

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
        txtNomPer = new javax.swing.JTextField();
        cboPersonalUsu = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txtCodigoUsu = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtApePer = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtClaveUsu = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        btnGuardarUsu = new javax.swing.JButton();
        btnModificarUsu = new javax.swing.JButton();
        btnCancelarUsu = new javax.swing.JButton();
        btnSalirUsu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel9.setFont(new java.awt.Font("Garamond", 1, 12)); // NOI18N
        jLabel9.setText("ALTA MOBILE");

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
        jLabel2.setText("ACTIVAR USRUARIO ");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Dato de Usuarios"));

        jLabel4.setText("Nombre :");

        txtNomPer.setEditable(false);

        cboPersonalUsu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar...", "Activo", "Inactivo", " ", " ", " " }));
        cboPersonalUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPersonalUsuActionPerformed(evt);
            }
        });

        jLabel3.setText("Codigo :");

        txtCodigoUsu.setEditable(false);
        txtCodigoUsu.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel7.setText("Estado :");

        txtApePer.setEditable(false);

        jLabel8.setText("Apellido :");

        jLabel10.setText("Usuario :");

        txtUsuario.setEditable(false);

        txtClaveUsu.setEditable(false);
        txtClaveUsu.setText("jPasswordField1");
        txtClaveUsu.setSelectionEnd(6);
        txtClaveUsu.setSelectionStart(18);

        jLabel11.setText("Pass :");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                            .addComponent(jLabel7)
                            .addComponent(jLabel11))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtClaveUsu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(cboPersonalUsu, 0, 98, Short.MAX_VALUE))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboPersonalUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtClaveUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(42, 42, 42))
        );

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
                            .addComponent(btnCancelarUsu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnModificarUsu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnGuardarUsu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
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
                        .addComponent(btnGuardarUsu)
                        .addGap(39, 39, 39)
                        .addComponent(btnModificarUsu)
                        .addGap(33, 33, 33)
                        .addComponent(btnCancelarUsu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalirUsu))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        btnGuardarUsu.setEnabled(true);
        btnModificarUsu.setEnabled(false);
        btnCancelarUsu.setEnabled(true);

    }//GEN-LAST:event_btnModificarUsuActionPerformed

    private void btnGuardarUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarUsuActionPerformed
        // TODO add your handling code here:
        if (accion.equalsIgnoreCase("Guardar")) {
            if (txtNomPer.getText().compareTo("") != 0) {

                try {
                    Mobile u = new Mobile();
                    Connection con = BD.getConnection();
                    Statement stmt = con.createStatement();

                    u.setCi(txtUsuario.getText());
                    ResultSet rs = stmt.executeQuery("select ci from usermobile where ci='" + u.getCi() + "'");
                    System.out.println("CI persona recuperado     " + u.getCi());
                    if (rs.next()) {
                        if (u == null) {
                            u = new Mobile();
                        }
                        
                    }
                    u.setCiAux(rs.getString("ci"));
                    System.out.println("Copia de varialbe a idPaux     " + u.getCiAux());
                    if (!u.getCi().equals(u.getCiAux())) {
                        u.setCi(txtUsuario.getText());
                        u.setIdPerson(Integer.parseInt(txtCodigoUsu.getText()));
                        String pass = new String(txtClaveUsu.getPassword());
                        u.setPass(pass);
                        u.setEstado((String) cboPersonalUsu.getSelectedItem());

                        BDMobile.insertarUsuario(u);
                        JOptionPane.showMessageDialog(null, "[ Datos Agregados ]");

                    } else {
                        JOptionPane.showMessageDialog(null, "[ El usuario ya existe ]");
                    }
                    
                } catch (SQLException e) {
                    System.out.println("Error BD: " + e.getMessage());
                }
            }
        }
        if (accion.equalsIgnoreCase("Actualizar")) {
            Mobile u;
            try {
                u = BDMobile.buscarUsuario(Integer.parseInt(txtCodigoUsu.getText()));
                u.setIdPerson(Integer.parseInt(txtCodigoUsu.getText()));
                u.setCi(txtUsuario.getText());
                String pass = new String(txtClaveUsu.getPassword());
                u.setPass(pass);
                System.out.println("Pass" + pass);
                u.setEstado((String) cboPersonalUsu.getSelectedItem());

                System.out.println("ci a enviar" + u.getCi());
                System.out.println("pass" + u.getPass());

                String payload = "{\"tipoDoc\":\"CI\",\"nroDoc\":" + u.getCi() + ",\"texto\":\"Su cuenta esta " + u.getEstado() + ", Usuario: " + u.getCi() + " Contraseña: " + u.getPass() + "\"}";
                String requestUrl = "http://10.1.100.13:8080/sms/rest/envio_sms";
                System.out.println("Parametros de entrada   :" + payload);
                System.out.println("uri   :" + requestUrl);
                sendPostRequest(requestUrl, payload);
                BDMobile.actualizarUsuario(u);

                JOptionPane.showMessageDialog(null, " [ Datos Actualizados ]");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error BD: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnGuardarUsuActionPerformed

    private void jtPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtPersonalMouseClicked
        // TODO add your handling code here:
        try {

            Mobile p = BDMobile.buscarUsuario(Integer.parseInt(String.valueOf(jtPersonal.getModel().getValueAt(jtPersonal.getSelectedRow(), 0))));
            txtCodigoUsu.setText(String.valueOf(p.getIdPerson()));
            txtNomPer.setText(p.getNomPerson());
            txtApePer.setText(p.getApePerson());
            txtUsuario.setText(p.getCi());
            txtClaveUsu.setText(p.getPass());
            cboPersonalUsu.setSelectedItem(p.getEstado());

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
        ArrayList<Mobile> result = null;
        if (String.valueOf(cboParametroPer.getSelectedItem()).equalsIgnoreCase("Ci")) {
            result = BDMobile.listarMobilePorCi(txtBuscarPer.getText());

        } else if (String.valueOf(cboParametroPer.getSelectedItem()).equalsIgnoreCase("Nombre")) {
            result = BDMobile.listarMobilePorNombre(txtBuscarPer.getText());
        }
        recargarTable(result);
    }

    public void recargarTable(ArrayList<Mobile> list) {
        Object[][] datos = new Object[list.size()][6];
        int i = 0;
        for (Mobile p : list) {

            datos[i][0] = p.getIdPerson();
            datos[i][1] = p.getNomPerson();
            datos[i][2] = p.getApePerson();
            datos[i][3] = p.getCi();
            datos[i][4] = p.getEstado();

            i++;
        }
        jtPersonal.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                    "ID", "Nombre", "Apellido", "CI", "ESTADO"
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
                new FrmMantenimientoMobile().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarUsu;
    private javax.swing.JButton btnGuardarUsu;
    private javax.swing.JButton btnModificarUsu;
    private javax.swing.JButton btnSalirUsu;
    private javax.swing.JComboBox cboParametroPer;
    public javax.swing.JComboBox cboPersonalUsu;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
