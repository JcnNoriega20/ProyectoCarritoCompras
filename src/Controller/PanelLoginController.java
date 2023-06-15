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

    @FXML
    private void iniciarSesion(ActionEvent event) {
        try {
            AnchorPane panelCatalogo = FXMLLoader.load(getClass().getResource("/View/CatalogoZapatosVista.fxml"));

            Stage stage = new Stage();
            Scene scene = new Scene(panelCatalogo);

            stage.setScene(scene);
            stage.show();

            Stage ventanaPrincipal = (Stage) ((Node) event.getSource()).getScene().getWindow();
            ventanaPrincipal.close();

        } catch (IOException ex) {
            Logger.getLogger(PanelLoginController.class.getName()).log(Level.SEVERE, "" + ex, ex);
        }
        System.out.println("El usuario ha iniciado sesión");
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
