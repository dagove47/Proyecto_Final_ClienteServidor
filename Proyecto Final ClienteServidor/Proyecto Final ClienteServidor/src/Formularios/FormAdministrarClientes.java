
package Formularios;

    
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import java.util.Set;
import javax.swing.RowFilter;

import javax.swing.table.TableRowSorter;

public class FormAdministrarClientes extends javax.swing.JFrame {

    Conexion cc = new Conexion();
    Connection  con = cc.conectar();
    Statement st;
    DefaultTableModel  model ;
    public FormAdministrarClientes() {
        initComponents();
        this.setLocationRelativeTo(null);
        mostrardatos();
    }
    public void eliminarDatos(){
       
       try{
           int filaseleccionada = tabla.getSelectedRow();
           
           String sql = "delete from usuarios where Numero="+ tabla.getValueAt(filaseleccionada,0 );
           Statement st = con.createStatement();
           int n=st.executeUpdate(sql);
           
           if (n>=0) {
             JOptionPane.showMessageDialog(null, "CLIENTE ELIMINADO EXITOSAMENTE");
           }
         
       }catch(Exception e){
             JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR EL CLIENTE" + e.getMessage());
       }
   }
     
    public void actualizadatos(){
         
        int filaseleccionada = tabla.getSelectedRow();
        
        String contraseña = String.valueOf(fieldcontraseña.getPassword());
        String dan = (String)tabla.getValueAt(filaseleccionada, 0);
        
        String sql = "update usuarios set Nombre=?, Apellido1=?, Apellido2=?, Cedula=?, Telefono=? , Contraseña=? where Numero=?";
        if (fieldnombre.getText().isEmpty() || fieldapellido1.getText().isEmpty() || fieldapellido2.getText().isEmpty() || fieldcedula.getText().isEmpty() 
            || fieldtelefono.getText().isEmpty() || contraseña.isEmpty()) {
                 JOptionPane.showMessageDialog(null, "PORFAVOR COMPLETE TODOS LOS CAMPOS", "", JOptionPane.WARNING_MESSAGE);
            }else{
                 try {

                     PreparedStatement pst = con.prepareStatement(sql);

                     pst.setString(1, fieldnombre.getText());
                     pst.setString(2, fieldapellido1.getText());
                     pst.setString(3, fieldapellido2.getText());
                     pst.setString(4, fieldcedula.getText());
                     pst.setString(5, fieldtelefono.getText());
                     pst.setString(6, contraseña);
                     pst.setString(7, dan);
                     int n = pst.executeUpdate();

                     if (n >= 0) {
                         JOptionPane.showMessageDialog(null, "CLIENTE ACTUALIZADO");                    
                     }

                 } catch (Exception e) {
                     JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR EL CLIENTE" + e.getMessage());
                 }    
        }
    
    
    }
   public void mostrardatos(){
       String[] titulos = {"Numero","Nombre","Apellido1", "Apellido2", "Cedula", "Telefono","Contraseña"};
       String[] registros = new String[7];

         model = new DefaultTableModel(null, titulos);
       
       String sql = "select * from usuarios ";
       
       try{
     
        Statement st=con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while(rs.next()){
          registros[0] = rs.getString("Numero");
          registros[1] = rs.getString("Nombre");
          registros[2] = rs.getString("Apellido1");
          registros[3] = rs.getString("Apellido2");
          registros[4] = rs.getString("Cedula");
          registros[5] = rs.getString("Telefono");  
          registros[6] = rs.getString("Contraseña"); 
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtnombre = new javax.swing.JLabel();
        txtapellido2 = new javax.swing.JLabel();
        txtapellido1 = new javax.swing.JLabel();
        txtcedula = new javax.swing.JLabel();
        fieldnombre = new javax.swing.JTextField();
        fieldapellido1 = new javax.swing.JTextField();
        fieldapellido2 = new javax.swing.JTextField();
        fieldcedula = new javax.swing.JTextField();
        txttelefono = new javax.swing.JLabel();
        txtcontraseña = new javax.swing.JLabel();
        fieldtelefono = new javax.swing.JTextField();
        fieldcontraseña = new javax.swing.JPasswordField();
        btnmodificar = new javax.swing.JPanel();
        txtmodificar = new javax.swing.JLabel();
        btneliminar = new javax.swing.JPanel();
        txteliminar = new javax.swing.JLabel();
        imgfondo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelobjetos.setBackground(new java.awt.Color(41, 50, 60));
        panelobjetos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 24)); // NOI18N
        panelobjetos.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 30, 146, 40));

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
        tabla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tablaKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        panelobjetos.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 1010, 260));

        jPanel1.setBackground(new java.awt.Color(37, 76, 120));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        txtnombre.setFont(new java.awt.Font("Tw Cen MT Condensed", 2, 24)); // NOI18N
        txtnombre.setForeground(new java.awt.Color(255, 255, 255));
        txtnombre.setText("Nombre :");

        txtapellido2.setFont(new java.awt.Font("Tw Cen MT Condensed", 2, 24)); // NOI18N
        txtapellido2.setForeground(new java.awt.Color(255, 255, 255));
        txtapellido2.setText("Apellido 2:");

        txtapellido1.setFont(new java.awt.Font("Tw Cen MT Condensed", 2, 24)); // NOI18N
        txtapellido1.setForeground(new java.awt.Color(255, 255, 255));
        txtapellido1.setText("Apellido 1 :");

        txtcedula.setFont(new java.awt.Font("Tw Cen MT Condensed", 2, 24)); // NOI18N
        txtcedula.setForeground(new java.awt.Color(255, 255, 255));
        txtcedula.setText("Cedula:");

        txttelefono.setFont(new java.awt.Font("Tw Cen MT Condensed", 2, 24)); // NOI18N
        txttelefono.setForeground(new java.awt.Color(255, 255, 255));
        txttelefono.setText("Telefono:");

        txtcontraseña.setFont(new java.awt.Font("Tw Cen MT Condensed", 2, 24)); // NOI18N
        txtcontraseña.setForeground(new java.awt.Color(255, 255, 255));
        txtcontraseña.setText("Contraseña:");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(fieldnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtapellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(fieldapellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(fieldcedula, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtapellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(fieldapellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcontraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fieldtelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(fieldcontraseña)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttelefono)
                    .addComponent(fieldtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtapellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldapellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcontraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldcontraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtapellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldapellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldcedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(13, 13, 13))
        );

        panelobjetos.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 580, 200));

        imgfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Conejoimg.jpg"))); // NOI18N
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

    private void txtmodificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtmodificarMouseClicked
        // TODO add your handling code here:
       actualizadatos();
       mostrardatos();
       limpiar();
    }//GEN-LAST:event_txtmodificarMouseClicked

    private void txteliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txteliminarMouseClicked
        // TODO add your handling code here:
       eliminarDatos();
       mostrardatos();
       limpiar();
    }//GEN-LAST:event_txteliminarMouseClicked
