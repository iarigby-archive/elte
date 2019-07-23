package controller;


import java.net.URL;
import java.util.ResourceBundle;


import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;

import javafx.animation.PauseTransition;
import javafx.util.Duration;


import model.PairsModel;

public class PairsController implements Initializable {
	@FXML
	private Button txt;
	
	@FXML
	private Button fxf;
	
	@FXML
	private Button sxs;
	
	@FXML
	private GridPane gamePane;
	
	private Button currentButton;
	
	PairsModel pairsModel = new PairsModel(18);

	@Override
	public void initialize(URL location, ResourceBundle resource) {
		txt.setOnAction(ev -> newGame(2));
		fxf.setOnAction(ev -> newGame(4));
		sxs.setOnAction(ev -> newGame(6));
	}

	public void newGame(int size) {
		gamePane.getChildren().clear();
		pairsModel.GenerateTable(size);
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				Button button = new Button();
				button.setOnAction(ev -> openButton(button));
				gamePane.add(button, i, j);
			}
		}
	}
	
	public void openButton(Button button) {
		if(button != currentButton) {
			int i = GridPane.getRowIndex(button);
			int j = GridPane.getColumnIndex(button);
			button.setText(Integer.toString(pairsModel.getElement(i, j)));
			if (null != currentButton) {
				boolean openButton = pairsModel.openButton(i, j);
				System.out.println(openButton);
				if(openButton) {
					currentButton.setDisable(true);
					button.setDisable(true);
					currentButton = null;
				} else {
					showAndDisableButton(button, currentButton);
					currentButton = null;
				}
			} else {
				currentButton = button;
				pairsModel.openButton(i, j);
			}
		}
		
	}
	
	public void showAndDisableButton(Button button, Button currentButton) {
		PauseTransition timer = new PauseTransition(Duration.millis(1000));
		timer.setOnFinished(x -> {
			button.setText("");
			currentButton.setText("");
		});
		timer.playFromStart();
	}
}
