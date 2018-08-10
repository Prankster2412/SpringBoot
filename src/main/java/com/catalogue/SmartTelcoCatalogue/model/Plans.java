/**
 * 
 */
package com.catalogue.SmartTelcoCatalogue.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;

/**
 * @author jaymani
 *
 */
@Data
@Table
public class Plans {
	
	public Plans() {
		
	}

	@PrimaryKey
	@Id
	private String productId;
	private String productName;
	private String shortDesc;
	private String longDesc;
	private float unitPrice;
	private float retailPrice;
	private String category;
	private String subCategory;
	private String regions;
	private String dimensions;
	private Date createTs;
	private Date modifyTs;
	private String createProgId;
	private String modifyProgId;
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
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the shortDesc
	 */
	public String getShortDesc() {
		return shortDesc;
	}
	/**
	 * @param shortDesc the shortDesc to set
	 */
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	/**
	 * @return the longDesc
	 */
	public String getLongDesc() {
		return longDesc;
	}
	/**
	 * @param longDesc the longDesc to set
	 */
	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}
	/**
	 * @return the unitPrice
	 */
	public float getUnitPrice() {
		return unitPrice;
	}
	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	/**
	 * @return the retailPrice
	 */
	public float getRetailPrice() {
		return retailPrice;
	}
	/**
	 * @param retailPrice the retailPrice to set
	 */
	public void setRetailPrice(float retailPrice) {
		this.retailPrice = retailPrice;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
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
	/**
	 * @return the dimensions
	 */
	public String getDimensions() {
		return dimensions;
	}
	/**
	 * @param dimensions the dimensions to set
	 */
	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}
	/**
	 * @return the createTs
	 */
	public Date getCreateTs() {
		return createTs;
	}
	/**
	 * @param createTs the createTs to set
	 */
	public void setCreateTs(Date createTs) {
		this.createTs = createTs;
	}
	/**
	 * @return the modifyTs
	 */
	public Date getModifyTs() {
		return modifyTs;
	}
	/**
	 * @param modifyTs the modifyTs to set
	 */
	public void setModifyTs(Date modifyTs) {
		this.modifyTs = modifyTs;
	}
	/**
	 * @return the createProgId
	 */
	public String getCreateProgId() {
		return createProgId;
	}
	/**
	 * @param createProgId the createProgId to set
	 */
	public void setCreateProgId(String createProgId) {
		this.createProgId = createProgId;
	}
	/**
	 * @return the modifyProgId
	 */
	public String getModifyProgId() {
		return modifyProgId;
	}
	/**
	 * @param modifyProgId the modifyProgId to set
	 */
	public void setModifyProgId(String modifyProgId) {
		this.modifyProgId = modifyProgId;
	}
	
	public Plans(String productId,String productName,String shortDesc,String longDesc,float unitPrice,float retailPrice,
			String category,String region,String dimensions,
			Date createTs,Date modifyTs,String createProgId,String modifyProgId) {
			super();
			this.productId=productId;
			this.productName=productName;
			this.shortDesc=shortDesc;
			this.longDesc=longDesc;
			this.unitPrice=unitPrice;
			this.retailPrice=retailPrice;
			this.category=category;
			this.regions=region;
			this.createTs=createTs;
			this.modifyTs=modifyTs;
			this.createProgId=createProgId;
			this.modifyProgId=modifyProgId;
	}
	/**
	 * @return the subCategory
	 */
	public String getSubCategory() {
		return subCategory;
	}
	/**
	 * @param subCategory the subCategory to set
	 */
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
}
