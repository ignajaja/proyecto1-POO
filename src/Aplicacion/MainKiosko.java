/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Aplicacion;
//
//import Conceptos.Tipo;
//import Util.CrearArchivoTipos;
//import Util.GeneradorXMLTipo;
//import Util.IdGenerator;
import Util.CrearArchivoTipos;
import Ventanas.VentanaKiosko;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.ArrayList;

/**
 * elaborado por Ignacio Elizondo y Felipe Pineda
 * carné: 2025088220 y <carné de felipe> (respectivamente)
 */
public class MainKiosko {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        CrearArchivoTipos.Crear();

        VentanaKiosko kiosko = new VentanaKiosko();
        kiosko.setVisible(true);
        
    }
    
}
