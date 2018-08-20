/**
 * 
 */
package com.catalogue.SmartTelcoCatalogue.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalogue.SmartTelcoCatalogue.model.Plans;
import com.catalogue.SmartTelcoCatalogue.repository.PlanRepository;

/**
 * @author jaymani
 *
 */
@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	PlanRepository planRepository;

	@Override
	public List<Plans> getAllPlans() {
		final List<Plans> allPlans = (List<Plans>) planRepository.findAll();
		return allPlans;
	}

	@Override
	public Optional<Plans> getPlan(String productId) {
		final Optional<Plans> plan = planRepository.findById(productId);
		return plan;
	}

	@Override
	public Plans createPlan(@Valid Plans plan) {
		final Plans newPlan = planRepository.save(plan);
		return newPlan;
	}

	@Override
	public Plans updatePlan(@Valid Plans plan) {
		final Plans updatedPlan = planRepository.save(plan);
		return updatedPlan;
	}

	@Override
	public void deletePlan(String productId) {

		planRepository.deleteById(productId);
	}

	@Override
	public List<Plans> eligiblePlanByRegion(String region) {
		final List<Plans> planByRegion = planRepository.findByRegions(region);
		return planByRegion;
	}

	@Override
	public List<Plans> eligiblePlanBySubCategory(String subCategory) {
		final List<Plans> planBySubCategory = planRepository.findBySubCategory(subCategory);
		return planBySubCategory;
	}

	@Override
	public List<Plans> eligiblePlanByCategory(String category) {
		final List<Plans> planByCategory = planRepository.findByCategory(category);
		return planByCategory;
	}

}
