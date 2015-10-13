package com.mlongwe.springbootrest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mlongwe.springbootrest.domain.Product;
import com.mlongwe.springbootrest.repository.ProductRepository;
import com.mlongwe.springbootrest.service.ProductService;

/**
 * @author Miya W. Longwe
 * 
 *       
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class BootMongoDB implements CommandLineRunner {

    @Autowired
    private ProductService productService;
    
    @Autowired ProductRepository productRepository;

    private static final Logger logger = LoggerFactory.getLogger(BootMongoDB.class);

    public void run(String... args) throws Exception {
        List<Product> sku = productService.getSku("pad2.0");
        logger.info("result of getSku is {}", sku);
        List<Product> availableSku = productService.getAvailableSku("NEX.6");
        logger.info("result of getAvailableSku is {}", availableSku);
        List<Product> availableSkuCustom = productService.getAvailableSkuCustom("NEX.6");
        logger.info("result of availableSkuCustom is {}", availableSkuCustom);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(BootMongoDB.class, args);
    }
    
    @Bean
	InitializingBean populateTestData(ProductRepository productRepository) {
		return () -> {
			Product productOne = new Product();
			productOne.setAvailability(1);
			productOne.setMaterialName("iPad");
			productOne.setPrice(300.00);
			productOne.setSku("pad2.0");
			
			productRepository.save(productOne);

			
			productRepository.findAll().forEach(System.err::println);
		};
	}
}
