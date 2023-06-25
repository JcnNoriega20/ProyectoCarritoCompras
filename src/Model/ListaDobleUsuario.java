package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
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

    public NodoUsuario getCrearNodo(
            TextField txtNombre,
            TextField txtEmail,
            TextField txtNumCel,
            TextField txtPasswd,
            DatePicker datefechaNac,
            ComboBox cmbGender) {
        NodoUsuario buscar = null;
        try {
            buscar = getBuscarCod(txtEmail.getText());
            if (buscar != null) {
                alerta("Aviso", "Este usuario ya se encuentra registrado");
                return null;
            }
            if (!ValidarCampos(txtNombre, txtEmail, txtNumCel, txtPasswd, datefechaNac, cmbGender)) {
                ValidarCampos(txtNombre, txtEmail, txtNumCel, txtPasswd, datefechaNac, cmbGender);
                return null;
            } else {
                DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                NodoUsuario nuevoNodo = new NodoUsuario(
                        txtNombre.getText(),
                        txtEmail.getText(),
                        txtNumCel.getText(),
                        txtPasswd.getText(),
                        datefechaNac.getValue(),
                        cmbGender.getValue().toString());
                System.out.println(nuevoNodo.fechaNac);
                System.out.println(nuevoNodo.passwd);
                System.out.println("Usuario registrado");
                txtNombre.setText("");
                txtEmail.setText("");
                txtNumCel.setText("");
                txtPasswd.setText("");
                datefechaNac.setValue(null);
                cmbGender.getSelectionModel().selectFirst();
                return nuevoNodo;
            }

        } catch (Exception e) {
            alerta("Aviso", "" + e);
            return null;
        }
    }

    public boolean ValidarCampos(
            TextField txtNombre,
            TextField txtEmail,
            TextField txtNumCel,
            TextField txtPasswd,
            DatePicker datefechaNac,
            ComboBox cmbGender) {

        if (txtNombre.getText().isEmpty() || txtEmail.getText().isEmpty() || txtNumCel.getText().isEmpty()
                || txtPasswd.getText().isEmpty() || datefechaNac == null || cmbGender == null) {
            showAlert(Alert.AlertType.ERROR, "Error", "Debe completar todos los campos.");
            return false;
        }
        if (!txtEmail.getText().matches("[a-zA-Z0-9_]+@shoes\\.com")) {
            showAlert(Alert.AlertType.ERROR, "Error", "El formato del correo electrónico es incorrecto.");
            return false;
        }
        if (txtPasswd.getText().length() < 8 || txtPasswd.getText().length() > 16) {
            showAlert(AlertType.ERROR, "Error", "La contraseña no cuenta o excede el limite "
                    + "\nde caracteres permitidos (8 a 16 caracteres)");
            return false; // La contraseña no cumple con la longitud requerida
        }

        if (!txtPasswd.getText().matches("[a-zA-Z0-9]*")) {
            showAlert(AlertType.ERROR, "Error", "La contraseña solo acepta números y letras"
                    + "\nnada de espacios o caracteres especiales");
            return false; // La contraseña contiene caracteres especiales o espacios
        }
        return true;
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

    public boolean validarCuenta(TextField txtCorreo, TextField txtPass) {
        boolean validar = true;
        if (txtCorreo.getText().isEmpty() && txtPass.getText().isEmpty()) {
            alerta("Aviso", "Los campos están vacios");
            validar = false;
        } else {
            NodoUsuario buscar = getBuscarCod(txtCorreo.getText());
            if (buscar != null) {
                if ((buscar.passwd).equals(txtPass.getText())) {
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

        return validar;
    }

    public boolean getEsVacia() {
        return cab == null ? true : false;
    }

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

    public void setAddInicio(
            TextField txtNombre,
            TextField txtEmail,
            TextField txtNumCel,
            TextField txtPasswd,
            DatePicker txtfechaNac,
            ComboBox cmbGender) {
        
        NodoUsuario info = getCrearNodo(txtNombre, txtEmail, txtNumCel,
                txtPasswd, txtfechaNac, cmbGender);

        if (info != null) {
            if (cab == null) {
                cab = info;
                alerta("Aviso", "Se ha registrado");
            } else {
                info.sig = cab;
                cab.ant = info;
                cab = info;
                alerta("Aviso", "Se ha registrado al inicio ");
            }
        } else {
        }
    }

    
    public void setAddFinal(
            TextField txtNombre,
            TextField txtEmail,
            TextField txtNumCel,
            TextField txtPasswd,
            DatePicker txtfechaNac,
            ComboBox cmbGender) {
        
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
    
    public void guardarDatosEnArchivo(ListaDobleUsuario listaUsuarios) {
        String nombre = "user.txt";
        Path ubicacion = Paths.get(System.getProperty("user.dir"), nombre);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ubicacion.toFile()))) {
            NodoUsuario nodoActual = cab;

            while (nodoActual != null) {
                writer.write(nodoActual.nombre + ",");
                writer.write(nodoActual.email + ",");
                writer.write(nodoActual.numCel + ",");
                writer.write(nodoActual.passwd + ",");
                writer.write(nodoActual.fechaNac.format(dateFormatter) + ",");
                writer.write(nodoActual.gen);
                writer.newLine();

                nodoActual = nodoActual.sig;
            }

            System.out.println("Datos guardados correctamente en el archivo.");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos en el archivo: " + e.getMessage());
        }
    }

    public ListaDobleUsuario cargarDatosDesdeArchivo() {
        String nombreArchivo = "user.txt";
        Path ubicacion = Paths.get(System.getProperty("user.dir"), nombreArchivo);

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        ListaDobleUsuario listaUsuarios = new ListaDobleUsuario();

        try (BufferedReader reader = new BufferedReader(new FileReader(ubicacion.toFile()))) {
            String linea;

            while ((linea = reader.readLine()) != null) {
                String[] atributos = linea.split(",");

                String nombre = atributos[0];
                String correo = atributos[1];
                String numCelular = atributos[2];
                String contrasena = atributos[3];
                LocalDate fechaNacimiento = LocalDate.parse(atributos[4], dateFormatter);
                String genero = atributos[5];

                listaUsuarios.insertarFinal(nombre, correo, numCelular, contrasena, fechaNacimiento, genero);
            }

            System.out.println("Datos cargados correctamente desde el archivo.");
        } catch (IOException e) {
            System.out.println("Error al cargar los datos desde el archivo: " + e.getMessage());
        }

        return listaUsuarios;
    }
    
    public void insertarFinal(String nombre, String correo, String numCelular, String contrasena, LocalDate fechaNacimiento, String genero) {
        NodoUsuario nuevoNodo = new NodoUsuario(nombre, correo, numCelular, contrasena, fechaNacimiento, genero);

        if (cab == null) {
            
            cab = nuevoNodo;
        } else {
            NodoUsuario temp = cab;            
            while (temp.sig != null) {
                temp = temp.sig;
            }            
            temp.sig=nuevoNodo;
            nuevoNodo.ant=temp;
        }
    }

    public boolean modificarContrasena(TextField txtCorreo, TextField newPass, Label lblText, Button btnValidar) {
        NodoUsuario buscar = getBuscarCod(txtCorreo.getText());

        if (buscar != null) {
            System.out.println("correo se encontro");
            btnValidar.setText("CAMBIAR CONTRASEÑA");
            newPass.setVisible(true);
            lblText.setVisible(true);
            newPass.requestFocus();
            if (!newPass.getText().matches("[a-zA-Z0-9]*")) {
                showAlert(AlertType.ERROR, "Error", "La contraseña solo acepta números y letras"
                        + "\nnada de espacios o caracteres especiales");
                return false; // La contraseña contiene caracteres especiales o espacios
            }
            if (newPass.getText().length() < 8 || newPass.getText().length() > 16) {
                showAlert(AlertType.ERROR, "Error", "La contraseña no cuenta o excede el limite "
                        + "\nde caracteres permitidos (8 a 16 caracteres)");
                return false; // La contraseña no cumple con la longitud requerida
            }
            if (newPass.getText().isEmpty()) {
                System.out.println("Contaseña no se cambio");
                return false;
            } else {
                buscar.passwd = newPass.getText();
                showAlert(AlertType.CONFIRMATION, "Confirmacion", "Contraseña cambiada con éxito");
                System.out.println("contraseña se cambio");
                return true;
            }
        } else {
            showAlert(AlertType.ERROR, "Error", "Correo erroneo, por favor digitelo de nuevo");
            txtCorreo.setText("");
            txtCorreo.requestFocus();
            return false;
        }

    }
}
