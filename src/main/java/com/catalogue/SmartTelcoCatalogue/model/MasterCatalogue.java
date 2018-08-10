/**
 * 
 */
package com.catalogue.SmartTelcoCatalogue.model;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author jaymani
 *
 */

@Entity
@Table
public class MasterCatalogue {

	public MasterCatalogue() {
	}

	@EmbeddedId
	private MyKey myKey;
	private String productName;
	private String shortDesc;
	private String longDesc;
	private float unitPrice;
	private float retailPrice;
	private String dimensions;
	private Date createTs;
	private Date modifyTs;
	private String createProgId;
	private String modifyProgId;
	
	/**
	 * @return the myKey
	 */
	public MyKey getMyKey() {
		return myKey;
	}

	/**
	 * @param myKey
	 *            the myKey to set
	 */
	public void setMyKey(MyKey myKey) {
		this.myKey = myKey;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName
	 *            the productName to set
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
	 * @param shortDesc
	 *            the shortDesc to set
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
	 * @param longDesc
	 *            the longDesc to set
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
	 * @param unitPrice
	 *            the unitPrice to set
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
	 * @param retailPrice
	 *            the retailPrice to set
	 */
	public void setRetailPrice(float retailPrice) {
		this.retailPrice = retailPrice;
	}

	

	/**
	 * @return the dimensions
	 */
	public String getDimensions() {
		return dimensions;
	}

	/**
	 * @param dimensions
	 *            the dimensions to set
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
	 * @param createTs
	 *            the createTs to set
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
	 * @param modifyTs
	 *            the modifyTs to set
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
	 * @param createProgId
	 *            the createProgId to set
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
	 * @param modifyProgId
	 *            the modifyProgId to set
	 */
	public void setModifyProgId(String modifyProgId) {
		this.modifyProgId = modifyProgId;
	}

	public MasterCatalogue(MyKey myKey, String productName, String shortDesc, String longDesc, float unitPrice,
			float retailPrice, String dimensions, Date createTs, Date modifyTs, String createProgId,
			String modifyProgId) {
		super();
		this.myKey = myKey;
		this.productName = productName;
		this.shortDesc = shortDesc;
		this.longDesc = longDesc;
		this.unitPrice = unitPrice;
		this.retailPrice = retailPrice;
		this.createTs = createTs;
		this.modifyTs = modifyTs;
		this.createProgId = createProgId;
		this.modifyProgId = modifyProgId;
	}
}
