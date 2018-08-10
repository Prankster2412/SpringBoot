/**
 * 
 */
package com.catalogue.SmartTelcoCatalogue.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.catalogue.SmartTelcoCatalogue.model.Products;


/**
 * @author jaymani
 *
 */
public interface ProductService {
	
	public List<Products> getAllProducts();

	public Optional<Products> getProduct(String productId);

	public Products createProduct(@Valid Products product);

	public void deleteProduct(String productId);

	public Products updateProduct(@Valid Products product);
	

}
