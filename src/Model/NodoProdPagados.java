/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Miguel
 */
public class NodoProdPagados {
    String id;
    NodoZapato shoesPay;
    NodoProdPagados sig;
    NodoProdPagados ant;

    public NodoProdPagados(String id, NodoZapato shoesBuy) {
        this.id = id;
        this.shoesPay = shoesBuy;
        sig=ant=null;
    }
}
