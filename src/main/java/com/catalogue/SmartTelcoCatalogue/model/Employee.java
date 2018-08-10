/**
 * 
 */
package com.catalogue.SmartTelcoCatalogue.model;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;






/**
 * @author jaymani
 *
 */
@Data
@Table
public class Employee {
	
	@PrimaryKey
	@Id
	private String empid;
	
	@NotBlank
	private String emp_dept;
	@NotBlank
	private String emp_first;
	@NotBlank
	private String emp_last;

	public Employee(){}
	
	public Employee(String empid,String emp_dept,String emp_first,String emp_last) {
		this.empid=empid;
		this.emp_dept=emp_dept;
		this.emp_first=emp_first;
		this.emp_last=emp_last;
				
	}
	
	/**
	 * @return the empid
	 */
	public String getEmpid() {
		return empid;
	}

	/**
	 * @param empid the empid to set
	 */
	public void setEmpid(String empid) {
		this.empid = empid;
	}

	/**
	 * @return the emp_dept
	 */
	public String getEmp_dept() {
		return emp_dept;
	}

	/**
	 * @param emp_dept the emp_dept to set
	 */
	public void setEmp_dept(String emp_dept) {
		this.emp_dept = emp_dept;
	}

	/**
	 * @return the emp_first
	 */
	public String getEmp_first() {
		return emp_first;
	}

	/**
	 * @param emp_first the emp_first to set
	 */
	public void setEmp_first(String emp_first) {
		this.emp_first = emp_first;
	}

	/**
	 * @return the emp_last
	 */
	public String getEmp_last() {
		return emp_last;
	}

	/**
	 * @param emp_last the emp_last to set
	 */
	public void setEmp_last(String emp_last) {
		this.emp_last = emp_last;
	}

	@Override
	public String toString() {
		return String.format("Employee[empid=%d, firstname='%s', lastName='%s', dept=%d]", this.empid,
				this.emp_first, this.emp_last, this.emp_dept);
	}
	
	
}
