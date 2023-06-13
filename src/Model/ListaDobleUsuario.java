/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 *
 * @author wikicamus
 */
public class ListaDobleUsuario {
    NodoUsuario cab;

    public ListaDobleUsuario() {
        cab=null;
    }
    
    public void alerta(String title, String msj){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msj);

        alert.showAndWait();
    }
    
    public NodoUsuario getBuscarCod(String correo) {
        if (cab == null) {
            return null;
        } else {
            NodoUsuario aux = cab;
            while (aux != null) {
                if ((aux.email).equals(correo)) {
                    return aux;
                } else {
                    aux = aux.sig;
                }
            }
            return null;
        }
    }

    public boolean getEsVacia() {
        return cab == null ? true : false;
    }
    
    public NodoUsuario getCrearNodo(
            TextField txtNombre,
            TextField txtEmail,
            TextField txtNumCel,
            TextField txtPasswd,
            TextField txtfechaNac,
            ComboBox cmbGender) {
        NodoUsuario buscar = null;
        try {
            buscar = getBuscarCod(txtEmail.getText());
            if (buscar != null) {
                alerta("Aviso", "Este usuario ya se encuentra registrado");
                return null;
            }
            //Una vez capturados los datos, se crea en memoria el Nodo
            NodoUsuario nuevoNodo = new NodoUsuario(
                    txtNombre.getText(),                    
                    txtEmail.getText(),
                    txtNumCel.getText(),
                    txtPasswd.getText(),
                    txtfechaNac.getText(),
                    cmbGender.getValue().toString());
            return nuevoNodo;
        } catch (Exception e) {
            alerta("Aviso", ""+e);
            return null;
        }
    }
    
    public NodoUsuario getUltimo() {
        if (cab == null) {
            return null;
        } else {
            NodoUsuario aux = cab;
            while (aux.sig != null) {
                aux = aux.sig;
            }
            return aux;
        }
    }

    //Este método agrega un nuevo Nodo al final de la lista.
    public void setAddFinal(
            TextField txtNombre,
            TextField txtEmail,
            TextField txtNumCel,
            TextField txtPasswd,
            TextField txtfechaNac,
            ComboBox cmbGender) {
        //Creamos el nuevo Nodo a registrar
        NodoUsuario nuevoUser = getCrearNodo(
                txtNombre,
                txtEmail,
                txtNumCel,
                txtPasswd,
                txtfechaNac,
                cmbGender);
                    
        
        if (nuevoUser != null) {
            if (cab == null) {
                cab = nuevoUser;
                
            } else {

                NodoUsuario ultimo = getUltimo();
                ultimo.sig = nuevoUser;
                nuevoUser.ant = ultimo;
                alerta("Aviso", "Se ha registrado con exito");
            }
        } else {
        }
    }
    
    
    
}
