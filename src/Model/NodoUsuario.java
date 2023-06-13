/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author wikicamus
 */
public class NodoUsuario {
    String nombre;
    String email;
    String numCel;
    String cont;
    String fechaNac;
    String edad;
    NodoUsuario sig, ant;

    public NodoUsuario(String nombre, String email, String numCel, String cont, String fechaNac, String edad) {
        this.nombre = nombre;
        this.email = email;
        this.numCel = numCel;
        this.cont = cont;
        this.fechaNac = fechaNac;
        this.edad = edad;
        this.sig = null;
        this.ant = null;
    }

    
}
