package com.miya.longwe.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.miya.longwe.springboot.configuration.JpaConfiguration;

@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"com.miya.longwe.springboot"})// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class SpringBootAngularJs {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAngularJs.class, args);
	}
}
