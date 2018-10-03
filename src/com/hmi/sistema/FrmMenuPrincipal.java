
package com.hmi.sistema;
/**
 *
 * @author DERLIS
 */

import com.hmi.conexiones.BD;
import static com.hmi.sistema.AccessoSistema.txtUsuario;
import com.hmi.variables.Usuario;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.UIManager;


public class FrmMenuPrincipal extends javax.swing.JFrame {

    
    public FrmMenuPrincipal() throws SQLException {
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        JPanel panel = new JPanel();
        //this.setUndecorated(true);
        
        initComponents();
        
        
                   
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xsize = (int) tk.getScreenSize().getWidth();
        int ysize = (int) tk.getScreenSize().getHeight();
        this.setSize(xsize, ysize);
        
        panel.getWidth();
        
        try{
        Usuario u = new Usuario();
        Connection con = BD.getConnection();
        Statement stmt = con.createStatement();
        
        //String usuario = null;
        //usuario = (txtNombreID.getText());
        //txtNombreID.setText(u.getcUsuId());
        
        String dato;
        dato = txtUsuario.getText();
        FrmMenuPrincipal.txtNombreID.setText(dato);
        System.out.println("usuario lo que recibi   :" + dato);
        ResultSet rs = stmt.executeQuery("select useRol from usuarioDesk where cUsuId='"+ dato +"'");
        System.out.println("db  :" + rs.next());
        u.setUseRol(rs.getInt("useRol"));
        System.out.println("Rol Recuperado     " + u.getUseRol()); 
            if (rs.next()){
                if (u == null){
                   u = new Usuario();
                   }
                }
                           
                   
        if(u.getUseRol() == 2){
        Remedios.setEnabled(false);
        Escritorio.setEnabled(false);
        AtenderConsulta.setEnabled(false);
        PreConsulta.setEnabled(false);
        Resetar.setEnabled(false);
        Remedios.setEnabled(false);
            }else if(u.getUseRol() == 3){
                Personal.setEnabled(false);
                Persona.setEnabled(false);
                Escritorio.setEnabled(false);
                Mobil.setEnabled(false);
                miCategoria.setEnabled(false);
                AtenderConsulta.setEnabled(false);
                Resetar.setEnabled(false);
                Agendar.setEnabled(false);
                SmsEnviados.setEnabled(false);
                SmsPreiba.setEnabled(false);
                PreConsulta.setEnabled(false);
                }else if(u.getUseRol() == 4){
                    miCategoria.setEnabled(false);
                    Remedios.setEnabled(false);
                    Personal.setEnabled(false);
                    PreConsulta.setEnabled(false);
                    Persona.setEnabled(false);
                    Escritorio.setEnabled(false);
                    Mobil.setEnabled(false);
                    Agendar.setEnabled(false);
                    Agendar.setEnabled(false);
                    SmsPreiba.setEnabled(false);
                    SMS.setEnabled(false);
                }else if(u.getUseRol() == 5){
                    Personal.setEnabled(false);
                Persona.setEnabled(false);
                Escritorio.setEnabled(false);
                Mobil.setEnabled(false);
                miCategoria.setEnabled(false);
                AtenderConsulta.setEnabled(false);
                Resetar.setEnabled(false);
                Agendar.setEnabled(false);
                SmsEnviados.setEnabled(false);
                SmsPreiba.setEnabled(false);
                Remedios.setEnabled(false);
                
                }
        
        
        }catch(SQLException e){
        System.out.println("error db" + e);
        }
        
        }
    
  
    
    
   
    
   

    public String getAnual() {
        return anual;
    }

