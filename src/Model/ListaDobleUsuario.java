/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.format.DateTimeFormatter;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author wikicamus
 */
public class ListaDobleUsuario {

    NodoUsuario cab;

    public ListaDobleUsuario() {
        cab = null;
    }

    public void alerta(String title, String msj) {
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

    public boolean validarCuenta(TextField txtCorreo, TextField txtPass) {
        boolean validar = true;
        if (txtCorreo.getText().isEmpty() && txtPass.getText().isEmpty()) {
            alerta("Aviso", "Los campos están vacios");
            validar = false;
        } else {
            if (cab == null) {
                System.out.println("cabecera vacia");
                validar = false;
            } else {
                NodoUsuario buscar = getBuscarCod(txtCorreo.getText());
                if (buscar != null) {
                    if ((buscar.cont).equals(txtPass.getText())) {
                        System.out.println("contraseña correcta");
                        alerta("Bienvenido", "Bienvenido al proyecto de Juan Noriega");
                        validar = true;
                    } else {
                        System.out.println("contraseña incorrecta");
                        alerta("Aviso", "Contraseña incorrecta");
                        txtPass.setText("");
                        txtPass.requestFocus();
                        validar = false;
                    }
                } else {
                    alerta("Aviso", "Correo no registrado o erroneo, por favor verifique");
                    txtCorreo.setText("");
                    txtPass.setText("");
                    txtCorreo.requestFocus();
                    validar = false;

                }

            }
        }

        return validar;
    }

    public boolean getEsVacia() {
        return cab == null ? true : false;
    }

    /*public nodo getCrearNodo(
        JTextField Jtfcod,
        JTextField Jtfnoms,
        JTextField JtfNHorasT,
        JTextField JtfVHoraT,
        JTextField JtfNhorasE){
        nodo buscar = null;        
        try {                        
            buscar = getBuscarCod(Jtfcod.getText());
            if (buscar != null) {
                JOptionPane.showMessageDialog(null,
                    "Error: Este código ya se encuentra "
                    + "registrado.  Reemplazar código!"); 
                Jtfcod.setText("");
                Jtfcod.requestFocus();                
                return null;
            }            
            //Una vez capturados los datos, se crea en memoria el nodo
            nodo info = new nodo(
                Jtfcod.getText(), 
                Jtfnoms.getText(), 
                Double.parseDouble(JtfNHorasT.getText()), 
                Double.parseDouble(JtfVHoraT.getText()), 
                Double.parseDouble(JtfNhorasE.getText()));
            return info;
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "" + e);
            return null;
        }
    }*/
    public void mostrarUser() {
        if (cab == null) {
            alerta("aviso", "Cabecera vacia");
        } else {
            NodoUsuario mostrarNodo = cab;
            while (mostrarNodo != null) {
                alerta("Mostrar nodos", "Nombre: " + mostrarNodo.nombre + "\n"
                        + "Correo: " + mostrarNodo.email);
                mostrarNodo = mostrarNodo.sig;

            }
        }
    }

    public NodoUsuario getCrearNodo(
            TextField txtNombre,
            TextField txtEmail,
            TextField txtNumCel,
            TextField txtPasswd,
            DatePicker txtfechaNac,
            ComboBox cmbGender) {
        NodoUsuario buscar = null;
        try {
            buscar = getBuscarCod(txtEmail.getText());
            if (buscar != null) {
                alerta("Aviso", "Este usuario ya se encuentra registrado");
                return null;
            }
            //Una vez capturados los datos, se crea en memoria el Nodo
            
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            NodoUsuario nuevoNodo = new NodoUsuario(
                    txtNombre.getText(),
                    txtEmail.getText(),
                    txtNumCel.getText(),
                    txtPasswd.getText(),
                    txtfechaNac.getValue().format(dateFormat).toString(),
                    cmbGender.getValue().toString());
            System.out.println("usuario se ha registrado");
            return nuevoNodo;
        } catch (Exception e) {
            alerta("Aviso", "" + e);
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

    public void setAddInicio(
            TextField txtNombre,
            TextField txtEmail,
            TextField txtNumCel,
            TextField txtPasswd,
            DatePicker txtfechaNac,
            ComboBox cmbGender) {
        //Creamos el nodo que se desea registrar
        //en la lista
        NodoUsuario info = getCrearNodo(txtNombre, txtEmail, txtNumCel, txtPasswd, txtfechaNac, cmbGender);

        if (info != null) {
            if (cab == null) {
                cab = info;
                alerta("Aviso", "Se ha registrado");
            } else {
                //Enlazamos el nuevo nodo a la lista
                info.sig = cab;
                cab.ant = info;
                //Ahora se debe mover cab al primer 
                //nuevo elemento
                cab = info;
                alerta("Aviso", "Se ha registrado al inicio ");
            }
        } else {
        }
    }

    //Este método agrega un nuevo Nodo al final de la lista.
    public void setAddFinal(
            TextField txtNombre,
            TextField txtEmail,
            TextField txtNumCel,
            TextField txtPasswd,
            DatePicker txtfechaNac,
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
