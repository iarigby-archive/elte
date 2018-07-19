package model;

import java.math.BigDecimal;

public class ExpressionOperandPair {

    private String expression;
    private BigDecimal operand;

    public ExpressionOperandPair() {
        reset();
    }

    public void reset() {
        expression = null;
        operand = BigDecimal.ZERO;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public BigDecimal getOperand() {
        return operand;
    }

    public void setOperand(BigDecimal operand) {
        this.operand = operand;
    }
}
