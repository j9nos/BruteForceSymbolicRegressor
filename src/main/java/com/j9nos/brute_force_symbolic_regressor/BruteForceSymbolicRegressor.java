package com.j9nos.brute_force_symbolic_regressor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;

public final class BruteForceSymbolicRegressor {
    private static final BigDecimal TOLERANCE = BigDecimal.ZERO;
    private final Variable output;
    private final Variable[] inputs;
    private final HashSet<Formula> potentialFormulas;

    public BruteForceSymbolicRegressor(final Variable output, final Variable[] inputs) {
        this.output = output;
        this.inputs = inputs;
        potentialFormulas = new HashSet<>();
    }

    private void calculate(final ArrayList<Variable> variables, final ArrayList<Operator> operators) {
        BigDecimal result = variables.get(0);
        try {
            for (int i = 0; i < operators.size(); i++) {
                result = operators.get(i).execute(result, variables.get(i + 1));
            }
            if (acceptable(result)) {
                potentialFormulas.add(new Formula(variables, operators, output));
            }
        } catch (final ArithmeticException ignored) {
        }
    }

    private boolean acceptable(final BigDecimal result) {
        return result.subtract(output).abs().compareTo(TOLERANCE) <= 0;
    }

    public void regress(final int numberOfUsableVariables) {
        if (numberOfUsableVariables <= 0 || numberOfUsableVariables > inputs.length) {
            throw new RuntimeException("Out of boundary");
        }
        Permutator.permutate(numberOfUsableVariables, inputs, new ArrayList<>(), variables
                -> Permutator.permutate(variables.size() - 1, Operator.values(), new ArrayList<>(), operators
                -> calculate(variables, operators)));
    }

    public HashSet<Formula> getPotentialFormulas() {
        return potentialFormulas;
    }
}
