package Controller;

import Model.ListaDobleUsuario;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

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
    private Button btnMostrarCarrito;
    @FXML
    private Pane panelProducto;
    @FXML
    private BorderPane vtnVistaProducto;
    @FXML
    private Button btnAggCarrito;
    @FXML
    private ComboBox<String> cmbTalla;
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
    @FXML
    private VBox panelContenCarrito;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private Button btnPagarProduct;
    @FXML
    private Button btnAggCrto1;
    @FXML
    private Button btnAggCrto4;
    @FXML
    private Button btnAggCrto3;
    @FXML
    private Button btnAggCrto5;
    @FXML
    private Button btnAggCrto7;
    @FXML
    private Button btnAggCrto8;
    @FXML
    private Button btnAggCrto2;

    ListaDobleUsuario metodUser;
    private Map<Pane, Image> paneImageMap;
    @FXML
    private Pane panelContGenShoes;
    @FXML
    private Button btnShoesWoman;
    @FXML
    private Button btnShoesMen;
    @FXML
    private Button btnOpciones;

    public CatalogoZapatosController() {

    }

    public CatalogoZapatosController(ListaDobleUsuario metodUser) {
        this.metodUser = metodUser;

    }

    public ListaDobleUsuario getMetodUser() {
        return metodUser;
    }

    public void setMetodUser(ListaDobleUsuario metodUser) {
        this.metodUser = metodUser;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        scrollPane.setVisible(false);
        panelProducto.setVisible(false);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);

        almacenarImagen();
        mostrarImagenes();
    }

    private void mostrarImagenes() {
        for (Map.Entry<Pane, Image> entry : paneImageMap.entrySet()) {
            Pane pane = entry.getKey();
            Image image = entry.getValue();

            ImageView imageView = new ImageView(image);
            pane.getChildren().add(imageView);
        }
    }

    private void almacenarImagen() {
        paneImageMap = new HashMap<>();
        paneImageMap.put(img1, new Image("/Images/shoesMen1.jpg"));
        paneImageMap.put(img2, new Image("/Images/shoesMen2.jpg"));
        paneImageMap.put(img3, new Image("/Images/shoesMen3.jpg"));
        paneImageMap.put(img4, new Image("/Images/shoesMen4.jpg"));
        paneImageMap.put(img5, new Image("/Images/shoesMen5.jpg"));
        paneImageMap.put(img6, new Image("/Images/shoesMen6.jpg"));
        paneImageMap.put(img7, new Image("/Images/shoesMen7.jpg"));
        paneImageMap.put(img8, new Image("/Images/shoesMen8.jpg"));
    }

    @FXML
    private void mostrarCarrito(ActionEvent event) {
        scrollPane.setVisible(!scrollPane.isVisible());
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
        Button eventBtn = (Button) event.getSource();
        if (eventBtn.getId().equals("btnAggCrto1")) {
            Label lblTalla = new Label("TALLA: ");
            Label lblPrecio = new Label("PRECIO: ");
            Label lblMarca = new Label("MARCA: ");
            Label lblGenero = new Label("GENERO: ");
            Label lblTipoZap = new Label("TIPO ZAPATO: ");
            Button btnEliminar = new Button("Eliminar Carrito");
            GridPane contendElemtZapatos = new GridPane();
            System.out.println(btnEliminar.getAccessibleText());

            ColumnConstraints column1 = new ColumnConstraints();
            column1.setPrefWidth(panelContenCarrito.getWidth() / 2);

            contendElemtZapatos.getColumnConstraints().addAll(column1);
            contendElemtZapatos.prefWidth(panelContenCarrito.getMaxWidth());
            contendElemtZapatos.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

            contendElemtZapatos.add(lblMarca, 0, 0);
            contendElemtZapatos.add(lblTipoZap, 1, 0);
            contendElemtZapatos.add(lblGenero, 0, 1);
            contendElemtZapatos.add(lblTalla, 1, 1);
            contendElemtZapatos.add(lblPrecio, 0, 2);
            contendElemtZapatos.add(btnEliminar, 1, 2);

            panelContenCarrito.getChildren().add(contendElemtZapatos);
        }

    }

    @FXML
    private void volverCatalogo(ActionEvent event) {

        panelProducto.setVisible(false);
    }

    @FXML
    private void mostrarOpcionesUser(ActionEvent event) {
        panelContenOpcUser.setVisible(!panelContenOpcUser.isVisible());
        panelContenProdPagados.setVisible(false);
        scrollPane.setVisible(false);

    }

    @FXML
    private void mostrarEntregados(ActionEvent event) {
        panelContenProdPagados.setVisible(!panelContenProdPagados.isVisible());
        panelContenOpcUser.setVisible(false);
        scrollPane.setVisible(false);
    }

    @FXML
    private void cambiarContrasena(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/VtnCambiarClave.fxml"));
            AnchorPane vtnCambiarContra;
            vtnCambiarContra = loader.load();
            VtnCambiarClaveController controller = loader.getController();
            controller.setMetodsUser(metodUser);

            Stage stage = new Stage();
            stage.setScene(new Scene(vtnCambiarContra));
            stage.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(CatalogoZapatosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void cerrarSesion(ActionEvent event) throws IOException {

    }

    @FXML
    private void realizarPago(ActionEvent event) {
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
    private void mostrarOpciones(ActionEvent event) {
        panelContGenShoes.setVisible(!panelContGenShoes.isVisible());
        panelContenProdPagados.setVisible(false);
        scrollPane.setVisible(false);
        panelContenOpcUser.setVisible(false);
    }

    @FXML
    private void changeGenShoes(ActionEvent event) {
        Button eventBtn = (Button) event.getSource();

        if (eventBtn.getId().equals("btnShoesWoman")) {
            paneImageMap = new HashMap<>();
            paneImageMap.put(img1, new Image("/Images/shoesWoman1.jpg"));
            paneImageMap.put(img2, new Image("/Images/shoesWoman2.jpg"));
            paneImageMap.put(img3, new Image("/Images/shoesWoman3.jpg"));
            paneImageMap.put(img4, new Image("/Images/shoesWoman4.jpg"));
            paneImageMap.put(img5, new Image("/Images/shoesWoman5.jpg"));
            paneImageMap.put(img6, new Image("/Images/shoesWoman6.jpg"));
            paneImageMap.put(img7, new Image("/Images/shoesWoman7.jpg"));
            paneImageMap.put(img8, new Image("/Images/shoesWoman8.jpg"));
            mostrarImagenes();
        } else if (eventBtn.getId().equals("btnShoesMen")) {
            paneImageMap = new HashMap<>();
            paneImageMap.put(img1, new Image("/Images/shoesMen1.jpg"));
            paneImageMap.put(img2, new Image("/Images/shoesMen2.jpg"));
            paneImageMap.put(img3, new Image("/Images/shoesMen3.jpg"));
            paneImageMap.put(img4, new Image("/Images/shoesMen4.jpg"));
            paneImageMap.put(img5, new Image("/Images/shoesMen5.jpg"));
            paneImageMap.put(img6, new Image("/Images/shoesMen6.jpg"));
            paneImageMap.put(img7, new Image("/Images/shoesMen7.jpg"));
            paneImageMap.put(img8, new Image("/Images/shoesMen8.jpg"));
            mostrarImagenes();
        }
    }

}
