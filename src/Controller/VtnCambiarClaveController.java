/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.ListaDobleUsuario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 57312
 */
public class VtnCambiarClaveController implements Initializable {

    @FXML
    private Button btnValidarCorreo;
    @FXML
    private Button btnCancelar;
    @FXML
    private Label lblTexto;
    @FXML
    private TextField txtGetEmail;
    @FXML
    private TextField txtGetPasNew;

    /**
     * Initializes the controller class.
     */
    ListaDobleUsuario metodsUser;

    public VtnCambiarClaveController() {
    }

    public VtnCambiarClaveController(ListaDobleUsuario metodUser) {
        this.metodsUser = metodUser;
    }

    public ListaDobleUsuario getMetodsUser() {
        return metodsUser;
    }

    public void setMetodsUser(ListaDobleUsuario metodsUser) {
        this.metodsUser = metodsUser;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void validarCorreo(ActionEvent event) {
        metodsUser.modificarContrasena(
                txtGetEmail,txtGetPasNew,
                lblTexto, btnValidarCorreo);
        
    }

    @FXML
    private void cerrarVtnChngPass(ActionEvent event) {
        Stage stage = (Stage) this.btnCancelar.getScene().getWindow();
        stage.close();

    }

}
