package com.miya.longwe.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.miya.longwe.springboot.configuration.JpaConfiguration;


/**
 * The Class SpringBootAngularJs.
 */
@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"com.miya.longwe.springboot"})// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class SpringBootAngularJs {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringBootAngularJs.class, args);
	}
}
