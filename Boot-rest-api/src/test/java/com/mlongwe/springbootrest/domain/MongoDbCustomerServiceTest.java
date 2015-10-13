/**
 * 
 */
package com.mlongwe.springbootrest.domain;

import static com.mlongwe.springbootrest.domain.CustomerAssertDTO.assertThatTodoDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.mlongwe.springbootrest.exception.CustomerNotFoundException;
import com.mlongwe.springbootrest.repository.CustomerRepository;
import com.mlongwe.springbootrest.repository.MongoDbCustomerService;

/**
 * @author mlongwe
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class MongoDbCustomerServiceTest {
	
	private String ID ="123456";

	private String FIRST_NAME ="Micky";

	private String LAST_NAME ="Mouse";

	private String COMPONY ="Micky Studios";

	private String DESCRIPTION ="Movie Producer";

	private String EMAIL= "mick.mouse@mm.com";

	private String FAX = "781-997-8787";

	private String PHONE= "781-789-2324";

	private String WEBSITE ="www.mickeystudios.com";
	
	 @Mock
	    private CustomerRepository repository;

	    private MongoDbCustomerService service;
	    
	    
	    
	    @Before
	    public void setUp() {
	        this.service = new MongoDbCustomerService(repository);
	    }

	    
	    @Test
	    public void create_ShouldSaveNewCustomerEntry() {
	        CustomerDTO newCustomerDTO = new CustomerDTOBuilder()
	                .firstName(FIRST_NAME)
	                .lastName(FIRST_NAME)
	                .company(COMPONY)
	                .phone(PHONE)
	                .fax(FAX)
	                .email(EMAIL)
	                .website(WEBSITE)
	                .description(DESCRIPTION)
	                .build();

	        when(repository.save(isA(Customer.class))).thenAnswer(invocation -> (Customer) invocation.getArguments()[0]);

	        service.create(newCustomerDTO);

	        ArgumentCaptor<Customer> savedCustomerrgument = ArgumentCaptor.forClass(Customer.class);

	        verify(repository, times(1)).save(savedCustomerrgument.capture());
	        verifyNoMoreInteractions(repository);
	    
	        assertThatTodoDTO(newCustomerDTO)
	        .hasEmailId(EMAIL)
	        .hasDescription(DESCRIPTION);
	        
	                
	              
	                
	               
	                
	    }
	    
	    @Test
	    public void findAll_OneCustomerEntryFound_ShouldReturnTheInformationOfFoundCustomerEntry() {
	    
	    	
	    	
	    	Customer expected = new CustomerBuilder()
	                .id(ID)
	                .firstName(FIRST_NAME)
	                .company(COMPONY)
	                .lastName(LAST_NAME)
	                .fax(FAX)
	                .phone(PHONE)
	                .email(EMAIL)
	                .description(DESCRIPTION)
	                .build();

	        when(repository.findAll()).thenReturn(Arrays.asList(expected));

	        List<CustomerDTO> todoEntries = service.findAll();
	        assertThat(todoEntries).hasSize(1);

	        CustomerDTO actual = todoEntries.iterator().next();
	        assertThatTodoDTO(actual)
	                .hasId(ID)
	                .hasEmailId(EMAIL)
	                .hasDescription(DESCRIPTION);
	    }
	    
	    @Test(expected = CustomerNotFoundException.class)
	    public void findById_CustomerEntryNotFound_ShouldThrowException() {
	        when(repository.findOne(ID)).thenReturn(null);
	     
	        CustomerDTO newCustomerDTO = new CustomerDTOBuilder()
	                .id(ID)
	                .build();

	        service.update(newCustomerDTO);
	    }

}
