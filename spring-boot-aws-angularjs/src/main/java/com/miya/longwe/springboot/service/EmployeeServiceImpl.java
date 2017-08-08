package com.miya.longwe.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miya.longwe.springboot.model.Employee;
import com.miya.longwe.springboot.repositories.EmployeeRepository;



// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeServiceImpl.
 */
@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	/** The employee repository. */
	@Autowired
	private EmployeeRepository employeeRepository;

	/* (non-Javadoc)
	 * @see com.miya.longwe.springboot.service.EmployeeService#findById(java.lang.Long)
	 */
	public Employee findById(Long id) {
		return employeeRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see com.miya.longwe.springboot.service.EmployeeService#findByName(java.lang.String)
	 */
	public Employee findByName(String name) {
		return employeeRepository.findByName(name);
	}

	/* (non-Javadoc)
	 * @see com.miya.longwe.springboot.service.EmployeeService#saveEmployee(com.miya.longwe.springboot.model.Employee)
	 */
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	/* (non-Javadoc)
	 * @see com.miya.longwe.springboot.service.EmployeeService#updateEmployee(com.miya.longwe.springboot.model.Employee)
	 */
	public void updateEmployee(Employee employee){
		saveEmployee(employee);
	}

	/* (non-Javadoc)
	 * @see com.miya.longwe.springboot.service.EmployeeService#deleteEmployeeById(java.lang.Long)
	 */
	public void deleteEmployeeById(Long id){
		employeeRepository.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.miya.longwe.springboot.service.EmployeeService#deleteAllEmployees()
	 */
	public void deleteAllEmployees(){
		employeeRepository.deleteAll();
	}

	/* (non-Javadoc)
	 * @see com.miya.longwe.springboot.service.EmployeeService#findAllEmployees()
	 */
	public List<Employee> findAllEmployees(){
		return employeeRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.miya.longwe.springboot.service.EmployeeService#isEmployeeExist(com.miya.longwe.springboot.model.Employee)
	 */
	public boolean isEmployeeExist(Employee user) {
		return findByName(user.getName()) != null;
	}

}
