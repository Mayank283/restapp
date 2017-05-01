package org.mayank.restapp.simple.controller;

import java.util.List;

import org.mayank.restapp.simple.entities.EmployeeEntity;
import org.mayank.restapp.simple.error.ErrorResponse;
import org.mayank.restapp.simple.exception.EmployeeNotFoundException;
import org.mayank.restapp.simple.requestbody.Employee;
import org.mayank.restapp.simple.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employee")
public class EmployeeController {

	@Autowired
	EmployeeService empSer;

	@RequestMapping(value = "/insert", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public String insert(@RequestBody Employee employee) {
		EmployeeEntity emp = new EmployeeEntity(employee.getEmp_id(),employee.getEmp_name());
		empSer.insertEmployee(emp);
		return "success";
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> findById() {
		List<Employee> employee = empSer.findAll();
		return new ResponseEntity<List<Employee>>(employee,HttpStatus.FOUND);
	}
	
	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee findById(@PathVariable Long id) throws EmployeeNotFoundException{
		Employee employee = empSer.findById(id);
		return employee;
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.NO_CONTENT.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
}