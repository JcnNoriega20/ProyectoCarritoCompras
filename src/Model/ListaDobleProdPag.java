package Model;

public class ListaDobleProdPag {
    NodoProdPagados cab;

    public ListaDobleProdPag() {
        cab=null;
    }
    
    public NodoProdPagados crearNuevoNodo(String id, NodoZapato shoePay){
        NodoProdPagados nuevoNodo = new NodoProdPagados(id, shoePay);
        return nuevoNodo;
    }
    
    public NodoProdPagados getUltimo() {
        if (cab == null) {
            return null;
        } else {
            NodoProdPagados aux = cab;
            while (aux.sig != null) {
                aux = aux.sig;
            }
            return aux;
        }
    }
    
    public void addFinal(String id, NodoZapato nodoPag){
        NodoProdPagados nuevoProdPag = crearNuevoNodo(id, nodoPag);

        if (nuevoProdPag != null) {
            if (cab == null) {
                cab = nuevoProdPag;

            } else {

                NodoProdPagados ultimo = getUltimo();
                ultimo.sig = nuevoProdPag;
                nuevoProdPag.ant = ultimo;
                System.out.println("Se ha registrado con exito");
            }
        } else {
        }
    }
    
    public void mostrarNodos() {
    NodoProdPagados actual = cab;

    while (actual != null) {
        System.out.println("ID: " + actual.id);
        System.out.println("Zapato: " + actual.shoesPay.genero+
                "\n"+actual.shoesPay.marca);
        System.out.println("--------------------");
        actual = actual.sig;
    }
}

    
    
}
