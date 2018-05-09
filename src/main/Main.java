package main;

import controller.Screens;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	 @Override
	 public void start(Stage primaryStage) {
		 try {
			VBox root = (VBox) FXMLLoader.load(getClass().getResource(Screens.MAIN.toString()));
			Scene scene = new Scene(root, 500, 700);
            //scene.getStylesheets().add(getClass().getResource("../view/style.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setResizable(true);
            primaryStage.setTitle("Internet Coffee Shop");
            primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
	 
	 public static void main(String[] args) {
		launch(args); 
	 }
}
