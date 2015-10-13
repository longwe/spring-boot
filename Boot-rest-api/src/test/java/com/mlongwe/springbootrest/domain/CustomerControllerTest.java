/**
 * 
 */
package com.mlongwe.springbootrest.domain;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.lang.reflect.Method;
import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.annotation.ExceptionHandlerMethodResolver;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod;

import com.mlongwe.springbootrest.controller.CustomerController;
import com.mlongwe.springbootrest.error.RestErrorHandler;
import com.mlongwe.springbootrest.exception.CustomerNotFoundException;
import com.mlongwe.springbootrest.service.CustomerService;

/**
 * @author mlongwe
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

	private String ID = "123456";

	private String FIRST_NAME = "Micky";

	private String LAST_NAME = "Mouse";

	private String COMPANY = "Micky Studios";

	private String DESCRIPTION = "Movie Producer";

	private String EMAIL = "mick.mouse@mm.com";

	private String FAX = "781-997-8787";

	private String PHONE = "781-789-2324";

	private String WEBSITE = "www.mickeystudios.com";

	private static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	private static final int MAX_LENGTH_DESCRIPTION = 500;
	private static final int MAX_LENGTH_TITLE = 100;

	@Mock
	private CustomerService service;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(new CustomerController(service))
				.setHandlerExceptionResolvers(withExceptionControllerAdvice()).build();
	}

	private ExceptionHandlerExceptionResolver withExceptionControllerAdvice() {
		final ExceptionHandlerExceptionResolver exceptionResolver = new ExceptionHandlerExceptionResolver() {
			@Override
			protected ServletInvocableHandlerMethod getExceptionHandlerMethod(final HandlerMethod handlerMethod,
					final Exception exception) {
				Method method = new ExceptionHandlerMethodResolver(RestErrorHandler.class).resolveMethod(exception);
				if (method != null) {
					ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
					messageSource.setBasename("messages");
					return new ServletInvocableHandlerMethod(new RestErrorHandler(messageSource), method);
				}
				return super.getExceptionHandlerMethod(handlerMethod, exception);
			}
		};
		exceptionResolver.afterPropertiesSet();
		return exceptionResolver;
	}

	@Test
	public void create_TodoEntryWithOnlyTitle_ShouldCreateNewCustomerEntryWithoutDescription() throws Exception {

		CustomerDTO newCustomerDTO = new CustomerDTOBuilder().firstName(FIRST_NAME).lastName(FIRST_NAME)
				.company(COMPANY).phone(PHONE).fax(FAX).email(EMAIL).website(WEBSITE).description(DESCRIPTION).build();

		System.out.println(" ***************" + WebTestUtil.convertObjectToJsonString(newCustomerDTO));
		mockMvc.perform(post("/api/v1/customer").contentType(APPLICATION_JSON_UTF8)
				.content(WebTestUtil.convertObjectToJsonBytes(newCustomerDTO))

		);

		ArgumentCaptor<CustomerDTO> createdArgument = ArgumentCaptor.forClass(CustomerDTO.class);
		verify(service, times(1)).create(createdArgument.capture());
		verifyNoMoreInteractions(service);

		CustomerDTO created = createdArgument.getValue();
		// assertThatTodoDTO(created)
		// .hasNoId()
		// .hasTitle(TITLE)
		// .hasNoDescription();
	}

	@Test
	public void delete_CustomerEntryNotFound_ShouldReturnResponseStatusNotFound() throws Exception {
		when(service.delete(ID)).thenThrow(new CustomerNotFoundException(ID));

		mockMvc.perform(delete("/api/v1/customer/{id}", ID)).andExpect(status().isNotFound());
	}

	@Test
	public void delete_TodoEntryFound_ShouldReturnResponseStatusOk() throws Exception {
		CustomerDTO deleted = new CustomerDTOBuilder().id(ID).build();

		when(service.delete(ID)).thenReturn(deleted);

		mockMvc.perform(delete("/api/v1/customer/{id}", ID)).andExpect(status().isOk());
	}

	@Test
	public void findAll_ShouldReturnResponseStatusOk() throws Exception {
		mockMvc.perform(get("/api/v1/customer")).andExpect(status().isOk());
	}

	@Test
	public void update_CustomerEntryWithOnlyTitle_ShouldReturnTheInformationOfUpdatedTodoEntryAsJSon() throws Exception {

		CustomerDTO updatedCustomerEntry = new CustomerDTOBuilder().firstName(FIRST_NAME).lastName(LAST_NAME)
				.company(COMPANY).phone(PHONE).fax(FAX).email(EMAIL).website(WEBSITE).description(DESCRIPTION).build();

		when(service.update(isA(CustomerDTO.class)))
				.then(invocationOnMock -> (CustomerDTO) invocationOnMock.getArguments()[0]);

		mockMvc.perform(put("/api/v1/customer/{id}", ID).contentType(APPLICATION_JSON_UTF8)
				.content(WebTestUtil.convertObjectToJsonBytes(updatedCustomerEntry)))
				.andExpect(content().contentType(APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.id", isEmptyOrNullString()))
				.andExpect(jsonPath("$.email", is(EMAIL)))
				.andExpect(jsonPath("$.firstName", is(FIRST_NAME)))
				.andExpect(jsonPath("$.company", is(COMPANY)))
				.andExpect(jsonPath("$.phone", is(PHONE)));
	}

}
