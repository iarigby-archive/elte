package controller;
import java.net.URL;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import helpers.Context;
import helpers.SceneController;
import helpers.Screens;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AdminPanelController implements Initializable{
	
	private SceneController vbox;
	private SceneController contentBox;
	private EntityManager entityManager;
	
	
	@FXML
	private VBox box;

	@FXML
	private HBox menu;
	
	@FXML
	private VBox content;
	
	
	@Override
	public void initialize(URL url, ResourceBundle arg1) {
		entityManager = Context.getInstance().getEntityManager();
		vbox = new SceneController(box);
		contentBox = new SceneController(content);
	}	
	
	@FXML
	public void goToMainMenu() {
		vbox.changeScene(Screens.MAIN);
	}
	
	@FXML
	public void goToDeviceMenu() {
		contentBox.changeScene(Screens.MODIFYDEVICES);
	}
	
	@FXML
	public void listUsages() {
		contentBox.changeScene(Screens.LISTUSAGES);
	}
	
	@FXML
	public void makeTheDreamComeTrue() {
		content.getChildren().clear();
		String qlString = "SELECT SUM(u.bill) FROM UsageUGH u";
		Query q = entityManager.createQuery(qlString);
		double sum = (double) q.getSingleResult();
		Label l = new Label();
		l.setText("All I want for Christmas is " + sum);
		content.getChildren().add(l);
	}
	
	@FXML
	public void listClients() {
		contentBox.changeScene(Screens.LISTCLIENTS);
	}
}