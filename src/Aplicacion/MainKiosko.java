/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Aplicacion;

import Conceptos.Tipo;
import Util.GeneradorXMLTipo;
import Util.IdGenerator;
import Ventanas.VentanaKiosko;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * elaborado por Ignacio Elizondo y Felipe Pineda
 * carné: 2025088220 y <carné de felipe> (respectivamente)
 */
public class MainKiosko {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Tipo> listaTipos = new ArrayList();
        
        Tipo tipo1 = new Tipo();
        tipo1.setDescripcion("Uso del tren diario, aplica de lunes a viernes en horario regular de 5am a 9pm");
        tipo1.setId(IdGenerator.generarIdTipo());
        tipo1.setImagen("path/imagen.jpg");
        tipo1.setNombre("Diario");
        listaTipos.add(tipo1);

        Tipo tipo2 = new Tipo();
        tipo2.setDescripcion("Uso del tren de ida y vuelta el mismo día durante el horario regular de 5am a 9pm");
        tipo2.setId(IdGenerator.generarIdTipo());
        tipo2.setImagen("path/imagen2.jpg");
        tipo2.setNombre("Ida y vuelta");
        listaTipos.add(tipo2);
        
        Tipo tipo3 = new Tipo();
        tipo3.setDescripcion("Uso único del tren durante el horario regular de 5am a 9pm");
        tipo3.setId(IdGenerator.generarIdTipo());
        tipo3.setImagen("path/imagen3.jpg");
        tipo3.setNombre("Único uso");
        listaTipos.add(tipo3);
        
        
        try{
            OutputStream stream = new FileOutputStream("src/data/tiquetes.xml");
            GeneradorXMLTipo.Generar(listaTipos, stream);
            stream.close();    
        } catch(IOException e) {
            System.err.println("No es encontró el archivo " + e.getMessage());
        }

        VentanaKiosko kiosko = new VentanaKiosko();
        kiosko.setVisible(true);
        
    }
    
}
