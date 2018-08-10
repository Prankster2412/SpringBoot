/**
 * 
 */
package com.catalogue.SmartTelcoCatalogue.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.catalogue.SmartTelcoCatalogue.model.Plans;

/**
 * @author jaymani
 *
 */
@Repository("planRepository")
public interface PlanRepository extends CrudRepository<Plans, String> {
	
	@Query(value="SELECT * FROM plans WHERE regions=?0")
	public List<Plans> findByRegions(String regions);
	
	@Query(value="SELECT * FROM plans WHERE category=?0")
	public List<Plans> findByCategory(String Category);
	
	@Query(value="SELECT * FROM plans WHERE subcategory=?0")
	public List<Plans> findBySubCategory(String subCategory);
}
