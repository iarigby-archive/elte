package controller;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import helpers.Context;
import helpers.SceneController;
import helpers.Screens;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Device;

public class ModifyDevicesController implements Initializable{
	
	private EntityManager entityManager;
	private SceneController vbox;
	
	@FXML
	private VBox box;
	
	@FXML
	private VBox info;
	
	@FXML
	private HBox modifyDevices;
	
	
	@FXML
	private TextField brandNameField;
	
	@FXML
	private TextField newBN, newOS;
	
	@FXML
	private TableView<Device> tableView;
	
	@FXML
	private TextField operatingSystemField;
	
	@FXML
	private Button addDevice;
	
	@FXML
    private TableColumn<Device, String> brandName;

    @FXML
    private TableColumn<Device, String> operatingSystem;
    
   	private Device selectedDevice;
	
	@Override
	public void initialize(URL url, ResourceBundle arg1) {
		entityManager = Context.getInstance().getEntityManager();
		vbox = new SceneController(box);
		listDevices();
		tableView.setEditable(true);
		brandName.setCellValueFactory(new PropertyValueFactory<>("brandName"));
		brandName.setOnEditCommit(ev -> 
            ((Device) ev.getTableView().getItems().get(
                        ev.getTablePosition().getRow()))
            		.setBrandName(ev.getNewValue())
            
        );
		operatingSystem.setCellValueFactory(new PropertyValueFactory<>("operatingSystem"));
		operatingSystem.setOnEditCommit(ev ->
		 	((Device) ev.getTableView().getItems().get(
                 ev.getTablePosition().getRow()))
     			.setOperatingSystem(ev.getNewValue())
			);
	}
	
	@FXML 
	public void addDevice() {
		if(brandNameField.getText().isEmpty() || operatingSystemField.getText().isEmpty()) {
			vbox.displayAlert(AlertType.ERROR, "Empty Fields", "Please fill in all the fields");
 		} else {
			Device device = new Device(brandNameField.getText(), operatingSystemField.getText());
			entityManager.getTransaction().begin();
			entityManager.persist(device);
			entityManager.getTransaction().commit();
			brandNameField.clear();
			operatingSystemField.clear();
			listDevices();
 		}	
		
	}
	
	@FXML
	public void listDevices() {
		if(!box.getChildren().contains(modifyDevices)) box.getChildren().add(1, modifyDevices);
		tableView.getItems().clear();
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Device> devicesQuery = cb.createQuery(Device.class);
        Root<Device> root = devicesQuery.from(Device.class);
        devicesQuery.select(root);
        List<Device> freeDevices = entityManager.createQuery(devicesQuery).getResultList();
        for (Device device : freeDevices) {
        	tableView.getItems().add(device);
        }
        tableView.setRowFactory(tv -> {
            TableRow<Device> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
               selectedDevice = row.getItem();
               newBN.setText(selectedDevice.getBrandName());
               newOS.setText(selectedDevice.getOperatingSystem());
            });
            return row ;
        });       
	}
	
	@FXML
	public void goToMainMenu() {
		vbox.changeScene(Screens.MAIN);
	}
	
	@FXML
	public void deleteDevice() {
		if(selectedDevice == null) {
			vbox.displayMissingSelectAlert();
		} else {
			entityManager.getTransaction().begin();
			entityManager.remove(selectedDevice);
			entityManager.getTransaction().commit();
			tableView.getItems().remove(selectedDevice);
		}
	}
	
	@FXML
	public void saveChanges() {
		if (selectedDevice == null) {
			vbox.displayMissingSelectAlert();
		} else if (newBN.getText().isEmpty() || newOS.getText().isEmpty()) {
			vbox.displayMissingFieldAlert();
		} else {
			selectedDevice.setBrandName(newBN.getText());
			selectedDevice.setOperatingSystem(newOS.getText());
			entityManager.getTransaction().begin();
			entityManager.persist(selectedDevice);
			entityManager.getTransaction().commit();
			listDevices();
		}
	}
		
}