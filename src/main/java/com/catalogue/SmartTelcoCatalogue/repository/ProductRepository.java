/**
 * 
 */
package com.catalogue.SmartTelcoCatalogue.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.catalogue.SmartTelcoCatalogue.model.Products;

/**
 * @author jaymani
 *
 */
@Repository("productRepository")
public interface ProductRepository extends CrudRepository<Products, String> {

}
