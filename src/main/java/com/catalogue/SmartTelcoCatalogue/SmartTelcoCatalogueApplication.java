package com.catalogue.SmartTelcoCatalogue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import com.catalogue.SmartTelcoCatalogue.model.Plans;
import com.catalogue.SmartTelcoCatalogue.model.Products;


/**
 * @author jaymani
 *
 */
@SpringBootApplication
@ComponentScan({"com.catalogue.SmartTelcoCatalogue","com.catalogue.SmartTelcoCatalogue.model"})
@EntityScan(basePackageClasses= {Products.class,Plans.class})
public class SmartTelcoCatalogueApplication  {

	public static void main(String[] args) {
		//Run the sping boot application
		SpringApplication.run(SmartTelcoCatalogueApplication.class, args);
	}
}