    public void setAnual(String anual) {
        this.anual = anual;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String retornarMes(int numero) {
        String descmes = "";
        switch (numero) {
            case 1:
                descmes = "ENERO";
                break;
            case 2:
                descmes = "FEBRERO";
                break;
            case 3:
                descmes = "MARZO";
                break;
            case 4:
                descmes = "ABRIL";
                break;
            case 5:
                descmes = "MAYO";
                break;
            case 6:
                descmes = "JUNIO";
                break;
            case 7:
                descmes = "JULIO";
                break;
            case 8:
                descmes = "AGOSTO";
                break;
            case 9:
                descmes = "SEPTEMBRE";
                break;
            case 10:
                descmes = "OCTOBRE";
                break;
            case 11:
                descmes = "NOVIEMBRE";
                break;
            case 12:
                descmes = "DICIEMBRE";
                break;
        }
        return descmes;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreID = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        mOpciones = new javax.swing.JMenuBar();
        jMenu11 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        miSalir = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        Fichas = new javax.swing.JMenu();
        miCategoria = new javax.swing.JMenuItem();
        Remedios = new javax.swing.JMenuItem();
        Personal = new javax.swing.JMenuItem();
        Persona = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        Agendar = new javax.swing.JMenuItem();
        PreConsulta = new javax.swing.JMenuItem();
        AtenderConsulta = new javax.swing.JMenuItem();
        Resetar = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        miConsultaProv = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        Escritorio = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        Mobil = new javax.swing.JMenuItem();
        SMS = new javax.swing.JMenu();
        SmsEnviados = new javax.swing.JMenuItem();
        SmsPreiba = new javax.swing.JMenuItem();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SistemaHospital HMI");
        setResizable(false);

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));
        jDesktopPane1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagespng.png"))); // NOI18N

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("USUARIO:");

        txtNombreID.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        txtNombreID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtNombreID.setText("NOMBRE USUARIO");

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel5.setText("FECHA ACTUAL :");