public void limpiar(){
    fieldnombre.setText("");
    fieldapellido1.setText("");        
    fieldapellido2.setText("");
    fieldcedula.setText("");
    fieldtelefono.setText("");
    fieldcontraseña.setText("");

}
    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        // TODO add your handling code here:
        int filaseleccionada = tabla.rowAtPoint(evt.getPoint());
        
        fieldnombre.setText(tabla.getValueAt(filaseleccionada, 1).toString());
        fieldapellido1.setText(tabla.getValueAt(filaseleccionada, 2).toString());
        fieldapellido2.setText(tabla.getValueAt(filaseleccionada, 3).toString());
        fieldcedula.setText(tabla.getValueAt(filaseleccionada, 4).toString());
        fieldtelefono.setText(tabla.getValueAt(filaseleccionada, 5).toString());
        fieldcontraseña.setText(tabla.getValueAt(filaseleccionada, 6).toString());
    }//GEN-LAST:event_tablaMouseClicked

    private void tablaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaKeyTyped
        // TODO add your handling code here:
         
        
    }//GEN-LAST:event_tablaKeyTyped

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        FormAdministracion run = new FormAdministracion();
        run.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        IniciaSesion run = new IniciaSesion();
       run.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_jLabel3MouseClicked

   
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
            java.util.logging.Logger.getLogger(FormAdministrarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAdministrarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAdministrarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAdministrarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new FormAdministrarClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JPanel btneliminar;
    private javax.swing.JPanel btnmodificar;
    private javax.swing.JTextField fieldapellido1;
    private javax.swing.JTextField fieldapellido2;
    private javax.swing.JTextField fieldcedula;
    private javax.swing.JPasswordField fieldcontraseña;
    private javax.swing.JTextField fieldnombre;
    private javax.swing.JTextField fieldtelefono;
    private javax.swing.JLabel imgfondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelobjetos;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel txtapellido1;
    private javax.swing.JLabel txtapellido2;
    private javax.swing.JLabel txtcedula;
    private javax.swing.JLabel txtcontraseña;
    private javax.swing.JLabel txteliminar;
    private javax.swing.JLabel txtmodificar;
    private javax.swing.JLabel txtnombre;
    private javax.swing.JLabel txttelefono;
    // End of variables declaration//GEN-END:variables
}
