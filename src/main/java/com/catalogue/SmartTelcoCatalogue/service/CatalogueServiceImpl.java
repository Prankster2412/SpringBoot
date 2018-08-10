/**
 * 
 */
package com.catalogue.SmartTelcoCatalogue.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalogue.SmartTelcoCatalogue.model.Employee;
import com.catalogue.SmartTelcoCatalogue.repository.EmployeeRepository;

/**
 * @author jaymani
 *
 */
@Service
public class CatalogueServiceImpl implements CatalogueService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
		

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> getEmployee(String empId) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(empId);
	}

	

}
