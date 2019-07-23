package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import model.ButtonModel;

public class ButtonController implements Initializable{

	private static final String DEFAULT_STYLE = "red";
	private static final String SPECIAL_STYLE = "black";
	
	@FXML
	private Button mainButton;
	
	private ButtonModel buttonModel = new ButtonModel();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		mainButton.setText(buttonModel.toString());
		mainButton.setOnAction(e -> changeColor());
	}
	
	private void changeColor() {
		mainButton.setText(buttonModel.toString());
		buttonModel.increaseCounter();
	}

}
