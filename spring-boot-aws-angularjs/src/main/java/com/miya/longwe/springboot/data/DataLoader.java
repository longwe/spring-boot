package com.miya.longwe.springboot.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.miya.longwe.springboot.repositories.EmployeeRepository;

/*
@Component

public class DataLoader implements CommandLineRunner{

	@Autowired
	private DataBuilder dataBuilder;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... arg0) throws Exception {
		
		//log.debug("Loading test data...");
		dataBuilder.createEmployees().forEach(customer -> employeeRepository.save(customer));
		//log.debug("Test data loaded...");	
	}

}*/