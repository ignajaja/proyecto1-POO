/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Aplicacion;

import Util.CrearArchivoTipos;
import Ventanas.VentanaAdministracion;

/**
 * elaborado por Ignacio Elizondo y Felipe Pineda
 * carné: 2025088220 y <carné de felipe> (respectivamente)
 */
public class MainAdministrador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CrearArchivoTipos.Crear();
        
        VentanaAdministracion admin = new VentanaAdministracion();
        admin.setVisible(true);
    }
    
}
