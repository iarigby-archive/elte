package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import application.Counter;


public class TableController implements Initializable {
	
	@FXML 
	private Button fxf;

	@FXML
	private Button sxs;
	
	@FXML
	private Button nxn;
	
	@FXML
	private BorderPane mainPane;
	
	@FXML
	private GridPane menu;
	
	@FXML
	private GridPane buttons;
	
	
	
	private final Counter counter = new Counter();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		fxf.setOnAction(ev -> {
			buttons.getChildren().clear();
			updateButtons(4);
		});
		
		sxs.setOnAction(ev -> {
			buttons.getChildren().clear();
			updateButtons(6);
		});
		
		nxn.setOnAction(ev -> {
			buttons.getChildren().clear();
			updateButtons(9);
		});
		
		
		
	}
	
	public void updateButtons(int n) {
		counter.reset();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				Button button = new Button();
				button.setOnAction(ev -> {
						counter.increase();
						button.setText(counter.toString());
						button.setStyle("-fx-background-color: gray;");
						button.setDisable(true);
					
				});
				buttons.add(button, i, j);
			}
		}
	}

}
