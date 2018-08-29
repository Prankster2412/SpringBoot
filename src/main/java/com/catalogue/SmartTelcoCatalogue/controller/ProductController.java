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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalogue.SmartTelcoCatalogue.model.Products;
import com.catalogue.SmartTelcoCatalogue.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author jaymani
 *
 */

@RestController
@RequestMapping("/smartTelco")
@Api(value="onlinestore", description="Operations pertaining to products in Online Store")
public class ProductController {

	private static final Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;
	
    @ApiOperation(value = "View a list of available products",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }

    )
	// Get all products id
    @RequestMapping(value = "/products", method= RequestMethod.GET, produces = "application/json")
	public List<Products> getAllProducts() {
		log.debug("Getting all the products");
		return productService.getAllProducts();
	}
    @ApiOperation(value = "Search a product with an ID",response = Products.class)
	// Get catalogue for catalogueId
    @RequestMapping(value = "/products/{productId}", method= RequestMethod.GET, produces = "application/json")
	public Optional<Products> getProduct(@PathVariable(value = "productId") String productId) {
		log.debug("Getting Product details for {}.", productId);
		return productService.getProduct(productId);
	}
    
    @ApiOperation(value = "Add a product")
	// Create Product
	@PostMapping("/createProduct")
	public Products createProducts(@Valid @RequestBody Products product) {
		return productService.createProduct(product);
	}
    @ApiOperation(value = "Update a product")
	// Update Product
	@PutMapping("/updateProduct")
	public Products updateProduct(@Valid @RequestBody Products product) {
		return productService.updateProduct(product);
	}
    
    @ApiOperation(value = "Delete a product")
	//Delete Product
	@DeleteMapping("/deleteProduct/{productId}")
	public void deleteProduct(@PathVariable(value = "productId") String productId) {
		productService.deleteProduct(productId);
	}
	
    @ApiOperation(value = "Return eligible product by SubCategory",response = Iterable.class)
    @RequestMapping(value = "/eligibleProductsBySubCategory/{subCategory}", method= RequestMethod.GET, produces = "application/json")
	public List<Products> eligibleProductsBySubCategory(@PathVariable(value = "subCategory") String subCategory) {
		return productService.eligibleProductsBySubCategory(subCategory);
		
	}
	
    @ApiOperation(value = "Return eligible product by Category",response = Iterable.class)
    @RequestMapping(value = "/eligibleProductsByCategory/{category}", method= RequestMethod.GET, produces = "application/json")
	public List<Products> eligibleProductsByCategory(@PathVariable(value = "category") String category) {
		return productService.eligibleProductsByCategory(category);
		
	}
}
