/**
 * 
 */
package com.mlongwe.springbootrest.service;

import java.util.List;

import com.mlongwe.springbootrest.domain.CustomerDTO;

/**
 * This interface declares the methods that provides CRUD operations for
 * {@link com.mlongwe.springbootrest.domain.Customer} objects.
 *
 * @author mlongwe
 *
 */
public interface CustomerService {

	/**
	 * Creates a new CustomerDTO entry.
	 * 
	 * @param CustomerDTO
	 *            The information of the created CustomerDTO entry.
	 * @return The information of the created CustomerDTO entry.
	 */
	public CustomerDTO create(CustomerDTO customerDTO);

	/**
	 * Deletes a customerDTO entry.
	 * 
	 * @param id
	 *            The id of the deleted customerDTO entry.
	 * @return THe information of the deleted customerDTO entry.
	 * 
	 *         if no customerDTO entry is found.
	 */
	public CustomerDTO delete(String id);

	/**
	 * Finds all customerDTO entries.
	 * 
	 * @return The information of all customerDTO entries.
	 */
	public List<CustomerDTO> findAll();

	/**
	 * Finds a single customerDTO entry.
	 * 
	 * @param id
	 *            The id of the requested customerDTO entry.
	 * @return The information of the requested customerDTO entry.
	 * 
	 *         if no customerDTO entry is found.
	 */
	public CustomerDTO findById(String id);

	/**
	 * Updates the information of a customerDTO entry.
	 * 
	 * @param customerDTO
	 *            The information of the updated customerDTO entry.
	 * @return The information of the updated customerDTO entry. if no
	 *         customerDTO entry is found.
	 */
	public CustomerDTO update(CustomerDTO customerDTO);
	
	
	public CustomerDTO findCustomerByEmail(String email);
	
	

}
