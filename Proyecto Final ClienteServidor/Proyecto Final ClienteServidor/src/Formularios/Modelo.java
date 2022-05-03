/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import java.util.ArrayList;
import Formularios.Mascotas;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import static Principal.Principal.*;

/**
 *
 * @author jimen
 */
public class Modelo {
    Conexion cc = new Conexion();
    Connection  con = cc.conectar();
    public ArrayList<Mascotas> getMascotas(){
        
        String nombrepropietario =  nuevalista.getPrimero().getPersona().getNombre();
        Statement stmt;
        ResultSet rs;
        
        ArrayList<Mascotas> listamascotas = new ArrayList<>();
    
        try{
        stmt = con.createStatement();
        rs = stmt.executeQuery("select * from mascotas where NombrePropietario='"+nombrepropietario +"'");
        
        while(rs.next()){
        Mascotas mascota = new Mascotas();
        
        mascota.setNombremascota(rs.getString("NombreMascota"));
        listamascotas.add(mascota);
        
        }
        
        }catch(Exception e){
        
        
        }
        return listamascotas;
    }
}
