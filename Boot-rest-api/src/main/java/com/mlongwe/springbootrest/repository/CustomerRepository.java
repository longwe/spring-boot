/**
 * 
 */
package com.mlongwe.springbootrest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.Repository;

import com.mlongwe.springbootrest.domain.Customer;

/**
 * This repository provides CRUD operations for {@link com.mlongwe.springbootrest.domain.Customer}
 * objects.
 * @author Miya W. Longwe
 */
public interface CustomerRepository extends /*Repository*/ MongoRepository<Customer, String> {
	 /**
     * Deletes a Customer entry from the database.
     * @param deleted   The deleted Customer entry.
     */
   public void delete(Customer deleted);

    /**
     * Finds all Customer entries from the database.
     * @return  The information of all Customer entries that are found from the database.
     */
  public  List<Customer> findAll();

    /**
     * Finds the information of a single Customer entry.
     * @param id    The id of the requested Customer entry.
     * @return      The information of the found Customer entry. If no Customer entry
     *              is found, this method returns an empty {@link java.util.Optional} object.
     */
public  Customer findOne(String id);

    /**
     * Saves a new Customer entry to the database.
     * @param saved The information of the saved Customer entry.
     * @return      The information of the saved Customer entry.
     */
   public Customer save(Customer saved);
   
   

   public Customer findByEmail(String email);

  // @Query(value = "{sku: ?0, availability : 1}")
  // public List<Customer> findBySkuOnlyAvailables(String sku);

   
   

}
