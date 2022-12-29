package com.spring.employee_details.Spring_employee.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings({ "serial" })
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {
	
	public EmployeeNotFoundException(String exception) {
		super(exception);
	}
}
