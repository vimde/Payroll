package com.payroll.transaction.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.payroll.model.Employee;
import com.payroll.payment.classification.PaymentClassification;
import com.payroll.payment.classification.SalariedClassification;
import com.payroll.payment.method.HoldMethod;
import com.payroll.payment.method.PaymentMethod;
import com.payroll.repository.PayrollDatabase;
import com.payroll.schedule.payment.MonthlySchedule;
import com.payroll.schedule.payment.PaymentSchedule;
import com.payroll.transaction.AddSalariedEmployee;

public class AddEmployeeTransactionSpec {

	@Test
	public void salariedEmployeeShouldBeAdded() {
		int employeeId = 1;
		AddSalariedEmployee salariedEmployeeTransaction = new AddSalariedEmployee(
				employeeId, "Bill", "Home", 1000.00);
		salariedEmployeeTransaction.execute();

		Employee employee = PayrollDatabase.getEmployeeBy(employeeId);
		assertEquals(employeeId, employee.getId());
		assertEquals("Bill", employee.getName());
		
		PaymentClassification paymentClassification = employee.getPaymentClassification();
		assertTrue("Not a Salaried Payment Classification", 
				paymentClassification instanceof SalariedClassification);
		
		SalariedClassification salariedClassification = (SalariedClassification) paymentClassification;
		
		assertEquals(new Double(1000.00), salariedClassification.getSalary());
		
		PaymentSchedule paymentSchedule = employee.getPaymentSchedule();
		assertTrue("Not a monthly schedule", paymentSchedule instanceof MonthlySchedule);
		
		PaymentMethod paymentMethod = employee.getPaymentMethod();
		assertTrue("Not a Hold method", paymentMethod instanceof HoldMethod);
	}
}
