package com.spring.employee_details.Spring_employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.employee_details.Spring_employee.model.Employee;
import com.spring.employee_details.Spring_employee.model.EmployeeNotFoundException;
import com.spring.employee_details.Spring_employee.repository.EmployeeRepository;
@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Employee> getEmployees() {
		List<Employee> employees=employeeRepository.findAll();
		if(employees.size()>0) {
			return employees;
		}
		else
			return new ArrayList<Employee>();
	}
	
	public Employee getEmployeesById(int id) throws EmployeeNotFoundException {
		Optional<Employee> employee=employeeRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		else
			return null;
	}
	
	public Employee createOrUpdateEmployees(Employee employee) throws EmployeeNotFoundException{
		Optional<Employee> employees=employeeRepository.findById(employee.getId());
		if(employees.isPresent()) {
			Employee newEmployee=employees.get();
			newEmployee.setId(employee.getId());
			newEmployee.setAge(employee.getAge());
			newEmployee.setName(employee.getName());
			newEmployee.setSalary(employee.getSalary());
			
			newEmployee=employeeRepository.save(newEmployee);
			
			return newEmployee;
		}
		else {
			employee=employeeRepository.save(employee);
			return employee;
		}
	
	}

	public void deleteById(int id) throws EmployeeNotFoundException {
		Optional<Employee> deleteEmp=employeeRepository.findById(id);
		if(deleteEmp.isPresent()) {
			employeeRepository.deleteById(id);
		}
		else
			throw new EmployeeNotFoundException("No employee is present in this id");
	}
}
