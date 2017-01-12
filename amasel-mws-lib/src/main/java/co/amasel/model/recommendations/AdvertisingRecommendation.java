/*******************************************************************************
 * Copyright 2009-2014 Amazon Services. All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 *
 * You may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at: http://aws.amazon.com/apache2.0
 * This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR 
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the 
 * specific language governing permissions and limitations under the License.
 *******************************************************************************
 * Advertising Recommendation
 * API Version: 2013-04-01
 * Library Version: 2014-10-01
 * Generated: Fri Oct 10 17:55:39 GMT 2014
 */
package co.amasel.model.recommendations;

import javax.xml.datatype.XMLGregorianCalendar;

import com.amazonservices.mws.client.*;
import co.amasel.model.common.AmaselMwsObject;
import co.amasel.model.common.ResponseHeaderMetadata;
import co.amasel.model.common.ResponseMetadata;
import com.amazonservices.mws.client.MwsReader;
import com.amazonservices.mws.client.MwsWriter;
import com.amazonservices.mws.client.MwsResponseHeaderMetadata;

/**
 * AdvertisingRecommendation complex type.
 *
 * XML schema:
 *
 * <pre>
 * &lt;complexType name="AdvertisingRecommendation"&gt;
 *    &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *          &lt;sequence&gt;
 *             &lt;element name="LastUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *             &lt;element name="ItemIdentifier" type="{https://mws.amazonservices.com/Recommendations/2013-04-01}ProductIdentifier"/&gt;
 *             &lt;element name="ItemName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="BrandName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="ProductCategory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="SalesRank" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *             &lt;element name="YourPricePlusShipping" type="{https://mws.amazonservices.com/Recommendations/2013-04-01}Price" minOccurs="0"/&gt;
 *             &lt;element name="LowestPricePlusShipping" type="{https://mws.amazonservices.com/Recommendations/2013-04-01}Price" minOccurs="0"/&gt;
 *             &lt;element name="AvailableQuantity" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *             &lt;element name="SalesForTheLast30Days" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *             &lt;element name="RecommendationId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *             &lt;element name="RecommendationReason" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *          &lt;/sequence&gt;
 *       &lt;/restriction&gt;
 *    &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class AdvertisingRecommendation extends AmaselMwsObject {

	private XMLGregorianCalendar lastUpdated;

	private ProductIdentifier itemIdentifier;

	private String itemName;

	private String brandName;

	private String productCategory;

	private Integer salesRank;

	private Price yourPricePlusShipping;

	private Price lowestPricePlusShipping;

	private Integer availableQuantity;

	private Integer salesForTheLast30Days;

	private String recommendationId;

	private String recommendationReason;

	/**
	 * Get the value of LastUpdated.
	 *
	 * @return The value of LastUpdated.
	 */
	public XMLGregorianCalendar getLastUpdated() {
		return lastUpdated;
	}

	/**
	 * Set the value of LastUpdated.
	 *
	 * @param lastUpdated
	 *            The new value to set.
	 */
	public void setLastUpdated(XMLGregorianCalendar lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	/**
	 * Check to see if LastUpdated is set.
	 *
	 * @return true if LastUpdated is set.
	 */
	public boolean isSetLastUpdated() {
		return lastUpdated != null;
	}

	/**
	 * Set the value of LastUpdated, return this.
	 *
	 * @param lastUpdated
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public AdvertisingRecommendation withLastUpdated(
			XMLGregorianCalendar lastUpdated) {
		this.lastUpdated = lastUpdated;
		return this;
	}

	/**
	 * Get the value of ItemIdentifier.
	 *
	 * @return The value of ItemIdentifier.
	 */
	public ProductIdentifier getItemIdentifier() {
		return itemIdentifier;
	}

	/**
	 * Set the value of ItemIdentifier.
	 *
	 * @param itemIdentifier
	 *            The new value to set.
	 */
	public void setItemIdentifier(ProductIdentifier itemIdentifier) {
		this.itemIdentifier = itemIdentifier;
	}

	/**
	 * Check to see if ItemIdentifier is set.
	 *
	 * @return true if ItemIdentifier is set.
	 */
	public boolean isSetItemIdentifier() {
		return itemIdentifier != null;
	}

	/**
	 * Set the value of ItemIdentifier, return this.
	 *
	 * @param itemIdentifier
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public AdvertisingRecommendation withItemIdentifier(
			ProductIdentifier itemIdentifier) {
		this.itemIdentifier = itemIdentifier;
		return this;
	}

	/**
	 * Get the value of ItemName.
	 *
	 * @return The value of ItemName.
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * Set the value of ItemName.
	 *
	 * @param itemName
	 *            The new value to set.
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * Check to see if ItemName is set.
	 *
	 * @return true if ItemName is set.
	 */
	public boolean isSetItemName() {
		return itemName != null;
	}

	/**
	 * Set the value of ItemName, return this.
	 *
	 * @param itemName
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public AdvertisingRecommendation withItemName(String itemName) {
		this.itemName = itemName;
		return this;
	}

	/**
	 * Get the value of BrandName.
	 *
	 * @return The value of BrandName.
	 */
	public String getBrandName() {
		return brandName;
	}

	/**
	 * Set the value of BrandName.
	 *
	 * @param brandName
	 *            The new value to set.
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	/**
	 * Check to see if BrandName is set.
	 *
	 * @return true if BrandName is set.
	 */
	public boolean isSetBrandName() {
		return brandName != null;
	}

	/**
	 * Set the value of BrandName, return this.
	 *
	 * @param brandName
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public AdvertisingRecommendation withBrandName(String brandName) {
		this.brandName = brandName;
		return this;
	}

	/**
	 * Get the value of ProductCategory.
	 *
	 * @return The value of ProductCategory.
	 */
	public String getProductCategory() {
		return productCategory;
	}

	/**
	 * Set the value of ProductCategory.
	 *
	 * @param productCategory
	 *            The new value to set.
	 */
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	/**
	 * Check to see if ProductCategory is set.
	 *
	 * @return true if ProductCategory is set.
	 */
	public boolean isSetProductCategory() {
		return productCategory != null;
	}

	/**
	 * Set the value of ProductCategory, return this.
	 *
	 * @param productCategory
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public AdvertisingRecommendation withProductCategory(String productCategory) {
		this.productCategory = productCategory;
		return this;
	}

	/**
	 * Get the value of SalesRank.
	 *
	 * @return The value of SalesRank.
	 */
	public Integer getSalesRank() {
		return salesRank;
	}

	/**
	 * Set the value of SalesRank.
	 *
	 * @param salesRank
	 *            The new value to set.
	 */
	public void setSalesRank(Integer salesRank) {
		this.salesRank = salesRank;
	}

	/**
	 * Check to see if SalesRank is set.
	 *
	 * @return true if SalesRank is set.
	 */
	public boolean isSetSalesRank() {
		return salesRank != null;
	}

	/**
	 * Set the value of SalesRank, return this.
	 *
	 * @param salesRank
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public AdvertisingRecommendation withSalesRank(Integer salesRank) {
		this.salesRank = salesRank;
		return this;
	}

	/**
	 * Get the value of YourPricePlusShipping.
	 *
	 * @return The value of YourPricePlusShipping.
	 */
	public Price getYourPricePlusShipping() {
		return yourPricePlusShipping;
	}

	/**
	 * Set the value of YourPricePlusShipping.
	 *
	 * @param yourPricePlusShipping
	 *            The new value to set.
	 */
	public void setYourPricePlusShipping(Price yourPricePlusShipping) {
		this.yourPricePlusShipping = yourPricePlusShipping;
	}

	/**
	 * Check to see if YourPricePlusShipping is set.
	 *
	 * @return true if YourPricePlusShipping is set.
	 */
	public boolean isSetYourPricePlusShipping() {
		return yourPricePlusShipping != null;
	}

	/**
	 * Set the value of YourPricePlusShipping, return this.
	 *
	 * @param yourPricePlusShipping
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public AdvertisingRecommendation withYourPricePlusShipping(
			Price yourPricePlusShipping) {
		this.yourPricePlusShipping = yourPricePlusShipping;
		return this;
	}

	/**
	 * Get the value of LowestPricePlusShipping.
	 *
	 * @return The value of LowestPricePlusShipping.
	 */
	public Price getLowestPricePlusShipping() {
		return lowestPricePlusShipping;
	}

	/**
	 * Set the value of LowestPricePlusShipping.
	 *
	 * @param lowestPricePlusShipping
	 *            The new value to set.
	 */
	public void setLowestPricePlusShipping(Price lowestPricePlusShipping) {
		this.lowestPricePlusShipping = lowestPricePlusShipping;
	}

	/**
	 * Check to see if LowestPricePlusShipping is set.
	 *
	 * @return true if LowestPricePlusShipping is set.
	 */
	public boolean isSetLowestPricePlusShipping() {
		return lowestPricePlusShipping != null;
	}

	/**
	 * Set the value of LowestPricePlusShipping, return this.
	 *
	 * @param lowestPricePlusShipping
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public AdvertisingRecommendation withLowestPricePlusShipping(
			Price lowestPricePlusShipping) {
		this.lowestPricePlusShipping = lowestPricePlusShipping;
		return this;
	}

	/**
	 * Get the value of AvailableQuantity.
	 *
	 * @return The value of AvailableQuantity.
	 */
	public Integer getAvailableQuantity() {
		return availableQuantity;
	}

	/**
	 * Set the value of AvailableQuantity.
	 *
	 * @param availableQuantity
	 *            The new value to set.
	 */
	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	/**
	 * Check to see if AvailableQuantity is set.
	 *
	 * @return true if AvailableQuantity is set.
	 */
	public boolean isSetAvailableQuantity() {
		return availableQuantity != null;
	}

	/**
	 * Set the value of AvailableQuantity, return this.
	 *
	 * @param availableQuantity
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public AdvertisingRecommendation withAvailableQuantity(
			Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
		return this;
	}

	/**
	 * Get the value of SalesForTheLast30Days.
	 *
	 * @return The value of SalesForTheLast30Days.
	 */
	public Integer getSalesForTheLast30Days() {
		return salesForTheLast30Days;
	}

	/**
	 * Set the value of SalesForTheLast30Days.
	 *
	 * @param salesForTheLast30Days
	 *            The new value to set.
	 */
	public void setSalesForTheLast30Days(Integer salesForTheLast30Days) {
		this.salesForTheLast30Days = salesForTheLast30Days;
	}

	/**
	 * Check to see if SalesForTheLast30Days is set.
	 *
	 * @return true if SalesForTheLast30Days is set.
	 */
	public boolean isSetSalesForTheLast30Days() {
		return salesForTheLast30Days != null;
	}

	/**
	 * Set the value of SalesForTheLast30Days, return this.
	 *
	 * @param salesForTheLast30Days
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public AdvertisingRecommendation withSalesForTheLast30Days(
			Integer salesForTheLast30Days) {
		this.salesForTheLast30Days = salesForTheLast30Days;
		return this;
	}

	/**
	 * Get the value of RecommendationId.
	 *
	 * @return The value of RecommendationId.
	 */
	public String getRecommendationId() {
		return recommendationId;
	}

	/**
	 * Set the value of RecommendationId.
	 *
	 * @param recommendationId
	 *            The new value to set.
	 */
	public void setRecommendationId(String recommendationId) {
		this.recommendationId = recommendationId;
	}

	/**
	 * Check to see if RecommendationId is set.
	 *
	 * @return true if RecommendationId is set.
	 */
	public boolean isSetRecommendationId() {
		return recommendationId != null;
	}

	/**
	 * Set the value of RecommendationId, return this.
	 *
	 * @param recommendationId
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public AdvertisingRecommendation withRecommendationId(
			String recommendationId) {
		this.recommendationId = recommendationId;
		return this;
	}

	/**
	 * Get the value of RecommendationReason.
	 *
	 * @return The value of RecommendationReason.
	 */
	public String getRecommendationReason() {
		return recommendationReason;
	}

	/**
	 * Set the value of RecommendationReason.
	 *
	 * @param recommendationReason
	 *            The new value to set.
	 */
	public void setRecommendationReason(String recommendationReason) {
		this.recommendationReason = recommendationReason;
	}

	/**
	 * Check to see if RecommendationReason is set.
	 *
	 * @return true if RecommendationReason is set.
	 */
	public boolean isSetRecommendationReason() {
		return recommendationReason != null;
	}

	/**
	 * Set the value of RecommendationReason, return this.
	 *
	 * @param recommendationReason
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public AdvertisingRecommendation withRecommendationReason(
			String recommendationReason) {
		this.recommendationReason = recommendationReason;
		return this;
	}

	/**
	 * Read members from a MwsReader.
	 *
	 * @param r
	 *            The reader to read from.
	 */
	@Override
	public void readFragmentFrom(MwsReader r) {
		lastUpdated = r.read("LastUpdated", XMLGregorianCalendar.class);
		itemIdentifier = r.read("ItemIdentifier", ProductIdentifier.class);
		itemName = r.read("ItemName", String.class);
		brandName = r.read("BrandName", String.class);
		productCategory = r.read("ProductCategory", String.class);
		salesRank = r.read("SalesRank", Integer.class);
		yourPricePlusShipping = r.read("YourPricePlusShipping", Price.class);
		lowestPricePlusShipping = r
				.read("LowestPricePlusShipping", Price.class);
		availableQuantity = r.read("AvailableQuantity", Integer.class);
		salesForTheLast30Days = r.read("SalesForTheLast30Days", Integer.class);
		recommendationId = r.read("RecommendationId", String.class);
		recommendationReason = r.read("RecommendationReason", String.class);
	}

	/**
	 * Write members to a MwsWriter.
	 *
	 * @param w
	 *            The writer to write to.
	 */
	@Override
	public void writeFragmentTo(MwsWriter w) {
		w.write("LastUpdated", lastUpdated);
		w.write("ItemIdentifier", itemIdentifier);
		w.write("ItemName", itemName);
		w.write("BrandName", brandName);
		w.write("ProductCategory", productCategory);
		w.write("SalesRank", salesRank);
		w.write("YourPricePlusShipping", yourPricePlusShipping);
		w.write("LowestPricePlusShipping", lowestPricePlusShipping);
		w.write("AvailableQuantity", availableQuantity);
		w.write("SalesForTheLast30Days", salesForTheLast30Days);
		w.write("RecommendationId", recommendationId);
		w.write("RecommendationReason", recommendationReason);
	}

	/**
	 * Write tag, xmlns and members to a MwsWriter.
	 *
	 * @param w
	 *            The Writer to write to.
	 */
	@Override
	public void writeTo(MwsWriter w) {
		w.write("https://mws.amazonservices.com/Recommendations/2013-04-01",
				"AdvertisingRecommendation", this);
	}

	/** Value constructor. */
	public AdvertisingRecommendation(XMLGregorianCalendar lastUpdated,
			ProductIdentifier itemIdentifier, String itemName,
			String brandName, String productCategory, Integer salesRank,
			Price yourPricePlusShipping, Price lowestPricePlusShipping,
			Integer availableQuantity, Integer salesForTheLast30Days,
			String recommendationId, String recommendationReason) {
		this.lastUpdated = lastUpdated;
		this.itemIdentifier = itemIdentifier;
		this.itemName = itemName;
		this.brandName = brandName;
		this.productCategory = productCategory;
		this.salesRank = salesRank;
		this.yourPricePlusShipping = yourPricePlusShipping;
		this.lowestPricePlusShipping = lowestPricePlusShipping;
		this.availableQuantity = availableQuantity;
		this.salesForTheLast30Days = salesForTheLast30Days;
		this.recommendationId = recommendationId;
		this.recommendationReason = recommendationReason;
	}

	/** Default constructor. */
	public AdvertisingRecommendation() {
		super();
	}

	public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
		return null;
	}

	public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd) {
	}

}
