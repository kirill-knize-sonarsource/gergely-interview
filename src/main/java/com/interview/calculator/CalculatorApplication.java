package com.interview.calculator;


import com.interview.calculator.dto.Operation;
import com.interview.calculator.enums.Expressions;
import com.interview.calculator.services.*;

public class CalculatorApplication {

	UserInput userInput;
	Calculate calculate;
	ParseInput parseInput;
	ValueHolder valueHolder;

	public CalculatorApplication() {
		this.userInput = new UserInputFromCommandLine();
		this.calculate = new Calculate();
		this.parseInput = new ParseInput();
		this.valueHolder = new InMemoryValueHolder();
	}

	public static void main(String[] args) {
		CalculatorApplication ca = new CalculatorApplication();
		while (true) {
			String expressionFromUser = ca.userInput.getExpressionFromUser();
			Operation operation = ca.parseInput.parseInput(expressionFromUser);
			if (operation.getOperator().equals(Expressions.DISPLAY)) {
				ca.valueHolder.printSavedValues();
			} else {
				ca.calculate.calculate(operation);
			}
		}
	}

}
