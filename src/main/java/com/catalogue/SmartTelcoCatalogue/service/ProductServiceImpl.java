/**
 * 
 */
package com.catalogue.SmartTelcoCatalogue.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalogue.SmartTelcoCatalogue.model.Products;
import com.catalogue.SmartTelcoCatalogue.repository.ProductRepository;

/**
 * @author jaymani
 *
 */
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
	/* (non-Javadoc)
	 * @see com.catalogue.SmartTelcoCatalogue.service.ProductService#getAllProducts()
	 */
	@Override
	public List<Products> getAllProducts() {
		log.info("Getting all the product");
		return (List<Products>)productRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.catalogue.SmartTelcoCatalogue.service.ProductService#getProduct(java.lang.String)
	 */
	@Override
	public Optional<Products> getProduct(String productId) {
		log.info("Getting product details for : ",productId);
		return productRepository.findById(productId);
	}

	@Override
	public Products createProduct(@Valid Products product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(String productId) {
		// TODO Auto-generated method stub
		productRepository.deleteById(productId);
	}

	@Override
	public Products updateProduct(@Valid Products product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	
}
