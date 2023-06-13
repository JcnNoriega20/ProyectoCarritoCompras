/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.ListaDobleUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author wikicamus
 */
public class LoginController {

    @FXML
    private TextField txtUser;
    @FXML
    private Label lblLink;
    @FXML
    private PasswordField txtPass;
    @FXML
    private Button btnLogin;
    
    ListaDobleUsuario userMetods = new ListaDobleUsuario();
    @FXML
    private AnchorPane vtnLogin;
    @FXML
    private Pane panelLogin;
    @FXML
    private Pane panelRegister;
    @FXML
    private TextField txtUser1;
    @FXML
    private PasswordField txtPass1;
    @FXML
    private Button btnLogin1;
    @FXML
    private TextField txtUser11;
    @FXML
    private TextField txtUser111;
    @FXML
    private PasswordField txtPass11;
    

    @FXML
    private void click(MouseEvent event) {
        System.out.println("Hola mundo");
    }

    @FXML
    private void cambiarCursor(MouseEvent event) {
        lblLink.setCursor(Cursor.HAND);
        btnLogin.setCursor(Cursor.HAND);
    }

    @FXML
    private void iniciarSesion(ActionEvent event) {
        boolean exisUser = userMetods.getBuscarCod(txtUser.getText()) != null;
        if(!exisUser)
            userMetods.alerta("Aviso", "Bienvenido");
        else{
            userMetods.alerta("Aviso", "Denegado");
        }
        
    }
    
}
