package com.j9nos.brute_force_symbolic_regressor;

import java.math.BigDecimal;
import java.util.Objects;

public class Variable extends BigDecimal {
    private final String name;

    public Variable(final String value, final String name) {
        super(value);
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Variable variable = (Variable) o;
        return name.equals(variable.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
