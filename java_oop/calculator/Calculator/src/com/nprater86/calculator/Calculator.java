package com.nprater86.calculator;

public class Calculator {
	private double operandOne = 0;
	private double operandTwo = 0;
	private String operation = "";
	private double results = 0;
	
	public Calculator() {
	}
	
	public void performOperation() {
		if(operation == "+") {
			this.results = operandOne + operandTwo;
		} else if(operation == "-") {
			this.results = operandOne - operandTwo;
		} else {
			System.out.println("Invalid operation.");
		}
	}
	
	public double getResults() {
		return this.results;
	}
	
	public double getOperandOne() {
		return operandOne;
	}
	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}
	public double getOperandTwo() {
		return operandTwo;
	}
	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}	
}
