package com.cg.springjpamvc.service;

import java.util.List;

import com.cg.springjpamvc.dto.Employee;

public interface IEmployeeService
{
	public int addEmployeeData(Employee emp);
	public List<Employee> showAllEmployee();
	public void deleteEmployee(int empId);
	public void updateEmployee(Employee emp);
	public Employee searchEmployee(int id);
}
