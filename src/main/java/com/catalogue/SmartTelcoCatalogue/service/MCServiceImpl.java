/**
 * 
 */
package com.catalogue.SmartTelcoCatalogue.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalogue.SmartTelcoCatalogue.model.MasterCatalogue;
import com.catalogue.SmartTelcoCatalogue.repository.MCRepository;

/**
 * @author jaymani
 *
 */
@Service
public class MCServiceImpl implements MCService {
	
	@Autowired
	MCRepository mcRepository;

	/* (non-Javadoc)
	 * @see com.catalogue.SmartTelcoCatalogue.service.MCService#getAllProducts()
	 */
	@Override
	public List<MasterCatalogue> getAllProducts() {
		// TODO Auto-generated method stub
		return (List<MasterCatalogue>) mcRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.catalogue.SmartTelcoCatalogue.service.MCService#getEligibleProductsByRegion(java.lang.String)
	 */
	@Override
	public Optional<MasterCatalogue> getEligibleProductsByRegion(String region) {
		// TODO Auto-generated method stub
		return mcRepository.findById(region);
	}

	@Override
	public MasterCatalogue createMCProduct(MasterCatalogue masterCatalogue) {
		// TODO Auto-generated method stub
		return mcRepository.save(masterCatalogue);
	}

}
