package controller;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;

import helpers.Context;
import helpers.SceneController;
import helpers.Screens;
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
		boolean missingFields = false;
		for (TextField f : requiredFields) {
			if (f.getText().isEmpty()) missingFields = true;
		}
		if (missingFields) {
			vbox.displayAlert(AlertType.ERROR, "Missing Fields", "Please fill in all the fields");
		} else if (userExists(personal_id.getText())) {
			vbox.displayAlert(AlertType.ERROR, "Error", "User with this ID already exists");
		} else {
			addClient();
			finalMessage.setText("congrats, you've registered. Use your personal ID to log in");
			for (TextField f : requiredFields) f.clear();
		}
	}
	
	@FXML
	public void goToMainMenu() {
		vbox.changeScene(Screens.MAIN);
	}
	
	private void addClient() {
		Client client = new Client(name.getText(), address.getText(), personal_id.getText());
		entityManager.getTransaction().begin();
		entityManager.persist(client);
		entityManager.getTransaction().commit();
		
	}
	
	private boolean userExists(String id) {
		String s = "select count(e) from Client e where e.personal_id = :id";
	    Long count = (Long) entityManager.createQuery(s).setParameter("id", id).getSingleResult();
	    return count > 0; 
	}
	
}