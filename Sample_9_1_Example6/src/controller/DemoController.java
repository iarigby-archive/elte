package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class DemoController implements Initializable {

    @FXML
    private GridPane buttonsPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 1; i <= 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button b = new Button("(" + i + ", " + j + ")");
                b.setPrefHeight(120);
                b.setPrefWidth(120);
                b.setBackground(new Background(new BackgroundFill(Color.DARKGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
                b.setStyle("-fx-border-style: solid");
                b.setOnMouseEntered(e -> b.setStyle("-fx-background-color: lightgreen; -fx-border-style: solid"));
                b.setOnMouseExited(e -> b.setStyle("-fx-background-color: darkgreen; -fx-border-style: solid"));
                buttonsPane.add(b, j, i);
            }
        }
        buttonsPane.add(new Label("Here's a label on (0, 1)"), 1, 0);
    }
}
