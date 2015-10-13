/**
 * 
 */
package com.mlongwe.springbootrest.domain;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * This data transfer object contains the information of a single Customer
 * entry and specifies validation rules that are used to ensure that only
 * valid information can be saved to the used database.

 * @author mlongwe
 *
 */
public class CustomerDTO {
	
	 private String id;

	 @NotEmpty
	 @Size(max = Customer.MAX_LENGTH_FIRST_NAME)
	private String firstName;

	 @NotEmpty
	 @Size(max = Customer.MAX_LENGTH_LAST_NAME)
	 private String lastName;

	private String company;

	@Size(max = Customer.MAX_LENGTH_DESCRIPTION)
	private String description;

	private String email;

	private String fax;

	private String phone;

	private String website;

	
	public CustomerDTO(){}
	
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}




	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}




	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}


	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the fax
	 */
	public String getFax() {
		return fax;
	}


	/**
	 * @param fax the fax to set
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}


	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}


	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}


	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}


	/**
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}
	
	
	@Override
    public String toString() {
     //   return String.format(
             //   "CustomerDTO[id=%s,lastName=%s, firstName=%s,company=%s,phone=%s,email=%s, fax=%s, website=%s,  description=%s ]",
             
	   return String.format(
           "CustomerDTO[id=%s,lastName=%s, firstName=%s, company=%s,phone=%s,email=%s, fax=%s, website=%s,description=%s ]",
		this.id,
                this.firstName,
                this.lastName,
                this.company,
                this.phone,
                this.email,
                this.fax,
                this.website,
                this.description
                );
    }

}
