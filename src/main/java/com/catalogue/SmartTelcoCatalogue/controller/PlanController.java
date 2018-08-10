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

import com.catalogue.SmartTelcoCatalogue.model.Plans;
import com.catalogue.SmartTelcoCatalogue.service.PlanService;

/**
 * @author jaymani
 *
 */

@RestController
@RequestMapping("/smartTelco")
public class PlanController {

	private static final Logger log = LoggerFactory.getLogger(PlanController.class);

	@Autowired
	private PlanService planService;

	// Get all products id
	@GetMapping("/plans")
	public List<Plans> getAllPlans() {
		log.debug("Getting all the plans");
		return planService.getAllPlans();
	}

	// Get catalogue for catalogueId
	@GetMapping("/plans/{productId}")
	public Optional<Plans> getPlan(@PathVariable(value = "productId") String productId) {
		log.debug("Getting Plan details for {}.", productId);
		return planService.getPlan(productId);
	}

	// Create Plans
	@PostMapping("/createPlan")
	public Plans createPlan(@Valid @RequestBody Plans plan) {

		return planService.createPlan(plan);

	}

	// Update Plan
	@PutMapping("/updatePlan")
	public Plans updatePlan(@Valid @RequestBody Plans plan) {
		return planService.updatePlan(plan);
	}

	// Delete Product
	@DeleteMapping("/deletePlan/{productId}")
	public void deletePlan(@PathVariable(value = "productId") String productId) {
		planService.deletePlan(productId);
	}
	
	@GetMapping("/eligiblePlanByRegion/{region}")
	public List<Plans> eligiblePlanByRegion(@PathVariable(value = "region") String region) {
		return planService.eligiblePlanByRegion(region);
		
	}
	
	@GetMapping("/eligiblePlanBySubCategory/{subCategory}")
	public List<Plans> eligiblePlanBySubCategory(@PathVariable(value = "subCategory") String subCategory) {
		return planService.eligiblePlanBySubCategory(subCategory);
		
	}
	
	@GetMapping("/eligiblePlanByCategory/{category}")
	public List<Plans> eligiblePlanByCategory(@PathVariable(value = "category") String category) {
		return planService.eligiblePlanByCategory(category);
		
	}
}
