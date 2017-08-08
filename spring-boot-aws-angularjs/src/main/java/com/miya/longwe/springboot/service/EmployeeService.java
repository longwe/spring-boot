package com.miya.longwe.springboot.service;


import java.util.List;

import com.miya.longwe.springboot.model.Employee;

// TODO: Auto-generated Javadoc
/**
 * The Interface EmployeeService.
 */
public interface EmployeeService {
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the employee
	 */
	Employee findById(Long id);

	/**
	 * Find by name.
	 *
	 * @param name the name
	 * @return the employee
	 */
	Employee findByName(String name);

	/**
	 * Save employee.
	 *
	 * @param employee the employee
	 */
	void saveEmployee(Employee employee);

	/**
	 * Update employee.
	 *
	 * @param employee the employee
	 */
	void updateEmployee(Employee employee);

	/**
	 * Delete employee by id.
	 *
	 * @param id the id
	 */
	void deleteEmployeeById(Long id);

	/**
	 * Delete all employees.
	 */
	void deleteAllEmployees();

	/**
	 * Find all employees.
	 *
	 * @return the list
	 */
	List<Employee> findAllEmployees();

	/**
	 * Checks if is employee exist.
	 *
	 * @param employee the employee
	 * @return true, if is employee exist
	 */
	boolean isEmployeeExist(Employee employee);
}