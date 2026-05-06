package Conceptos;

public class Precio {
    String id;
    String monto;
    String fecha;
    String tipo; // esto es el id del tipo

    public String getId() {
        return id;
    }

    public void setId(String idPrecio) {
        this.id = idPrecio;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Precio(String id, String monto, String fecha, String tipo) {
        this.id = id;
        this.monto = monto;
        this.fecha = fecha;
        this.tipo = tipo;
    }
    
    public Precio(){
        
    }
    
    
}
