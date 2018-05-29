package controller;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.Client;

public class RegisterController implements Initializable{
	
	private EntityManager entityManager;
	private SceneController vbox;
	private List<TextField> requiredFields = new ArrayList<TextField>();
	
	@FXML
	private VBox box;
	
	@FXML
	private GridPane pane;
	@FXML
	private TextField name;
	
	@FXML
	private TextField address;
	
	@FXML
	private TextField personal_id;
	
	@FXML
	private Button register;
	
	@FXML
	private Label finalMessage;
	
	@Override
	public void initialize(URL url, ResourceBundle arg1) {
		entityManager = Context.getInstance().getEntityManager();
		vbox = new SceneController(box);
		requiredFields.add(name);
		requiredFields.add(personal_id);
		requiredFields.add(address);
	}
	
	@FXML 
	public void register() {
		boolean canRegister = true;
		for (TextField f : requiredFields) {
			if (f.getText().isEmpty()) canRegister = false;
		}
		if (canRegister) {
			Client client = new Client(name.getText(), address.getText(), personal_id.getText());
			entityManager.getTransaction().begin();
			entityManager.persist(client);
			entityManager.getTransaction().commit();
			finalMessage.setText("congrats, you've registered. Use your personal ID to log in");
			for (TextField f : requiredFields) f.clear();
		} else {
			vbox.displayAlert(AlertType.ERROR, "Missing Fields", "Please fill in all the fields");
		}
	}
	
	@FXML
	public void goToMainMenu() {
		vbox.changeScene(Screens.MAIN);
	}
}