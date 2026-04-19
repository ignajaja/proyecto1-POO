package Util;

// usamos un IdGenerator con un obtenerIdNueva() para generar una nueva Id para cada cosa

/**
no se puede devolver el número, si algún objeto es borrado o vence como un tiquete
ya queda con ese ID para siempre, no se pueden devolver ni dar a uno nuevo si
ya fue tomado en algún punto
 */


/**
de momento todas las ID son diferentes entre conceptos, 
si ya hay un tiquete 1 no puede haber ni un precio ni un tipo con el mismo id, 
y se están tratando iniciando desde el 1 y es un número entero que suma se suma 
en uno cada vez que es llamado
*/

public class IdGenerator {
    int Id = 0;
    
    public int GenerarIdNueva(){
        Id++;
        return Id;
    }
    
    public int obtenerUltimaId(){
        return Id;
    }
}
