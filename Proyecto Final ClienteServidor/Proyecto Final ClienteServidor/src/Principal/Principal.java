/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;


import Formularios.IniciaSesion;
import ListaCircularSimple.ListaCircularSimple;
import ListaCircularSimple2.ListaCircularSimple2;

/**
 *
 * @author jimen
 */
public class Principal {
    public static ListaCircularSimple nuevalista = new  ListaCircularSimple();
    public static  ListaCircularSimple2 nuevalista2 = new  ListaCircularSimple2();
    
    public static void main(String[]args){
        IniciaSesion run = new  IniciaSesion();
        run.setVisible(true);
    
    }
}
