package controller;


import java.net.URL;
import java.util.ResourceBundle;
import java.util.TimeZone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.UsageUGH;

public class SessionScreenController implements Initializable {

	private EntityManagerFactory emfactory;
    private EntityManager entityManager;
    private SceneController vbox;

    @FXML 
    private VBox window;
    
   @FXML
   private Label text;
   
   @FXML
   private Label time;
      
   private UsageUGH usage;
   
	@Override
	public void initialize(URL url, ResourceBundle arg1) {
		TimeZone.setDefault(TimeZone.getTimeZone("Europe/Budapest"));
        emfactory = Persistence.createEntityManagerFactory("InternetCoffeeShop_PU");
        entityManager = emfactory.createEntityManager();
        Context.getInstance().setEntityManager(entityManager);        
        //menuBar.setFocusTraversable(true);
        vbox = new SceneController(window);
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
	public void logOut() {
		entityManager.getTransaction().begin();
		usage.calculateBill();
		entityManager.merge(usage);
		entityManager.getTransaction().commit();
		((Stage) window.getScene().getWindow()).close();
	}
	
	public void setUsageUGH(UsageUGH usage) {
		this.usage = usage;
	}
		
}
