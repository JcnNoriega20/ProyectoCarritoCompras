/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author 57312
 */
public class VtnMetodoPagoController implements Initializable {

    @FXML
    private ComboBox<String> cmbMetodoPago;
    @FXML
    private Label lbl1;
    @FXML
    private Label lbl2;
    @FXML
    private Label lbl3;
    @FXML
    private Label lbl4;
    @FXML
    private TextField txt1;
    @FXML
    private TextField txt2;
    @FXML
    private TextField txt3;
    @FXML
    private TextField txt4;
    @FXML
    private Button btnCancelarCompra;
    @FXML
    private Button btnRealizarCompra;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> elementos = FXCollections.observableArrayList("Selecciones una opción",
                "Tarjeta Crédito",
                "Tarjeta Débito",
                "Bancolombia",
                "Cuenta Nequi",
                "Cuenta Daviplata");
        
        cmbMetodoPago.setItems(elementos);
        cmbMetodoPago.setValue(elementos.get(0));
        cmbMetodoPago.setOnAction((event) -> {
            int metodo = cmbMetodoPago.getSelectionModel().getSelectedIndex();
            switch (metodo) {
                case 0:
                    lbl1.setVisible(false);
                    lbl2.setVisible(false);
                    lbl3.setVisible(false);
                    lbl4.setVisible(false);
                    txt1.setVisible(false);
                    txt2.setVisible(false);
                    txt3.setVisible(false);
                    txt4.setVisible(false);
                    txt4.setVisible(false);
                    btnRealizarCompra.setDisable(true);
                    break;
                case 1:
                    lbl1.setVisible(true);
                    lbl2.setVisible(true);
                    lbl3.setVisible(true);
                    lbl4.setVisible(true);
                    txt1.setVisible(true);
                    txt2.setVisible(true);
                    txt3.setVisible(true);
                    txt4.setVisible(true);
                    txt4.setVisible(true);
                    btnRealizarCompra.setDisable(false);
                    lbl1.setText("NÚMERO DE TARJETA:");
                    lbl2.setText("NOMBRE Y APELLIDO");
                    lbl3.setText("FECHA DE EXPIRACIÓN");
                    lbl4.setText("CÓDIGO DE SEGURIDAD");
                    break;
                case 2:
                    lbl1.setVisible(true);
                    lbl2.setVisible(true);
                    lbl3.setVisible(true);
                    lbl4.setVisible(true);
                    txt1.setVisible(true);
                    txt2.setVisible(true);
                    txt3.setVisible(true);
                    txt4.setVisible(true);
                    txt4.setVisible(true);
                    btnRealizarCompra.setDisable(false);
                    lbl1.setText("NÚMERO DE TARJETA:");
                    lbl2.setText("NOMBRE Y APELLIDO");
                    lbl3.setText("FECHA DE EXPIRACIÓN");
                    lbl4.setText("CÓDIGO DE SEGURIDAD");
                    break;

                case 3:
                    lbl1.setVisible(true);
                    lbl2.setVisible(true);
                    lbl3.setVisible(true);
                    lbl4.setVisible(false);
                    txt1.setVisible(true);
                    txt2.setVisible(true);
                    txt3.setVisible(true);
                    txt4.setVisible(true);
                    txt4.setVisible(false);
                    btnRealizarCompra.setDisable(false);
                    lbl1.setText("NÚMERO DE CUENTA:");
                    lbl2.setText("NOMBRE Y APELLIDO");
                    lbl3.setText("CANTIDAD A PAGAR");

                    break;
                case 4:
                    lbl1.setVisible(true);
                    lbl2.setVisible(true);
                    lbl3.setVisible(true);
                    lbl4.setVisible(false);
                    txt1.setVisible(true);
                    txt2.setVisible(true);
                    txt3.setVisible(true);
                    txt4.setVisible(true);
                    txt4.setVisible(false);
                    btnRealizarCompra.setDisable(false);
                    lbl1.setText("NÚMERO DE CUENTA:");
                    lbl2.setText("NOMBRE Y APELLIDO");
                    lbl3.setText("CANTIDAD A PAGAR");
                    break;
                case 5:
                    lbl1.setVisible(true);
                    lbl2.setVisible(true);
                    lbl3.setVisible(true);
                    lbl4.setVisible(false);
                    txt1.setVisible(true);
                    txt2.setVisible(true);
                    txt3.setVisible(true);
                    txt4.setVisible(true);
                    txt4.setVisible(false);
                    btnRealizarCompra.setDisable(false);
                    lbl1.setText("NÚMERO DE CUENTA:");
                    lbl2.setText("NOMBRE Y APELLIDO");
                    lbl3.setText("CANTIDAD A PAGAR");
                    break;
                case 6:
                    lbl1.setVisible(true);
                    lbl2.setVisible(true);
                    lbl3.setVisible(true);
                    lbl4.setVisible(false);
                    txt1.setVisible(true);
                    txt2.setVisible(true);
                    txt3.setVisible(true);
                    txt4.setVisible(true);
                    txt4.setVisible(false);
                    btnRealizarCompra.setDisable(false);
                    lbl1.setText("NÚMERO DE CUENTA:");
                    lbl2.setText("NOMBRE Y APELLIDO");
                    lbl3.setText("CANTIDAD A PAGAR");
                    break;
                default:
                    throw new AssertionError();
            }
        });
    }

}
