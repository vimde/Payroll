package com.payroll.repository;

import java.util.HashMap;
import java.util.Map;

import com.payroll.model.Employee;

public class PayrollDatabase {
	
	private static Map<Integer, Employee> employees = new HashMap<>();

	public static Employee getEmployeeBy(Integer employeeId) {
		return employees.get(employeeId);
	}
	
	public static void addEmployee(Integer employeeId, Employee employee) {
		employees.put(employeeId, employee);
	}
}
