package Conceptos;

import java.util.Date;

public class Precio {
    String id;
    String precio;
    Date fecha;
    String tipo; // esto es el id del tipo

    public String getId() {
        return id;
    }

    public void setId(String idPrecio) {
        this.id = idPrecio;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Precio(String id, String precio, Date fecha, String tipo) {
        this.id = id;
        this.precio = precio;
        this.fecha = fecha;
        this.tipo = tipo;
    }
    
    public Precio(){
        
    }
    
    
}