        jLabel6.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel6.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(320, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreID, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addContainerGap())
        );
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtNombreID, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        mOpciones.setBackground(new java.awt.Color(0, 204, 51));
        mOpciones.setBorder(javax.swing.BorderFactory.createTitledBorder("HMI V 0.1"));
        mOpciones.setForeground(new java.awt.Color(0, 204, 102));
        mOpciones.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mOpciones.setFont(new java.awt.Font("Garamond", 0, 14)); // NOI18N
        mOpciones.setPreferredSize(new java.awt.Dimension(0, 90));
        mOpciones.setRequestFocusEnabled(false);

        jMenu11.setText("               ");
        jMenu11.setEnabled(false);
        mOpciones.add(jMenu11);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/1291627904_home.png"))); // NOI18N
        jMenu3.setText("INICIO");
        jMenu3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        miSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        miSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/Exit.png"))); // NOI18N
        miSalir.setText("SALIR");
        miSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSalirActionPerformed(evt);
            }
        });
        jMenu3.add(miSalir);
        jMenu3.add(jSeparator1);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/People.png"))); // NOI18N
        jMenuItem1.setText("Re-Login");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        mOpciones.add(jMenu3);

        Fichas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/mantenimiento1.png"))); // NOI18N
        Fichas.setText("        INGRESAR");
        Fichas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Fichas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Fichas.setPreferredSize(new java.awt.Dimension(110, 31));
        Fichas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        miCategoria.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        miCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/List.png"))); // NOI18N
        miCategoria.setText("Fichas");
        miCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCategoriaActionPerformed(evt);
            }
        });
        Fichas.add(miCategoria);
        miCategoria.getAccessibleContext().setAccessibleDescription("ctrl+c");

        Remedios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        Remedios.setText("Medicamentos");
        Remedios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemediosActionPerformed(evt);
            }
        });
        Fichas.add(Remedios);

        Personal.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        Personal.setText("Personal");
        Personal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PersonalActionPerformed(evt);
            }
        });
        Fichas.add(Personal);

        Persona.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        Persona.setText("Persona");
        Persona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PersonaActionPerformed(evt);
            }
        });
        Fichas.add(Persona);

        mOpciones.add(Fichas);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/administrador.png"))); // NOI18N
        jMenu1.setText("CONSULTAS");
        jMenu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jMenu1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        Agendar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        Agendar.setText("Agendar-Consulta");
        Agendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendarActionPerformed(evt);
            }
        });
        jMenu1.add(Agendar);

        PreConsulta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        PreConsulta.setText("Pre-Consulta");
        PreConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreConsultaActionPerformed(evt);
            }
        });
        jMenu1.add(PreConsulta);

        AtenderConsulta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        AtenderConsulta.setText("Ateneder-Consulta");
        AtenderConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtenderConsultaActionPerformed(evt);
            }
        });
        jMenu1.add(AtenderConsulta);

        Resetar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        Resetar.setText("Resetar");
        Resetar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetarActionPerformed(evt);
            }
        });
        jMenu1.add(Resetar);

        mOpciones.add(jMenu1);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/buscar.png"))); // NOI18N
        jMenu5.setText("      BUSCAR");
        jMenu5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu5.setPreferredSize(new java.awt.Dimension(100, 30));
        jMenu5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jMenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5ActionPerformed(evt);
            }
        });

        miConsultaProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/Text preview.png"))); // NOI18N
        miConsultaProv.setText("Consulta de Fichas");
        miConsultaProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConsultaProvActionPerformed(evt);
            }
        });
        jMenu5.add(miConsultaProv);
        jMenu5.add(jSeparator2);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/Text preview.png"))); // NOI18N
        jMenuItem2.setText("Consulta de Viaticos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem2);

        mOpciones.add(jMenu5);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/admin.png"))); // NOI18N
        jMenu6.setText("ADMINISTRADOR");
        jMenu6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jMenu6.add(jSeparator3);

        Escritorio.setText("Alta Usuario");

        jMenuItem14.setText("Escriotirio");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        Escritorio.add(jMenuItem14);

        Mobil.setText("Mobil");
        Mobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MobilActionPerformed(evt);
            }
        });
        Escritorio.add(Mobil);

        jMenu6.add(Escritorio);

        SMS.setText("SMS");

        SmsEnviados.setText("Enviados");
        SmsEnviados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SmsEnviadosActionPerformed(evt);
            }
        });
        SMS.add(SmsEnviados);

        SmsPreiba.setText("Prueba");
        SmsPreiba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SmsPreibaActionPerformed(evt);
            }
        });
        SMS.add(SmsPreiba);

        jMenu6.add(SMS);

        mOpciones.add(jMenu6);

        setJMenuBar(mOpciones);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        getAccessibleContext().setAccessibleName("HMI");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_miSalirActionPerformed

    private void miConsultaProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConsultaProvActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_miConsultaProvActionPerformed

    private void jMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu5ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        AccessoSistema acs=new AccessoSistema();
         acs.show(true);
         this.hide();
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void miCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCategoriaActionPerformed
        // TODO add your handling code here:
        FrmMantenimientoFichas frmfichas = new FrmMantenimientoFichas();
        JPanel jPanel1  = new JPanel();
        frmfichas.getContentPane().add(jPanel1);
        frmfichas.pack();
        frmfichas.setVisible(true);

    }//GEN-LAST:event_miCategoriaActionPerformed

    private void PreConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreConsultaActionPerformed
        // TODO add your handling code here:
        FrmMantenimientoPreConsulta frmProf = new FrmMantenimientoPreConsulta();
        frmProf.txtUsuario.setText(txtNombreID.getText().trim());
        JPanel jPanel1  = new JPanel();
        frmProf.getContentPane().add(jPanel1);
        frmProf.pack();
        frmProf.setVisible(true);
        
    }//GEN-LAST:event_PreConsultaActionPerformed

    private void AtenderConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtenderConsultaActionPerformed
        // TODO add your handling code here:
        
        
        String dato;
        dato = txtUsuario.getText();
        System.out.println("id a pasar con dato atender   :" + dato);
        FrmMantenimientoAtendida frmProf = new FrmMantenimientoAtendida();
        JPanel jPanel1  = new JPanel();
        frmProf.getContentPane().add(jPanel1);
        frmProf.pack();
        frmProf.setVisible(true);
        
        
        
        
        
    }//GEN-LAST:event_AtenderConsultaActionPerformed

    private void RemediosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemediosActionPerformed
        // TODO add your handling code here:
        FrmRemedios frmremedios = new FrmRemedios();
        JPanel jPanel1  = new JPanel();
        frmremedios.getContentPane().add(jPanel1);
        frmremedios.pack();
        frmremedios.setVisible(true);
    }//GEN-LAST:event_RemediosActionPerformed

    private void PersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PersonalActionPerformed
        // TODO add your handling code here:
        FrmMantenimientoPersonal frmpersonal = new FrmMantenimientoPersonal();
        JPanel jPanel1  = new JPanel();
        frmpersonal.getContentPane().add(jPanel1);
        frmpersonal.pack();
        frmpersonal.setVisible(true);
    }//GEN-LAST:event_PersonalActionPerformed

    private void PersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PersonaActionPerformed
        // TODO add your handling code here:
        FrmMantenimientoPersona frmpersona = new FrmMantenimientoPersona();
        JPanel jPanel1  = new JPanel();
        frmpersona.getContentPane().add(jPanel1);
        frmpersona.pack();
        frmpersona.setVisible(true);
    }//GEN-LAST:event_PersonaActionPerformed

    private void ResetarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetarActionPerformed
        // TODO add your handling code here:
        FrmRecetario frmfichas = new FrmRecetario();
        JPanel jPanel1  = new JPanel();
        frmfichas.getContentPane().add(jPanel1);
        frmfichas.pack();
        frmfichas.setVisible(true);
    }//GEN-LAST:event_ResetarActionPerformed

    private void MobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MobilActionPerformed
        // TODO add your handling code here:
        FrmMantenimientoMobile frmmovil = new FrmMantenimientoMobile();
        JPanel jPanel1  = new JPanel();
        frmmovil.getContentPane().add(jPanel1);
        frmmovil.pack();
        frmmovil.setVisible(true);
    }//GEN-LAST:event_MobilActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
        FrmMantenimientoUsuario frmuser = new FrmMantenimientoUsuario();
        JPanel jPanel1  = new JPanel();
        frmuser.getContentPane().add(jPanel1);
        frmuser.pack();
        frmuser.setVisible(true);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void SmsPreibaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SmsPreibaActionPerformed
        // TODO add your handling code here:
        FrmMantenimientoSMS FrmSMS = new FrmMantenimientoSMS();
        JPanel jPanel1  = new JPanel();
        FrmSMS.getContentPane().add(jPanel1);
        FrmSMS.pack();
        FrmSMS.setVisible(true);
        
               
    }//GEN-LAST:event_SmsPreibaActionPerformed

    private void SmsEnviadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SmsEnviadosActionPerformed
        // TODO add your handling code here:
        JDBuscarSMS JDBsms = new JDBuscarSMS(this, true, this);
         JPanel jPanel1  = new JPanel();
        JDBsms.getContentPane().add(jPanel1);
        JDBsms.pack();
        JDBsms.setVisible(true);
    }//GEN-LAST:event_SmsEnviadosActionPerformed

    private void AgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendarActionPerformed
        // TODO add your handling code here:
        FrmMantenimientoAgenda frmagendar = new FrmMantenimientoAgenda();
         JPanel jPanel1  = new JPanel();
        frmagendar.getContentPane().add(jPanel1);
        frmagendar.pack();
        frmagendar.setVisible(true);
    }//GEN-LAST:event_AgendarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new FrmMenuPrincipal().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FrmMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Agendar;
    private javax.swing.JMenuItem AtenderConsulta;
    private javax.swing.JMenu Escritorio;
    private javax.swing.JMenu Fichas;
    private javax.swing.JMenuItem Mobil;
    private javax.swing.JMenuItem Persona;
    private javax.swing.JMenuItem Personal;
    private javax.swing.JMenuItem PreConsulta;
    private javax.swing.JMenuItem Remedios;
    private javax.swing.JMenuItem Resetar;
    private javax.swing.JMenu SMS;
    private javax.swing.JMenuItem SmsEnviados;
    private javax.swing.JMenuItem SmsPreiba;
    public javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JMenuBar mOpciones;
    private javax.swing.JMenuItem miCategoria;
    private javax.swing.JMenuItem miConsultaProv;
    private javax.swing.JMenuItem miSalir;
    public static javax.swing.JLabel txtNombreID;
    // End of variables declaration//GEN-END:variables
    
    public String fecha;
    public String anual;
    public int mes;
}