package helpers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Client;
import model.Device;
import model.Tuple;


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
	
	public void displayMissingSelectAlert() {
		displayAlert(AlertType.ERROR, "Error", "Please select device");
	}
	
	public void displayMissingFieldAlert() {
		displayAlert(AlertType.ERROR, "Error", "Some Fields are empty");
	}
	
	
	public void setBox(VBox box) {
		this.box = box;
	}
	
	public void displayInfo(VBox vbox, Client client) {
		displayInfo("Client", vbox,
				new Tuple("Name", client.getName()),
				new Tuple("Address", client.getAddress()),
				new Tuple("Personal ID", client.getPersonal_id())
				);
	}
	
	public void displayInfo(VBox vbox, Device device) {
		displayInfo("Device", vbox,
				new Tuple("Brand Name", device.getOperatingSystem()),
				new Tuple("Operating System", device.getOperatingSystem()));
	}
	
	public void displayInfo(String header, VBox vbox, Tuple...data) {
		vbox.getChildren().add(new Label(header +  " Info: "));
		for (Tuple tuple : data) {
			vbox.getChildren().add(new HBox(10,
				new Label(tuple.getName() + ": "),
				new Label(tuple.getData())
				)
			);
		}
		
	}
		
}
