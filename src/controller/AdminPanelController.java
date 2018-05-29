package controller;
import java.net.URL;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.Device;

public class AdminPanelController implements Initializable{
	
	private EntityManager entityManager;
	private SceneController vbox;
	
	@FXML
	private VBox box;
	
	@FXML
	private GridPane newDevicePane;
	@FXML
	private TextField brandName;
	
	@FXML
	private TextField operatingSystem;
	
	@FXML
	private Button addDevice;
	//you can use id number to log in
	//
	@FXML
	private Label finalMessage;
	
	@Override
	public void initialize(URL url, ResourceBundle arg1) {
		entityManager = Context.getInstance().getEntityManager();
		vbox = new SceneController(box);
		box.getChildren().remove(newDevicePane);
	}
	
	@FXML 
	public void addDevice() {
		if(brandName.getText().isEmpty() || operatingSystem.getText().isEmpty()) {
			vbox.displayAlert(AlertType.ERROR, "Empty Fields", "Please fill in all the fields");
 		} else {
			Device device = new Device(brandName.getText(), operatingSystem.getText());
			entityManager.getTransaction().begin();
			entityManager.persist(device);
			entityManager.getTransaction().commit();
			brandName.clear();
			operatingSystem.clear();
			
			//finalMessage.setText("congrats, you've registered. Use your personal ID to log in");
 		}
		
	}
	
	@FXML
	public void goToMainMenu() {
		vbox.changeScene(Screens.MAIN);
	}
	
	@FXML
	public void showNewDeviceMenu() {
		box.getChildren().add(1, newDevicePane);
	}
	
}