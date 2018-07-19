package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import model.Coordinate;
import model.KnightGame;

public class KnightController implements Initializable {

	@FXML
	private HBox sizeHBox;
	
	@FXML
	private GridPane buttonsPane;
	
	//@FXML
	private Label stepsCount;
	
	private Button currentLocation;
	
	private KnightGame game;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		addMenuButtons();
		newGame(6);
	}
	
	private void addMenuButtons() {
		String s;
		for (int i = 6; i <= 10; i+=2 ) {
			final int size = i;
			s = Integer.toString(i);
			Button button = new Button(s + " x " + s);
			button.setOnAction(a -> newGame(size));
			sizeHBox.getChildren().add(button);
		}
		Label steps = new Label("Steps: ");
		stepsCount = new Label();
		sizeHBox.getChildren().addAll(steps, stepsCount);
	}
	
	private void newGame(int size) {
		buttonsPane.getChildren().clear();
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				Button button = new Button();
				button.setOnAction(ev -> makeMove(button));
				buttonsPane.add(button, i, j);
			}
		}
		game = new KnightGame(size);
		Button startingButton = (Button) buttonsPane.getChildren().get(game.getNodeIndex());
		startingButton.setDisable(true);
		updateStepsCount();
		currentLocation = startingButton;
		currentLocation.setStyle("-fx-background-color: #ffaf99;");
		checkProgress();
	}
	
	private void makeMove(Button button) {
		Coordinate coordinate = toCoordinate(button);
		if (game.nextStep(coordinate)) {
			if (null != currentLocation)
				currentLocation.setStyle("-fx-background-color: #ff6da7;");
			button.setDisable(true);
			updateStepsCount();
			currentLocation = button;
			currentLocation.setStyle("-fx-background-color: #ff9e59;");
			checkProgress();
		}
	}
	
	private void updateStepsCount() {
		stepsCount.setText(Integer.toString(game.getStepsCount()));
	}
	
	private Coordinate toCoordinate(Button button) {
		return new Coordinate(GridPane.getRowIndex(button),GridPane.getColumnIndex(button));
	}
	
	
	private void checkProgress() {
		if (game.isGameWon()) {
			showMessage("Yay", "You did it");
			newGame(game.getSize());
		} else if (game.isStuck()) {
			showMessage("Oh no:(", "You got stuck");
			newGame(game.getSize());
		}
	}
	
	 private void showMessage(String title, String contentText) {
	        Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle(title);
	        alert.setHeaderText(null);
	        alert.setContentText(contentText);
	        alert.showAndWait();
	    }
}
