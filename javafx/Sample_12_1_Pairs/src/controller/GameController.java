package controller;

import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;
import model.Coordinate;
import model.PairTable;

public class GameController implements Initializable {

    @FXML
    private HBox sizeHBox;

    @FXML
    private Label stepsLabel;

    @FXML
    private GridPane buttonsPane;

    private final PairTable gameTable = new PairTable();

    private boolean suspended;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addSizeButtons();
        newGame(4);
    }

    private void addSizeButtons() {
        for (int size = 2; size <= 6; size += 2) {
            final int finalSize = size;
            String sizeAsString = Integer.toString(size);
            Button sizeButton = new Button(sizeAsString + " x " + sizeAsString);
            sizeButton.setOnAction(a -> newGame(finalSize));
            sizeHBox.getChildren().add(sizeButton);
        }
    }

    private void newGame(int size) {
        suspended = false;
        gameTable.newGame(size);
        buttonsPane.getChildren().clear();
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                Button b = new Button();
                b.getStyleClass().add("tableButton");
                final int x = i;
                final int y = j;
                b.setOnAction(e -> step(b, x, y));
                buttonsPane.add(b, i, j);
            }
        }
    }

    private void step(Button selected, int i, int j) {
        if (!suspended) {
            setButtonTextToField(selected, i, j);
            selected.setDisable(true);

            gameTable.discover(i, j);
            if (gameTable.bothDiscovered()) {
                if (!gameTable.checkPairs()) {
                    suspended = true;
                    Set<Coordinate> coords = gameTable.getPairCoordinates();
                    PauseTransition timer = new PauseTransition(Duration.seconds(1));
                    timer.setOnFinished(x -> {
                        bringButtonsBackToGame(coords);
                        suspended = false;
                    });
                    timer.playFromStart();
                }
                gameTable.newRound();
                checkGameEndAndRestart();
            }
        }
    }

    private void setButtonTextToField(Button btn, int i, int j) {
        btn.setText(Integer.toString(gameTable.getField(i, j)));
    }

    private void bringButtonsBackToGame(Collection<Coordinate> buttonCoordinates) {
        buttonCoordinates.forEach(coord -> {
            Button btn = (Button) buttonsPane.getChildren().get(coord.getX() * gameTable.getSize() + coord.getY());
            btn.setText("");
            btn.setDisable(false);
        });
    }

    private void checkGameEndAndRestart() {
        if (gameTable.isFull()) {
            showMessage("Yes, you did it!", "Congrats, you have won this game as you discovered all fields.\n");
            newGame(gameTable.getSize());
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
