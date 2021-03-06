
package Formularios;

    
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import static Principal.Principal.*;
import java.util.Set;


public class FormVerCitasCliente extends javax.swing.JFrame {

    Conexion cc = new Conexion();
    Connection  con = cc.conectar();
    Statement st;

    public FormVerCitasCliente() {
        initComponents();
        this.setLocationRelativeTo(null);
        mostrardatos();
        limpiar();
    }
       public void eliminarDatos(){
       
       try{
           int filaseleccionada = tabla.getSelectedRow();
           
           String sql = "delete  from citas where Numero="+ tabla.getValueAt(filaseleccionada,0 );
           Statement st = con.createStatement();
           int n=st.executeUpdate(sql);
           
           if (n>=0) {
             JOptionPane.showMessageDialog(null, "CITA ELIMINADA EXITOSAMENTE");
           }
         
       }catch(Exception e){
             JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR EL USUARIO" + e.getMessage());
       }
   }
       
    public void actualizadatos(){
         String tiposolicitud = String.valueOf(fieldtiposolicitud.getSelectedItem());
         String horadecita = String.valueOf(fieldhoradecita.getSelectedItem());  
        
        int filaseleccionada = tabla.getSelectedRow();
        
        String dan = (String)tabla.getValueAt(filaseleccionada, 0);
        
        String sql = "update citas set NombrePropietario=?, NombreMascota=?, FechadeCita=?, HoradeCita=?, TipoSolicitud=? where Numero=?";
        if (fieldnombrepropietario.getText().isEmpty() || fieldnombremascota.getText().isEmpty() || fieldfechacita.getCalendar() == null ) {
                 JOptionPane.showMessageDialog(null, "PORFAVOR COMPLETE TODOS LOS CAMPOS", "", JOptionPane.WARNING_MESSAGE);
            }else{
                 try {

                     PreparedStatement pst = con.prepareStatement(sql);

                     pst.setString(1, fieldnombrepropietario.getText());
                     pst.setString(2, fieldnombremascota.getText());
                     pst.setString(3, ((JTextField) fieldfechacita.getDateEditor().getUiComponent()).getText());
                     pst.setString(4, horadecita);
                     pst.setString(5, tiposolicitud);
                     pst.setString(6, dan);
                     int n = pst.executeUpdate();

                     if (n >= 0) {
                         JOptionPane.showMessageDialog(null, "CITA ACTUALIZADA");                    
                     }

                 } catch (Exception e) {
                     JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR LA CITA" + e.getMessage());
                 }    
        }
    
    
    }
    
    
     
