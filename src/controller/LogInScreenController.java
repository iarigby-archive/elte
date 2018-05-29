package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Client;
import model.Client_;
import model.Device;
import model.Device_;
import model.UsageUGH;

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
    
    private Device selectedDevice;

    
	@Override
	public void initialize(URL url, ResourceBundle arg1) {
		entityManager = Context.getInstance().getEntityManager();
		vbox = new SceneController(box);
		signIn.setVisible(false);
		
		brandName.setCellValueFactory(new PropertyValueFactory<>("brandName"));
		operatingSystem.setCellValueFactory(new PropertyValueFactory<>("operatingSystem"));
		
		listDevices();
	}
	
	@FXML
	public void listDevices() {
		signIn.setVisible(true);
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Device> devicesQuery = cb.createQuery(Device.class);
        Root<Device> root = devicesQuery.from(Device.class);
        devicesQuery.where(cb.and(
        		cb.equal(root.get(Device_.isFree), true)));
        devicesQuery.select(root);
        List<Device> freeDevices = entityManager.createQuery(devicesQuery).getResultList();
        for (Device device : freeDevices) {
        	tableView.getItems().add(device);
        }
        tableView.setRowFactory(tv -> {
            TableRow<Device> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
               selectedDevice = row.getItem();
                
            });
            return row ;
        });       
	}
	
	@FXML
	public void signIn() {
		Client client = getClient(personal_ID.getText());
		if (client == null) {
			vbox.displayAlert(AlertType.ERROR, "error", "the id you entered is incorrect");
		} else if (selectedDevice == null) {
			vbox.displayAlert(AlertType.ERROR, "error", "please select device");
		} else {
			UsageUGH usage = new UsageUGH(client, selectedDevice);
			entityManager.getTransaction().begin();
			entityManager.persist(usage);
			entityManager.getTransaction().commit();
			openNewSession(usage);	
		}
	}
	
	@FXML
	public void goToMainMenu() {
		vbox.changeScene(Screens.MAIN);
	}
	
	private void openNewSession(UsageUGH usage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(Screens.SESSION.toString()));
			Scene scene = new Scene((VBox) loader.load(), 600, 400);
	        Stage stage = new Stage();
	        stage.setTitle("New Window");
	        stage.setScene(scene);
	        stage.show();
	        ((SessionScreenController) loader.getController()).setUsageUGH(usage);
	       
	    } catch (IOException e) {
	    	vbox.displayAlert(AlertType.ERROR, "REEEE", "REEEE");
	    	e.printStackTrace();
	    }
	}
	
	private Client getClient(String id) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Client> devicesQuery = cb.createQuery(Client.class);
        Root<Client> root = devicesQuery.from(Client.class);
        devicesQuery.where(cb.and(
        		cb.equal(root.get(Client_.personal_id), id)));
        devicesQuery.select(root);
    	try {
    		return entityManager.createQuery(devicesQuery).getSingleResult();
    	} catch (Exception e) {
    		return null;
    	}
	}
	
	
	
}
