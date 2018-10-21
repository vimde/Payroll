package com.payroll.transaction;

import com.payroll.payment.classification.HourlyClassification;
import com.payroll.payment.classification.PaymentClassification;
import com.payroll.schedule.payment.PaymentSchedule;
import com.payroll.schedule.payment.WeeklySchedule;

public class AddHourlyEmployee extends AddEmployeeTransaction {

	private Double hourlyRate;
	
	public AddHourlyEmployee(Integer employeeId, String name, String address, Double hourlyRate) {
		super(employeeId, name, address);
		this.hourlyRate = hourlyRate;
	}
	
	@Override
	protected PaymentClassification makeClassification() {
		return new HourlyClassification(this.hourlyRate);
	}

	@Override
	protected PaymentSchedule makeSchedule() {
		return new WeeklySchedule();
	}

}
