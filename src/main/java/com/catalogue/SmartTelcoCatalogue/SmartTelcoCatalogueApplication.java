package com.catalogue.SmartTelcoCatalogue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import com.catalogue.SmartTelcoCatalogue.model.Plans;
import com.catalogue.SmartTelcoCatalogue.model.Products;


/**
 * @author jaymani
 *
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan({"com.catalogue.SmartTelcoCatalogue","com.catalogue.SmartTelcoCatalogue.model"})
@EntityScan(basePackageClasses= {Products.class,Plans.class})
public class SmartTelcoCatalogueApplication  {

	public static void main(String[] args) {
		//Run the sping boot application
		SpringApplication.run(SmartTelcoCatalogueApplication.class, args);
	}
}
