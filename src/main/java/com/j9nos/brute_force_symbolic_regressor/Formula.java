package com.j9nos.brute_force_symbolic_regressor;

import java.util.ArrayList;
import java.util.Objects;

public record Formula(ArrayList<Variable> variables, ArrayList<Operator> operators, Variable output) {

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append('(' )
                .append(variables.get(0));
        for (int i = 0; i < operators.size(); i++) {
            stringBuilder
                    .append(operators.get(i))
                    .append(variables.get(i + 1))
                    .append(')' );
        }
        return stringBuilder.append(")=").append(output).toString();
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        final Formula otherFormula = (Formula) other;
        return Objects.equals(variables, otherFormula.variables) && Objects.equals(operators, otherFormula.operators)
                && Objects.equals(output, otherFormula.output);
    }

    @Override
    public int hashCode() {
        return Objects.hash(variables, operators, output);
    }
}
