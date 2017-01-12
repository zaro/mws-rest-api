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
 * Pricing Recommendation
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
 * PricingRecommendation complex type.
 *
 * XML schema:
 *
 * <pre>
 * &lt;complexType name="PricingRecommendation"&gt;
 *    &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *          &lt;sequence&gt;
 *             &lt;element name="LastUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *             &lt;element name="ItemIdentifier" type="{https://mws.amazonservices.com/Recommendations/2013-04-01}ProductIdentifier"/&gt;
 *             &lt;element name="ItemName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="Condition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="SubCondition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="FulfillmentChannel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="YourPricePlusShipping" type="{https://mws.amazonservices.com/Recommendations/2013-04-01}Price" minOccurs="0"/&gt;
 *             &lt;element name="LowestPricePlusShipping" type="{https://mws.amazonservices.com/Recommendations/2013-04-01}Price" minOccurs="0"/&gt;
 *             &lt;element name="PriceDifferenceToLowPrice" type="{https://mws.amazonservices.com/Recommendations/2013-04-01}Price" minOccurs="0"/&gt;
 *             &lt;element name="MedianPricePlusShipping" type="{https://mws.amazonservices.com/Recommendations/2013-04-01}Price" minOccurs="0"/&gt;
 *             &lt;element name="LowestMerchantFulfilledOfferPrice" type="{https://mws.amazonservices.com/Recommendations/2013-04-01}Price" minOccurs="0"/&gt;
 *             &lt;element name="LowestAmazonFulfilledOfferPrice" type="{https://mws.amazonservices.com/Recommendations/2013-04-01}Price" minOccurs="0"/&gt;
 *             &lt;element name="NumberOfOffers" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *             &lt;element name="NumberOfMerchantFulfilledOffers" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *             &lt;element name="NumberOfAmazonFulfilledOffers" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *             &lt;element name="RecommendationId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *             &lt;element name="RecommendationReason" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *          &lt;/sequence&gt;
 *       &lt;/restriction&gt;
 *    &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class PricingRecommendation extends AmaselMwsObject {

	private XMLGregorianCalendar lastUpdated;

	private ProductIdentifier itemIdentifier;

	private String itemName;

	private String condition;

	private String subCondition;

	private String fulfillmentChannel;

	private Price yourPricePlusShipping;

	private Price lowestPricePlusShipping;

	private Price priceDifferenceToLowPrice;

	private Price medianPricePlusShipping;

	private Price lowestMerchantFulfilledOfferPrice;

	private Price lowestAmazonFulfilledOfferPrice;

	private Integer numberOfOffers;

	private Integer numberOfMerchantFulfilledOffers;

	private Integer numberOfAmazonFulfilledOffers;

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
	public PricingRecommendation withLastUpdated(
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
	public PricingRecommendation withItemIdentifier(
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
	public PricingRecommendation withItemName(String itemName) {
		this.itemName = itemName;
		return this;
	}

	/**
	 * Get the value of Condition.
	 *
	 * @return The value of Condition.
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * Set the value of Condition.
	 *
	 * @param condition
	 *            The new value to set.
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}

	/**
	 * Check to see if Condition is set.
	 *
	 * @return true if Condition is set.
	 */
	public boolean isSetCondition() {
		return condition != null;
	}

	/**
	 * Set the value of Condition, return this.
	 *
	 * @param condition
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public PricingRecommendation withCondition(String condition) {
		this.condition = condition;
		return this;
	}

	/**
	 * Get the value of SubCondition.
	 *
	 * @return The value of SubCondition.
	 */
	public String getSubCondition() {
		return subCondition;
	}

	/**
	 * Set the value of SubCondition.
	 *
	 * @param subCondition
	 *            The new value to set.
	 */
	public void setSubCondition(String subCondition) {
		this.subCondition = subCondition;
	}

	/**
	 * Check to see if SubCondition is set.
	 *
	 * @return true if SubCondition is set.
	 */
	public boolean isSetSubCondition() {
		return subCondition != null;
	}

	/**
	 * Set the value of SubCondition, return this.
	 *
	 * @param subCondition
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public PricingRecommendation withSubCondition(String subCondition) {
		this.subCondition = subCondition;
		return this;
	}

	/**
	 * Get the value of FulfillmentChannel.
	 *
	 * @return The value of FulfillmentChannel.
	 */
	public String getFulfillmentChannel() {
		return fulfillmentChannel;
	}

	/**
	 * Set the value of FulfillmentChannel.
	 *
	 * @param fulfillmentChannel
	 *            The new value to set.
	 */
	public void setFulfillmentChannel(String fulfillmentChannel) {
		this.fulfillmentChannel = fulfillmentChannel;
	}

	/**
	 * Check to see if FulfillmentChannel is set.
	 *
	 * @return true if FulfillmentChannel is set.
	 */
	public boolean isSetFulfillmentChannel() {
		return fulfillmentChannel != null;
	}

	/**
	 * Set the value of FulfillmentChannel, return this.
	 *
	 * @param fulfillmentChannel
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public PricingRecommendation withFulfillmentChannel(
			String fulfillmentChannel) {
		this.fulfillmentChannel = fulfillmentChannel;
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
	public PricingRecommendation withYourPricePlusShipping(
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
	public PricingRecommendation withLowestPricePlusShipping(
			Price lowestPricePlusShipping) {
		this.lowestPricePlusShipping = lowestPricePlusShipping;
		return this;
	}

	/**
	 * Get the value of PriceDifferenceToLowPrice.
	 *
	 * @return The value of PriceDifferenceToLowPrice.
	 */
	public Price getPriceDifferenceToLowPrice() {
		return priceDifferenceToLowPrice;
	}

	/**
	 * Set the value of PriceDifferenceToLowPrice.
	 *
	 * @param priceDifferenceToLowPrice
	 *            The new value to set.
	 */
	public void setPriceDifferenceToLowPrice(Price priceDifferenceToLowPrice) {
		this.priceDifferenceToLowPrice = priceDifferenceToLowPrice;
	}

	/**
	 * Check to see if PriceDifferenceToLowPrice is set.
	 *
	 * @return true if PriceDifferenceToLowPrice is set.
	 */
	public boolean isSetPriceDifferenceToLowPrice() {
		return priceDifferenceToLowPrice != null;
	}

	/**
	 * Set the value of PriceDifferenceToLowPrice, return this.
	 *
	 * @param priceDifferenceToLowPrice
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public PricingRecommendation withPriceDifferenceToLowPrice(
			Price priceDifferenceToLowPrice) {
		this.priceDifferenceToLowPrice = priceDifferenceToLowPrice;
		return this;
	}

	/**
	 * Get the value of MedianPricePlusShipping.
	 *
	 * @return The value of MedianPricePlusShipping.
	 */
	public Price getMedianPricePlusShipping() {
		return medianPricePlusShipping;
	}

	/**
	 * Set the value of MedianPricePlusShipping.
	 *
	 * @param medianPricePlusShipping
	 *            The new value to set.
	 */
	public void setMedianPricePlusShipping(Price medianPricePlusShipping) {
		this.medianPricePlusShipping = medianPricePlusShipping;
	}

	/**
	 * Check to see if MedianPricePlusShipping is set.
	 *
	 * @return true if MedianPricePlusShipping is set.
	 */
	public boolean isSetMedianPricePlusShipping() {
		return medianPricePlusShipping != null;
	}

	/**
	 * Set the value of MedianPricePlusShipping, return this.
	 *
	 * @param medianPricePlusShipping
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public PricingRecommendation withMedianPricePlusShipping(
			Price medianPricePlusShipping) {
		this.medianPricePlusShipping = medianPricePlusShipping;
		return this;
	}

	/**
	 * Get the value of LowestMerchantFulfilledOfferPrice.
	 *
	 * @return The value of LowestMerchantFulfilledOfferPrice.
	 */
	public Price getLowestMerchantFulfilledOfferPrice() {
		return lowestMerchantFulfilledOfferPrice;
	}

	/**
	 * Set the value of LowestMerchantFulfilledOfferPrice.
	 *
	 * @param lowestMerchantFulfilledOfferPrice
	 *            The new value to set.
	 */
	public void setLowestMerchantFulfilledOfferPrice(
			Price lowestMerchantFulfilledOfferPrice) {
		this.lowestMerchantFulfilledOfferPrice = lowestMerchantFulfilledOfferPrice;
	}

	/**
	 * Check to see if LowestMerchantFulfilledOfferPrice is set.
	 *
	 * @return true if LowestMerchantFulfilledOfferPrice is set.
	 */
	public boolean isSetLowestMerchantFulfilledOfferPrice() {
		return lowestMerchantFulfilledOfferPrice != null;
	}

	/**
	 * Set the value of LowestMerchantFulfilledOfferPrice, return this.
	 *
	 * @param lowestMerchantFulfilledOfferPrice
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public PricingRecommendation withLowestMerchantFulfilledOfferPrice(
			Price lowestMerchantFulfilledOfferPrice) {
		this.lowestMerchantFulfilledOfferPrice = lowestMerchantFulfilledOfferPrice;
		return this;
	}

	/**
	 * Get the value of LowestAmazonFulfilledOfferPrice.
	 *
	 * @return The value of LowestAmazonFulfilledOfferPrice.
	 */
	public Price getLowestAmazonFulfilledOfferPrice() {
		return lowestAmazonFulfilledOfferPrice;
	}

	/**
	 * Set the value of LowestAmazonFulfilledOfferPrice.
	 *
	 * @param lowestAmazonFulfilledOfferPrice
	 *            The new value to set.
	 */
	public void setLowestAmazonFulfilledOfferPrice(
			Price lowestAmazonFulfilledOfferPrice) {
		this.lowestAmazonFulfilledOfferPrice = lowestAmazonFulfilledOfferPrice;
	}

	/**
	 * Check to see if LowestAmazonFulfilledOfferPrice is set.
	 *
	 * @return true if LowestAmazonFulfilledOfferPrice is set.
	 */
	public boolean isSetLowestAmazonFulfilledOfferPrice() {
		return lowestAmazonFulfilledOfferPrice != null;
	}

	/**
	 * Set the value of LowestAmazonFulfilledOfferPrice, return this.
	 *
	 * @param lowestAmazonFulfilledOfferPrice
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public PricingRecommendation withLowestAmazonFulfilledOfferPrice(
			Price lowestAmazonFulfilledOfferPrice) {
		this.lowestAmazonFulfilledOfferPrice = lowestAmazonFulfilledOfferPrice;
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
	public PricingRecommendation withNumberOfOffers(Integer numberOfOffers) {
		this.numberOfOffers = numberOfOffers;
		return this;
	}

	/**
	 * Get the value of NumberOfMerchantFulfilledOffers.
	 *
	 * @return The value of NumberOfMerchantFulfilledOffers.
	 */
	public Integer getNumberOfMerchantFulfilledOffers() {
		return numberOfMerchantFulfilledOffers;
	}

	/**
	 * Set the value of NumberOfMerchantFulfilledOffers.
	 *
	 * @param numberOfMerchantFulfilledOffers
	 *            The new value to set.
	 */
	public void setNumberOfMerchantFulfilledOffers(
			Integer numberOfMerchantFulfilledOffers) {
		this.numberOfMerchantFulfilledOffers = numberOfMerchantFulfilledOffers;
	}

	/**
	 * Check to see if NumberOfMerchantFulfilledOffers is set.
	 *
	 * @return true if NumberOfMerchantFulfilledOffers is set.
	 */
	public boolean isSetNumberOfMerchantFulfilledOffers() {
		return numberOfMerchantFulfilledOffers != null;
	}

	/**
	 * Set the value of NumberOfMerchantFulfilledOffers, return this.
	 *
	 * @param numberOfMerchantFulfilledOffers
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public PricingRecommendation withNumberOfMerchantFulfilledOffers(
			Integer numberOfMerchantFulfilledOffers) {
		this.numberOfMerchantFulfilledOffers = numberOfMerchantFulfilledOffers;
		return this;
	}

	/**
	 * Get the value of NumberOfAmazonFulfilledOffers.
	 *
	 * @return The value of NumberOfAmazonFulfilledOffers.
	 */
	public Integer getNumberOfAmazonFulfilledOffers() {
		return numberOfAmazonFulfilledOffers;
	}

	/**
	 * Set the value of NumberOfAmazonFulfilledOffers.
	 *
	 * @param numberOfAmazonFulfilledOffers
	 *            The new value to set.
	 */
	public void setNumberOfAmazonFulfilledOffers(
			Integer numberOfAmazonFulfilledOffers) {
		this.numberOfAmazonFulfilledOffers = numberOfAmazonFulfilledOffers;
	}

	/**
	 * Check to see if NumberOfAmazonFulfilledOffers is set.
	 *
	 * @return true if NumberOfAmazonFulfilledOffers is set.
	 */
	public boolean isSetNumberOfAmazonFulfilledOffers() {
		return numberOfAmazonFulfilledOffers != null;
	}

	/**
	 * Set the value of NumberOfAmazonFulfilledOffers, return this.
	 *
	 * @param numberOfAmazonFulfilledOffers
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public PricingRecommendation withNumberOfAmazonFulfilledOffers(
			Integer numberOfAmazonFulfilledOffers) {
		this.numberOfAmazonFulfilledOffers = numberOfAmazonFulfilledOffers;
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
	public PricingRecommendation withRecommendationId(String recommendationId) {
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
	public PricingRecommendation withRecommendationReason(
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
		condition = r.read("Condition", String.class);
		subCondition = r.read("SubCondition", String.class);
		fulfillmentChannel = r.read("FulfillmentChannel", String.class);
		yourPricePlusShipping = r.read("YourPricePlusShipping", Price.class);
		lowestPricePlusShipping = r
				.read("LowestPricePlusShipping", Price.class);
		priceDifferenceToLowPrice = r.read("PriceDifferenceToLowPrice",
				Price.class);
		medianPricePlusShipping = r
				.read("MedianPricePlusShipping", Price.class);
		lowestMerchantFulfilledOfferPrice = r.read(
				"LowestMerchantFulfilledOfferPrice", Price.class);
		lowestAmazonFulfilledOfferPrice = r.read(
				"LowestAmazonFulfilledOfferPrice", Price.class);
		numberOfOffers = r.read("NumberOfOffers", Integer.class);
		numberOfMerchantFulfilledOffers = r.read(
				"NumberOfMerchantFulfilledOffers", Integer.class);
		numberOfAmazonFulfilledOffers = r.read("NumberOfAmazonFulfilledOffers",
				Integer.class);
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
		w.write("Condition", condition);
		w.write("SubCondition", subCondition);
		w.write("FulfillmentChannel", fulfillmentChannel);
		w.write("YourPricePlusShipping", yourPricePlusShipping);
		w.write("LowestPricePlusShipping", lowestPricePlusShipping);
		w.write("PriceDifferenceToLowPrice", priceDifferenceToLowPrice);
		w.write("MedianPricePlusShipping", medianPricePlusShipping);
		w.write("LowestMerchantFulfilledOfferPrice",
				lowestMerchantFulfilledOfferPrice);
		w.write("LowestAmazonFulfilledOfferPrice",
				lowestAmazonFulfilledOfferPrice);
		w.write("NumberOfOffers", numberOfOffers);
		w.write("NumberOfMerchantFulfilledOffers",
				numberOfMerchantFulfilledOffers);
		w.write("NumberOfAmazonFulfilledOffers", numberOfAmazonFulfilledOffers);
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
				"PricingRecommendation", this);
	}

	/** Value constructor. */
	public PricingRecommendation(XMLGregorianCalendar lastUpdated,
			ProductIdentifier itemIdentifier, String itemName,
			String condition, String subCondition, String fulfillmentChannel,
			Price yourPricePlusShipping, Price lowestPricePlusShipping,
			Price priceDifferenceToLowPrice, Price medianPricePlusShipping,
			Price lowestMerchantFulfilledOfferPrice,
			Price lowestAmazonFulfilledOfferPrice, Integer numberOfOffers,
			Integer numberOfMerchantFulfilledOffers,
			Integer numberOfAmazonFulfilledOffers, String recommendationId,
			String recommendationReason) {
		this.lastUpdated = lastUpdated;
		this.itemIdentifier = itemIdentifier;
		this.itemName = itemName;
		this.condition = condition;
		this.subCondition = subCondition;
		this.fulfillmentChannel = fulfillmentChannel;
		this.yourPricePlusShipping = yourPricePlusShipping;
		this.lowestPricePlusShipping = lowestPricePlusShipping;
		this.priceDifferenceToLowPrice = priceDifferenceToLowPrice;
		this.medianPricePlusShipping = medianPricePlusShipping;
		this.lowestMerchantFulfilledOfferPrice = lowestMerchantFulfilledOfferPrice;
		this.lowestAmazonFulfilledOfferPrice = lowestAmazonFulfilledOfferPrice;
		this.numberOfOffers = numberOfOffers;
		this.numberOfMerchantFulfilledOffers = numberOfMerchantFulfilledOffers;
		this.numberOfAmazonFulfilledOffers = numberOfAmazonFulfilledOffers;
		this.recommendationId = recommendationId;
		this.recommendationReason = recommendationReason;
	}

	/** Default constructor. */
	public PricingRecommendation() {
		super();
	}

	public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
		return null;
	}

	public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd) {
	}

}
