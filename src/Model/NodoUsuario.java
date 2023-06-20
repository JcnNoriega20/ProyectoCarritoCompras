/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author wikicamus
 */
public class NodoUsuario {

    String nombre;
    String email;
    String numCel;
    String passwd;
    LocalDate fechaNac; 
    String gen;
    NodoUsuario sig, ant;
    
    public NodoUsuario(String nombre, String email, String numCel, String passwd, LocalDate fechaNac, String gen) {
        this.nombre = nombre;
        this.email = email;
        this.numCel = numCel;
        this.passwd = passwd;
        this.fechaNac = fechaNac;    
        this.gen = gen;
        this.sig = null;
        this.ant = null;
    }

}
