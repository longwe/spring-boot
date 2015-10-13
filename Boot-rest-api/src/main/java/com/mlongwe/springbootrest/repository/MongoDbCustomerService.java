package com.mlongwe.springbootrest.repository;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mlongwe.springbootrest.domain.Customer;
import com.mlongwe.springbootrest.domain.CustomerDTO;
import com.mlongwe.springbootrest.service.CustomerService;

/**
 * 
 */

/**
 * /** This service class saves
 * {@link com.mlongwe.springbootrest.domain.Customer} objects to MongoDB
 * database.
 * 
 * @author mlongwe
 *
 */
@Service
public class MongoDbCustomerService implements CustomerService {

	private final static Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MongoDbCustomerService.class);

	private final CustomerRepository customerRepository;

	@Autowired
	public MongoDbCustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public CustomerDTO create(CustomerDTO customerDTO) {
		LOGGER.info("Creating a new customer entry with information: {}", customerDTO);
		Customer peristedCustomer = Customer.getBuilder().company(customerDTO.getCompany())
				.lastName(customerDTO.getLastName()).firstName(customerDTO.getFirstName()).email(customerDTO.getEmail())
				.website(customerDTO.getWebsite()).description(customerDTO.getDescription()).fax(customerDTO.getFax())
				.phone(customerDTO.getPhone()).buid();

		peristedCustomer = customerRepository.save(peristedCustomer);
		LOGGER.info("Created a new customer entry with information: {}", peristedCustomer);
		return convertToDTO(peristedCustomer);
	}

	@Override
	public CustomerDTO delete(String id) {
		LOGGER.info("Deleting a customer entry with id: {}", id);

		Customer customerToDelete = findCustomerById(id);

		LOGGER.info("Deleted todo entry with informtation: {}", customerToDelete);

		customerRepository.delete(customerToDelete);

		return convertToDTO(customerToDelete);
	}

	@Override
	public List<CustomerDTO> findAll() {

		LOGGER.info("Finding all customers entries.");
		List<Customer> customerList = customerRepository.findAll();

		LOGGER.info("Found {} customer entries", customerList.size());

		return convertToDTOList(customerList);
	}

	@Override
	public CustomerDTO findById(String id) {

		LOGGER.info("Finding customer entry with id: {}", id);

		Customer customerFound = findCustomerById(id);

		LOGGER.info("Found customer entry: {}", customerFound);

		return convertToDTO(customerFound);
	}
	
	

	@Override
	public CustomerDTO update(CustomerDTO customerDTO) {

		LOGGER.info("Updating customer entry with information: {}", customerDTO);

		Customer updatedCustomer = findCustomerById(customerDTO.getId());
		updatedCustomer.update(customerDTO.getFirstName(), customerDTO.getLastName(), customerDTO.getDescription());
		updatedCustomer = customerRepository.save(updatedCustomer);

		LOGGER.info("Updated customer entry with information: {}", updatedCustomer);

		return convertToDTO(updatedCustomer);
	}

	private CustomerDTO convertToDTO(Customer customerModel) {
		CustomerDTO customerDto = new CustomerDTO();

		customerDto.setId(customerModel.getId());
		customerDto.setFirstName(customerModel.getFirstName());
		customerDto.setDescription(customerModel.getDescription());
		customerDto.setCompany(customerModel.getCompany());
		customerDto.setLastName(customerModel.getLastName());
		customerDto.setPhone(customerModel.getPhone());
		customerDto.setEmail(customerModel.getEmail());
		customerDto.setWebsite(customerModel.getWebsite());
		customerDto.setFax(customerModel.getFax());
		return customerDto;
	}

	private Customer findCustomerById(String id) {
	 Customer result = customerRepository.findOne(id);

		return result ; //.orElseThrow(() -> new CustomerNotFoundException(id));

	}

	private List<CustomerDTO> convertToDTOList(List<Customer> models) {
		return models.stream().map(this::convertToDTO).collect(toList());
	}

	

	@Override
	public CustomerDTO findCustomerByEmail(String email) {
	
		Customer customer =customerRepository.findByEmail(email);
		
		return convertToDTO(customer);
	}

}
