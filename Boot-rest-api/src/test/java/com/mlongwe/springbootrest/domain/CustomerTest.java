/**
 * 
 */
package com.mlongwe.springbootrest.domain;

import org.junit.Test;



/**
 * @author mlongwe
 *
 */
public class CustomerTest {

	private static final String DESCRIPTION = "description";
	private static final String FIRST_NAME = "Daniel";
	private static final String LAST_NAME = "Longwe";
	private static final String PHONE = "7819631212";
	private static final String EMAIL = "john_doe@gmail.com";
	private static final String WEBSITE = "www.mlongwe.com";
	private static final String FAX = "7819631222";

	private static final int MAX_LENGTH_DESCRIPTION = 500;
	private static final int MAX_LENGTH_FIRST_NAME = 100;

	private static final String UPDATED_DESCRIPTION = "updatedDescription";
	private static final String UPDATED_TITLE = "updatedTitle";

	@Test(expected = NullPointerException.class)
	public void build_NullFirstName_ShouldThrowException() {
		Customer.getBuilder().firstName(null).lastName(LAST_NAME).description(DESCRIPTION).buid();

	}

	@Test(expected = IllegalArgumentException.class)
	public void build_EmptyLastName_ShouldThrowException() {
		Customer.getBuilder()
					.lastName("")
					.firstName(FIRST_NAME)
					.phone(PHONE).buid();

	}

	@Test (expected = IllegalArgumentException.class)
	public void build_LastNameIsTooLong_ShouldThrowException() {
		String longLastName = StringTestUtil.createStringWithLength(MAX_LENGTH_FIRST_NAME + 1);
		Customer.getBuilder()
				.lastName(LAST_NAME)
				.firstName(longLastName)
				.phone(PHONE)
				.buid();

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void build_DescriptionIsTooLong_ShouldThrowException() {
		String longDescription = StringTestUtil.createStringWithLength(MAX_LENGTH_DESCRIPTION + 1);
		Customer.getBuilder()
				.lastName(LAST_NAME)
				.firstName(FIRST_NAME)
				.description(longDescription)
				.phone(PHONE)
				.buid();

	}
	
	
}