/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author wikicamus
 */
public class PanelLoginController implements Initializable {

    private CatalogoZapatosController catalogoController;
    @FXML
    private BorderPane panelLogin;
    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField txtPass;
    private Label lblLink;
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnIrReg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void setCatalogoController(CatalogoZapatosController catalogoController) {
        this.catalogoController = catalogoController;
    }
    
    public void cerrarSesion() throws IOException {
        // Código para cerrar sesión
        
        // Mostrar nuevamente la ventana de inicio de sesión
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/LoginVista.fxml"));
        BorderPane root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        // Configurar el controlador del catálogo de productos en null
        catalogoController.setLoginController(null);
    }

    @FXML
    private void iniciarSesion(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/CatalogoZapatosVista.fxml"));
        Parent root = loader.load();
        CatalogoZapatosController catalogoController = loader.getController();

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

        catalogoController.setLoginController(this);
            System.out.println("El usuario ha iniciado sesión");
        } catch (IOException ex) {
            Logger.getLogger(PanelLoginController.class.getName()).log(Level.SEVERE, "" + ex, ex);
        }
        
    }

    @FXML
    private void cargarRegister(ActionEvent event) throws IOException {
        AnchorPane paneReg = FXMLLoader.load(getClass().getResource("/View/PanelRegister.fxml"));

        Stage panelReg = new Stage();
        Scene regScene = new Scene(paneReg);

        panelReg.setScene(regScene);
        panelReg.show();

    }

}
