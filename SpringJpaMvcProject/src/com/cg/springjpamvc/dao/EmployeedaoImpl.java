package com.cg.springjpamvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.springjpamvc.dto.Employee;
@Repository("employeedao")
public class EmployeedaoImpl implements IEmployeeDao {

	@PersistenceContext
	EntityManager entitymanager;
	@Override
	public int addEmployeeData(Employee emp) {

		entitymanager.persist(emp);
		entitymanager.flush();
		return emp.getEmpId();
	}

	@Override
	public List<Employee> showAllEmployee() {
		Query queryOne=entitymanager.createQuery("FROM Employee");
		List<Employee> myList=queryOne.getResultList();
		return myList;
	}

	@Override
	public void deleteEmployee(int empId) {
		Query queryTwo=entitymanager.createQuery("DELETE FROM Employee WHERE empId=:eid");
		queryTwo.setParameter("eid", empId);
		queryTwo.executeUpdate();

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
