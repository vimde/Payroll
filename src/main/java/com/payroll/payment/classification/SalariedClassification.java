package com.payroll.payment.classification;

public class SalariedClassification implements PaymentClassification {

	private Double salary;
	
	public SalariedClassification(double salary) {
		this.salary = salary;
	}

	public Double getSalary() {
		return this.salary;
	}

}
