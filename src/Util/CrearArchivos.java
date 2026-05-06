/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import Conceptos.Tipo;
import Conceptos.Precio;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 *
 * @author ignac
 */
public class CrearArchivos {
    public static void Crear(){
//        File archivo = new File("src/Data/tipos.xml");
//        if (archivo.exists()){ // esto verifica si el archivo existe, si sí lo retorna, sino lo crea y lo llena
//            return;
//        }
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
        
        ArrayList<Precio> listaPrecios = new ArrayList();
        
        Precio precio1 = new Precio(IdGenerator.generarIdPrecio(), "20000", "10-05-2026", "TIPO-001");
        Precio precio2 = new Precio(IdGenerator.generarIdPrecio(), "4000", "10-05-2026", "TIPO-002");
        Precio precio3 = new Precio(IdGenerator.generarIdPrecio(), "2500", "10-05-2026", "TIPO-003");
        
        listaPrecios.add(precio1);
        listaPrecios.add(precio2);
        listaPrecios.add(precio3);


        
//        File tiquetesFile = new File("src/data/tiquetes.xml");
//        if (!tiquetesFile.exists()) {
//            try {
//                tiquetesFile.getParentFile().mkdirs();
//                OutputStream st = new FileOutputStream(tiquetesFile);
//                st.write("<tiquetes>\n</tiquetes>\n".getBytes());
//                st.close();
//            } catch (IOException e) {
//                System.err.println("No se pudo crear tiquetes.xml: " + e.getMessage());
//            }
//        }
//
//        // También crear precios.xml vacío si no existe
//        File preciosFile = new File("src/data/precios.xml");
//        if (!preciosFile.exists()) {
//            try {
//                preciosFile.getParentFile().mkdirs();
//                OutputStream st = new FileOutputStream(preciosFile);
//                st.write("<precios>\n</precios>\n".getBytes());
//                st.close();
//            } catch (IOException e) {
//                System.err.println("No se pudo crear precios.xml: " + e.getMessage());
//            }
//        }
        
        try{
                OutputStream stream = new FileOutputStream("src/Data/precios.xml");
                GeneradorXMLPrecio.Generar(listaPrecios, stream);
                stream.close();    
            } catch(IOException e) {
                System.err.println("No es encontró el archivo " + e.getMessage());
        }        
        
        try{
                OutputStream stream = new FileOutputStream("src/Data/tipos.xml");
                GeneradorXMLTipo.Generar(listaTipos, stream);
                stream.close();    
            } catch(IOException e) {
                System.err.println("No es encontró el archivo " + e.getMessage());
        }
    }
}
