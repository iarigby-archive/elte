package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import model.BinaryOperator;
import model.CalculatorModel;
import model.ExpressionOperandPair;

public class CalculatorController implements Initializable {

    private final CalculatorModel model = new CalculatorModel();
    @FXML
    private Label expressionLabel;
    @FXML
    private Label operandLabel;
    @FXML
    private GridPane from1to9Pane;
    @FXML
    private BorderPane mainPane;
    @FXML
    private Button zeroButton;
    @FXML
    private Button addButton;
    @FXML
    private Button subtractButton;
    @FXML
    private Button multiplyButton;
    @FXML
    private Button divideButton;
    @FXML
    private Button equalsButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bindKeysAndAnimation();
        updateLabels();
        zeroButton.setOnAction(ev -> updateOperand(0));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int value = 9 - 3 * j - (2 - i);
                Button button = new Button(String.valueOf(value));
                button.setOnAction(ev -> updateOperand(value));
                from1to9Pane.add(button, i, j);
            }
        }
        addButton.setOnAction(ev -> updateOperator(BinaryOperator.PLUS));
        subtractButton.setOnAction(ev -> updateOperator(BinaryOperator.MINUS));
        multiplyButton.setOnAction(ev -> updateOperator(BinaryOperator.TIMES));
        divideButton.setOnAction(ev -> updateOperator(BinaryOperator.DIVISION));
        equalsButton.setOnAction(ev -> {
            model.calculateResult();
            updateLabels();
        });
    }

    private void bindKeysAndAnimation() {
        mainPane.setOnKeyTyped(ev -> {
            String buttonText = ev.getCharacter();
            Button pressed = null;
            if ("0".equals(buttonText)) {
                pressed = zeroButton;
            } else if (Character.isDigit(buttonText.charAt(0))) {
                pressed = findPressedGreaterThanZeroButton(buttonText);
            } else if (addButton.getText().equals(buttonText)) {
                pressed = addButton;
            } else if (subtractButton.getText().equals(buttonText)) {
                pressed = subtractButton;
            } else if (multiplyButton.getText().equals(buttonText)) {
                pressed = multiplyButton;
            } else if (divideButton.getText().equals(buttonText)) {
                pressed = divideButton;
            } else if (equalsButton.getText().equals(buttonText)) {
                pressed = equalsButton;
            }
            if (pressed != null) {
                animatePressedButton(pressed);
            }
        });
        mainPane.setOnKeyPressed(ev -> {
            Button pressed = null;
            if (ev.getCode().equals(KeyCode.ENTER)) {
                pressed = equalsButton;
            } else if (ev.getCode().equals(KeyCode.ESCAPE)) {
                model.reset();
                updateLabels();
            }
            if (pressed != null) {
                animatePressedButton(pressed);
            }
        });
    }

    private void updateLabels() {
        ExpressionOperandPair pair = model.getExpressionOperandPair();
        expressionLabel.setText(pair.getExpression());
        operandLabel.setText(pair.getOperand().toString());
    }

    private Button findPressedGreaterThanZeroButton(String digitText) {
        for (Node node : from1to9Pane.getChildren()) {
            Button digitButton = (Button) node;
            if (digitButton.getText().equals(digitText)) {
                return digitButton;
            }
        }
        return null;
    }

    private void updateOperand(int value) {
        model.updateOperand(value);
        updateLabels();
    }

    private void updateOperator(BinaryOperator operator) {
        model.updateOperator(operator);
        updateLabels();
    }

    private void animatePressedButton(Button button) {
        Button pressed = button;
        pressed.arm();
        pressed.fire();
        PauseTransition pause = new PauseTransition(Duration.seconds(0.3));
        pause.setOnFinished(e -> pressed.disarm());
        pause.play();
    }
}
