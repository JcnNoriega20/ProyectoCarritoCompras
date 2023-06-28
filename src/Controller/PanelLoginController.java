/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.ListaDobleUsuario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author wikicamus
 */
public class PanelLoginController implements Initializable {
    
    @FXML
    private BorderPane panelLogin;
    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField txtPass;    
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnIrReg;

    /**
     * Initializes the controller class.
     */
    ListaDobleUsuario metodUser = new ListaDobleUsuario();
    
    public PanelLoginController() {
        metodUser.cargarDatosDesdeArchivo();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        metodUser.cargarDatosDesdeArchivo();
    }
    
    @FXML
    private void iniciarSesion(ActionEvent event) {
        //metodUser.validarCuenta(txtUser, txtPass);
        boolean validar = metodUser.validarCuenta(txtUser, txtPass) == true;
        if (validar == true) {
            metodUser.alerta("Aviso", "Sí ingresó");
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/CatalogoZapatosVista.fxml"));
                Parent root = loader.load();
                CatalogoZapatosController catalogoController = loader.getController();
                catalogoController.setMetodUser(metodUser);
                
                Scene scene = new Scene(root);                
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Bienvenido a SHOES JUAN");
                stage.showAndWait();
                
                System.out.println("El usuario ha iniciado sesión");
            } catch (IOException ex) {
                Logger.getLogger(PanelLoginController.class.getName()).log(Level.SEVERE, "" + ex, ex);
            }
        } else {
            metodUser.alerta("Aviso", "No ingresó");
        }
        
    }
    
    @FXML
    private void cargarRegister(ActionEvent event) throws IOException {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/PanelRegister.fxml"));
            Parent root = loader.load();
            PanelRegisterController controller = loader.getController();
            controller.setMiPrincipal(metodUser);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Registro de usuario");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    @FXML
    private void validarCorreo(KeyEvent event) {
    }
    
    
    
}
