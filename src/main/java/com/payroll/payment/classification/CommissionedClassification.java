package com.payroll.payment.classification;

public class CommissionedClassification implements PaymentClassification {

	private Double salary;
	private Double commissionRate;
	
	public CommissionedClassification(Double salary, Double commissionRate) {
		this.salary = salary;
		this.commissionRate = commissionRate;
	}

	public Double getSalary() {
		return salary;
	}

	public Double getCommissionRate() {
		return commissionRate;
	}

}

