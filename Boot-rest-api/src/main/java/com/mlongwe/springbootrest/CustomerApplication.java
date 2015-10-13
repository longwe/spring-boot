package com.mlongwe.springbootrest;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mlongwe.springbootrest.domain.Customer;
import com.mlongwe.springbootrest.repository.CustomerRepository;

/**
 * This configuration class has three responsibilities:
 * <ol>
 * <li>It enables the auto configuration of the Spring application context.</li>
 * <li>It ensures that Spring looks for other components (controllers, services,
 * and repositories) from the <code>com.mlongwe.springbootrest.*</code> package.
 * </li>
 * <li>It launches our application in the main() method.</li>
 * </ol>
 * 
 * @author Miya W. Longwe
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan

public class CustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	@Bean
	InitializingBean populateTestData(CustomerRepository repository) {
		return () -> {
			

			repository.save(Customer.getBuilder().lastName("miya").firstName("longwe").description("test-user")
					.phone("7819749878").email("miya_longwe@yahoo.com").fax("7788-98888").company("VW").website("www.vw.com")
					.buid());
			repository.save(Customer.getBuilder().lastName("miya").firstName("longwe").description("test-user1")
					.phone("7819744545").email("dad_longwe@yahoo.com").fax("7788-5673").company("Costco").website("www.costoco.com")
					.buid());
			repository.save(Customer.getBuilder().lastName("Dog").firstName("Snoop").description("Bulk buyer")
					.phone("5089749878").email("snoopdog@gmail.com").fax("781-963-12163").company("Mon and Pop").website("www.momandpop.com")
					.buid());
			repository.save(Customer.getBuilder().lastName("Brady").firstName("Thom").description("Super customer")
					.phone("2169749878").email("tbrady@yahoo.com").fax("4542-98888").company("Press").website("www.press.com")
					.buid());
			repository.save(Customer.getBuilder().lastName("foo").firstName("bar").description("Whole saler buyer")
					.phone("5519740878").email("foo_bar@hotmail.com").fax("677-98888").company("CNN").website("www.cnn.")
					.buid());
			repository.save(Customer.getBuilder().lastName("Adam").firstName("Chris").description("Coorporate buyer --B2B")
					.phone("2158905859").email("adam_chris@yahoo.com").fax("7745888888").company("Toyota").website("www.toyota.com")
					.buid());
			repository.findAll().forEach(System.err::println);
		};
	}
}
