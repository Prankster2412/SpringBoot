/**
 * 
 */
package com.catalogue.SmartTelcoCatalogue.service;

import java.util.List;
import java.util.Optional;

import com.catalogue.SmartTelcoCatalogue.model.Employee;


/**
 * @author jaymani
 *
 */
public interface CatalogueService {

	// Get all Employee
	public List<Employee> getAllEmployees();

	// Get specific Employee
	public Optional<Employee> getEmployee(String empId);

	

}
