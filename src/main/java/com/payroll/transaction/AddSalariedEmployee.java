package com.payroll.transaction;

import com.payroll.payment.classification.PaymentClassification;
import com.payroll.payment.classification.SalariedClassification;
import com.payroll.schedule.payment.MonthlySchedule;
import com.payroll.schedule.payment.PaymentSchedule;

public class AddSalariedEmployee extends AddEmployeeTransaction {

	private double salary;
	
	public AddSalariedEmployee(Integer employeeId, String name, String address, double salary) {
		super(employeeId, name, address);
		this.salary = salary;
	}

	@Override
	protected PaymentClassification makeClassification() {
		return new SalariedClassification(salary);
	}

	@Override
	protected PaymentSchedule makeSchedule() {
		return new MonthlySchedule();
	}

}
