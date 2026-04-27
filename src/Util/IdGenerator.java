package Util;

// usamos un IdGenerator con un obtenerIdNueva() para generar una nueva Id para cada cosa

import Conceptos.Precio;
import Conceptos.Tipo;
import Conceptos.Tiquete;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;


public class IdGenerator {
    private static int idTipos = -1;
    private static int idPreci = -1;
    private static int idTique = -1;
    
    private static void inicializarIdTipo(){
        if (idTipos != -1) return;
        idTipos = 0;
        try{
            File xmlFile = new File("src/data/tipos.xml");
            if(!xmlFile.exists()) return;
            ArrayList<Tipo> tipos = util.CargadorXMLTipo.Cargar(new FileInputStream(xmlFile));
            for (Tipo t: tipos){
                int numero = Integer.parseInt(t.getId().split("-")[1]);
                if (numero >= idTipos) idTipos = numero +1;
            }
        } catch(Exception e) {
            System.err.println("Error al inicalizar las identificaciones de los tipos. " + e.getMessage());
        }
    }
    
    private static void inicializarIdPrecio(){
        if (idPreci != -1) return;
        idPreci = 0;
        try{
            File xmlFile = new File("src/data/precios.xml");
            if(!xmlFile.exists()) return;
            ArrayList<Precio> precios = util.CargadorXMLTipo.Cargar(new FileInputStream(xmlFile));
            for (Precio p: precios){
                int numero = Integer.parseInt(p.getId().split("-")[1]);
                if (numero >= idPreci) idPreci = numero +1;
            }
        } catch(Exception e) {
            System.err.println("Error al inicalizar las identificaciones de los precios. " + e.getMessage());
        }
    }
    
   private static void inicializarIdTiquete() {
        if (idTique != -1) return;
        idTique = 0;
        try {
            File xmlFile = new File("src/data/tiquetes.xml");
            if (!xmlFile.exists()) return;

            ArrayList<Tiquete> tiquetes = util.CargadorXMLTiquete.Cargar(new FileInputStream(xmlFile));
            if (tiquetes.isEmpty()) return;

            for (Tiquete t : tiquetes) {
                try {
                    int numero = Integer.parseInt(t.getId().split("-")[1]);
                    if (numero >= idTique) idTique = numero + 1;
                } catch (NumberFormatException e) {
                    System.err.println("ID con formato inválido: " + t.getId());
                }
            }
        } catch (Exception e) {
            System.err.println("Error al inicializar idTiquetes: " + e.getMessage());
    }
}
    public static String generarIdTipo(){
        inicializarIdTipo();
        return String.format("TIPO-%03d", idTipos++);
    }
    public static String generarIdPrecio(){
        inicializarIdPrecio();
        return String.format("PREC-%03d", idPreci++);
    }
    public static String generarIdTiquete(){
        inicializarIdTiquete();
        return String.format("TIQU-%03d", idTique++);
    }
    
}
