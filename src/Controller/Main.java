package Controller;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {

        try {
            FXMLLoader loader = new FXMLLoader();
            //loader.setLocation(Main.class.getResource("/View/LoginVista.fxml"));
            loader.setLocation(Main.class.getResource("/View/CatalogoZapatosVista.fxml"));
            Pane ventana = (Pane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(ventana);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Bienvenido - Login");
            primaryStage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
