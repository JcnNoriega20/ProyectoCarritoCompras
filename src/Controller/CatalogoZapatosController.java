
package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.text.html.HTMLDocument;


public class CatalogoZapatosController implements Initializable {

    @FXML
    private Pane zapato1;
    @FXML
    private Pane zapato2;
    @FXML
    private Pane img1;
    @FXML
    private Pane zapato5;
    @FXML
    private Pane img5;
    @FXML
    private Pane img2;
    @FXML
    private Pane zapato3;
    @FXML
    private Pane img3;
    @FXML
    private Pane zapato4;
    @FXML
    private Pane img4;
    @FXML
    private Pane zapato6;
    @FXML
    private Pane img6;
    @FXML
    private Pane zapato7;
    @FXML
    private Pane img7;
    @FXML
    private Pane zapato8;
    @FXML
    private Pane img8;
    @FXML
    private Pane panelContenedorCarrito;
    @FXML
    private Button btnMostrarCarrito;
    @FXML
    private Pane panelProducto;
    @FXML
    private BorderPane vtnVistaProducto;
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
    @FXML
    private Button btnVolver;
    @FXML
    private Button btnPagar;
    @FXML
    private Button btnOpcionesUser;
    @FXML
    private Button btnentregados;
    @FXML
    private Button btnCambiarContrasena;
    @FXML
    private Button btnCerrarSesion;
    @FXML
    private Pane panelContenProdPagados;
    @FXML
    private Pane panelContenOpcUser;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        panelProducto.setVisible(false);
    }

    @FXML
    private void mostrarCarrito(ActionEvent event) {
        panelContenedorCarrito.setVisible(!panelContenedorCarrito.isVisible());
        panelContenOpcUser.setVisible(false);
        panelContenProdPagados.setVisible(false);
    }

    @FXML
    private void mostrarProducto(MouseEvent event) {
        panelProducto.setVisible(true);
    }

    @FXML
    private void cambiarCursor(MouseEvent event) {
    }

    @FXML
    private void aggCarrito(ActionEvent event) {
    }

    @FXML
    private void volverCatalogo(ActionEvent event) {
        panelProducto.setVisible(false);
    }

    @FXML
    private void pagarProducto(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/VtnMetodoPago.fxml"));
            AnchorPane paneMetodoPago;
            paneMetodoPago = loader.load();
            VtnMetodoPagoController controller = loader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(paneMetodoPago));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(CatalogoZapatosController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void mostrarOpcionesUser(ActionEvent event) {
        panelContenOpcUser.setVisible(!panelContenOpcUser.isVisible());
        panelContenProdPagados.setVisible(false);
        panelContenedorCarrito.setVisible(false);

    }

    @FXML
    private void mostrarEntregados(ActionEvent event) {
        panelContenProdPagados.setVisible(!panelContenProdPagados.isVisible());
        panelContenOpcUser.setVisible(false);
        panelContenedorCarrito.setVisible(false);
    }

    @FXML
    private void cambiarContrasena(ActionEvent event) {
    }

    @FXML
    private void cerrarSesion(ActionEvent event) {
    }

}
