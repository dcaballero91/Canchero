package com.hmi.sistema;

import com.hmi.conexiones.BDUsuario;
import com.hmi.variables.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.UIManager;

public class JDBuscarUsuario extends javax.swing.JDialog {

    private final FrmMantenimientoUsuario JDBListaP;

    /**
     * Creates new form JDBuscarProductoListaR
     *
     * @param parent
     * @param modal
     * @param FrmMP
     */
    public JDBuscarUsuario(java.awt.Frame parent, boolean modal, final FrmMantenimientoUsuario JDBListaP) {
        super(parent, modal);
        initComponents();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        actualizarBusqueda();
        this.JDBListaP = JDBListaP;
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscarPro = new javax.swing.JTextField();
        cboParametroPro = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProducto = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Garamond", 1, 20)); // NOI18N
        jLabel1.setText("USUARIO ESCRITORIO");

        jLabel2.setText("BUSCAR :");

        txtBuscarPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProKeyReleased(evt);
            }
        });

        cboParametroPro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre", "CI", " " }));
        cboParametroPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboParametroProActionPerformed(evt);
            }
        });

        jtProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "NOMBRE", "CATEGORIA", "DESCRIPCION", "ESTADO"
            }
        ));
        jtProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProductoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtProducto);
        if (jtProducto.getColumnModel().getColumnCount() > 0) {
            jtProducto.getColumnModel().getColumn(0).setPreferredWidth(10);
            jtProducto.getColumnModel().getColumn(1).setPreferredWidth(150);
            jtProducto.getColumnModel().getColumn(2).setPreferredWidth(10);
            jtProducto.getColumnModel().getColumn(3).setPreferredWidth(10);
        }

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/Exit.png"))); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarPro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboParametroPro, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(132, 132, 132))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboParametroPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProductoMouseClicked
        // TODO add your handling code here
        try {

            Usuario u = BDUsuario.buscarUsuario(Integer.parseInt(String.valueOf(jtProducto.getModel().getValueAt(jtProducto.getSelectedRow(), 0))));

            JDBListaP.txtCodigoUsu.setText(String.valueOf(u.getIdUserDesk()));
            JDBListaP.txtNomPer.setText(u.getNomPerson());
            JDBListaP.txtApePer.setText(u.getApePerson());
            JDBListaP.txtUsuario.setText(u.getcUsuId());
            JDBListaP.txtClaveUsu.setText(u.getcUsuClave());
            //u.setPersonal(BDPersonal.buscarPersonalNombre((String) cboPersonalUsu.getSelectedItem()));
            if (u.getUseRol() == 1) {

                JDBListaP.cboPersonalUsu.setSelectedItem("Administrador");
            } else if (u.getUseRol() == 2) {
                JDBListaP.cboPersonalUsu.setSelectedItem("Operador");
            } else if (u.getUseRol() == 3) {
                JDBListaP.cboPersonalUsu.setSelectedItem("Farmacia");
            } else if (u.getUseRol() == 4) {
                JDBListaP.cboPersonalUsu.setSelectedItem("Doctor");
            } else if (u.getUseRol() == 3) {
                JDBListaP.cboPersonalUsu.setSelectedItem("Enfermeria");
            } 
            JDBListaP.cboEstadoUsu.setSelectedItem(u.getcUsuEstado());

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jtProductoMouseClicked

    private void cboParametroProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboParametroProActionPerformed
        // TODO add your handling code here:
        actualizarBusqueda();
    }//GEN-LAST:event_cboParametroProActionPerformed

    private void txtBuscarProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProKeyReleased
        // TODO add your handling code here:
        actualizarBusqueda();
    }//GEN-LAST:event_txtBuscarProKeyReleased

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void actualizarBusqueda() {
        ArrayList<Usuario> result = null;
        if (String.valueOf(cboParametroPro.getSelectedItem()).equalsIgnoreCase("Ci")) {
            result = BDUsuario.listarUsuarioPorCi(txtBuscarPro.getText());

        } else if (String.valueOf(cboParametroPro.getSelectedItem()).equalsIgnoreCase("Nombre")) {
            result = BDUsuario.listarUsuarioPorNombre(txtBuscarPro.getText());
        }
        recargarTable(result);
    }

    public void recargarTable(ArrayList<Usuario> list) {
        Object[][] datos = new Object[list.size()][6];
        int i = 0;
        for (Usuario p : list) {
            datos[i][0] = p.getIdUserDesk();
            datos[i][1] = p.getNomPerson();
            datos[i][2] = p.getApePerson();
            datos[i][3] = p.getcUsuId();
            datos[i][4] = p.getcUsuEstado();
            datos[i][5] = p.getUseRol();
            i++;
        }
        jtProducto.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                    "ID", "NOMBRE", "APELIDO", "USUARIO", "ESTADO", "ROL"
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
            java.util.logging.Logger.getLogger(JDBuscarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDBuscarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDBuscarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDBuscarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                JDBuscarUsuario dialog = new JDBuscarUsuario(new javax.swing.JFrame(), true, null);
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
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cboParametroPro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtProducto;
    private javax.swing.JTextField txtBuscarPro;
    // End of variables declaration//GEN-END:variables

}
