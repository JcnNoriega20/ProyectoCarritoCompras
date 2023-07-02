package Controller;

import Model.ListaDobleUsuario;
import Model.ListaDobleZapato;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
import sun.plugin2.os.windows.Windows;

public class CatalogoZapatosController implements Initializable {

    ListaDobleUsuario metodUser;
    ListaDobleZapato metodShoes = new ListaDobleZapato();

    private Map<Pane, Image> paneImageMap;

    @FXML
    private Pane img1;
    @FXML
    private Pane img5;
    @FXML
    private Pane img2;
    @FXML
    private Pane img3;
    @FXML
    private Pane img4;
    @FXML
    private Pane img6;
    @FXML
    private Pane img7;
    @FXML
    private Pane img8;
    @FXML
    private Button btnMostrarCarrito;
    @FXML
    private Pane panelProducto;
    @FXML
    private BorderPane vtnVistaProducto;
    private ComboBox<String> cmbTalla;
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
    @FXML
    private Pane panelContGenShoes;
    @FXML
    private Button btnShoesWoman;
    @FXML
    private Button btnShoesMen;
    @FXML
    private Button btnOpciones;
    @FXML
    private GridPane contenedorCatalogo;
    @FXML
    private ComboBox<String> cmbTalla1;
    @FXML
    private Label lblMarca1;
    @FXML
    private Label lblGenero1;
    @FXML
    private Label lblTipo1;
    @FXML
    private ComboBox<String> cmbTalla5;
    @FXML
    private Label lblMarca5;
    @FXML
    private Label lblGenero5;
    @FXML
    private Label lblTipo5;
    @FXML
    private Label lblPrecio5;
    @FXML
    private ComboBox<String> cmbTalla2;
    @FXML
    private Label lblMarca2;
    @FXML
    private Label lblGenero2;
    @FXML
    private Label lblTipo2;
    @FXML
    private Label lblPrecio2;
    @FXML
    private Label lblMarca3;
    @FXML
    private Label lblGenero3;
    @FXML
    private Label lblTipo3;
    @FXML
    private Label lblPrecio3;
    @FXML
    private ComboBox<String> cmbTalla4;
    @FXML
    private Label lblMarca4;
    @FXML
    private Label lblGenero4;
    @FXML
    private Label lblTipo4;
    @FXML
    private Label lblPrecio4;
    @FXML
    private ComboBox<String> cmbTalla6;
    @FXML
    private Label lblMarca6;
    @FXML
    private Label lblGenero6;
    @FXML
    private Label lblTipo6;
    @FXML
    private Label lblPrecio6;
    @FXML
    private ComboBox<String> cmbTalla7;
    @FXML
    private Label lblMarca7;
    @FXML
    private Label lblGenero7;
    @FXML
    private Label lblTipo7;
    @FXML
    private Label lblPrecio7;
    @FXML
    private ComboBox<String> cmbTalla8;
    @FXML
    private Label lblMarca8;
    @FXML
    private Label lblGenero8;
    @FXML
    private Label lblTipo8;
    @FXML
    private Label lblPrecio8;
    @FXML
    private ComboBox<String> cmbTalla3;
    @FXML
    private Button btnAggCarritoP;
    @FXML
    private ComboBox<String> cmbTallaP;
    @FXML
    private Label lblMarcaP;
    @FXML
    private Label lblTipoP;
    @FXML
    private Label lblPrecioP;
    @FXML
    private Label lblDescriptionP;
    @FXML
    private Label lblGeneroP;
    @FXML
    private AnchorPane root;

    public CatalogoZapatosController() {

    }

    public CatalogoZapatosController(ListaDobleUsuario metodUser) {
        this.metodUser = metodUser;
        //this.metodShoes = metodShoes;

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

        String[] valuesCmb = {"35", "36", "37", "38", "39", "40"};
        cmbTalla1.setItems(FXCollections.observableArrayList(valuesCmb));
        cmbTalla2.setItems(FXCollections.observableArrayList(valuesCmb));
        cmbTalla3.setItems(FXCollections.observableArrayList(valuesCmb));
        cmbTalla4.setItems(FXCollections.observableArrayList(valuesCmb));
        cmbTalla5.setItems(FXCollections.observableArrayList(valuesCmb));
        cmbTalla6.setItems(FXCollections.observableArrayList(valuesCmb));
        cmbTalla7.setItems(FXCollections.observableArrayList(valuesCmb));
        cmbTalla8.setItems(FXCollections.observableArrayList(valuesCmb));
        cmbTallaP.setItems(FXCollections.observableArrayList(valuesCmb));

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
        Pane eventPane = (Pane) event.getSource();
    String paneId = eventPane.getId();

    // Obtener la imagen correspondiente al panel seleccionado
    Image image = paneImageMap.get(eventPane);

    // Limpiar el panel grande
    panelFoto.getChildren().clear();

    // Mostrar la imagen ampliada en el panel grande
    ImageView imageViewAmpliada = new ImageView(image);
    imageViewAmpliada.setFitWidth(200);
    imageViewAmpliada.setFitHeight(200);

    panelFoto.getChildren().add(imageViewAmpliada);
    panelProducto.setVisible(true);
        
    }
    

