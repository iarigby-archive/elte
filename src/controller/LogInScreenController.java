package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.Device;

public class LogInScreenController implements Initializable{
	
	private EntityManager entityManager;
	private SceneController vbox;
	
	@FXML
	private TextField personal_ID;
	
	@FXML
	private VBox box;
	
	@FXML
	private Menu devices;
	
	@FXML
	private Button signIn;
	
	 @FXML
    private TableView<Device> tableView;

    @FXML
    private TableColumn<Device, String> brandName;

    @FXML
    private TableColumn<Device, String> operatingSystem;
    
    //private Device selectedDevice;

   
	@Override
	public void initialize(URL url, ResourceBundle arg1) {
		entityManager = Context.getInstance().getEntityManager();
		vbox = new SceneController(box);
		signIn.setVisible(false);
	}
	
	@FXML
	public void listDevices() {
		signIn.setVisible(true);
		entityManager.getTransaction();
	}
	
	@FXML
	public void signIn() {
		
	}
	
	@FXML
	public void goToMainMenu() {
		vbox.changeScene(Screens.MAIN);
	}
	
	
}
