/**
 * 
 */
package com.mlongwe.springbootrest.domain;


/**
 * The Class CustomerDTOBuilder.
 *
 * @author mlongwe
 */
public class CustomerDTOBuilder {
	
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
	
	private String id;

	
	/**
	 * Instantiates a new customer dto builder.
	 */
	public CustomerDTOBuilder(){}
	
	public CustomerDTOBuilder id(String id){
		this.id = id;
		return this;
	}
	
	/**
	 * Last name.
	 *
	 * @param lastName the last name
	 * @return the customer dto builder
	 */
	public CustomerDTOBuilder lastName(String lastName){
		this.lastName = lastName;
		return this;
	}
	
	/**
	 * First name.
	 *
	 * @param firstName the first name
	 * @return the customer dto builder
	 */
	public CustomerDTOBuilder firstName(String firstName){
		this.firstName = firstName;
		return this;
	}
	
	/**
	 * Phone.
	 *
	 * @param phone the phone
	 * @return the customer dto builder
	 */
	public CustomerDTOBuilder phone(String phone){
		this.phone = phone;
		return this;
	}
	
	/**
	 * Company.
	 *
	 * @param company the company
	 * @return the customer dto builder
	 */
	public CustomerDTOBuilder company(String company){
		this.company = company;
		return this;
	}
	
	/**
	 * Description.
	 *
	 * @param description the description
	 * @return the customer dto builder
	 */
	public CustomerDTOBuilder description(String description){
		this.description = description;
		return this;
	}
	
	/**
	 * Email.
	 *
	 * @param email the email
	 * @return the customer dto builder
	 */
	public CustomerDTOBuilder email(String email){
		this.email = email;
		return this;
	}
	
	/**
	 * Fax.
	 *
	 * @param fax the fax
	 * @return the customer dto builder
	 */
	public CustomerDTOBuilder fax(String fax){
		this.fax = fax;
		return this;
	}
	
	/**
	 * Website.
	 *
	 * @param website the website
	 * @return the customer dto builder
	 */
	public CustomerDTOBuilder website(String website){
		this.website = website;
		return this;
	}
	
	/**
	 * Builds the.
	 *
	 * @return the customer dto
	 */
	public CustomerDTO build(){
		CustomerDTO customerDto = new CustomerDTO();
		customerDto.setCompany(company);
		customerDto.setDescription(description);
		customerDto.setEmail(email);
		customerDto.setFax(fax);
		customerDto.setFirstName(firstName);
		customerDto.setLastName(lastName);
		customerDto.setDescription(description);
		customerDto.setPhone(phone);
		customerDto.setWebsite(website);
		
		return customerDto;
		
		
	}

}
