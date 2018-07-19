package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.BiFunction;

public enum BinaryOperator {
    
    PLUS((l, r) -> l.add(r).stripTrailingZeros(), "+"),
    MINUS((l, r) -> l.subtract(r).stripTrailingZeros(), "-"),
    TIMES((l, r) -> l.multiply(r).stripTrailingZeros(), "*"),
    DIVISION((l, r) -> l.divide(r, 10, RoundingMode.HALF_EVEN).stripTrailingZeros(), "/");

    private final BiFunction<BigDecimal, BigDecimal, BigDecimal> calculation;
    private final String stringVersion;

    private BinaryOperator(BiFunction<BigDecimal, BigDecimal, BigDecimal> calculation, String stringVersion) {
        this.calculation = calculation;
        this.stringVersion = stringVersion;
    }

    public BigDecimal calculate(BigDecimal left, BigDecimal right) {
        return calculation.apply(left, right);
    }

    public String getStringVersion() {
        return stringVersion;
    }
    
}
