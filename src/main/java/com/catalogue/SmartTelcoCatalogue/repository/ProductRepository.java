/**
 * 
 */
package com.catalogue.SmartTelcoCatalogue.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.catalogue.SmartTelcoCatalogue.model.Products;

/**
 * @author jaymani
 *
 */
@Repository("productRepository")
public interface ProductRepository extends CrudRepository<Products, String> {
	
	@Query(value="SELECT * FROM plans WHERE category=?0")
	public List<Products> findByCategory(String Category);
	
	@Query(value="SELECT * FROM plans WHERE subcategory=?0")
	public List<Products> findBySubCategory(String subCategory);

}
