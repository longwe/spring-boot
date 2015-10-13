package com.mlongwe.springbootrest.domain;

import org.springframework.test.util.ReflectionTestUtils;

/**
 * The Class CustomerBuilder.
 *
 * @author mlongwe
 */
public class CustomerBuilder {
	
	/** The id. */
	private String id;

	/** The first name. */
	private String firstName;

	/** The last name. */
	private String lastName;

	/** The company. */
	private String company;

	/** The description. */
	private String description;

	/** The email. */
	private String email;

	/** The fax. */
	private String fax;

	/** The phone. */
	private String phone;

	/** The website. */
	private String website;

	
	/**
	 * Id.
	 *
	 * @param id the id
	 * @return the customer builder
	 */
	CustomerBuilder id (String id){
		this.id = id;
		return this;
	}
	
	/**
	 * First name.
	 *
	 * @param firstName the first name
	 * @return the customer builder
	 */
	CustomerBuilder firstName (String firstName){
		this.firstName = firstName;
		return this;
	}
	
	CustomerBuilder lastName(String lastName){
		this.lastName = lastName;
		return this;
		
	}
	
	
	/**
	 * Company.
	 *
	 * @param company the company
	 * @return the customer builder
	 */
	CustomerBuilder company (String company){
		this.company = company;
		return this;
	}
	
	/**
	 * Description.
	 *
	 * @param description the description
	 * @return the customer builder
	 */
	CustomerBuilder description (String description){
		this.description = description;
		return this;
	}
	
	/**
	 * Email.
	 *
	 * @param email the email
	 * @return the customer builder
	 */
	CustomerBuilder email (String email){
		this.email = email;
		return this;
	}
	
	/**
	 * Fax.
	 *
	 * @param fax the fax
	 * @return the customer builder
	 */
	CustomerBuilder fax (String fax){
		this.fax = fax;
		return this;
	}
	
	/**
	 * Phone.
	 *
	 * @param phone the phone
	 * @return the customer builder
	 */
	CustomerBuilder phone (String phone){
		this.phone = phone;
		return this;
	}
	
	/**
	 * Website.
	 *
	 * @param website the website
	 * @return the customer builder
	 */
	CustomerBuilder website (String website){
		this.website = website;
		return this;
	}
	
	
	/**
	 * Builds the.
	 *
	 * @return the customer
*/
	Customer build (){
		Customer customer =  Customer.getBuilder()
				.company(company)
				.firstName(firstName)
				.lastName(lastName)
				.description(description)
				.email(email)
				.website(website)
				.phone(phone)
				.fax(fax)
		.buid();
		
		ReflectionTestUtils.setField(customer, "id", id);
		return customer;
	 
	}

}