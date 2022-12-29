package com.spring.employee_details.Spring_employee.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.employee_details.Spring_employee.model.Employee;

public interface EmployeeRepository extends JpaRepository <Employee,Integer> {

}