    public void mostrardatos(){
       String[] titulos = {"Numero","Nombre Propietario","Nombre Mascota", "Fecha Cita", "Hora Cita", "Tipo de Cita"};
       String[] registros = new String[6];
       String nombreusuario = nuevalista.getPrimero().getPersona().getNombre();
    
       DefaultTableModel model = new DefaultTableModel(null,titulos);
       
       String sql = "select * from citas  where NombrePropietario='"+nombreusuario+"'";
       
       try{
     
        Statement st=con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while(rs.next()){
          registros[0] = rs.getString("Numero");
          registros[1] = rs.getString("NombrePropietario");
          registros[2] = rs.getString("NombreMascota");
          registros[3] = rs.getString("FechadeCita");
          registros[4] = rs.getString("HoradeCita");
          registros[5] = rs.getString("TipoSolicitud");   
          model.addRow(registros);
        }        
        tabla.setModel(model);
        
       }catch(Exception e){
       JOptionPane.showMessageDialog(null, "ERROR AL LISTAR LA BD" + e.getMessage());
       }
       
    }
   
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        panelobjetos = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        fieldnombrepropietario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        fieldnombremascota = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        fieldfechacita = new com.toedter.calendar.JDateChooser();
        fieldhoradecita = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fieldtiposolicitud = new javax.swing.JComboBox<>();
        btneliminar = new javax.swing.JPanel();
        txteliminar = new javax.swing.JLabel();
        btnmodificar = new javax.swing.JPanel();
        txtmodificar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        imgfondo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelobjetos.setBackground(new java.awt.Color(41, 50, 60));
        panelobjetos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(37, 76, 120));
        jPanel7.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fieldnombrepropietario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldnombrepropietarioKeyTyped(evt);
            }
        });
        jPanel7.add(fieldnombrepropietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 160, -1));

        jLabel5.setFont(new java.awt.Font("Tw Cen MT Condensed", 2, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nombre propietario:");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 160, 20));

        fieldnombremascota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldnombremascotaKeyTyped(evt);
            }
        });
        jPanel7.add(fieldnombremascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 160, -1));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT Condensed", 2, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nombre mascota:");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 160, 20));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT Condensed", 2, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fecha de Cita:");
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 160, 20));

        fieldfechacita.setDateFormatString("yyyy,MM,d");
        jPanel7.add(fieldfechacita, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 160, -1));

        fieldhoradecita.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8:00 a.m", "9:00 a.m", "10:00 a.m", "11:00 a.m", "1:00 p.m", "2:00 p.m", "3:00 p.m", "4:00 p.m", "5:00 p.m" }));
        jPanel7.add(fieldhoradecita, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 160, -1));

        jLabel8.setFont(new java.awt.Font("Tw Cen MT Condensed", 2, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Hora de Cita");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 160, 20));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed", 2, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tipo de Solicitud:");
        jPanel7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 160, 20));

        fieldtiposolicitud.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Consulta Medica", "Vacunacion", "Corte de Pelo", "Ba??o" }));
        jPanel7.add(fieldtiposolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 160, -1));

        btneliminar.setBackground(new java.awt.Color(64, 104, 151));
        btneliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txteliminar.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        txteliminar.setForeground(new java.awt.Color(255, 255, 255));
        txteliminar.setText("    ELIMINAR");
        txteliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txteliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txteliminarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btneliminarLayout = new javax.swing.GroupLayout(btneliminar);
        btneliminar.setLayout(btneliminarLayout);
        btneliminarLayout.setHorizontalGroup(
            btneliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txteliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        btneliminarLayout.setVerticalGroup(
            btneliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txteliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel7.add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, -1, -1));

        btnmodificar.setBackground(new java.awt.Color(64, 104, 151));
        btnmodificar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtmodificar.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        txtmodificar.setForeground(new java.awt.Color(255, 255, 255));
        txtmodificar.setText("   MODIFICAR");
        txtmodificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtmodificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtmodificarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnmodificarLayout = new javax.swing.GroupLayout(btnmodificar);
        btnmodificar.setLayout(btnmodificarLayout);
        btnmodificarLayout.setHorizontalGroup(
            btnmodificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtmodificar, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        btnmodificarLayout.setVerticalGroup(
            btnmodificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtmodificar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel7.add(btnmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, -1, -1));

        panelobjetos.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, 380, 280));

        tabla.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        panelobjetos.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 620, 470));

        imgfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Pollitoimg.jpg"))); // NOI18N
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

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Flecha.png"))); // NOI18N
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
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
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void fieldnombrepropietarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldnombrepropietarioKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if ((c<'a' || c>'z') && (c<'A' || c>'Z')) evt.consume(); {

        }
    }//GEN-LAST:event_fieldnombrepropietarioKeyTyped

    private void fieldnombremascotaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldnombremascotaKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if ((c<'a' || c>'z') && (c<'A' || c>'Z')) evt.consume(); {

        }
    }//GEN-LAST:event_fieldnombremascotaKeyTyped

    private void txtmodificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtmodificarMouseClicked
        // TODO add your handling code here:
        if (fieldnombrepropietario.getText().isEmpty() || fieldnombremascota.getText().isEmpty() || fieldfechacita.getCalendar() == null ) {
                 JOptionPane.showMessageDialog(null, "PORFAVOR SELECCIONE UNA CITA", "", JOptionPane.WARNING_MESSAGE);
            }else{
            actualizadatos();
            mostrardatos();
            limpiar();    
        }
  
    }//GEN-LAST:event_txtmodificarMouseClicked

    private void txteliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txteliminarMouseClicked
        // TODO add your handling code here:
        if (fieldnombrepropietario.getText().isEmpty() || fieldnombremascota.getText().isEmpty() || fieldfechacita.getCalendar() == null ) {
                 JOptionPane.showMessageDialog(null, "PORFAVOR SELECCIONE UNA CITA", "", JOptionPane.WARNING_MESSAGE);
            }else{
            int opcion = JOptionPane.showConfirmDialog(null,"??ESTA SEGURO QUE DESEA ELIMINAR ESTA CITA?");
         if (opcion == 0) {
             eliminarDatos();
             mostrardatos();           
             limpiar(); 
        }
        }
        
    }//GEN-LAST:event_txteliminarMouseClicked

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
      
        int filaseleccionada = tabla.rowAtPoint(evt.getPoint());
        
        fieldnombrepropietario.setText(tabla.getValueAt(filaseleccionada, 1).toString());
        fieldnombremascota.setText(tabla.getValueAt(filaseleccionada, 2).toString());
        fieldfechacita.setDate((java.sql.Date.valueOf(tabla.getValueAt(filaseleccionada, 3).toString())));
        fieldhoradecita.setSelectedItem(tabla.getValueAt(filaseleccionada, 4));
        fieldtiposolicitud.setSelectedItem(tabla.getValueAt(filaseleccionada, 5));
    }//GEN-LAST:event_tablaMouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        FormMenuPropietario run = new FormMenuPropietario();
        run.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        IniciaSesion run = new IniciaSesion();
       run.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_jLabel3MouseClicked

    public void limpiar(){
    fieldnombrepropietario.setText("");
    fieldnombremascota.setText("");
    fieldfechacita.setCalendar(null);
    fieldhoradecita.setSelectedItem(null);
    fieldtiposolicitud.setSelectedItem(null);
    }
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
            java.util.logging.Logger.getLogger(FormVerCitasCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormVerCitasCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormVerCitasCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormVerCitasCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormVerCitasCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JPanel btneliminar;
    private javax.swing.JPanel btnmodificar;
    private com.toedter.calendar.JDateChooser fieldfechacita;
    private javax.swing.JComboBox<String> fieldhoradecita;
    private javax.swing.JTextField fieldnombremascota;
    private javax.swing.JTextField fieldnombrepropietario;
    private javax.swing.JComboBox<String> fieldtiposolicitud;
    private javax.swing.JLabel imgfondo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelobjetos;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel txteliminar;
    private javax.swing.JLabel txtmodificar;
    // End of variables declaration//GEN-END:variables
}
