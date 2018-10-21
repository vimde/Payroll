package com.payroll.transaction;

import com.payroll.payment.classification.CommissionedClassification;
import com.payroll.payment.classification.PaymentClassification;
import com.payroll.schedule.payment.BiweeklySchedule;
import com.payroll.schedule.payment.PaymentSchedule;

public class AddCommissionedEmployee extends AddEmployeeTransaction {

	private Double salary;
	private Double commissionRate;
	
	public AddCommissionedEmployee(Integer employeeId, String name, String address, Double salary, Double commissionRate) {
		super(employeeId, name, address);
		this.salary = salary;
		this.commissionRate = commissionRate;
	}

	@Override
	protected PaymentClassification makeClassification() {
		return new CommissionedClassification(salary, commissionRate);
	}

	@Override
	protected PaymentSchedule makeSchedule() {
		return new BiweeklySchedule();
	}

}
