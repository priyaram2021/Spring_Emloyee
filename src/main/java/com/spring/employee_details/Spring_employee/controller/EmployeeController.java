package com.spring.employee_details.Spring_employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.employee_details.Spring_employee.model.Employee;
import com.spring.employee_details.Spring_employee.model.EmployeeNotFoundException;
import com.spring.employee_details.Spring_employee.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping
	public ResponseEntity<List<Employee>> getEmployees(){
		List<Employee> obj=employeeService.getEmployees();
		return new ResponseEntity<List<Employee>> (obj,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeesById(@PathVariable int id)throws EmployeeNotFoundException{
		Employee obj1=employeeService.getEmployeesById(id);
		return new ResponseEntity<Employee> (obj1,new HttpHeaders(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Employee> createOrUpdateEmployees(@RequestBody Employee employee)throws EmployeeNotFoundException{
		Employee newEmployee =employeeService.createOrUpdateEmployees(employee);
		return new ResponseEntity<Employee> (newEmployee,new HttpHeaders(),HttpStatus.OK);
		}
	
	@DeleteMapping("/{id}")
	public HttpStatus deleteById(@PathVariable int id) {
		employeeService.deleteById(id);
		return HttpStatus.GONE;
	}
	
//	@ExceptionHandler(EmployeeNotFoundException.class)
//	public ResponseEntity<Employee> handleEmployeeNotFoundException(EmployeeNotFoundException ex){
//		//ErrorDetails errorDetails=new ErrorDetails(ex.getMessage(),request.getDiscription(true));
//		return new ResponseEntity<>(new HttpHeaders(),HttpStatus.NOT_FOUND);
//	}
	
}
