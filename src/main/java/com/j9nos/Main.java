package com.j9nos;

import com.j9nos.brute_force_symbolic_regressor.BruteForceSymbolicRegressor;
import com.j9nos.brute_force_symbolic_regressor.Variable;

public final class Main {

    private Main() {
    }

    public static void main(final String[] args) {
        final Variable output = new Variable("68.81180767", "DaysSalesOutstanding");

        final Variable[] input = {
                new Variable("258998", "AccountsReceivable"),
                new Variable("993659", "NetCreditSales"),
                new Variable("264", "Days"),
                new Variable("131886", "IrrelevantData1"),
                new Variable("0", "IrrelevantData2")
        };

        final BruteForceSymbolicRegressor regressor = new BruteForceSymbolicRegressor(output, input);
        regressor.regress(3);

        System.out.println(regressor.getPotentialFormulas());
    }
}


