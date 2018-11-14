package com.cg.springjpamvc.dao;

import java.util.List;

import com.cg.springjpamvc.dto.Employee;

public interface IEmployeeDao
{
	public int addEmployeeData(Employee emp);
	public List<Employee> showAllEmployee();
	public void deleteEmployee(int empId);
	public void updateEmployee(Employee emp);
	public Employee searchEmployee(int id);

}
