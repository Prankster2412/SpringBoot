package com.catalogue.SmartTelcoCatalogue.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalogue.SmartTelcoCatalogue.model.Employee;
import com.catalogue.SmartTelcoCatalogue.service.CatalogueService;

/**
 * @author jaymani
 *
 */

@RestController
@RequestMapping("/smartTelco")
public class CatalogueController {
	private static final Logger log = LoggerFactory.getLogger(CatalogueController.class);

	public CatalogueController() {
	}

	@Autowired
	private CatalogueService catalogueService;

	// Get all employee id
	@GetMapping("/employee")
	public List<Employee> getAllEmployees() {
		log.debug("Getting all the employees");
		return catalogueService.getAllEmployees();
	}

	// Get employee for employeeId
	@GetMapping("/employee/{empId}")
	public Optional<Employee> getEmployee(@PathVariable(value = "empId") String empId) {
		log.debug("Getting Employee details for {}.", empId);
		return catalogueService.getEmployee(empId);
	}

	/*
	 * //Create Products
	 * 
	 * @PostMapping("/create-profile") public Products
	 * createProducts(@Valid @RequestBody String productId,String productName,String
	 * shortDesc,String longDesc,Double unitPrice,Double retailPrice,String
	 * category,String subCategory) { return productService.;
	 * 
	 * }
	 */
	@RequestMapping("/greeting")
	public String greeting() {
		return "Hello from EurekaClient!";
	}

}
