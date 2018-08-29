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
@Api(value="onlinestore", description="Operations pertaining to plans in Online Store")
public class PlanController {

	private static final Logger log = LoggerFactory.getLogger(PlanController.class);

	@Autowired
	private PlanService planService;

	// Get all products id
	@ApiOperation(value = "View a list of available plans",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@GetMapping("/plans")
	public List<Plans> getAllPlans() {
		log.debug("Getting all the plans");
		return planService.getAllPlans();
	}

	// Get catalogue for catalogueId
	@ApiOperation(value = "Search a plan with an ID",response = Plans.class)
	@GetMapping("/plans/{productId}")
	public Optional<Plans> getPlan(@PathVariable(value = "productId") String productId) {
		log.debug("Getting Plan details for {}.", productId);
		return planService.getPlan(productId);
	}

	// Create Plans
	@ApiOperation(value="Add a plan")
	@PostMapping("/createPlan")
	public Plans createPlan(@Valid @RequestBody Plans plan) {

		return planService.createPlan(plan);

	}

	// Update Plan
	@ApiOperation(value="Update a plan")
	@PutMapping("/updatePlan")
	public Plans updatePlan(@Valid @RequestBody Plans plan) {
		return planService.updatePlan(plan);
	}

	// Delete Product
	@ApiOperation(value="Delete a plan")
	@DeleteMapping("/deletePlan/{productId}")
	public void deletePlan(@PathVariable(value = "productId") String productId) {
		planService.deletePlan(productId);
	}
	
	@ApiOperation(value = "Return eligible product by Region",response = Iterable.class)
	@GetMapping("/eligiblePlanByRegion/{region}")
	public List<Plans> eligiblePlanByRegion(@PathVariable(value = "region") String region) {
		return planService.eligiblePlanByRegion(region);
		
	}
	
	@ApiOperation(value = "Return eligible Plans by SubCategory",response = Iterable.class)
	@GetMapping("/eligiblePlanBySubCategory/{subCategory}")
	public List<Plans> eligiblePlanBySubCategory(@PathVariable(value = "subCategory") String subCategory) {
		return planService.eligiblePlanBySubCategory(subCategory);
		
	}
	
	@ApiOperation(value = "Return eligible product by Category",response = Iterable.class)
	@GetMapping("/eligiblePlanByCategory/{category}")
	public List<Plans> eligiblePlanByCategory(@PathVariable(value = "category") String category) {
		return planService.eligiblePlanByCategory(category);
		
	}
}
