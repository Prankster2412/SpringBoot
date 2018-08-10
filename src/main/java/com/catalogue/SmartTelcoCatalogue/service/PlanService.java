package com.catalogue.SmartTelcoCatalogue.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.catalogue.SmartTelcoCatalogue.model.Plans;

public interface PlanService {
	
	public List<Plans> getAllPlans();
	
	public Optional<Plans> getPlan(String productId);

	public Plans createPlan(@Valid Plans plan);

	public Plans updatePlan(@Valid Plans plan);

	public void deletePlan(String productId);

	public List<Plans> eligiblePlanByRegion(String region);

	public List<Plans> eligiblePlanBySubCategory(String subCategory);

	public List<Plans> eligiblePlanByCategory(String category);

}