package com.payroll.transaction;

import com.payroll.model.Employee;
import com.payroll.payment.classification.PaymentClassification;
import com.payroll.payment.method.HoldMethod;
import com.payroll.payment.method.PaymentMethod;
import com.payroll.repository.PayrollDatabase;
import com.payroll.schedule.payment.PaymentSchedule;

public abstract class AddEmployeeTransaction implements Transaction {

	private final Integer employeeId;
	private final String name;
	private final String address;
	
	public AddEmployeeTransaction(Integer employeeId, String name, String address) {
		this.employeeId = employeeId;
		this.name = name;
		this.address = address;
	}
	
	protected abstract PaymentClassification makeClassification();
	protected abstract PaymentSchedule makeSchedule();
	
	public void execute() {
		PaymentClassification paymentClassification = makeClassification();
		PaymentSchedule paymentSchedule = makeSchedule();
		PaymentMethod paymentMethod = new HoldMethod();
		
		Employee employee = new Employee(employeeId, name, address);
		employee.setPaymentClassification(paymentClassification);
		employee.setPaymentSchedule(paymentSchedule);
		employee.setPaymentMethod(paymentMethod);
		
		PayrollDatabase.addEmployee(this.employeeId, employee);
	}
}
