package com.miya.longwe.springboot.service;


import java.util.List;

import com.miya.longwe.springboot.model.Employee;

public interface EmployeeService {
	
	Employee findById(Long id);

	Employee findByName(String name);

	void saveEmployee(Employee employee);

	void updateEmployee(Employee employee);

	void deleteEmployeeById(Long id);

	void deleteAllEmployees();

	List<Employee> findAllEmployees();

	boolean isEmployeeExist(Employee employee);
}