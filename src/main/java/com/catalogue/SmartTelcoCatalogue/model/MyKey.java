/**
 * 
 */
package com.catalogue.SmartTelcoCatalogue.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author jaymani
 *
 */
@Embeddable
public class MyKey implements Serializable {
	
	@Column(name="productid")
	private String productId;
	
	@Column(name="regions")
	private String regions;
	
	@Column(name="category")
	private String category;
	
	@Column(name="subcategory")
	private String subCategory;
	public MyKey() {
		
	}
	
	public MyKey(String productId,String regions,String category,String subCategory) {
		super();
		this.productId=productId;
		this.regions=regions;
		this.category=category;
		this.subCategory=subCategory;
	}
	
	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/**
	 * @return the regions
	 */
	public String getRegions() {
		return regions;
	}

	/**
	 * @param regions the regions to set
	 */
	public void setRegions(String regions) {
		this.regions = regions;
	}
	
	

}
