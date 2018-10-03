package com.hmi.sistema;

import com.hmi.conexiones.BD;
import com.hmi.conexiones.BDAgenda;
import com.hmi.conexiones.BDFichas;
import com.hmi.variables.Agenda;
import com.hmi.variables.Fichas;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class FrmMantenimientoAgenda extends javax.swing.JFrame {

    String accion = "";

    public FrmMantenimientoAgenda() {
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
            ResultSet rs = stmt.executeQuery("select max(nroAgenda) from Agenda where fechAgenda=CURDATE()");
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
        cboEstado.setSelectedItem("Seleccionar...");
        txtIDDoc.setText("");
        txtTipo.setText("");

    }

    public void activarCajaTexto(boolean b) {
        txtCodigoPer.setEditable(!b);
        txtCiPer.setEditable(b);
        txtNombrePer.setEditable(!b);
        txtApellido.setEditable(!b);
        txtEspecialista.setEditable(b);
        txtCedula.setEditable(!b);
        txtIDDoc.setEditable(b);
        txtTipo.setEditable(!b);

    }

    public void activarBotones(boolean b) {
        btnNuevoPer.setEnabled(b);
        btnGuardarPer.setEnabled(!b);
        btnModificarPer.setEnabled(b);
        btnCancelarPer.setEnabled(!b);

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
        btnBuscarPro = new javax.swing.JButton();
        cboEstado = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtIDDoc = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        btnBuscarPro1 = new javax.swing.JButton();
        txtDoc = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtFicha = new javax.swing.JTextField();
        btnBuscarPro2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnNuevoPer = new javax.swing.JButton();
        btnGuardarPer = new javax.swing.JButton();
        btnModificarPer = new javax.swing.JButton();
        btnCancelarPer = new javax.swing.JButton();
        btnSalirPer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("BUSCAR AGENDADOS :");

        txtBuscarPer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarPerKeyReleased(evt);
            }
        });

        cboParametroPer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ficha", "CI", "Estado" }));
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

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingrese Datos"));

        jLabel3.setText("Nro Agenda :");

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

        jLabel7.setText("Fecha :");

        txtEspecialista.setEditable(false);
        txtEspecialista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEspecialistaActionPerformed(evt);
            }
        });

        jLabel8.setText("Estado :");

        btnBuscarPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/View.png"))); // NOI18N
        btnBuscarPro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscarPro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProActionPerformed(evt);
            }
        });

        cboEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar...", "A", "P" }));

        jLabel10.setText("ID Doc :");

        txtCedula.setEditable(false);

        jLabel9.setText("CIº :");

        txtIDDoc.setEditable(false);

        jLabel11.setText("Tipo :");

        txtTipo.setEditable(false);

        btnBuscarPro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/View.png"))); // NOI18N
        btnBuscarPro1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscarPro1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscarPro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPro1ActionPerformed(evt);
            }
        });

        txtDoc.setEditable(false);

        jLabel12.setText("Nombre :");

        jLabel13.setText("Ficha :");

        txtFicha.setEditable(false);

        btnBuscarPro2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/View.png"))); // NOI18N
        btnBuscarPro2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscarPro2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscarPro2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPro2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(txtCodigoPer, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(68, 68, 68)
                                    .addComponent(jLabel9))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtApellido)
                                        .addComponent(txtNombrePer, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtCiPer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(btnBuscarPro, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                            .addComponent(jLabel13))))))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(13, 13, 13)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(txtEspecialista, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnBuscarPro2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtIDDoc, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addComponent(txtCedula)
                    .addComponent(txtTipo)
                    .addComponent(txtDoc)
                    .addComponent(txtFicha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarPro1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCodigoPer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtCiPer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscarPro)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFicha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarPro1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtIDDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10)))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtEspecialista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNombrePer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addComponent(btnBuscarPro2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(42, 42, 42))))
        );

        jLabel2.setFont(new java.awt.Font("Garamond", 1, 20)); // NOI18N
        jLabel2.setText("REGISTRAR AGENDA");

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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                            .addGap(18, 18, 18)
                            .addComponent(btnSalirPer, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(btnCancelarPer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 788, Short.MAX_VALUE)
                .addContainerGap())
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
        btnModificarPer.setEnabled(false);
        btnCancelarPer.setEnabled(true);

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
            if (txtCiPer.getText().compareTo("") != 0 && txtNombrePer.getText().compareTo("") != 0 && txtApellido.getText().compareTo("") != 0) {
                try {
                    Agenda a = new Agenda();
                    Fichas f;
                    Integer idpersona = null;
                    f = new Fichas();
                    try {
                        Connection con = BD.getConnection();
                        Statement stmt = con.createStatement();
                        idpersona = Integer.parseInt(txtCiPer.getText());
                        System.out.println("id person a buscar   :" + idpersona);
                        ResultSet rs = stmt.executeQuery("select nficha from Fichas where idPerson='" + idpersona + "'");
                        System.out.println("rs select" + rs.next());
                        f.setNficha(rs.getInt("nficha"));
                        System.out.println("Numero Ficha Recuperado   :" + f.getNficha());
                        
                        idpersona = f.getIdficha();
                        if (rs.next()) {
                            if (f == null) {
                                f = new Fichas();
                            }
                        }
                        
                    } catch (SQLException e) {
                        
                        System.out.println("Error DB" + e);
                        
                    }
                    
                    if (!idpersona.equals(null)) {
                        a.setIdperson(Integer.parseInt(txtCiPer.getText()));
                        System.out.println("id person   :" + a.getIdperson());
                        a.setFechAgenda(txtEspecialista.getText());
                        cboEstado.setSelectedItem("P");
                        a.setEstado((String) cboEstado.getSelectedItem());
                        System.out.println("Estado a guardar   :" + a.getEstado());
                        a.setTipoCons(txtTipo.getText());
                        a.setDoc(Integer.parseInt(txtIDDoc.getText()));
                        a.setNficha(Integer.parseInt(txtFicha.getText()));                        
                        a.setIdagenda(Integer.parseInt(txtCodigoPer.getText()));
                        System.out.println("id agenda para insertart:  " + a.getIdagenda());
                        if (a.getIdagenda() <= 10) {
                            
                            BDAgenda.insertarAgenda(a);
                            JOptionPane.showMessageDialog(null, "[ Datos Agregados ]");
                            
                        } else {
                            
                            JOptionPane.showMessageDialog(null, "[ Solo Se Permite hasta 10 ]");
                            
                        }
                        
                    } else {
                        
                        JOptionPane.showMessageDialog(null, "[ No tiene ficha ]");
                    }
                } catch (SQLException e) {
                    System.out.println("Error BD: " + e.getMessage());
                    
                    JOptionPane.showMessageDialog(null, "[ No tiene ficha ]");
                }
                
                limpiarCajaTexto();
                obtenerUltimoId();
            } else {
                JOptionPane.showMessageDialog(null, "Llene Todos Los Campos..!!");
            }
        }
        if (accion.equalsIgnoreCase("Actualizar")) {
            
            try {
                Fichas f;
                Integer idpersona = null;
                f = new Fichas();
                Connection con = BD.getConnection();
                Statement stmt = con.createStatement();
                idpersona = Integer.parseInt(txtCiPer.getText());
                System.out.println("id person a buscar   :" + idpersona);
                ResultSet rs = stmt.executeQuery("select nficha from Fichas where idPerson='" + idpersona + "'");
                
                if (rs.next()) {
                    if (f == null) {
                        f = new Fichas();
                    }
                }
                
                f.setNficha(rs.getInt("nficha"));
                System.out.println("Numero Ficha Recuperado Actualizar   :" + f.getNficha());
                idpersona = f.getIdficha();
                Agenda a;
                a = new Agenda();
                if (!idpersona.equals(null)) {
                    
                    System.out.println("id agenda   " + a.getIdagenda());
                    a.setIdagenda(Integer.parseInt(txtCodigoPer.getText()));
                    a.setIdperson(Integer.parseInt(txtCiPer.getText()));
                    System.out.println("id person   :" + a.getIdperson());
                    a.setFechAgenda(txtEspecialista.getText());
                    cboEstado.setSelectedItem("P");
                    a.setEstado((String) cboEstado.getSelectedItem());
                    System.out.println("Estado a guardar   :" + a.getEstado());
                    a.setTipoCons(txtTipo.getText());
                    a.setDoc(Integer.parseInt(txtIDDoc.getText()));
                    a.setNficha(Integer.parseInt(txtFicha.getText()));
                    BDAgenda.actualizarAgenda(a);
                    JOptionPane.showMessageDialog(null, " [ Datos Actualizados ]");
                } else {
                    JOptionPane.showMessageDialog(null, " [ No registrado ]");
                }
                
            } catch (SQLException e) {
                System.out.println("Error BD: " + e.getMessage());
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

            Agenda a = BDAgenda.buscarAgenda(Integer.parseInt(String.valueOf(jtPersonal.getModel().getValueAt(jtPersonal.getSelectedRow(), 0))));
            System.out.println("idagenda   :" + a.getIdagenda());
            txtCodigoPer.setText(String.valueOf(a.getIdagenda()));
            System.out.println("id person  :" + a.getIdperson());
            txtCiPer.setText(String.valueOf(a.getIdperson()));
            Fichas f;
            Integer idpersona = null;
            f = new Fichas();

            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            idpersona = Integer.parseInt(txtCiPer.getText());
            System.out.println("id person a buscar   :" + idpersona);
            ResultSet rs = stmt.executeQuery("select nficha from Fichas where idPerson='" + idpersona + "'");

            if (rs.next()) {
                if (f == null) {
                    f = new Fichas();
                }
            }
            

            f.setNficha(rs.getInt("nficha"));
            System.out.println("Numero Ficha Recuperado   :" + f.getNficha());
            //txtCodigoPer.setText(String.valueOf(a.getIdperson()));
            txtNombrePer.setText(a.getNombre());
            txtApellido.setText(a.getApellido());
            txtEspecialista.setText(a.getFechAgenda());
            cboEstado.setSelectedItem((String) a.getEstado());
            txtFicha.setText(String.valueOf(f.getNficha()));
            txtIDDoc.setText(String.valueOf(a.getDoc()));
            txtTipo.setText(a.getTipoCons());
            txtCedula.setText(a.getCi());

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

    private void txtCodigoPerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoPerActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtCodigoPerActionPerformed

    private void txtCiPerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCiPerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCiPerActionPerformed

    private void btnBuscarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProActionPerformed
        // TODO add your handling code here:

        try {
            String idficha = txtCiPer.getText();
            System.out.println("ID   :" + idficha);
            Fichas f;
            f = BDFichas.buscar(idficha);

            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select pa.nomPerson, pa.apePerson, pa.ciPersona, fi.nficha from persona as pa inner join Fichas as fi on pa.idperson=fi.idPerson where pa.idperson='" + idficha + "'");

            if (rs.next()) {
                if (f == null) {
                    f = new Fichas();
                }
            }
            
            

            f.setApellido(rs.getString("apePerson"));
            txtApellido.setText(f.getApellido());
            f.setNombre(rs.getString("nomPerson"));
            txtNombrePer.setText(f.getNombre());
            f.setCi(rs.getString("ciPersona"));
            txtCedula.setText(f.getCi());
            f.setNficha(rs.getInt("nficha"));
            txtFicha.setText(String.valueOf(f.getNficha()));
            

            System.out.println("Nombre    :" + f.getNombre());
            System.out.println("Apellido    :" + f.getApellido());
            System.out.println("Cedula     :" + f.getCi());
            System.out.println("Ficha     :" + f.getNficha());
        } catch (SQLException ex) {
            System.out.println("Error Al Seleccionar Elemento:" + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Tiene que agregar ID Persona..!!");
        }

    }//GEN-LAST:event_btnBuscarProActionPerformed

    private void btnBuscarPro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPro1ActionPerformed
        // TODO add your handling code here:

        try {

            Agenda a = null;
            String iddoc = txtIDDoc.getText();
            System.out.println("ID   :" + iddoc);
          
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select nomPerson, apePerson,tipoPerson from persona inner join personal on persona.idperson=personal.idPerson where iPersonal='" + iddoc + "'");

            if (rs.next()) {
                if (a == null) {
                    a = new Agenda();
                }
            }
            
            a.setNombre(rs.getString("nomPerson"));

            a.setApellido(rs.getString("apePerson"));
            a.setTipoCons(rs.getString("tipoPerson"));
            
            txtDoc.setText(a.getNombre() + " " + a.getApellido());
            txtTipo.setText(a.getTipoCons());
            System.out.println("Nombre    :" + a.getNombre());
            System.out.println("Apellido    :" + a.getApellido());
            System.out.println("Tipo Doc    :" + a.getTipoCons());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No existe..!!");
            System.out.println("Error Al Seleccionar Elemento:" + ex.getMessage());

        }


    }//GEN-LAST:event_btnBuscarPro1ActionPerformed

    private void txtEspecialistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEspecialistaActionPerformed
        // TODO add your handling code here:
        
        
       

    }//GEN-LAST:event_txtEspecialistaActionPerformed

    private void btnBuscarPro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPro2ActionPerformed
        // TODO add your handling code here:
        try {

            Agenda a;
            a = new Agenda();
            String Fechaux = null;
            Fechaux = ((txtEspecialista.getText()));
            System.out.println("Fecha agenda para select  :" + Fechaux);
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select max(nroAgenda) from Agenda where fechAgenda='" + Fechaux + "'");
            System.out.println("respuesta RS  " + rs.next());
            int ID = rs.getInt(1);
            if (rs.next()) {
                if (a == null) {
                    a = new Agenda();
                }
            }

            System.out.println("cantidad en agenda  " + ID);
            if (ID <= 10) {
                JOptionPane.showMessageDialog(null, "Disponible");
            } else {
                JOptionPane.showMessageDialog(null, "No Disponible");
            }

        } catch (Exception e) {
            System.out.println("Error DB  :" + e);

        }
        
        
        
        
    }//GEN-LAST:event_btnBuscarPro2ActionPerformed

    private void actualizarBusqueda() {
        ArrayList<Agenda> result = null;
        if (String.valueOf(cboParametroPer.getSelectedItem()).equalsIgnoreCase("Ficha")) {
            result = BDAgenda.listarAgendaPorNficha(txtBuscarPer.getText());

        } else if (String.valueOf(cboParametroPer.getSelectedItem()).equalsIgnoreCase("CI")) {
            result = BDAgenda.listarAgendaPorCodigo(txtBuscarPer.getText());

        } else if (String.valueOf(cboParametroPer.getSelectedItem()).equalsIgnoreCase("Estado")) {
            result = BDAgenda.listarAgendaPorEstado(txtBuscarPer.getText());
        }

        recargarTable(result);
    }

    public void recargarTable(ArrayList<Agenda> list) {
        Object[][] datos = new Object[list.size()][5];
        int i = 0;
        for (Agenda a : list) {

            datos[i][0] = a.getIdagenda();
            datos[i][1] = a.getNombre();
            datos[i][2] = a.getApellido();
            datos[i][3] = a.getFechAgenda();
            datos[i][4] = a.getEstado();
            
            i++;
        }
        jtPersonal.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                    "ID", "Nombre", "Apellido", "Fecha", "Estado"
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
            java.util.logging.Logger.getLogger(FrmMantenimientoAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMantenimientoAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMantenimientoAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMantenimientoAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrmMantenimientoAgenda().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarPro;
    private javax.swing.JButton btnBuscarPro1;
    private javax.swing.JButton btnBuscarPro2;
    private javax.swing.JButton btnCancelarPer;
    private javax.swing.JButton btnGuardarPer;
    private javax.swing.JButton btnModificarPer;
    private javax.swing.JButton btnNuevoPer;
    private javax.swing.JButton btnSalirPer;
    private javax.swing.JComboBox cboEstado;
    private javax.swing.JComboBox cboParametroPer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtPersonal;
    public javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBuscarPer;
    public javax.swing.JTextField txtCedula;
    public javax.swing.JTextField txtCiPer;
    private javax.swing.JTextField txtCodigoPer;
    public javax.swing.JTextField txtDoc;
    public javax.swing.JTextField txtEspecialista;
    public javax.swing.JTextField txtFicha;
    public javax.swing.JTextField txtIDDoc;
    public javax.swing.JTextField txtNombrePer;
    public javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables

}
