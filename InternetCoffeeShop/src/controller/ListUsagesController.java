package controller;
import java.net.URL;
import java.util.Date;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.UsageUGH;

public class ListUsagesController implements Initializable{
	
	private EntityManager entityManager;
	private SceneController vbox;
	
	@FXML
	private VBox box;
	
	@FXML
	private VBox info;
	
	@FXML
	private HBox usages;
	
	@FXML
	private TableView<UsageUGH> tableView;
	
	@FXML
    private TableColumn<UsageUGH, Integer> client;

    @FXML
    private TableColumn<UsageUGH, Integer> device;
    
    @FXML
    private TableColumn<UsageUGH, Date> logInTime;
    
    @FXML
    private TableColumn<UsageUGH, Date> logOutTime;

    @FXML
    private TableColumn<UsageUGH, Float> bill;

    @FXML
    private Label deviceDetails;
    
    @FXML
    private Label clientDetails;

	
	private UsageUGH selectedUsageUGH;
	
	@Override
	public void initialize(URL url, ResourceBundle arg1) {
		entityManager = Context.getInstance().getEntityManager();
		vbox = new SceneController(box);
		client.setCellValueFactory(new PropertyValueFactory<>("client"));
		device.setCellValueFactory(new PropertyValueFactory<>("device"));
		logInTime.setCellValueFactory(new PropertyValueFactory<>("logInTime"));
		logOutTime.setCellValueFactory(new PropertyValueFactory<>("logOutTime"));
		bill.setCellValueFactory(new PropertyValueFactory<>("bill"));
		listUsageUGHs();
	}
	
	
	@FXML
	public void listUsageUGHs() {
		tableView.getItems().clear();
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UsageUGH> devicesQuery = cb.createQuery(UsageUGH.class);
        Root<UsageUGH> root = devicesQuery.from(UsageUGH.class);
        devicesQuery.select(root);
        List<UsageUGH> freeUsageUGHs = entityManager.createQuery(devicesQuery).getResultList();
        for (UsageUGH usage : freeUsageUGHs) {
        	tableView.getItems().add(usage);
        }
        tableView.setRowFactory(tv -> {
            TableRow<UsageUGH> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
               selectedUsageUGH = row.getItem();
               if (selectedUsageUGH != null) {
            	   info.getChildren().clear();
            	   vbox.displayInfo(info, selectedUsageUGH.getClient());
            	   vbox.displayInfo(info, selectedUsageUGH.getDevice());
               }
            });
            return row ;
        });       
	}
	
	@FXML
	public void goToMainMenu() {
		vbox.changeScene(Screens.MAIN);
	}
	
	

	
}