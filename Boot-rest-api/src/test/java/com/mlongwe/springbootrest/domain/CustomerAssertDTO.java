/**
 * 
 */
package com.mlongwe.springbootrest.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractAssert;

/**
 * @author mlongwe
 *
 */
public class CustomerAssertDTO   extends AbstractAssert<CustomerAssertDTO, CustomerDTO>{
	
	 private CustomerAssertDTO(CustomerDTO actual) {
	        super(actual, CustomerAssertDTO.class);
	    }

	    static CustomerAssertDTO assertThatTodoDTO(CustomerDTO actual) {
	        return new CustomerAssertDTO(actual);
	    }

	    public CustomerAssertDTO hasDescription(String expectedDescription) {
	        isNotNull();

	        String actualDescription = actual.getDescription();
	        assertThat(actualDescription)
	                .overridingErrorMessage("Expected description to be <%s> but was <%s>",
	                        expectedDescription,
	                        actualDescription
	                )
	                .isEqualTo(expectedDescription);

	        return this;
	    }

	    public CustomerAssertDTO hasId(String expectedId) {
	        isNotNull();

	        String actualId = actual.getId();
	        assertThat(actualId)
	                .overridingErrorMessage("Expected id to be <%s> but was <%s>",
	                        expectedId,
	                        actualId
	                )
	                .isEqualTo(expectedId);

	        return this;
	    }

	    public CustomerAssertDTO hasNoDescription() {
	        isNotNull();

	        String actualDescription = actual.getDescription();
	        assertThat(actualDescription)
	                .overridingErrorMessage("expected description to be <null> but was <%s>", actualDescription)
	                .isNull();

	        return this;
	    }

	    public CustomerAssertDTO hasNoId() {
	        isNotNull();

	        String actualId = actual.getId();
	        assertThat(actualId)
	                .overridingErrorMessage("Expected id to be <null> but was <%s>", actualId)
	                .isNull();

	        return this;
	    }

	    public CustomerAssertDTO hasEmailId(String expectedEmail) {
	        isNotNull();

	        String actualEmail = actual.getEmail();
	        assertThat(actualEmail)
	                .overridingErrorMessage("Expected title to be <%s> but was <%s>",
	                		expectedEmail,
	                		actualEmail
	                )
	                .isEqualTo(expectedEmail);

	        return this;
	    }

}
