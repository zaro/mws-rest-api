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
 * Fulfillment Recommendation
 * API Version: 2013-04-01
 * Library Version: 2014-10-01
 * Generated: Fri Oct 10 17:55:39 GMT 2014
 */
package co.amasel.model.recommendations;

import java.math.BigDecimal;

import javax.xml.datatype.XMLGregorianCalendar;

import com.amazonservices.mws.client.*;
import co.amasel.model.common.AmaselMwsObject;
import co.amasel.model.common.ResponseHeaderMetadata;
import co.amasel.model.common.ResponseMetadata;
import com.amazonservices.mws.client.MwsReader;
import com.amazonservices.mws.client.MwsWriter;
import com.amazonservices.mws.client.MwsResponseHeaderMetadata;

/**
 * FulfillmentRecommendation complex type.
 *
 * XML schema:
 *
 * <pre>
 * &lt;complexType name="FulfillmentRecommendation"&gt;
 *    &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *          &lt;sequence&gt;
 *             &lt;element name="LastUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *             &lt;element name="ItemIdentifier" type="{https://mws.amazonservices.com/Recommendations/2013-04-01}ProductIdentifier"/&gt;
 *             &lt;element name="ItemName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="BrandName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="ProductCategory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="SalesRank" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *             &lt;element name="BuyboxPrice" type="{https://mws.amazonservices.com/Recommendations/2013-04-01}Price" minOccurs="0"/&gt;
 *             &lt;element name="NumberOfOffers" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *             &lt;element name="NumberOfOffersFulfilledByAmazon" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *             &lt;element name="AverageCustomerReview" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *             &lt;element name="NumberOfCustomerReviews" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *             &lt;element name="ItemDimensions" type="{https://mws.amazonservices.com/Recommendations/2013-04-01}ItemDimensions" minOccurs="0"/&gt;
 *             &lt;element name="RecommendationId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *             &lt;element name="RecommendationReason" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *          &lt;/sequence&gt;
 *       &lt;/restriction&gt;
 *    &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class FulfillmentRecommendation extends AmaselMwsObject {

	private XMLGregorianCalendar lastUpdated;

	private ProductIdentifier itemIdentifier;

	private String itemName;

	private String brandName;

	private String productCategory;

	private Integer salesRank;

	private Price buyboxPrice;

	private Integer numberOfOffers;

	private Integer numberOfOffersFulfilledByAmazon;

	private BigDecimal averageCustomerReview;

	private Integer numberOfCustomerReviews;

	private ItemDimensions itemDimensions;

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
	public FulfillmentRecommendation withLastUpdated(
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
	public FulfillmentRecommendation withItemIdentifier(
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
	public FulfillmentRecommendation withItemName(String itemName) {
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
	public FulfillmentRecommendation withBrandName(String brandName) {
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
	public FulfillmentRecommendation withProductCategory(String productCategory) {
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
	public FulfillmentRecommendation withSalesRank(Integer salesRank) {
		this.salesRank = salesRank;
		return this;
	}

	/**
	 * Get the value of BuyboxPrice.
	 *
	 * @return The value of BuyboxPrice.
	 */
	public Price getBuyboxPrice() {
		return buyboxPrice;
	}

	/**
	 * Set the value of BuyboxPrice.
	 *
	 * @param buyboxPrice
	 *            The new value to set.
	 */
	public void setBuyboxPrice(Price buyboxPrice) {
		this.buyboxPrice = buyboxPrice;
	}

	/**
	 * Check to see if BuyboxPrice is set.
	 *
	 * @return true if BuyboxPrice is set.
	 */
	public boolean isSetBuyboxPrice() {
		return buyboxPrice != null;
	}

	/**
	 * Set the value of BuyboxPrice, return this.
	 *
	 * @param buyboxPrice
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public FulfillmentRecommendation withBuyboxPrice(Price buyboxPrice) {
		this.buyboxPrice = buyboxPrice;
		return this;
	}

	/**
	 * Get the value of NumberOfOffers.
	 *
	 * @return The value of NumberOfOffers.
	 */
	public Integer getNumberOfOffers() {
		return numberOfOffers;
	}

	/**
	 * Set the value of NumberOfOffers.
	 *
	 * @param numberOfOffers
	 *            The new value to set.
	 */
	public void setNumberOfOffers(Integer numberOfOffers) {
		this.numberOfOffers = numberOfOffers;
	}

	/**
	 * Check to see if NumberOfOffers is set.
	 *
	 * @return true if NumberOfOffers is set.
	 */
	public boolean isSetNumberOfOffers() {
		return numberOfOffers != null;
	}

	/**
	 * Set the value of NumberOfOffers, return this.
	 *
	 * @param numberOfOffers
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public FulfillmentRecommendation withNumberOfOffers(Integer numberOfOffers) {
		this.numberOfOffers = numberOfOffers;
		return this;
	}

	/**
	 * Get the value of NumberOfOffersFulfilledByAmazon.
	 *
	 * @return The value of NumberOfOffersFulfilledByAmazon.
	 */
	public Integer getNumberOfOffersFulfilledByAmazon() {
		return numberOfOffersFulfilledByAmazon;
	}

	/**
	 * Set the value of NumberOfOffersFulfilledByAmazon.
	 *
	 * @param numberOfOffersFulfilledByAmazon
	 *            The new value to set.
	 */
	public void setNumberOfOffersFulfilledByAmazon(
			Integer numberOfOffersFulfilledByAmazon) {
		this.numberOfOffersFulfilledByAmazon = numberOfOffersFulfilledByAmazon;
	}

	/**
	 * Check to see if NumberOfOffersFulfilledByAmazon is set.
	 *
	 * @return true if NumberOfOffersFulfilledByAmazon is set.
	 */
	public boolean isSetNumberOfOffersFulfilledByAmazon() {
		return numberOfOffersFulfilledByAmazon != null;
	}

	/**
	 * Set the value of NumberOfOffersFulfilledByAmazon, return this.
	 *
	 * @param numberOfOffersFulfilledByAmazon
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public FulfillmentRecommendation withNumberOfOffersFulfilledByAmazon(
			Integer numberOfOffersFulfilledByAmazon) {
		this.numberOfOffersFulfilledByAmazon = numberOfOffersFulfilledByAmazon;
		return this;
	}

	/**
	 * Get the value of AverageCustomerReview.
	 *
	 * @return The value of AverageCustomerReview.
	 */
	public BigDecimal getAverageCustomerReview() {
		return averageCustomerReview;
	}

	/**
	 * Set the value of AverageCustomerReview.
	 *
	 * @param averageCustomerReview
	 *            The new value to set.
	 */
	public void setAverageCustomerReview(BigDecimal averageCustomerReview) {
		this.averageCustomerReview = averageCustomerReview;
	}

	/**
	 * Check to see if AverageCustomerReview is set.
	 *
	 * @return true if AverageCustomerReview is set.
	 */
	public boolean isSetAverageCustomerReview() {
		return averageCustomerReview != null;
	}

	/**
	 * Set the value of AverageCustomerReview, return this.
	 *
	 * @param averageCustomerReview
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public FulfillmentRecommendation withAverageCustomerReview(
			BigDecimal averageCustomerReview) {
		this.averageCustomerReview = averageCustomerReview;
		return this;
	}

	/**
	 * Get the value of NumberOfCustomerReviews.
	 *
	 * @return The value of NumberOfCustomerReviews.
	 */
	public Integer getNumberOfCustomerReviews() {
		return numberOfCustomerReviews;
	}

	/**
	 * Set the value of NumberOfCustomerReviews.
	 *
	 * @param numberOfCustomerReviews
	 *            The new value to set.
	 */
	public void setNumberOfCustomerReviews(Integer numberOfCustomerReviews) {
		this.numberOfCustomerReviews = numberOfCustomerReviews;
	}

	/**
	 * Check to see if NumberOfCustomerReviews is set.
	 *
	 * @return true if NumberOfCustomerReviews is set.
	 */
	public boolean isSetNumberOfCustomerReviews() {
		return numberOfCustomerReviews != null;
	}

	/**
	 * Set the value of NumberOfCustomerReviews, return this.
	 *
	 * @param numberOfCustomerReviews
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public FulfillmentRecommendation withNumberOfCustomerReviews(
			Integer numberOfCustomerReviews) {
		this.numberOfCustomerReviews = numberOfCustomerReviews;
		return this;
	}

	/**
	 * Get the value of ItemDimensions.
	 *
	 * @return The value of ItemDimensions.
	 */
	public ItemDimensions getItemDimensions() {
		return itemDimensions;
	}

	/**
	 * Set the value of ItemDimensions.
	 *
	 * @param itemDimensions
	 *            The new value to set.
	 */
	public void setItemDimensions(ItemDimensions itemDimensions) {
		this.itemDimensions = itemDimensions;
	}

	/**
	 * Check to see if ItemDimensions is set.
	 *
	 * @return true if ItemDimensions is set.
	 */
	public boolean isSetItemDimensions() {
		return itemDimensions != null;
	}

	/**
	 * Set the value of ItemDimensions, return this.
	 *
	 * @param itemDimensions
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public FulfillmentRecommendation withItemDimensions(
			ItemDimensions itemDimensions) {
		this.itemDimensions = itemDimensions;
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
	public FulfillmentRecommendation withRecommendationId(
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
	public FulfillmentRecommendation withRecommendationReason(
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
		buyboxPrice = r.read("BuyboxPrice", Price.class);
		numberOfOffers = r.read("NumberOfOffers", Integer.class);
		numberOfOffersFulfilledByAmazon = r.read(
				"NumberOfOffersFulfilledByAmazon", Integer.class);
		averageCustomerReview = r.read("AverageCustomerReview",
				BigDecimal.class);
		numberOfCustomerReviews = r.read("NumberOfCustomerReviews",
				Integer.class);
		itemDimensions = r.read("ItemDimensions", ItemDimensions.class);
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
		w.write("BuyboxPrice", buyboxPrice);
		w.write("NumberOfOffers", numberOfOffers);
		w.write("NumberOfOffersFulfilledByAmazon",
				numberOfOffersFulfilledByAmazon);
		w.write("AverageCustomerReview", averageCustomerReview);
		w.write("NumberOfCustomerReviews", numberOfCustomerReviews);
		w.write("ItemDimensions", itemDimensions);
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
				"FulfillmentRecommendation", this);
	}

	/** Value constructor. */
	public FulfillmentRecommendation(XMLGregorianCalendar lastUpdated,
			ProductIdentifier itemIdentifier, String itemName,
			String brandName, String productCategory, Integer salesRank,
			Price buyboxPrice, Integer numberOfOffers,
			Integer numberOfOffersFulfilledByAmazon,
			BigDecimal averageCustomerReview, Integer numberOfCustomerReviews,
			ItemDimensions itemDimensions, String recommendationId,
			String recommendationReason) {
		this.lastUpdated = lastUpdated;
		this.itemIdentifier = itemIdentifier;
		this.itemName = itemName;
		this.brandName = brandName;
		this.productCategory = productCategory;
		this.salesRank = salesRank;
		this.buyboxPrice = buyboxPrice;
		this.numberOfOffers = numberOfOffers;
		this.numberOfOffersFulfilledByAmazon = numberOfOffersFulfilledByAmazon;
		this.averageCustomerReview = averageCustomerReview;
		this.numberOfCustomerReviews = numberOfCustomerReviews;
		this.itemDimensions = itemDimensions;
		this.recommendationId = recommendationId;
		this.recommendationReason = recommendationReason;
	}

	/** Default constructor. */
	public FulfillmentRecommendation() {
		super();
	}

	public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
		return null;
	}

	public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd) {
	}

}
