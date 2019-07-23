package controller;


import java.net.URL;
import java.util.ResourceBundle;
import java.util.TimeZone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import helpers.Context;
import helpers.SceneController;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
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
        vbox = new SceneController(window);
        //((Stage) window.getScene().getWindow()).setOnCloseRequest(e -> logOut());
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(60*1000),
                ae -> logOut()));
        timeline.play();
	}
	
	@FXML
	public void logOut() {
		text.setText("Calculating Bill...");	
		entityManager.getTransaction().begin();
		usage.getDevice().setFree(true);
		usage.calculateBill();
		entityManager.merge(usage);
		entityManager.getTransaction().commit();
		PauseTransition pause = new PauseTransition(Duration.seconds(1));
		pause.setOnFinished(event ->
		   text.setText("Your Bill is " + usage.getBill())
		);
		pause.play();
		PauseTransition pause2 = new PauseTransition(Duration.seconds(2));
		pause2.play();
		((Stage) window.getScene().getWindow()).close();
	}
	
	public void setUsageUGH(UsageUGH usage) {
		this.usage = usage;
	}
		
}
