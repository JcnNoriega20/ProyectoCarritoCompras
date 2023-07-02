package Model;

public class ListaDobleZapato {

    NodoZapato cabShoes;

    public ListaDobleZapato() {
        cabShoes = null;
    }

    public NodoZapato crearNodo(String marca, String tipo, double precio, String genero, String talla) {
        try {
            NodoZapato nuevoNodo = new NodoZapato(marca, tipo, precio, genero, talla);
            System.out.println("Nodo nuevo creado");
            return nuevoNodo;

        } catch (Exception e) {
            return null;
        }

    }

    public NodoZapato getUltimo() {
        if (cabShoes == null) {
            return null;
        } else {
            NodoZapato aux = cabShoes;
            while (aux.sig != null) {
                aux = aux.sig;
            }
            return aux;
        }
    }

    public void addFinal(String marca, String tipo, String precio, String genero, String talla) {
        NodoZapato nuevoZap = crearNodo(marca, tipo, Double.parseDouble(precio), genero, talla);
        if (cabShoes == null) {
            cabShoes = nuevoZap;
            System.out.println("Lista creada y agregado");
        } else {
            NodoZapato ultimo = getUltimo();
            ultimo.sig = nuevoZap;
            nuevoZap.ant = ultimo;
            System.out.println("Nodo agregado al final de la lista");

        }

    }
}
