/**
 * 
 */
package com.catalogue.SmartTelcoCatalogue.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalogue.SmartTelcoCatalogue.model.MasterCatalogue;
import com.catalogue.SmartTelcoCatalogue.service.MCService;



/**
 * @author jaymani
 *
 */
@RestController
@RequestMapping("/smartTelco")
public class MCController {
	
	private static final Logger log = LoggerFactory.getLogger(MCController.class);

	@Autowired
	private MCService mcService;
	
	// Get all products id
		@GetMapping("/mcProducts")
		public List<MasterCatalogue>getAllProducts(){
			log.debug("Getting all the products in MC");
			return mcService.getAllProducts();
		}
		@GetMapping("/mcProducts/{regions}")
		public Optional<MasterCatalogue>getProductsByRegion(@PathVariable(value="regions")String region){
			return mcService.getEligibleProductsByRegion(region);
		}
		
		// Create Plans
		@PostMapping("/createMCProduct")
		public MasterCatalogue createMCProduct(MasterCatalogue masterCatalogue) {
			return mcService.createMCProduct(masterCatalogue);
		}
		
	
}
