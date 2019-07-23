package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class DemoController implements Initializable {

    @FXML
    private GridPane buttonsPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 1; i <= 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttonsPane.add(new Button("(" + i + ", " + j + ")"), j, i);
            }
        }
        buttonsPane.add(new Label("Here's a label on (0, 1)"), 1, 0);
    }
}
