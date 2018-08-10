package com.catalogue.SmartTelcoCatalogue.service;

import java.util.List;
import java.util.Optional;

import com.catalogue.SmartTelcoCatalogue.model.MasterCatalogue;

/**
 * @author jaymani
 *
 */
public interface MCService {

	List<MasterCatalogue> getAllProducts();

	Optional<MasterCatalogue> getEligibleProductsByRegion(String region);

	MasterCatalogue createMCProduct(MasterCatalogue masterCatalogue);

}
