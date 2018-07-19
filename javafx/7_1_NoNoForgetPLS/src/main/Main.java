package main;

import java.util.TimeZone;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            TimeZone.setDefault(TimeZone.getTimeZone("Europe/Budapest"));

            VBox root = (VBox) FXMLLoader.load(getClass().getResource("../view/MainWindow.fxml"));
            Scene scene = new Scene(root, 900, 420);
            scene.getStylesheets().add(getClass().getResource("../view/style.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.setTitle("NoNoForgetPLS");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
