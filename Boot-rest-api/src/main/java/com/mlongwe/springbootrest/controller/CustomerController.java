/**
 * 
 */
package com.mlongwe.springbootrest.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mlongwe.springbootrest.domain.CustomerDTO;
import com.mlongwe.springbootrest.exception.CustomerNotFoundException;
import com.mlongwe.springbootrest.service.CustomerService;

/**
 * This controller provides the public API that is used to manage the information
 * of customer entries.
 * @author Miya W. Longwe
 */

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
	
	protected final static Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	
	
	private final CustomerService  customerService;
	
	@Autowired
	public CustomerController(CustomerService  customerService){
		this.customerService = customerService;
	}
	
	
	@RequestMapping(method =RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
public	CustomerDTO createCustomer (@RequestBody  @Valid CustomerDTO customerEntry){
	
		LOGGER.info("Creating a new customer entry with information: {}", customerEntry);
		
		CustomerDTO savedCustomer =  customerService.create(customerEntry);
		
		//LOGGER.info("Created a new customer entry with information: {}", savedCustomer.toString());

	
		return savedCustomer;
		
	}
	
	@RequestMapping(method= RequestMethod.GET)
public	List<CustomerDTO> findAllCustomers(){
		
		    LOGGER.info("Finding all customer entries");

	        List<CustomerDTO> customerList = customerService.findAll();
	       LOGGER.info("Found {} customer entries", customerList.size());

	        return customerList;
		
		
	}
	
	 @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
public	 CustomerDTO delete(@PathVariable("id") String id) {
	        LOGGER.info("Deleting todo entry with id: {}", id);

	        CustomerDTO deleted = customerService.delete(id);
	        LOGGER.info("Deleted todo entry with information: {}", deleted);

	        return deleted;
	    }
	 
	 
	 @RequestMapping(value = "{email}", method = RequestMethod.GET)
	public CustomerDTO findByEmail(@PathVariable("email") String email) {
	        LOGGER.info("Finding customerDTO entry with id: {}", email);

	      
	        CustomerDTO customerDTO = customerService.findCustomerByEmail(email);
	        LOGGER.info("Found customerDTO entry with information: {}", customerDTO);

	        return customerDTO;
	    }

	    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public    CustomerDTO update(@RequestBody @Valid CustomerDTO customerDTO) {
	        LOGGER.info("Updating customerDTO entry with information: {}", customerDTO);

	        CustomerDTO updated = customerService.update(customerDTO);
	        LOGGER.info("Updated customerDTO entry with information: {}", updated);

	        return updated;
	    }

	    @ExceptionHandler
	    @ResponseStatus(HttpStatus.NOT_FOUND)
	    public void handleCustomerNotFound(CustomerNotFoundException ex) {
	        LOGGER.error("Handling error with message: {}", ex.getMessage());
	    }
	

}
