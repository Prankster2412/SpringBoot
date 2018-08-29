/**
 * 
 */
package com.catalogue.SmartTelcoCatalogue.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * @author jaymani
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
        		.apis(RequestHandlerSelectors.basePackage("com.catalogue.SmartTelcoCatalogue.controller"))
        		.paths(regex("/smartTelco.*"))
        		.build()
        		.apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("SmartTelco Catalogue MicroServices", "Catalogue related APIs", "API TOS", "Terms of service", new Contact("Jayajith Mani", "www.sapient.com", "jmani@sapient.com"), "License of API", "API license URL");
        return apiInfo;
}
}