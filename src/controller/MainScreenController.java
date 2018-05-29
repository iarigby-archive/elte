package controller;


import java.net.URL;
import java.util.ResourceBundle;
import java.util.TimeZone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import helpers.Context;
import helpers.SceneController;
import helpers.Screens;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainScreenController implements Initializable {

	private EntityManagerFactory emfactory;
    private EntityManager entityManager;
    private SceneController vbox;

    @FXML 
    private VBox window;
    
    @FXML
    private HBox sections;
    
    @FXML
    private VBox content;
    
    @FXML
    private VBox box;
    
    @FXML
    private VBox currentSessions;
    
    @FXML
    private Button logIn;
    
    @FXML
    private Button register;
    
    @FXML
    private Button adminLogin;
   
	@Override
	public void initialize(URL url, ResourceBundle arg1) {
		TimeZone.setDefault(TimeZone.getTimeZone("Europe/Budapest"));
        emfactory = Persistence.createEntityManagerFactory("InternetCoffeeShop_PU");
        entityManager = emfactory.createEntityManager();
        Context.getInstance().setEntityManager(entityManager);        
        //menuBar.setFocusTraversable(true);
        vbox = new SceneController(content);
	}
	
	@FXML
	public void goToLogIn() {
		vbox.changeScene(Screens.LOGIN);
	}
	
	@FXML
	public void goToRegistration() {
		vbox.changeScene(Screens.REGISTRATION);
    }
	
	@FXML
	public void goToAdminPanel() {
		vbox.changeScene(Screens.ADMINPANEL);
	}
		
}
