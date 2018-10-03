package com.hmi.sistema;

import com.hmi.conexiones.BD;
import com.hmi.conexiones.BDSMS;
import static com.hmi.conexiones.sendPostRequest.sendPostRequest;
import com.hmi.variables.SMS;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class FrmMantenimientoSMS extends javax.swing.JFrame {

    String accion = "";

    /**
     * Creates new form FrmMantenimientoUsuario
     */
    public FrmMantenimientoSMS() {
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
            ResultSet rs = stmt.executeQuery("select max(idsms) from smsdesk");
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
        txtSms.setText("");

    }

    public void activarCajaTexto(boolean b) {
        txtCodigoUsu.setEditable(!b);
        txtNomPer.setEditable(b);
        txtSms.setEditable(b);

    }

    public void activarBotones(boolean b) {

        btnGuardarUsu.setEnabled(b);

        btnCancelarUsu.setEnabled(b);

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
        jLabel3 = new javax.swing.JLabel();
        txtCodigoUsu = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtSms = new javax.swing.JTextArea();
        btnCancelarUsu = new javax.swing.JButton();
        btnSalirUsu = new javax.swing.JButton();
        btnNuevoPer1 = new javax.swing.JButton();
        btnGuardarUsu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel9.setFont(new java.awt.Font("Garamond", 1, 12)); // NOI18N
        jLabel9.setText("SMS ENVIADOS");

        txtBuscarPer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarPerKeyReleased(evt);
            }
        });

        cboParametroPer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Numero", "Fecha" }));
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
                .addContainerGap(75, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jLabel2.setText("ENVIAR SMS");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("SMS"));

        jLabel4.setText("Numero :");

        txtNomPer.setEditable(false);

        jLabel3.setText("ID Sms :");

        txtCodigoUsu.setEditable(false);
        txtCodigoUsu.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel8.setText("Texto :");

        txtSms.setColumns(20);
        txtSms.setRows(5);
        jScrollPane2.setViewportView(txtSms);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
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
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

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

        btnNuevoPer1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/New document.png"))); // NOI18N
        btnNuevoPer1.setText("NUEVO");
        btnNuevoPer1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevoPer1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevoPer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoPer1ActionPerformed(evt);
            }
        });

        btnGuardarUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/Save.png"))); // NOI18N
        btnGuardarUsu.setText("ENVIAR");
        btnGuardarUsu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardarUsu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardarUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarUsuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnNuevoPer1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnGuardarUsu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelarUsu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalirUsu))
                    .addComponent(jLabel2)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNuevoPer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelarUsu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalirUsu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardarUsu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel4.getAccessibleContext().setAccessibleName("\"SMS\"");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        activarCajaTexto(true);
        obtenerUltimoId();
        activarBotones(true);
    }//GEN-LAST:event_btnCancelarUsuActionPerformed

    private void btnGuardarUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarUsuActionPerformed
        // TODO add your handling code here:
        if (accion.equalsIgnoreCase("Guardar")) {
            if (txtNomPer.getText().compareTo("") != 0) {

                try {
                    SMS s = new SMS();
                    Connection con = BD.getConnection();
                    s.setIdsms(Integer.parseInt(txtCodigoUsu.getText()));
                    s.setNumCel(txtNomPer.getText());
                    s.setTexto(txtSms.getText());
                    if (!s.getNumCel().equals("") && s.getNumCel() != null) {

                        
                        String payload = "{\"nroTel\":\"" + s.getNumCel() + "\",\"texto\":\"" + s.getTexto() + "\"}";
                        String requestUrl = "http://10.1.100.13:8080/sms/rest/envio_sms";
                        System.out.println("Parametros de entrada   :" + payload);
                        System.out.println("uri   :" + requestUrl);
                        sendPostRequest(requestUrl, payload);
                        BDSMS.insertarSMS(s);
                        JOptionPane.showMessageDialog(null, "[ SMS Enviado ]");

                    } else {
                        JOptionPane.showMessageDialog(null, "[ Debe cargar numero y sms ]");
                    }
                    
                     

                } catch (SQLException e) {
                    System.out.println("Error BD: " + e.getMessage());
                }
            } else {

                JOptionPane.showMessageDialog(null, "[ Debe cargar numero y sms ]");

            }
        }

    }//GEN-LAST:event_btnGuardarUsuActionPerformed

    private void jtPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtPersonalMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jtPersonalMouseClicked

    private void cboParametroPerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboParametroPerActionPerformed
        // TODO add your handling code here:
        actualizarBusqueda();
    }//GEN-LAST:event_cboParametroPerActionPerformed

    private void txtBuscarPerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarPerKeyReleased
        // TODO add your handling code here:
        actualizarBusqueda();
    }//GEN-LAST:event_txtBuscarPerKeyReleased

    private void btnNuevoPer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoPer1ActionPerformed
        // TODO add your handling code here:

        limpiarCajaTexto();
        activarCajaTexto(true);
        obtenerUltimoId();
        accion = "Guardar";
        activarBotones(true);

    }//GEN-LAST:event_btnNuevoPer1ActionPerformed

    private void actualizarBusqueda() {
        ArrayList<SMS> result = null;
        if (String.valueOf(cboParametroPer.getSelectedItem()).equalsIgnoreCase("Numero")) {
            result = BDSMS.listarSMSporNumero(txtBuscarPer.getText());

        } else if (String.valueOf(cboParametroPer.getSelectedItem()).equalsIgnoreCase("Fecha")) {
            result = BDSMS.listarSMSPorFecha(txtBuscarPer.getText());
        }
        recargarTable(result);
    }

    public void recargarTable(ArrayList<SMS> list) {
        Object[][] datos = new Object[list.size()][4];
        int i = 0;
        for (SMS p : list) {

            datos[i][0] = p.getIdsms();
            datos[i][1] = p.getNumCel();
            datos[i][2] = p.getFecha_int();
            datos[i][3] = p.getTexto();

            i++;
        }
        jtPersonal.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                    "ID", "Numero", "Fecha", "Texto"
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
                FrmMantenimientoSMS dialog = new FrmMantenimientoSMS();
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarUsu;
    private javax.swing.JButton btnGuardarUsu;
    private javax.swing.JButton btnNuevoPer1;
    private javax.swing.JButton btnSalirUsu;
    private javax.swing.JComboBox cboParametroPer;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtPersonal;
    private javax.swing.JTextField txtBuscarPer;
    public javax.swing.JTextField txtCodigoUsu;
    public javax.swing.JTextField txtNomPer;
    private javax.swing.JTextArea txtSms;
    // End of variables declaration//GEN-END:variables
}
