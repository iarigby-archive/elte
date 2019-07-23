package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

public class ClickCountingTableController implements Initializable {

    private static final String DEFAULT_STYLE = "button";
    private static final String CLICKED_STYLE = "grayBackground";

    private int counter; // counter should be part of the model in case it wasn't the only model part

    @FXML
    private GridPane tableView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        generateTable(4);
    }

    @FXML
    private void newGame(ActionEvent event) {
        Button btn = (Button) event.getSource();
        String text = btn.getText();
        if (text.equals("4 x 4")) {
            generateTable(4);
        } else if (text.equals("6 x 6")) {
            generateTable(6);
        } else if (text.equals("8 x 8")) {
            generateTable(8);
        }
    }

    private void generateTable(int size) {
        counter = 1;
        tableView.getChildren().clear();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Button btn = new Button();
                btn.setOnAction(e -> showAndDisableButton(btn));
                tableView.add(btn, j, i);
            }
        }
    }

    private void showAndDisableButton(Button btn) {
        btn.setText("" + counter++);
        btn.setDisable(true);
        PauseTransition timer = new PauseTransition(Duration.millis(500));
        timer.setOnFinished(x -> {
            btn.getStyleClass().remove(DEFAULT_STYLE);
            btn.getStyleClass().add(CLICKED_STYLE);
        });
        timer.playFromStart();
    }
}
