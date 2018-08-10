/**
 * 
 */
package com.catalogue.SmartTelcoCatalogue.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.catalogue.SmartTelcoCatalogue.model.Employee;

/**
 * @author jaymani
 *
 */
@Repository("employeeRepository")
public interface EmployeeRepository extends CrudRepository<Employee, String> {

}
