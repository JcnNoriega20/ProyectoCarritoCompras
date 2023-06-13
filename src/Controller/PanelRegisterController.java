/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author wikicamus
 */
public class PanelRegisterController implements Initializable {

    @FXML
    private TextField txtNomApeReg;
    @FXML
    private TextField txtEmailReg;
    @FXML
    private TextField txtNumCel;
    @FXML
    private PasswordField txtPassReg;
    @FXML
    private TextField txtFechaNac;
    @FXML
    private ComboBox<?> cmbGender;
    @FXML
    private Button btnRegister;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void viewGender(Event event) {
    }

    @FXML
    private void cambiarCursor(MouseEvent event) {
    }

    @FXML
    private void registrarUser(ActionEvent event) {
        System.out.println("Hola mundo");
    }
    
}
