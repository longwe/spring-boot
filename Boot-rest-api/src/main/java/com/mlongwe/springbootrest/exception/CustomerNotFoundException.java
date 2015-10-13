/**
 * 
 */
package com.mlongwe.springbootrest.exception;

/**
 * @author mlongwe
 *
 */
public class CustomerNotFoundException extends RuntimeException {
	
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public CustomerNotFoundException (String id){
	 super(String.format("No customer entry found with id: <%s>", id));
 }
 
}
