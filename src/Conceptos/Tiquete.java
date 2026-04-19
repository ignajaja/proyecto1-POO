package Conceptos;

public class Tiquete {
    String id;
    String nombre;
    String precio_id;

    public String getId() {
        return id;
    }

    public void setId(String idTiquete) {
        this.id = idTiquete;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecioId() {
        return precio_id;
    }

    public void setPrecioId(String precio_id) {
        this.precio_id = precio_id;
    }

    public Tiquete(String idTiquete, String nombre, String precio_id) {
        this.id = idTiquete;
        this.nombre = nombre;
        this.precio_id = precio_id;
    }
    
    public Tiquete(){
        
    }
}
