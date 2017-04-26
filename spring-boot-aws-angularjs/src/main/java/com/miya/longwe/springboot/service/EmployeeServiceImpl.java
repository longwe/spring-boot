package com.miya.longwe.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miya.longwe.springboot.model.Employee;
import com.miya.longwe.springboot.repositories.EmployeeRepository;



@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee findById(Long id) {
		return employeeRepository.findOne(id);
	}

	public Employee findByName(String name) {
		return employeeRepository.findByName(name);
	}

	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	public void updateEmployee(Employee employee){
		saveEmployee(employee);
	}

	public void deleteEmployeeById(Long id){
		employeeRepository.delete(id);
	}

	public void deleteAllEmployees(){
		employeeRepository.deleteAll();
	}

	public List<Employee> findAllEmployees(){
		return employeeRepository.findAll();
	}

	public boolean isEmployeeExist(Employee user) {
		return findByName(user.getName()) != null;
	}

}
