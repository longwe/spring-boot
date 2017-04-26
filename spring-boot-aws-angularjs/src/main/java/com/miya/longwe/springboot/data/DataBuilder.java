package com.miya.longwe.springboot.data;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.miya.longwe.springboot.model.Employee;

@Component
public class DataBuilder {
	
	public List<Employee> createEmployees() {

		Employee employee1 = new Employee(4, "Joe", 43,90000.00 );
		Employee employee2 = new Employee(4, "Joe", 43,90000.00 );
		Employee employee4 = new Employee(4, "Joe", 43,90000.00 );
		Employee employee3 = new Employee(4, "Joe", 43,90000.00 );

		
		return Arrays.asList(employee1, employee2, employee3, employee4);
	}
}