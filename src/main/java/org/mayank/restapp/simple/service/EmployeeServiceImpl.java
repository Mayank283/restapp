package org.mayank.restapp.simple.service;

import java.util.ArrayList;
import java.util.List;

import org.mayank.restapp.simple.dao.EmployeeRepository;
import org.mayank.restapp.simple.entities.EmployeeEntity;
import org.mayank.restapp.simple.exception.EmployeeNotFoundException;
import org.mayank.restapp.simple.requestbody.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository empRepo;

	@Override
	public void insertEmployee(EmployeeEntity employee) {
		empRepo.save(employee);

	}

	@Override
	public Employee findById(Long id) throws EmployeeNotFoundException {
		Employee employee = new Employee();
		EmployeeEntity emp = empRepo.findById(id);
		
		if(emp == null){
			throw new EmployeeNotFoundException("Employee not present");
		}
		
		employee.setEmp_id(emp.getEmp_id());
		employee.setEmp_name(emp.getEmp_name());

		return employee;
	}

	@Override
	public List<Employee> findAll() {
		
		List<Employee> empList = new ArrayList<Employee>();

		empRepo.findAll().forEach(empEntity -> {
			Employee emp = new Employee();
			emp.setEmp_id(empEntity.getEmp_id());
			emp.setEmp_name(empEntity.getEmp_name());
			empList.add(emp);
		});
		
		return empList;
	}
}
