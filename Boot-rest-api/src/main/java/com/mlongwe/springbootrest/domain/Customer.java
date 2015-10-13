/**
 * 
 */
package com.mlongwe.springbootrest.domain;

import static com.mlongwe.springbootrest.util.PreCondition.isTrue;
import static com.mlongwe.springbootrest.util.PreCondition.notEmpty;
import static com.mlongwe.springbootrest.util.PreCondition.notNull;

import org.springframework.data.annotation.Id;

/**
 * @author mlongwe
 *
 */
public final class Customer {
	static final int MAX_LENGTH_DESCRIPTION = 500;
	static final int MAX_LENGTH_FIRST_NAME = 100;
	static final int MAX_LENGTH_LAST_NAME = 100;

	@Id
	private String id;

	private String firstName;

	private String lastName;

	private String company;

	private String description;

	private String email;

	private String fax;

	private String phone;

	private String website;

	public Customer() {
	}
	
	 public static Builder getBuilder() {
        return new Builder();
    }

	public Customer(Builder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.company = builder.company;
		this.description = builder.description;
		this.email = builder.email;
		this.fax = builder.fax;
		this.phone = builder.phone;
		this.website=builder.website;

	}
	
	
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the fax
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}
	
	
	public void update(String firstName, String lastName, String description) {
		checkFistNameAndLastNameAndDescription(firstName, lastName, description);

        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
    }

	/**
	 * We don't have to use the builder pattern here because the constructed
	 * class has only two String fields. However, I use the builder pattern in
	 * this example because it makes the code a bit easier to read.
	 */
	public static class Builder {

		private String firstName;

		private String lastName;

		private String company;

		private String description;

		private String email;

		private String fax;

		private String phone;

		private String website;

		
		private Builder() {
		}
		

	public	Builder firstName(String firstName) {

			this.firstName = firstName;
			return this;

		}

	public	Builder lastName(String lastName) {

			this.lastName = lastName;
			return this;

		}

		public Builder company(String company) {

			this.company = company;
			return this;

		}

	public	Builder description(String description) {

			this.description = description;
			return this;

		}

	public	Builder email(String email) {

			this.email = email;
			return this;

		}
		
	public	Builder phone(String phone){
			this.phone = phone;
			return this;

	}
		
	public	Builder website(String website){
			this.website = website;
			return this;

	
		
	}
	public	Builder fax(String fax){
			this.fax = fax;
			return this;

	
		
	}
		
		
		
		

	public	Customer buid(){
			Customer build = new Customer(this);
			checkFistNameAndLastNameAndDescription(firstName, lastName, description);
			return build;
		}
		
		
		
}

	private static void checkFistNameAndLastNameAndDescription(String firstName, String lastName, String description) {
        notNull(firstName, "First Name cannot be null");
        notEmpty(firstName, "First Name cannot be empty");
       
        isTrue(firstName.length() <= MAX_LENGTH_FIRST_NAME,
                "First Name cannot be longer than %d characters",
                MAX_LENGTH_FIRST_NAME
        );
        
        notNull(lastName, "Last Name cannot be null");
        notEmpty(lastName, "Last Name cannot be empty");
        
        isTrue(lastName.length() <= MAX_LENGTH_LAST_NAME, "Last Name cannot be longer than %d characters", MAX_LENGTH_LAST_NAME
        	
        );
        
        

        if (description != null) {
            isTrue(description.length() <= MAX_LENGTH_DESCRIPTION,
                    "Description cannot be longer than %d characters",
                    MAX_LENGTH_DESCRIPTION
            );
        }
    }
	
}


