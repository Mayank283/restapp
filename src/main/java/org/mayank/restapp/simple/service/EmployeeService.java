package org.mayank.restapp.simple.service;

import java.util.List;

import org.mayank.restapp.simple.entities.EmployeeEntity;
import org.mayank.restapp.simple.exception.EmployeeNotFoundException;
import org.mayank.restapp.simple.requestbody.Employee;

public interface EmployeeService {

	public void insertEmployee(EmployeeEntity employee);

	public Employee findById(Long id) throws EmployeeNotFoundException;

	public List<Employee> findAll();
	
}
