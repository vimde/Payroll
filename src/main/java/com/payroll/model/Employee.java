package com.payroll.model;

import com.payroll.payment.classification.PaymentClassification;
import com.payroll.payment.method.PaymentMethod;
import com.payroll.schedule.payment.PaymentSchedule;

public class Employee {
	
	private Integer id;
	private String name;
	private String address;

	public Employee(Integer id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public PaymentClassification getPaymentClassification() {
		return null;
	}

	public Double getSalary() {
		return null;
	}

	public PaymentSchedule getPaymentSchedule() {
		return null;
	}

	public PaymentMethod getPaymentMethod() {
		return null;
	}

	public void setPaymentClassification(PaymentClassification paymentClassification) {
		
	}

	public void setPaymentSchedule(PaymentSchedule paymentSchedule) {
		
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		
	}

}
