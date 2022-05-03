/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
        
public class Conexion {
    Connection conectar = null;
    
    public Connection conectar(){
      try{
          Class.forName("com.mysql.cj.jdbc.Driver");
          conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectoclienteservidor", "root", "" );

      
      }catch(Exception e){
       JOptionPane.showMessageDialog(null, "No se conecto a la bd" + e.getMessage());
      }
    return conectar;
    }
}
