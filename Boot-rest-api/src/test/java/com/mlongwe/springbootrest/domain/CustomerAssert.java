/**
 * 
 */
package com.mlongwe.springbootrest.domain;

import org.assertj.core.api.AbstractAssert;


import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author mlongwe
 *
 */
public class CustomerAssert extends AbstractAssert<CustomerAssert,Customer> {

	protected CustomerAssert(Customer actual) {
		super(actual, Customer.class);
	}
	
	public static CustomerAssert assertThatCustomer(Customer actual){
		
		return new CustomerAssert(actual);
		
	}
	
	public CustomerAssert hasLastName(String expectedLastName){
		isNotNull();
		String actualLastName = actual.getLastName();
		assertThat(actualLastName)
				.overridingErrorMessage("Expected description to be <%s> but was <%s>",
				expectedLastName, actualLastName )
				.isEqualTo(expectedLastName);
		
		return this;
		
		
		
	}
	
	
	CustomerAssert hasNoDescription() {
        isNotNull();

        String actualDescription = actual.getDescription();
        assertThat(actualDescription)
                .overridingErrorMessage("Expected description to be <null> but was <%s>", actualDescription)
                .isNull();

        return this;
    }

	CustomerAssert hasNoId() {
        isNotNull();

        String actualId = actual.getId();
        assertThat(actualId)
                .overridingErrorMessage("Expected id to be <null> but was <%s>", actualId)
                .isNull();

        return this;
    }

	CustomerAssert hasEmailId(String expectedEmailId) {
        isNotNull();

        String actualTitle = actual.getEmail();
        assertThat(actualTitle)
                .overridingErrorMessage("Expected title to be <%s> but was <%s>",
                		expectedEmailId,
                        actualTitle
                )
                .isEqualTo(expectedEmailId);

        return this;
    }

}
