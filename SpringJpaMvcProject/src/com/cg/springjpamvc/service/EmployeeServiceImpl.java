package com.cg.springjpamvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.springjpamvc.dao.IEmployeeDao;
import com.cg.springjpamvc.dto.Employee;

@Service("employeeservice")
@Transactional			
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	IEmployeeDao employeedao;
	
	@Override
	public int addEmployeeData(Employee emp) {
		// TODO Auto-generated method stub
		return employeedao.addEmployeeData(emp);
	}

	@Override
	public List<Employee> showAllEmployee() {
		// TODO Auto-generated method stub
		return employeedao.showAllEmployee();
	}

	@Override
	public void deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		employeedao.deleteEmployee(empId);

	}

	@Override
	public void updateEmployee(Employee emp) {
		// TODO Auto-generated method stub

	}

	@Override
	public Employee searchEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