    @FXML
    private void volverCatalogo(ActionEvent event) {
        panelProducto.setVisible(false);
        ObservableList<Node> elementos = panelFoto.getChildren();
        for (Node elemento : elementos) {
            System.out.println(elemento);
            //panelFoto.getChildren().remove(elemento);
        }

    }

    @FXML
    private void cambiarCursor(MouseEvent event) {
    }

    @FXML
    private void aggCarrito(ActionEvent event) {
        Button eventBtn = (Button) event.getSource();
        Label lblTalla = new Label();
        Label lblPrecio = new Label();
        Label lblMarca = new Label();
        Label lblGenero = new Label();
        Label lblTipoZap = new Label();
        Button btnEliminar = new Button("Eliminar Carrito");
        GridPane contendElemtZapatos = new GridPane();
        ColumnConstraints column = new ColumnConstraints();
        btnEliminar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Acciones a realizar cuando se hace clic en el botón
                System.out.println("Botón clickeado");
                System.out.println(btnEliminar.getId());
                panelContenCarrito.getChildren().remove(contendElemtZapatos);
            }
        });

        switch (eventBtn.getId()) {
            case "btnAggCrto1":
                lblTalla.setText(cmbTalla1.getValue());
                lblPrecio.setText(lblPrecio1.getText());
                lblMarca.setText(lblMarca1.getText());
                lblGenero.setText(lblGenero1.getText());
                lblTipoZap.setText(lblTipo1.getText());

                column.setPrefWidth(panelContenCarrito.getWidth() / 2);

                contendElemtZapatos.getColumnConstraints().addAll(column);
                contendElemtZapatos.prefWidth(panelContenCarrito.getMaxWidth());
                contendElemtZapatos.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

                contendElemtZapatos.add(lblMarca, 0, 0);
                contendElemtZapatos.add(lblTipoZap, 1, 0);
                contendElemtZapatos.add(lblGenero, 0, 1);
                contendElemtZapatos.add(lblTalla, 1, 1);
                contendElemtZapatos.add(lblPrecio, 0, 2);
                contendElemtZapatos.add(btnEliminar, 1, 2);

                panelContenCarrito.getChildren().add(contendElemtZapatos);
                metodShoes.addFinal(lblMarca1.getText(), lblTipo1.getText(),
                        lblPrecio1.getText(), lblGenero1.getText(), cmbTalla1.getValue());
                break;
            case "btnAggCrto2":
                lblTalla.setText(cmbTalla2.getValue());
                lblPrecio.setText(lblPrecio2.getText());
                lblMarca.setText(lblMarca2.getText());
                lblGenero.setText(lblGenero2.getText());
                lblTipoZap.setText(lblTipo2.getText());

                column.setPrefWidth(panelContenCarrito.getWidth() / 2);

                contendElemtZapatos.getColumnConstraints().addAll(column);
                contendElemtZapatos.prefWidth(panelContenCarrito.getMaxWidth());
                contendElemtZapatos.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

                contendElemtZapatos.add(lblMarca, 0, 0);
                contendElemtZapatos.add(lblTipoZap, 1, 0);
                contendElemtZapatos.add(lblGenero, 0, 1);
                contendElemtZapatos.add(lblTalla, 1, 1);
                contendElemtZapatos.add(lblPrecio, 0, 2);
                contendElemtZapatos.add(btnEliminar, 1, 2);

                panelContenCarrito.getChildren().add(contendElemtZapatos);

                break;

            case "btnAggCrto3":
                lblTalla.setText(cmbTalla3.getValue());
                lblPrecio.setText(lblPrecio3.getText());
                lblMarca.setText(lblMarca3.getText());
                lblGenero.setText(lblGenero3.getText());
                lblTipoZap.setText(lblTipo3.getText());

                //ColumnConstraints column = new ColumnConstraints();
                column.setPrefWidth(panelContenCarrito.getWidth() / 2);

                contendElemtZapatos.getColumnConstraints().addAll(column);
                contendElemtZapatos.prefWidth(panelContenCarrito.getMaxWidth());
                contendElemtZapatos.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

                contendElemtZapatos.add(lblMarca, 0, 0);
                contendElemtZapatos.add(lblTipoZap, 1, 0);
                contendElemtZapatos.add(lblGenero, 0, 1);
                contendElemtZapatos.add(lblTalla, 1, 1);
                contendElemtZapatos.add(lblPrecio, 0, 2);
                contendElemtZapatos.add(btnEliminar, 1, 2);

                panelContenCarrito.getChildren().add(contendElemtZapatos);
                break;
            case "btnAggCrto4":
                lblTalla.setText(cmbTalla4.getValue());
                lblPrecio.setText(lblPrecio4.getText());
                lblMarca.setText(lblMarca4.getText());
                lblGenero.setText(lblGenero4.getText());
                lblTipoZap.setText(lblTipo4.getText());

                //ColumnConstraints column = new ColumnConstraints();
                column.setPrefWidth(panelContenCarrito.getWidth() / 2);

                contendElemtZapatos.getColumnConstraints().addAll(column);
                contendElemtZapatos.prefWidth(panelContenCarrito.getMaxWidth());
                contendElemtZapatos.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

                contendElemtZapatos.add(lblMarca, 0, 0);
                contendElemtZapatos.add(lblTipoZap, 1, 0);
                contendElemtZapatos.add(lblGenero, 0, 1);
                contendElemtZapatos.add(lblTalla, 1, 1);
                contendElemtZapatos.add(lblPrecio, 0, 2);
                contendElemtZapatos.add(btnEliminar, 1, 2);

                panelContenCarrito.getChildren().add(contendElemtZapatos);
                break;
            case "btnAggCrto5":
                lblTalla.setText(cmbTalla5.getValue());
                lblPrecio.setText(lblPrecio5.getText());
                lblMarca.setText(lblMarca5.getText());
                lblGenero.setText(lblGenero5.getText());
                lblTipoZap.setText(lblTipo5.getText());

                column.setPrefWidth(panelContenCarrito.getWidth() / 2);

                contendElemtZapatos.getColumnConstraints().addAll(column);
                contendElemtZapatos.prefWidth(panelContenCarrito.getMaxWidth());
                contendElemtZapatos.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

                contendElemtZapatos.add(lblMarca, 0, 0);
                contendElemtZapatos.add(lblTipoZap, 1, 0);
                contendElemtZapatos.add(lblGenero, 0, 1);
                contendElemtZapatos.add(lblTalla, 1, 1);
                contendElemtZapatos.add(lblPrecio, 0, 2);
                contendElemtZapatos.add(btnEliminar, 1, 2);

                panelContenCarrito.getChildren().add(contendElemtZapatos);
                break;
            case "btnAggCrto6":
                lblTalla.setText(cmbTalla6.getValue());
                lblPrecio.setText(lblPrecio6.getText());
                lblMarca.setText(lblMarca6.getText());
                lblGenero.setText(lblGenero6.getText());
                lblTipoZap.setText(lblTipo6.getText());

                column.setPrefWidth(panelContenCarrito.getWidth() / 2);

                contendElemtZapatos.getColumnConstraints().addAll(column);
                contendElemtZapatos.prefWidth(panelContenCarrito.getMaxWidth());
                contendElemtZapatos.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

                contendElemtZapatos.add(lblMarca, 0, 0);
                contendElemtZapatos.add(lblTipoZap, 1, 0);
                contendElemtZapatos.add(lblGenero, 0, 1);
                contendElemtZapatos.add(lblTalla, 1, 1);
                contendElemtZapatos.add(lblPrecio, 0, 2);
                contendElemtZapatos.add(btnEliminar, 1, 2);

                panelContenCarrito.getChildren().add(contendElemtZapatos);
                break;
            case "btnAggCrto7":
                lblTalla.setText(cmbTalla7.getValue());
                lblPrecio.setText(lblPrecio7.getText());
                lblMarca.setText(lblMarca7.getText());
                lblGenero.setText(lblGenero7.getText());
                lblTipoZap.setText(lblTipo7.getText());

                column.setPrefWidth(panelContenCarrito.getWidth() / 2);

                contendElemtZapatos.getColumnConstraints().addAll(column);
                contendElemtZapatos.prefWidth(panelContenCarrito.getMaxWidth());
                contendElemtZapatos.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

                contendElemtZapatos.add(lblMarca, 0, 0);
                contendElemtZapatos.add(lblTipoZap, 1, 0);
                contendElemtZapatos.add(lblGenero, 0, 1);
                contendElemtZapatos.add(lblTalla, 1, 1);
                contendElemtZapatos.add(lblPrecio, 0, 2);
                contendElemtZapatos.add(btnEliminar, 1, 2);

                panelContenCarrito.getChildren().add(contendElemtZapatos);
                break;
            case "btnAggCrto8":
                lblTalla.setText(cmbTalla8.getValue());
                lblPrecio.setText(lblPrecio8.getText());
                lblMarca.setText(lblMarca8.getText());
                lblGenero.setText(lblGenero8.getText());
                lblTipoZap.setText(lblTipo8.getText());

                column.setPrefWidth(panelContenCarrito.getWidth() / 2);

                contendElemtZapatos.getColumnConstraints().addAll(column);
                contendElemtZapatos.prefWidth(panelContenCarrito.getMaxWidth());
                contendElemtZapatos.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

                contendElemtZapatos.add(lblMarca, 0, 0);
                contendElemtZapatos.add(lblTipoZap, 1, 0);
                contendElemtZapatos.add(lblGenero, 0, 1);
                contendElemtZapatos.add(lblTalla, 1, 1);
                contendElemtZapatos.add(lblPrecio, 0, 2);
                contendElemtZapatos.add(btnEliminar, 1, 2);

                panelContenCarrito.getChildren().add(contendElemtZapatos);
                break;

        }

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
            stage.setTitle("CAMBIAR CONTRASEÑA");
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
            stage.setTitle("PAGAR PRODUCTO");
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
