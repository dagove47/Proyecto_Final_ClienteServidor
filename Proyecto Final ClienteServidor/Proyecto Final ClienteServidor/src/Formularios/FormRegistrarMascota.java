
package Formularios;

    

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static Principal.Principal.*;




public class FormRegistrarMascota extends javax.swing.JFrame {
    
    Conexion cc = new Conexion();
    Connection  con = cc.conectar();

    public FormRegistrarMascota() {
        initComponents();
        this.setLocationRelativeTo(null);

    
    }
    
   
    public void validaracceso(){
        
        
        int resultado = 0;
       
        try{
        
        String usuario = nuevalista.getPrimero().getPersona().getNombre();
        String sql = "select * from usuarios where Nombre='"+usuario+"'";
        
        Statement st= con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
     
            if (rs.next()) {
                resultado = 1;
                if (resultado == 1) {
                    agregamascota();       
                }else{
                    JOptionPane.showMessageDialog(null,"ERROR AL REGISTRAR LA MASCOTA");
                }    
            }else{
            JOptionPane.showMessageDialog(null,"ERROR AL REGISTRAR LA MASCOTA");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR EN EL ACCESSO" + e.getMessage());
        }
    
    }
  
     public void agregamascota(){
    String especie = String.valueOf(tipoespecie.getSelectedItem());
    String raza = String.valueOf(tiporaza.getSelectedItem());
    String usuario2 = nuevalista.getPrimero().getPersona().getNombre();
    String sql = "insert into mascotas (NombreMascota,NombrePropietario,FechadeNacimiento,Especie,Raza) values (?,?,?,?,?) ";
    
    try{
        if (fieldnombremascota.getText().isEmpty() || fieldfechanacimiento.getDate() == null) {
            JOptionPane.showMessageDialog(null, "PORFAVOR RELLENE TODOS LOS CAMPOS", "", JOptionPane.WARNING_MESSAGE);
        }else{
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, fieldnombremascota.getText());
            pst.setString(2, usuario2);
            pst.setString(3, ((JTextField)fieldfechanacimiento.getDateEditor().getUiComponent()).getText());
            pst.setString(4, especie);
            pst.setString(5, raza);
            pst.execute();
            JOptionPane.showMessageDialog(null, "LA MASCOTA SE REGISTRO EXITOSAMENTE");
        }
     
    }catch(Exception e){
    JOptionPane.showMessageDialog(null,"ERROR DE REGISTRO" + e.getMessage());
    }
    }
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        panelobjetos = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtfechanacimiento = new javax.swing.JLabel();
        txtespecie = new javax.swing.JLabel();
        fieldnombremascota = new javax.swing.JTextField();
        panelboton = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        fieldfechanacimiento = new com.toedter.calendar.JDateChooser();
        tiporaza = new javax.swing.JComboBox<>();
        txtespecie1 = new javax.swing.JLabel();
        tipoespecie = new javax.swing.JComboBox<>();
        imgfondo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelobjetos.setBackground(new java.awt.Color(41, 50, 60));
        panelobjetos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(37, 76, 120));
        jPanel7.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRAR MASCOTA");
        jPanel7.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 300, -1));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT Condensed", 2, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nombre mascota:");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 160, 20));

        txtfechanacimiento.setFont(new java.awt.Font("Tw Cen MT Condensed", 2, 24)); // NOI18N
        txtfechanacimiento.setForeground(new java.awt.Color(255, 255, 255));
        txtfechanacimiento.setText("Fecha de Nacimiento:");
        jPanel7.add(txtfechanacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 160, 20));

        txtespecie.setFont(new java.awt.Font("Tw Cen MT Condensed", 2, 24)); // NOI18N
        txtespecie.setForeground(new java.awt.Color(255, 255, 255));
        txtespecie.setText("Raza:");
        jPanel7.add(txtespecie, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 160, 20));

        fieldnombremascota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldnombremascotaKeyTyped(evt);
            }
        });
        jPanel7.add(fieldnombremascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 160, -1));

        panelboton.setBackground(new java.awt.Color(64, 104, 151));
        panelboton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelboton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("      CREAR");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        panelboton.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 30));

        jPanel7.add(panelboton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 130, 30));

        fieldfechanacimiento.setDateFormatString("yyyy,MM,d");
        jPanel7.add(fieldfechanacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 160, -1));

        tiporaza.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Husky Siberiano", "Golden Retriever", "Caniche", "Pastor Aleman", "Yorkshier Terrier", "Dálmata", "Bóxer", "Chihuahua", "Bulldog Ingles", "Beagle" }));
        jPanel7.add(tiporaza, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 160, -1));

        txtespecie1.setFont(new java.awt.Font("Tw Cen MT Condensed", 2, 24)); // NOI18N
        txtespecie1.setForeground(new java.awt.Color(255, 255, 255));
        txtespecie1.setText("Especie:");
        jPanel7.add(txtespecie1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 160, 20));

        tipoespecie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mamífero", "Ave", "Reptil", " " }));
        jPanel7.add(tipoespecie, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 160, -1));

        panelobjetos.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 550, 350));

        imgfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/caballoimg.jpg"))); // NOI18N
        panelobjetos.add(imgfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 510));

        PanelPrincipal.add(panelobjetos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1030, 510));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel2.setBackground(new java.awt.Color(0, 102, 102));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("HEALTHYBONES VETERYNARY");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logofinal.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Flecha.png"))); // NOI18N
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(2, 2, 2)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 574, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        PanelPrincipal.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 90));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
       validaracceso();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void fieldnombremascotaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldnombremascotaKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if ((c<'a' || c>'z') && (c<'A' || c>'Z')) evt.consume(); {

        }
    }//GEN-LAST:event_fieldnombremascotaKeyTyped

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        FormMenuPropietario run = new FormMenuPropietario();
        run.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        IniciaSesion run = new IniciaSesion();
       run.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_jLabel3MouseClicked

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
            java.util.logging.Logger.getLogger(FormRegistrarMascota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormRegistrarMascota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormRegistrarMascota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormRegistrarMascota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormRegistrarMascota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPrincipal;
    private com.toedter.calendar.JDateChooser fieldfechanacimiento;
    private javax.swing.JTextField fieldnombremascota;
    private javax.swing.JLabel imgfondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel panelboton;
    private javax.swing.JPanel panelobjetos;
    private javax.swing.JComboBox<String> tipoespecie;
    private javax.swing.JComboBox<String> tiporaza;
    private javax.swing.JLabel txtespecie;
    private javax.swing.JLabel txtespecie1;
    private javax.swing.JLabel txtfechanacimiento;
    // End of variables declaration//GEN-END:variables
}
