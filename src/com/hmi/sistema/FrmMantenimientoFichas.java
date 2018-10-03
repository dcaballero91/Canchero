package com.hmi.sistema;

import com.hmi.variables.Fichas;
import com.hmi.conexiones.BD;
import com.hmi.conexiones.BDFichas;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public final class FrmMantenimientoFichas extends javax.swing.JFrame {

    String accion;

    /**
     * Creates new form FrmMantenimientoFichas
     */
    public FrmMantenimientoFichas() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
        actualizarBusqueda();
        obtenerUltimoId();
        activarBotones(true);
        this.setLocationRelativeTo(null);
    }

    public void obtenerUltimoId() {
        try {
            try (Connection con = BD.getConnection()) {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select max(nficha) from Fichas");
                while (rs.next()) {
                    int lastID = rs.getInt(1);
                    txtNumero.setText(String.valueOf(lastID + 1));
                }
                rs.close();
                stmt.close();
            }
        } catch (SQLException error) {
            System.out.print(error);
        }
    }

    public void limpiarCajaTexto() {
        txtNumero.setText("");
        txtIDPadre.setText("");
        txtID.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtDireccion.setText("");
        txtFechaNac.setText("");
        txtDni.setText("");
        cboCeguro.setSelectedItem("Seleccionar...");
        txtTelefono.setText("");
        txtNacionalidad.setText("");
        txtDireccion.setText("");
        cboSexo.setSelectedItem("Seleccionar...");
        txtObs1.setText("");
        txtPadre.setText("");
        txtMadre.setText("");

    }

    public void activarCajaTexto(boolean b) {
        txtNumero.setEditable(b);
        txtIDPadre.setEditable(!b);
        txtID.setEditable(b);
        txtApellido.setEditable(!b);
        txtDireccion.setEditable(!b);
        txtFechaNac.setEnabled(!b);
        txtDni.setEditable(!b);
        txtTelefono.setEditable(!b);
        txtObs1.setEditable(b);
        txtNacionalidad.setEditable(!b);
        cboSexo.setEditable(!b);

        txtIDMadre.setEditable(b);
        txtIDPadre.setEditable(b);

    }

    public void activarBotones(boolean b) {
        btnNuevoProv.setEnabled(b);
        btnGuardarProv.setEnabled(!b);
        btnCancelarProv.setEnabled(!b);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscarProv = new javax.swing.JTextField();
        cboParametroProv = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtFichas = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cboCeguro = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtNacionalidad = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        cboSexo = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtObs1 = new javax.swing.JTextArea();
        txtIDPadre = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtPadre = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnBuscarPro = new javax.swing.JButton();
        txtFechaNac = new javax.swing.JTextField();
        btnBuscarPro1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtIDMadre = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtMadre = new javax.swing.JTextField();
        btnBuscarPro2 = new javax.swing.JButton();
        btnNuevoProv = new javax.swing.JButton();
        btnGuardarProv = new javax.swing.JButton();
        btnCancelarProv = new javax.swing.JButton();
        btnSalirProv = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        btnModificarPer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Garamond", 1, 14)); // NOI18N
        jLabel1.setText("BUSCAR FICHAS");

        txtBuscarProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarProvActionPerformed(evt);
            }
        });
        txtBuscarProv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProvKeyReleased(evt);
            }
        });

        cboParametroProv.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CI", "Nombre", "NFicha" }));
        cboParametroProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboParametroProvActionPerformed(evt);
            }
        });

        jtFichas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Año", "Nombre"
            }
        ));
        jtFichas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtFichasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtFichas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtBuscarProv, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboParametroProv, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboParametroProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Pasiente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel2.setText("NFichas (*):");

        jLabel3.setText("FNaci. (*):");

        jLabel4.setText("Nombre (*):");

        jLabel5.setText("Apellio(*):");

        jLabel6.setText("Dni(*):");

        jLabel7.setText("Seguro");

        cboCeguro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar...", "SI", "NO" }));

        jLabel8.setText("Nacionalidad");

        jLabel9.setText("Direccion");

        jLabel10.setText("Sexo");

        txtNumero.setEditable(false);
        txtNumero.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtApellido.setEditable(false);

        txtDni.setEditable(false);
        txtDni.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtTelefono.setEditable(false);
        txtTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        txtNacionalidad.setEditable(false);

        txtDireccion.setEditable(false);

        cboSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar...", "M", "F" }));

        jLabel11.setText("Telefono");

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Observaciones"));

        txtObs1.setEditable(false);
        txtObs1.setColumns(20);
        txtObs1.setRows(5);
        jScrollPane3.setViewportView(txtObs1);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtIDPadre.setEditable(false);

        jLabel12.setText("Padre:");

        txtPadre.setEditable(false);

        jLabel14.setText("ID : (*):");

        txtNombre.setEditable(false);

        btnBuscarPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/View.png"))); // NOI18N
        btnBuscarPro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscarPro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProActionPerformed(evt);
            }
        });

        txtFechaNac.setEditable(false);

        btnBuscarPro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/View.png"))); // NOI18N
        btnBuscarPro1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscarPro1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscarPro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPro1ActionPerformed(evt);
            }
        });

        jLabel15.setText("ID : (*):");

        txtID.setEditable(false);

        jLabel16.setText("ID : (*):");

        txtIDMadre.setEditable(false);

        jLabel17.setText("Madre:");

        txtMadre.setEditable(false);

        btnBuscarPro2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/View.png"))); // NOI18N
        btnBuscarPro2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscarPro2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscarPro2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPro2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addComponent(jLabel4))
                                    .addComponent(jLabel14))
                                .addGap(39, 39, 39)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNumero)
                                    .addComponent(txtNombre)
                                    .addComponent(txtFechaNac, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                    .addComponent(txtID, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarPro, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel7)
                                .addComponent(jLabel11)
                                .addComponent(jLabel10))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cboCeguro, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel6))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtDni, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtDireccion)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIDMadre)
                            .addComponent(txtMadre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarPro2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel15))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtIDPadre, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                    .addComponent(txtPadre))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscarPro1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarPro)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(txtNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboCeguro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscarPro1))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(txtIDPadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(txtPadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(txtIDMadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(txtMadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnBuscarPro2))))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        btnNuevoProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/New document.png"))); // NOI18N
        btnNuevoProv.setText("NUEVO");
        btnNuevoProv.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevoProv.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevoProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoProvActionPerformed(evt);
            }
        });

        btnGuardarProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/Save.png"))); // NOI18N
        btnGuardarProv.setText("GUARDAR");
        btnGuardarProv.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardarProv.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardarProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarProvActionPerformed(evt);
            }
        });

        btnCancelarProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/Erase.png"))); // NOI18N
        btnCancelarProv.setText("CANCELAR");
        btnCancelarProv.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelarProv.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelarProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarProvActionPerformed(evt);
            }
        });

        btnSalirProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/Exit.png"))); // NOI18N
        btnSalirProv.setText("SALIR");
        btnSalirProv.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalirProv.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalirProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirProvActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jLabel13.setText("CARGAR FICHAS");

        btnModificarPer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/Modify.png"))); // NOI18N
        btnModificarPer.setText("MODIFICAR");
        btnModificarPer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificarPer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificarPer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarPerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevoProv, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardarProv)
                .addGap(18, 18, 18)
                .addComponent(btnModificarPer, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelarProv)
                .addGap(26, 26, 26)
                .addComponent(btnSalirProv, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevoProv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalirProv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardarProv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelarProv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificarPer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirProvActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSalirProvActionPerformed

    private void btnNuevoProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoProvActionPerformed
        // TODO add your handling code here:
        limpiarCajaTexto();
        activarCajaTexto(true);
        activarBotones(false);
        accion = "Guardar";
        obtenerUltimoId();
    }//GEN-LAST:event_btnNuevoProvActionPerformed

    private void cboParametroProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboParametroProvActionPerformed
        // TODO add your handling code here:
        actualizarBusqueda();
    }//GEN-LAST:event_cboParametroProvActionPerformed

    private void txtBuscarProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarProvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarProvActionPerformed

    private void txtBuscarProvKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProvKeyReleased
        // TODO add your handling code here:
        actualizarBusqueda();
    }//GEN-LAST:event_txtBuscarProvKeyReleased
    private String GenerarCodigo() {
        SimpleDateFormat sdf = new SimpleDateFormat("hhmmss");
        return sdf.format(new Date());
    }
    private void btnGuardarProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProvActionPerformed
        // TODO add your handling code here:

        if (accion.equalsIgnoreCase("Guardar")) {
            if (txtNumero.getText().compareTo("") != 0 && txtID.getText().compareTo("") != 0 && txtApellido.getText().compareTo("") != 0
                    && txtTelefono.getText().compareTo("") != 0) {
                Fichas pv = new Fichas();
                int idficha;

                idficha = Integer.parseInt(txtID.getText());
                int npadre;
                npadre = Integer.parseInt(txtIDPadre.getText());
                int nmadre;
                nmadre = Integer.parseInt(txtIDMadre.getText());
                System.out.println("idmadre" + nmadre);
                System.out.println("idpadre" + npadre);
                System.out.println("idficha" + idficha);
                try {
                    String ci = null;
                    String ficha = null;

                    Fichas f;
                    f = new Fichas();
                    
                    //f = BDFichas.buscar(ci);
                    try {
                        Connection con = BD.getConnection();
                        Statement stmt = con.createStatement();

                        ci = txtDni.getText();
                        ficha = txtNumero.getText();
                        System.out.println("antes del selectci   :" + ci);
                        ResultSet rs = stmt.executeQuery("select pa.ciPersona,fi.nficha from persona as pa inner join Fichas as fi on pa.idperson=fi.idPerson where pa.ciPersona='" + ci + "'");
                        System.out.println("despues del select..." + rs.next());
                        f.setCi(rs.getString("ciPersona"));
                        f.setNfichaux(rs.getString("nficha"));
                        
                        
                        if (rs.next()) {
                            if (f == null) {
                                f = new Fichas();
                            }

                            

                        }
                        
                    } catch (SQLException e) {
                        System.out.println("Error BD recuperar ci: " + e.getMessage());
                    }
                    if (nmadre != npadre) {
                        if (idficha != npadre && idficha != nmadre) {
                            
                            System.out.println("getci   :" + f.getCi());
                            System.out.println("getnfichaaux   :" + f.getNfichaux());
                            String CiT = null;
                            String fich = null;
                            CiT = f.getCi();
                            fich = f.getNfichaux();
                            if(CiT == null && fich == null){
                            f.setCi(ci);
                            f.setNfichaux(ficha);
                            System.out.println("vino null se le carga ci:" + f.getCi());
                            System.out.println("vino null se le carga nficha:" + f.getNfichaux());
                                pv.setNficha(Integer.parseInt(txtNumero.getText()));
                                pv.setIdperson(Integer.parseInt(txtID.getText()));
                                pv.setSeguro((String) cboCeguro.getSelectedItem());
                                pv.setIdpadre(Integer.parseInt(txtIDPadre.getText()));
                                pv.setIdmadre(Integer.parseInt(txtIDMadre.getText()));

                                BDFichas.insertarFichas(pv);
                                JOptionPane.showMessageDialog(null, "Ficha Agredado");
                            }else {
                            JOptionPane.showMessageDialog(null, "CI o Ficha Ya Registrado..!");
                            
                            }
                            
                        } else {
                            System.out.println("Padre Madre son iguales..!!");
                            JOptionPane.showMessageDialog(null, "Padre Madre son iguales..!!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Igual Hijo con Padre o Madre");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(FrmMantenimientoFichas.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException e) {
                    System.out.println("Error BD: " + e.getMessage());
                }
                limpiarCajaTexto();
                obtenerUltimoId();
            } else {
                JOptionPane.showMessageDialog(null, "Llene Todos Los Campos Requeridos..!!");
            }
        }
        if (accion.equalsIgnoreCase("Actualizar")) {
            if (txtNumero.getText().compareTo("") != 0 && txtID.getText().compareTo("") != 0 && txtApellido.getText().compareTo("") != 0
                    && txtTelefono.getText().compareTo("") != 0) {
                Fichas pv = new Fichas();
                int idficha;

                idficha = Integer.parseInt(txtID.getText());
                int npadre;
                npadre = Integer.parseInt(txtIDPadre.getText());
                int nmadre;
                nmadre = Integer.parseInt(txtIDMadre.getText());
                System.out.println("idmadre" + nmadre);
                System.out.println("idpadre" + npadre);
                System.out.println("idficha" + idficha);
                try {
                    String ci = null;
                    String ficha = null;

                    Fichas f;
                    f = new Fichas();
                    
                    //f = BDFichas.buscar(ci);
                    try {
                        Connection con = BD.getConnection();
                        Statement stmt = con.createStatement();

                        ci = txtDni.getText();
                        ficha = txtNumero.getText();
                        System.out.println("antes del selectci   :" + ci);
                        ResultSet rs = stmt.executeQuery("select pa.ciPersona,fi.nficha from persona as pa inner join Fichas as fi on pa.idperson=fi.idPerson where pa.ciPersona='" + ci + "'");
                        System.out.println("despues del select..." + rs.next());
                        f.setCi(rs.getString("ciPersona"));
                        f.setNfichaux(rs.getString("nficha"));
                        
                        
                        if (rs.next()) {
                            if (f == null) {
                                f = new Fichas();
                            }

                            

                        }
                       
                    } catch (SQLException e) {
                        System.out.println("Error BD recuperar ci: " + e.getMessage());
                    }
                    if (nmadre != npadre) {
                        if (idficha != npadre && idficha != nmadre) {
                            
                            System.out.println("getci   :" + f.getCi());
                            System.out.println("getnfichaaux   :" + f.getNfichaux());
                            String CiT = null;
                            String fich = null;
                            CiT = f.getCi();
                            fich = f.getNfichaux();
                            if(CiT != null && !f.getNfichaux().equals(ficha)){
                            f.setCi(ci);
                            f.setNfichaux(ficha);
                            System.out.println("vino null se le carga ci:" + f.getCi());
                            System.out.println("vino null se le carga nficha:" + f.getNfichaux());
                            pv.setNficha(Integer.parseInt(txtNumero.getText()));
                            pv.setIdperson(Integer.parseInt(txtID.getText()));
                            System.out.println("id personal  :" + pv.getIdperson() );
                            pv.setSeguro((String) cboCeguro.getSelectedItem());
                            pv.setIdpadre(Integer.parseInt(txtIDPadre.getText()));
                            pv.setIdmadre(Integer.parseInt(txtIDMadre.getText()));
                            pv.setObserv(txtObs1.getText());

                            BDFichas.actualizarFichas(pv);
                            JOptionPane.showMessageDialog(null, "Ficha Actualizado");
                            }else {
                            JOptionPane.showMessageDialog(null, "Ficha Ya Registrado..!");
                            
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Padre Madre son iguales..!!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Igual Hijo con Padre o Madre");
                    }
                } catch (SQLException e) {
                    System.out.println("Error BD: " + e.getMessage());
                }
                limpiarCajaTexto();
                obtenerUltimoId();
            } else {
                JOptionPane.showMessageDialog(null, "Llene Todos Los Campos Requeridos..!!");
            }

            
        }
    }//GEN-LAST:event_btnGuardarProvActionPerformed

    private void btnCancelarProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarProvActionPerformed
        // TODO add your handling code here:
        limpiarCajaTexto();
        activarCajaTexto(false);
        obtenerUltimoId();
        activarBotones(true);
    }//GEN-LAST:event_btnCancelarProvActionPerformed

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // TODO add your handling code here:
        if (String.valueOf(evt.getKeyChar()).matches("[a-zA-Z]|\\s")) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void jtFichasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtFichasMouseClicked
        // TODO add your handling code here:
        try {
            Fichas fic = BDFichas.buscarFichas(Integer.parseInt(String.valueOf(jtFichas.getModel().getValueAt(jtFichas.getSelectedRow(), 0))));
            txtNumero.setText(String.valueOf(fic.getNficha()));
            txtFechaNac.setText(fic.getFechanac());
            txtID.setText(String.valueOf(fic.getIdperson()));
            txtNombre.setText(fic.getNombre());
            txtApellido.setText(fic.getApellido());
            txtDni.setText(String.valueOf(fic.getCi()));
            txtDireccion.setText(fic.getDirecc());
            txtNacionalidad.setText(fic.getNac());
            cboCeguro.setSelectedItem((String) fic.getSeguro());
            txtTelefono.setText(fic.getTelefono());
            cboSexo.setSelectedItem((String) fic.getSexo());
            txtObs1.setText(fic.getObserv());
            txtIDPadre.setText(String.valueOf(fic.getNpadre()));
            txtIDMadre.setText(String.valueOf(fic.getNmadre()));
            if (evt.getClickCount() == 2) {
                JOptionPane.showMessageDialog(null, "Solo seleccione el elemento");
            }
        } catch (SQLException ex) {
            System.out.println("Error Al Seleccionar Elemento:" + ex.getMessage());
        }
    }//GEN-LAST:event_jtFichasMouseClicked

    private void btnBuscarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProActionPerformed
        // TODO add your handling code here:

        try {
            String idficha = txtID.getText();
            System.out.println("ID   :" + idficha);
            Fichas f;
            f = BDFichas.buscar(idficha);

            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select idPerson,nomPerson,apePerson,ciPersona,dirPerson,tipTelefP,numPerson,sexo,nacionalidad,fechaNac from persona where idPerson='" + idficha + "'");

            if (rs.next()) {
                if (f == null) {
                    f = new Fichas();
                }
            }
            
            

            f.setFechanac(rs.getString("fechaNac"));
            txtFechaNac.setText(f.getFechanac());
            f.setNombre(rs.getString("nomPerson"));
            txtNombre.setText(f.getNombre());
            f.setApellido(rs.getString("apePerson"));
            txtApellido.setText(f.getApellido());
            f.setCi(rs.getString("ciPersona"));
            txtDni.setText(f.getCi());
            f.setDirecc(rs.getString("dirPerson"));
            txtDireccion.setText(f.getDirecc());
            f.setNac(rs.getString("nacionalidad"));
            txtNacionalidad.setText(f.getNac());
            f.setTelefono(rs.getString("numPerson"));
            txtTelefono.setText(f.getTelefono());
            f.setSexo(rs.getString("sexo"));
            cboSexo.setSelectedItem((String) f.getSexo());

            System.out.println("Nombre    :" + f.getNombre());
            System.out.println("Apellido    :" + f.getApellido());
            System.out.println("Cedula     :" + f.getCi());
            
        } catch (SQLException ex) {
            System.out.println("Error Al Seleccionar Elemento:" + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Tiene que agregar ID Persona..!!");
        }


    }//GEN-LAST:event_btnBuscarProActionPerformed

    private void btnBuscarPro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPro1ActionPerformed
        // TODO add your handling code here:
        try {
            String npadre = txtIDPadre.getText();
            System.out.println("ID   :" + npadre);
            Fichas f;
            f = BDFichas.buscar(npadre);

            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select idPerson,nomPerson,apePerson,ciPersona,dirPerson,tipTelefP,numPerson,sexo,nacionalidad,fechaNac from persona where idPerson='" + npadre + "'");

            if (rs.next()) {
                if (f == null) {
                    f = new Fichas();
                }
            }
            
            

            f.setNombre(rs.getString("nomPerson"));
            f.setApellido(rs.getString("apePerson"));
            txtPadre.setText(f.getNombre() + " " + f.getApellido());
            System.out.println("Nombre    :" + f.getNombre());
            System.out.println("Apellido    :" + f.getApellido());
            
        } catch (SQLException ex) {
            System.out.println("Error Al Seleccionar Elemento:" + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Tiene que agregar ID Padre..!!");
        }

    }//GEN-LAST:event_btnBuscarPro1ActionPerformed

    private void btnBuscarPro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPro2ActionPerformed
        // TODO add your handling code here:

        try {
            String nmadre = txtIDMadre.getText();
            System.out.println("ID   :" + nmadre);
            Fichas f;
            f = BDFichas.buscar(nmadre);

            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select idPerson,nomPerson,apePerson,ciPersona,dirPerson,tipTelefP,numPerson,sexo,nacionalidad,fechaNac from persona where idPerson='" + nmadre + "'");

            if (rs.next()) {
                if (f == null) {
                    f = new Fichas();
                }
            }
            
            f.setNombre(rs.getString("nomPerson"));
            f.setApellido(rs.getString("apePerson"));
            txtMadre.setText(f.getNombre() + " " + f.getApellido());
            System.out.println("Nombre    :" + f.getNombre());
            System.out.println("Apellido    :" + f.getApellido());
            
        } catch (SQLException ex) {
            System.out.println("Error Al Seleccionar Elemento:" + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Tiene que agregar ID Madre..!!");
        }

    }//GEN-LAST:event_btnBuscarPro2ActionPerformed

    private void btnModificarPerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarPerActionPerformed
        // TODO add your handling code here:
        activarCajaTexto(true);
        accion = "Actualizar";
        btnCancelarProv.setEnabled(true);
        btnGuardarProv.setEnabled(true);
        btnNuevoProv.setEnabled(false);
        btnModificarPer.setEnabled(true);


    }//GEN-LAST:event_btnModificarPerActionPerformed

    private void actualizarBusqueda() {
        ArrayList<Fichas> result = null;
        if (String.valueOf(cboParametroProv.getSelectedItem()).equalsIgnoreCase("CI")) {
            result = BDFichas.listarFichasPorNit(txtBuscarProv.getText());
        } else if (String.valueOf(cboParametroProv.getSelectedItem()).equalsIgnoreCase("Nombre")) {
            result = BDFichas.listarFichasPorNombre(txtBuscarProv.getText());
        } else if (String.valueOf(cboParametroProv.getSelectedItem()).equalsIgnoreCase("NFicha")) {
            result = BDFichas.listarFichasPorCodigo(txtBuscarProv.getText());
        }
        recargarTable(result);
    }

    public void recargarTable(ArrayList<Fichas> list) {
        Object[][] datos = new Object[list.size()][5];
        int i = 0;
        for (Fichas pv : list) {
            datos[i][0] = pv.getNficha();
            datos[i][1] = pv.getFechanac();
            datos[i][2] = pv.getNombre();
            datos[i][3] = pv.getApellido();
            datos[i][4] = pv.getCi();
            i++;
        }
        jtFichas.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                    "NFICHA", "AÑO", "NOMBRE", "APELLIDO", "CI"
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
            java.util.logging.Logger.getLogger(FrmMantenimientoFichas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMantenimientoFichas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMantenimientoFichas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMantenimientoFichas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrmMantenimientoFichas().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarPro;
    private javax.swing.JButton btnBuscarPro1;
    private javax.swing.JButton btnBuscarPro2;
    private javax.swing.JButton btnCancelarProv;
    private javax.swing.JButton btnGuardarProv;
    private javax.swing.JButton btnModificarPer;
    private javax.swing.JButton btnNuevoProv;
    private javax.swing.JButton btnSalirProv;
    private javax.swing.JComboBox cboCeguro;
    private javax.swing.JComboBox cboParametroProv;
    private javax.swing.JComboBox cboSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jtFichas;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBuscarProv;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtFechaNac;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIDMadre;
    private javax.swing.JTextField txtIDPadre;
    private javax.swing.JTextField txtMadre;
    private javax.swing.JTextField txtNacionalidad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumero;
    public javax.swing.JTextArea txtObs1;
    private javax.swing.JTextField txtPadre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

}
