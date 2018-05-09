package controller;
import java.net.URL;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.Client;

public class RegisterController implements Initializable{
	
	private EntityManager entityManager;
	private SceneController vbox;
	
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
	//you can use id number to log in
	//
	@FXML
	private Label finalMessage;
	
	@Override
	public void initialize(URL url, ResourceBundle arg1) {
		entityManager = Context.getInstance().getEntityManager();
		vbox = new SceneController(box);
	}
	
	@FXML 
	public void register() {
		Client client = new Client(name.getText(), address.getText(), personal_id.getText());
		entityManager.getTransaction().begin();
		entityManager.persist(client);
		entityManager.getTransaction().commit();
		finalMessage.setText("congrats, you've registered. Use your personal ID to log in");
	}
	
	@FXML
	public void goToMainMenu() {
		vbox.changeScene(Screens.MAIN);
	}
}