/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import Conceptos.Tiquete;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author ignac
 */
public class GeneradorXMLTiquete {
    public static void Generar(List<Tiquete> tiquetes, OutputStream salida){
        PrintWriter pw = new PrintWriter(salida);
        pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        pw.println("<tiquetes>");
        
        for (Tiquete t : tiquetes) {
            pw.println("    <tiquete id=\"" + t.getId() + "\">");
            pw.println("        <nombre>" + t.getNombre() + "</nombre>");
            pw.println("        <precio_id>" + t.getPrecioId()+ "</precio_id>");
            pw.println("    </tiquete>");
        }
        pw.println("</tiquetes>");
        pw.flush();
        
    }
}
