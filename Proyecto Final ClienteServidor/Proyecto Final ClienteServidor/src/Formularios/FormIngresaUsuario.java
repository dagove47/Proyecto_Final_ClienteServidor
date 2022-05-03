
package Formularios;




import ListaCircularSimple.Persona;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import static Principal.Principal.*;

public class FormIngresaUsuario extends javax.swing.JFrame {

    Conexion cc = new Conexion();
    Connection  con = cc.conectar();

   
    public FormIngresaUsuario() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Iniciar Sesion");          
    }

    public void validaracceso(){
        
        
        int resultado = 0;
       
        try{
        String usuario = txtfieldnombre.getText();
        String pass = String.valueOf(txtfieldpassword.getPassword());
        
        String sql = "select * from usuarios where Nombre='"+usuario+"' and Contraseña='"+pass+"'";
        
        Statement st= con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
     
            if (rs.next()) {
                resultado = 1;
                if (resultado == 1) {
                    nuevalista.insertarPrimero(new Persona(usuario));
                    FormMenuPropietario run = new FormMenuPropietario();
                    run.setVisible(true);
                    this.setVisible(false);
                           
                }else{
                    JOptionPane.showMessageDialog(null,"EL USUARIO NO ESTA REGISTRADO O LAS CREDENCIALES SON INCORRECTAS", "", JOptionPane.WARNING_MESSAGE);
                }    
            }else{
               txtfieldnombre.setText("");
               txtfieldpassword.setText("");
            JOptionPane.showMessageDialog(null,"EL USUARIO NO ESTA REGISTRADO O LAS CREDENCIALES SON INCORRECTAS");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR EN EL ACCESSO" + e.getMessage());
        }
    
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        panelobjetos = new javax.swing.JPanel();
        panelobjetosregistro = new javax.swing.JPanel();
        txttelefono = new javax.swing.JLabel();
        txtnombre = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtfieldnombre = new javax.swing.JTextField();
        txtfieldpassword = new javax.swing.JPasswordField();
        panelboton1 = new javax.swing.JPanel();
        txtingresar = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        imgfondo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelobjetos.setBackground(new java.awt.Color(41, 50, 60));
        panelobjetos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelobjetosregistro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txttelefono.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 24)); // NOI18N
        txttelefono.setForeground(new java.awt.Color(255, 255, 255));
        txttelefono.setText("Contraseña:");
        panelobjetosregistro.add(txttelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 110, -1));

        txtnombre.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 24)); // NOI18N
        txtnombre.setForeground(new java.awt.Color(255, 255, 255));
        txtnombre.setText("Nombre:");
        panelobjetosregistro.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 80, -1));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("INGRESO  DE USUARIO");
        panelobjetosregistro.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 210, -1));
        panelobjetosregistro.add(txtfieldnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 150, -1));
        panelobjetosregistro.add(txtfieldpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 150, -1));

        panelboton1.setBackground(new java.awt.Color(64, 104, 151));
        panelboton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelboton1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtingresar.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 24)); // NOI18N
        txtingresar.setForeground(new java.awt.Color(255, 255, 255));
        txtingresar.setText(" INGRESAR");
        txtingresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtingresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtingresarMouseClicked(evt);
            }
        });
        panelboton1.add(txtingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        panelobjetosregistro.add(panelboton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/loginfinal.jpg"))); // NOI18N
        panelobjetosregistro.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 320));

        panelobjetos.add(panelobjetosregistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 400, 320));

        imgfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Tortugaimg.jpg"))); // NOI18N
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
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        IniciaSesion run = new IniciaSesion();
        run.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void txtingresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtingresarMouseClicked
        // TODO add your handling code here:
        String contraseña = String.valueOf(txtfieldpassword.getPassword());
        if (txtfieldnombre.getText().isEmpty() || contraseña.isEmpty() ) {
              JOptionPane.showMessageDialog(null,"PORFAVOR RELLENE TODOS LOS CAMPOS","", JOptionPane.WARNING_MESSAGE);
        }else{
         validaracceso();
        }
       
    }//GEN-LAST:event_txtingresarMouseClicked

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
            java.util.logging.Logger.getLogger(FormIngresaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormIngresaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormIngresaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormIngresaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormIngresaUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JLabel imgfondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panelboton1;
    private javax.swing.JPanel panelobjetos;
    private javax.swing.JPanel panelobjetosregistro;
    private javax.swing.JTextField txtfieldnombre;
    private javax.swing.JPasswordField txtfieldpassword;
    private javax.swing.JLabel txtingresar;
    private javax.swing.JLabel txtnombre;
    private javax.swing.JLabel txttelefono;
    // End of variables declaration//GEN-END:variables
}
