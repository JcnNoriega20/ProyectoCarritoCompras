package Model;

public class NodoZapato {
    String marca;
    String tipo;
    double precio;
    String genero;
    String talla;
    NodoZapato sig;

    public NodoZapato(String marca, String tipo, double precio, String genero, String talla) {
        this.marca = marca;
        this.tipo = tipo;
        this.precio = precio;
        this.genero = genero;
        this.talla = talla;
        sig=null;
    }
    
    
}
