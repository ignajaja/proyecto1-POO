/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import Conceptos.Precio;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author ignac
 */
public class GeneradorXMLPrecio {
    public static void Generar(List<Precio> precios, OutputStream salida){
        PrintWriter pw = new PrintWriter(salida);
        pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        pw.println("<precios>");
        
        for (Precio p : precios) {
            pw.println("    <precio id=\"" + p.getId() + "\">");
            pw.println("        <tipo>" + p.getTipo() + "</tipo>");
            pw.println("        <precio>" + p.getPrecio() + "</precio>");
            pw.println("        <fecha>" + p.getFecha() + "</fecha>");
            pw.println("    </precio>");
        }
        pw.println("</precios>");
        pw.flush();
        
    }
}
