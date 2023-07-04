package Model;

public class ListaColaZapato {

    NodoZapato primero, ultimo;

    public ListaColaZapato() {
        primero = ultimo = null;
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

    public void addNodo(String marca, String tipo, String precio, String genero, String talla) {
        NodoZapato nuevoZap = crearNodo(marca, tipo, Double.parseDouble(precio), genero, talla);
        if (primero == null) {
            primero = nuevoZap;
            ultimo = nuevoZap;
            System.out.println("Lista creada y agregado");
        } else {

            ultimo.sig = nuevoZap;
            ultimo = nuevoZap;
            System.out.println("Nodo agregado al final de la lista");
            mostrarNodos();

        }

    }

    public void pasarDatosAListaDoble(ListaColaZapato cola, ListaDobleProdPag listaDoble) {
        System.out.println("Metodo inicializado");
        NodoZapato actual = cola.primero;
        int contador = 1;

        while (actual != null) {
            String id = "ID " + contador;
            listaDoble.addFinal(id, actual);
            actual = actual.sig;
            contador++;
        }
    }

    public void mostrarNodos() {
        NodoZapato actual = primero;
        int contador = 1;

        while (actual != null) {
            System.out.println("Nodo " + contador + ":");
            System.out.println("Marca: " + actual.marca);
            System.out.println("Tipo: " + actual.tipo);
            System.out.println("Precio: " + actual.precio);
            System.out.println("Género: " + actual.genero);
            System.out.println("Talla: " + actual.talla);
            System.out.println("--------------------");

            actual = actual.sig;
            contador++;
        }
    }
}
