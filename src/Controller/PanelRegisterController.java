/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.ListaDobleUsuario;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.LocalDateStringConverter;

public class PanelRegisterController implements Initializable {

    @FXML
    private TextField txtNomApeReg;
    @FXML
    private TextField txtEmailReg;
    @FXML
    private TextField txtNumCel;

    @FXML
    private ComboBox<String> cmbGender;
    @FXML
    private Button btnRegister;
    @FXML
    private Button btnRegresarLogin;

    ListaDobleUsuario metodUser2;
    @FXML
    private PasswordField txtPassReg;
    @FXML
    private DatePicker dateFechaNac;

    /**
     * Initializes the controller class.
     */
    public PanelRegisterController() {
    }

    public PanelRegisterController(ListaDobleUsuario miPrincipal) {
        this.metodUser2 = miPrincipal;
    }

    public ListaDobleUsuario getMiPrincipal() {
        return metodUser2;
    }

    public void setMiPrincipal(ListaDobleUsuario miPrincipal) {
        this.metodUser2 = miPrincipal;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cmbGender.getItems().addAll("Masculino", "Femenino");
        // Establecer el formato "dd/MM/yyyy"
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // Crear un StringConverter para convertir entre cadenas y fechas
        StringConverter<LocalDate> stringConverter = new LocalDateStringConverter(dateFormatter, null);
        // Establecer el StringConverter en el DatePicker
        dateFechaNac.setConverter(stringConverter);

    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void viewGender(Event event) {
    }

    @FXML
    private void cambiarCursor(MouseEvent event) {
    }

    @FXML
    private void registrarUser(ActionEvent event) {
         metodUser2.setAddFinal(
                    txtNomApeReg,
                    txtEmailReg,
                    txtNumCel,
                    txtPassReg,
                    dateFechaNac,
                    cmbGender);
         metodUser2.guardarDatosEnArchivo(metodUser2);
        
    }

    @FXML
    private void validarCorreo(KeyEvent event) {

    }

    @FXML
    private void cerrarRegister(ActionEvent event) {
            Stage stage = (Stage) this.btnRegister.getScene().getWindow();
            stage.close();
    }

}
