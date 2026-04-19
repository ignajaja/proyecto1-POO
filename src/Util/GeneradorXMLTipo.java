/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import Conceptos.Tipo;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author ignac
 */
public class GeneradorXMLTipo {
    public static void Generar(List<Tipo> tipos, OutputStream salida){
        PrintWriter pw = new PrintWriter(salida);
        pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        pw.println("<tipos>");
        
        for (Tipo t : tipos) {
            pw.println("    <tipo id=\"" + t.getId()+ "\">");
            pw.println("        <nombre>" + t.getNombre() + "</nombre>");
            pw.println("        <descripcion>" + t.getDescripcion()+ "</descripcion>");
            pw.println("        <imagen>" + t.getImagen()+ "</imagen>");
            pw.println("    </tipo>");
        }
        pw.println("</tipos>");
        pw.flush();
        
    }
}
