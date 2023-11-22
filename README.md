# BruteForceSymbolicRegressor
It allows the user to somewhat come up with potential formulas based on a specified output
and a list of variables

## Usage
Specify an output
```java
final Variable output = new Variable("68.81180767", "DaysSalesOutstanding");
```

Specify inputs that may or may not have anything to do with the output
```java
final Variable[] inputs = {
	new Variable("258998", "AccountsReceivable"),
	new Variable("993659", "NetCreditSales"),
	new Variable("264", "Days"),
	new Variable("131886", "IrrelevantData1"),
	new Variable("0", "IrrelevantData2")
};
```

Pass them to the constructor of the BruteForceSymbolicRegressor object
```java
final BruteForceSymbolicRegressor regressor = new BruteForceSymbolicRegressor(output, inputs);
```

Call the regress method
> Aim for lower values as this will improve accuracy
```java
regressor.regress(3);
```

Check whether there are potential formulas
```java
System.out.println(regressor.getPotentialFormulas());
```
Results:
> [(AccountsReceivable*Days)/NetCreditSales))=DaysSalesOutstanding, (Days*AccountsReceivable)/NetCreditSales))=DaysSalesOutstanding]
