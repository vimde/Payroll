package com.payroll.payment.classification;

public class HourlyClassification implements PaymentClassification {

	private Double hourlyRate;
	
	public HourlyClassification(Double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	
	public Double getHourlyRate() {
		return this.hourlyRate;
	}

}
