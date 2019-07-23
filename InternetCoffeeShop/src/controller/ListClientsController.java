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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import model.Client;

public class ListClientsController implements Initializable{
	
	private EntityManager entityManager;
	private SceneController vbox;
	
	@FXML
	private VBox box;
	
	@FXML
	private TableView<Client> tableView;
	
	@FXML
	private Button addDevice;
	
	@FXML
    private TableColumn<Client, String> name;

    @FXML
    private TableColumn<Client, String> address;

    @FXML
    private TableColumn<Client, String> personal_id;
    
	@Override
	public void initialize(URL url, ResourceBundle arg1) {
		entityManager = Context.getInstance().getEntityManager();
		vbox = new SceneController(box);
		listClients();
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		address.setCellValueFactory(new PropertyValueFactory<>("address"));
		personal_id.setCellValueFactory(new PropertyValueFactory<>("personal_id"));
	}
	
	@FXML
	public void listClients() {
		tableView.getItems().clear();
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Client> devicesQuery = cb.createQuery(Client.class);
        Root<Client> root = devicesQuery.from(Client.class);
        devicesQuery.select(root);
        List<Client> freeDevices = entityManager.createQuery(devicesQuery).getResultList();
        for (Client device : freeDevices) {
        	tableView.getItems().add(device);
        }
        tableView.setRowFactory(tv -> {
            TableRow<Client> row = new TableRow<>();
            return row ;
        });       
	}
	
	@FXML
	public void goToMainMenu() {
		vbox.changeScene(Screens.MAIN);
	}
		
}