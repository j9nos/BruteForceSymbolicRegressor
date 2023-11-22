package com.j9nos.brute_force_symbolic_regressor;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public enum Operator {

    ADDITION("+") {
        @Override
        public BigDecimal execute(final BigDecimal left, final BigDecimal right) {
            return left.add(right);
        }
    },

    SUBTRACTION("-") {
        @Override
        public BigDecimal execute(final BigDecimal left, final BigDecimal right) {
            return left.subtract(right);
        }
    },

    MULTIPLICATION("*") {
        @Override
        public BigDecimal execute(final BigDecimal left, final BigDecimal right) {
            return left.multiply(right);
        }
    },

    DIVISION("/") {
        @Override
        public BigDecimal execute(final BigDecimal left, final BigDecimal right) {
            if (!right.equals(BigDecimal.ZERO)) {
                return left.divide(right, new MathContext(10, RoundingMode.HALF_UP));
            }
            throw new ArithmeticException("Cannot divide by zero");
        }
    };

    public abstract BigDecimal execute(BigDecimal left, BigDecimal right);

    private final String identifier;

    Operator(final String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return identifier;
    }
}
