
package Formularios;

    
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static Principal.Principal.*;
public class IniciaSesion extends javax.swing.JFrame {

    Conexion cc = new Conexion();
    Connection  con = cc.conectar();
    
    Statement st;
 

    public IniciaSesion() {
        initComponents();
        this.setLocationRelativeTo(null);
  
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        PanelPrincipal = new javax.swing.JPanel();
        panelobjetos = new javax.swing.JPanel();
        imgfondo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelboton = new javax.swing.JPanel();
        txtadministracion = new javax.swing.JLabel();
        panelboton1 = new javax.swing.JPanel();
        txtingresar = new javax.swing.JLabel();
        panelboton2 = new javax.swing.JPanel();
        txtregistrarse = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelobjetos.setBackground(new java.awt.Color(41, 50, 60));
        panelobjetos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imgfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Erizoimg.jpg"))); // NOI18N
        panelobjetos.add(imgfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 510));

        PanelPrincipal.add(panelobjetos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1030, 510));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel2.setBackground(new java.awt.Color(0, 102, 102));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("HEALTHYBONES VETERYNARY");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logofinal.png"))); // NOI18N

        panelboton.setBackground(new java.awt.Color(64, 104, 151));
        panelboton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelboton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtadministracion.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 24)); // NOI18N
        txtadministracion.setForeground(new java.awt.Color(255, 255, 255));
        txtadministracion.setText("ADMINISTRACION");
        txtadministracion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtadministracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtadministracionMouseClicked(evt);
            }
        });
        panelboton.add(txtadministracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 30));

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

        panelboton2.setBackground(new java.awt.Color(64, 104, 151));
        panelboton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelboton2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtregistrarse.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 24)); // NOI18N
        txtregistrarse.setForeground(new java.awt.Color(255, 255, 255));
        txtregistrarse.setText("REGISTRARSE");
        txtregistrarse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtregistrarse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtregistrarseMouseClicked(evt);
            }
        });
        panelboton2.add(txtregistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 30));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                .addComponent(panelboton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelboton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelboton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(panelboton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(panelboton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(panelboton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(59, 59, 59))
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

    private void txtadministracionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtadministracionMouseClicked
        // TODO add your handling code here:
        FormIngresaAdministracion run = new  FormIngresaAdministracion();
        run.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_txtadministracionMouseClicked

    private void txtingresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtingresarMouseClicked
        // TODO add your handling code here:
        FormIngresaUsuario run = new FormIngresaUsuario();
        run.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_txtingresarMouseClicked

    private void txtregistrarseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtregistrarseMouseClicked
        // TODO add your handling code here:
        FormRegistroUsuario run = new FormRegistroUsuario();
        run.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_txtregistrarseMouseClicked

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
            java.util.logging.Logger.getLogger(IniciaSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IniciaSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IniciaSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IniciaSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IniciaSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JLabel imgfondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panelboton;
    private javax.swing.JPanel panelboton1;
    private javax.swing.JPanel panelboton2;
    private javax.swing.JPanel panelobjetos;
    private javax.swing.JLabel txtadministracion;
    private javax.swing.JLabel txtingresar;
    private javax.swing.JLabel txtregistrarse;
    // End of variables declaration//GEN-END:variables
}
