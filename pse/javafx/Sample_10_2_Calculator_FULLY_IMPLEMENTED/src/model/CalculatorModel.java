package model;

import java.math.BigDecimal;

public class CalculatorModel {

    private final ExpressionOperandPair pair = new ExpressionOperandPair();
    private BinaryOperator operator;
    private boolean isOperatorJustPressed = false;

    public void reset() {
        pair.reset();
    }

    public void calculateResult() {
        isOperatorJustPressed = true;
        String expression = pair.getExpression();
        if (expression != null) {
            BigDecimal first = new BigDecimal(expression.split(" ")[0]);
            BigDecimal result = operator.calculate(first, pair.getOperand());
            pair.setExpression(null);
            pair.setOperand(result);
        }
    }

    public void updateOperator(BinaryOperator operator) {
        this.operator = operator;
        String expression = pair.getExpression();
        if (expression == null) {
            pair.setExpression(pair.getOperand().toString() + " " + operator.getStringVersion());
            isOperatorJustPressed = true;
        } else {
            pair.setExpression(expression.substring(0, expression.length() - 1) + operator.getStringVersion());
        }
    }

    public void updateOperand(int digit) {
        if (isOperatorJustPressed) {
            setToDefaultOperand();
            isOperatorJustPressed = false;
        }
        BigDecimal operand = pair.getOperand();
        if (BigDecimal.ZERO.equals(operand)) {
            pair.setOperand(new BigDecimal(digit));
        } else {
            pair.setOperand(operand.multiply(new BigDecimal(10)).add(new BigDecimal(digit)));
        }
    }

    public ExpressionOperandPair getExpressionOperandPair() {
        return pair;
    }

    public void setToDefaultOperand() {
        pair.setOperand(BigDecimal.ZERO);
    }
}
