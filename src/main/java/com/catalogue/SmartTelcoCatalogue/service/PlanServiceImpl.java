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
		// TODO Auto-generated method stub
		return (List<Plans>) planRepository.findAll();
	}

	@Override
	public Optional<Plans> getPlan(String productId) {
		// TODO Auto-generated method stub
		return planRepository.findById(productId);
	}

	@Override
	public Plans createPlan(@Valid Plans plan) {
		
		return planRepository.save(plan);
	}

	@Override
	public Plans updatePlan(@Valid Plans plan) {
		// TODO Auto-generated method stub
		return planRepository.save(plan);
	}

	@Override
	public void deletePlan(String productId) {
		// TODO Auto-generated method stub
		planRepository.deleteById(productId);
	}

	@Override
	public List<Plans> eligiblePlanByRegion(String region) {
		// TODO Auto-generated method stub
		return planRepository.findByRegions(region);
	}

	@Override
	public List<Plans> eligiblePlanBySubCategory(String subCategory) {
		// TODO Auto-generated method stub
		return planRepository.findBySubCategory(subCategory);
	}

	@Override
	public List<Plans> eligiblePlanByCategory(String category) {
		// TODO Auto-generated method stub
		return planRepository.findByCategory(category);
	}
	
	
}
