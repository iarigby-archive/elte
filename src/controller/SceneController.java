package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;

public class SceneController {
	
	@FXML
	VBox box;
	
	public SceneController(VBox box) {
		this.box = box;
	}
	
	public void changeScene(Screens path) {
		box.getChildren().clear();
		 try {
           box.getChildren().add(FXMLLoader.load(getClass().getResource(path.toString())));
       } catch (IOException e) {
           e.printStackTrace();
       }
	}
	
	public void displayAlert(AlertType at, String title, String text) {
		Alert alert = new Alert(at);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
	}
	
	
	public void setBox(VBox box) {
		this.box = box;
	}
		
}
