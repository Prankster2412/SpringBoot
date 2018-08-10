/**
 * 
 */
package com.catalogue.SmartTelcoCatalogue.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.catalogue.SmartTelcoCatalogue.model.MasterCatalogue;

/**
 * @author jaymani
 *
 */
@Repository("mcRepository")
public interface MCRepository extends CrudRepository<MasterCatalogue, String> {

}
