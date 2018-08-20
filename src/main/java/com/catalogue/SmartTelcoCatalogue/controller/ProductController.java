/**
 * 
 */
package com.catalogue.SmartTelcoCatalogue.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalogue.SmartTelcoCatalogue.model.Products;
import com.catalogue.SmartTelcoCatalogue.service.ProductService;

/**
 * @author jaymani
 *
 */

@RestController
@RequestMapping("/smartTelco")
public class ProductController {

	private static final Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	// Get all products id
	@GetMapping("/products")
	public List<Products> getAllProducts() {
		log.debug("Getting all the products");
		return productService.getAllProducts();
	}

	// Get catalogue for catalogueId
	@GetMapping("/products/{productId}")
	public Optional<Products> getProduct(@PathVariable(value = "productId") String productId) {
		log.debug("Getting Product details for {}.", productId);
		return productService.getProduct(productId);
	}

	// Create Product
	@PostMapping("/createProduct")
	public Products createProducts(@Valid @RequestBody Products product) {
		return productService.createProduct(product);
	}

	// Update Product
	@PutMapping("/updateProduct")
	public Products updateProduct(@Valid @RequestBody Products product) {
		return productService.updateProduct(product);
	}

	//Delete Product
	@DeleteMapping("/deleteProduct/{productId}")
	public void deleteProduct(@PathVariable(value = "productId") String productId) {
		productService.deleteProduct(productId);
	}
	
	@GetMapping("/eligibleProductsBySubCategory/{subCategory}")
	public List<Products> eligibleProductsBySubCategory(@PathVariable(value = "subCategory") String subCategory) {
		return productService.eligibleProductsBySubCategory(subCategory);
		
	}
	
	@GetMapping("/eligibleProductsByCategory/{category}")
	public List<Products> eligibleProductsByCategory(@PathVariable(value = "category") String category) {
		return productService.eligibleProductsByCategory(category);
		
	}
}
