/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author 57312
 */
public class PanelProductoController implements Initializable {

    @FXML
    private BorderPane vtnVistaProducto;
    @FXML
    private Button btnVolver;
    @FXML
    private Button btnCarrito;
    @FXML
    private Button btnProducto;
    @FXML
    private Button btnCuenta;
    @FXML
    private Pane panelContenedorCarrito;
    @FXML
    private Button btnAggCarrito;
    @FXML
    private ComboBox<?> cmbTalla;
    @FXML
    private Label lblMarca;
    @FXML
    private Label lblTipo;
    @FXML
    private Label lblPrecio;
    @FXML
    private Label lblPrecio1;
    @FXML
    private HBox panelFoto;

    public PanelProductoController() {
        panelContenedorCarrito.setVisible(false);
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
    }    

    @FXML
    private void mostrarCarrito(ActionEvent event) {
        panelContenedorCarrito.setVisible(true);
    }

    @FXML
    private void cambiarCursor(MouseEvent event) {
    }

    @FXML
    private void aggCarrito(ActionEvent event) {
    }
    
}
