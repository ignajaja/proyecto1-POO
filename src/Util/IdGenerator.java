package Util;

// usamos un IdGenerator con un obtenerIdNueva() para generar una nueva Id para cada cosa

public class IdGenerator {
    private static int idTipos = 0;
    private static int idPreci = 0;
    private static int idTique = 0;
    
    public static String generarIdTipo(){
        return String.format("TIPO-%03d", idTipos++);
    }
    public static String generarIdPrecio(){
        return String.format("PREC-%03d", idPreci++);
    }
    public static String generarIdTiquete(){
        return String.format("TIPO-%03d", idTique++);
    }
    
}
