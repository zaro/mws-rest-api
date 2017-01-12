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
 * Inventory Recommendation
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
 * InventoryRecommendation complex type.
 *
 * XML schema:
 *
 * <pre>
 * &lt;complexType name="InventoryRecommendation"&gt;
 *    &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *          &lt;sequence&gt;
 *             &lt;element name="LastUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *             &lt;element name="ItemIdentifier" type="{https://mws.amazonservices.com/Recommendations/2013-04-01}ProductIdentifier"/&gt;
 *             &lt;element name="ItemName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="FulfillmentChannel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="SalesForTheLast14Days" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *             &lt;element name="SalesForTheLast30Days" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *             &lt;element name="AvailableQuantity" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *             &lt;element name="DaysUntilStockRunsOut" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *             &lt;element name="InboundQuantity" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *             &lt;element name="RecommendedInboundQuantity" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *             &lt;element name="DaysOutOfStockLast30Days" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *             &lt;element name="LostSalesInLast30Days" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *             &lt;element name="RecommendationId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *             &lt;element name="RecommendationReason" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *          &lt;/sequence&gt;
 *       &lt;/restriction&gt;
 *    &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class InventoryRecommendation extends AmaselMwsObject {

	private XMLGregorianCalendar lastUpdated;

	private ProductIdentifier itemIdentifier;

	private String itemName;

	private String fulfillmentChannel;

	private Integer salesForTheLast14Days;

	private Integer salesForTheLast30Days;

	private Integer availableQuantity;

	private Integer daysUntilStockRunsOut;

	private Integer inboundQuantity;

	private Integer recommendedInboundQuantity;

	private Integer daysOutOfStockLast30Days;

	private Integer lostSalesInLast30Days;

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
	public InventoryRecommendation withLastUpdated(
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
	public InventoryRecommendation withItemIdentifier(
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
	public InventoryRecommendation withItemName(String itemName) {
		this.itemName = itemName;
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
	public InventoryRecommendation withFulfillmentChannel(
			String fulfillmentChannel) {
		this.fulfillmentChannel = fulfillmentChannel;
		return this;
	}

	/**
	 * Get the value of SalesForTheLast14Days.
	 *
	 * @return The value of SalesForTheLast14Days.
	 */
	public Integer getSalesForTheLast14Days() {
		return salesForTheLast14Days;
	}

	/**
	 * Set the value of SalesForTheLast14Days.
	 *
	 * @param salesForTheLast14Days
	 *            The new value to set.
	 */
	public void setSalesForTheLast14Days(Integer salesForTheLast14Days) {
		this.salesForTheLast14Days = salesForTheLast14Days;
	}

	/**
	 * Check to see if SalesForTheLast14Days is set.
	 *
	 * @return true if SalesForTheLast14Days is set.
	 */
	public boolean isSetSalesForTheLast14Days() {
		return salesForTheLast14Days != null;
	}

	/**
	 * Set the value of SalesForTheLast14Days, return this.
	 *
	 * @param salesForTheLast14Days
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public InventoryRecommendation withSalesForTheLast14Days(
			Integer salesForTheLast14Days) {
		this.salesForTheLast14Days = salesForTheLast14Days;
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
	public InventoryRecommendation withSalesForTheLast30Days(
			Integer salesForTheLast30Days) {
		this.salesForTheLast30Days = salesForTheLast30Days;
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
	public InventoryRecommendation withAvailableQuantity(
			Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
		return this;
	}

	/**
	 * Get the value of DaysUntilStockRunsOut.
	 *
	 * @return The value of DaysUntilStockRunsOut.
	 */
	public Integer getDaysUntilStockRunsOut() {
		return daysUntilStockRunsOut;
	}

	/**
	 * Set the value of DaysUntilStockRunsOut.
	 *
	 * @param daysUntilStockRunsOut
	 *            The new value to set.
	 */
	public void setDaysUntilStockRunsOut(Integer daysUntilStockRunsOut) {
		this.daysUntilStockRunsOut = daysUntilStockRunsOut;
	}

	/**
	 * Check to see if DaysUntilStockRunsOut is set.
	 *
	 * @return true if DaysUntilStockRunsOut is set.
	 */
	public boolean isSetDaysUntilStockRunsOut() {
		return daysUntilStockRunsOut != null;
	}

	/**
	 * Set the value of DaysUntilStockRunsOut, return this.
	 *
	 * @param daysUntilStockRunsOut
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public InventoryRecommendation withDaysUntilStockRunsOut(
			Integer daysUntilStockRunsOut) {
		this.daysUntilStockRunsOut = daysUntilStockRunsOut;
		return this;
	}

	/**
	 * Get the value of InboundQuantity.
	 *
	 * @return The value of InboundQuantity.
	 */
	public Integer getInboundQuantity() {
		return inboundQuantity;
	}

	/**
	 * Set the value of InboundQuantity.
	 *
	 * @param inboundQuantity
	 *            The new value to set.
	 */
	public void setInboundQuantity(Integer inboundQuantity) {
		this.inboundQuantity = inboundQuantity;
	}

	/**
	 * Check to see if InboundQuantity is set.
	 *
	 * @return true if InboundQuantity is set.
	 */
	public boolean isSetInboundQuantity() {
		return inboundQuantity != null;
	}

	/**
	 * Set the value of InboundQuantity, return this.
	 *
	 * @param inboundQuantity
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public InventoryRecommendation withInboundQuantity(Integer inboundQuantity) {
		this.inboundQuantity = inboundQuantity;
		return this;
	}

	/**
	 * Get the value of RecommendedInboundQuantity.
	 *
	 * @return The value of RecommendedInboundQuantity.
	 */
	public Integer getRecommendedInboundQuantity() {
		return recommendedInboundQuantity;
	}

	/**
	 * Set the value of RecommendedInboundQuantity.
	 *
	 * @param recommendedInboundQuantity
	 *            The new value to set.
	 */
	public void setRecommendedInboundQuantity(Integer recommendedInboundQuantity) {
		this.recommendedInboundQuantity = recommendedInboundQuantity;
	}

	/**
	 * Check to see if RecommendedInboundQuantity is set.
	 *
	 * @return true if RecommendedInboundQuantity is set.
	 */
	public boolean isSetRecommendedInboundQuantity() {
		return recommendedInboundQuantity != null;
	}

	/**
	 * Set the value of RecommendedInboundQuantity, return this.
	 *
	 * @param recommendedInboundQuantity
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public InventoryRecommendation withRecommendedInboundQuantity(
			Integer recommendedInboundQuantity) {
		this.recommendedInboundQuantity = recommendedInboundQuantity;
		return this;
	}

	/**
	 * Get the value of DaysOutOfStockLast30Days.
	 *
	 * @return The value of DaysOutOfStockLast30Days.
	 */
	public Integer getDaysOutOfStockLast30Days() {
		return daysOutOfStockLast30Days;
	}

	/**
	 * Set the value of DaysOutOfStockLast30Days.
	 *
	 * @param daysOutOfStockLast30Days
	 *            The new value to set.
	 */
	public void setDaysOutOfStockLast30Days(Integer daysOutOfStockLast30Days) {
		this.daysOutOfStockLast30Days = daysOutOfStockLast30Days;
	}

	/**
	 * Check to see if DaysOutOfStockLast30Days is set.
	 *
	 * @return true if DaysOutOfStockLast30Days is set.
	 */
	public boolean isSetDaysOutOfStockLast30Days() {
		return daysOutOfStockLast30Days != null;
	}

	/**
	 * Set the value of DaysOutOfStockLast30Days, return this.
	 *
	 * @param daysOutOfStockLast30Days
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public InventoryRecommendation withDaysOutOfStockLast30Days(
			Integer daysOutOfStockLast30Days) {
		this.daysOutOfStockLast30Days = daysOutOfStockLast30Days;
		return this;
	}

	/**
	 * Get the value of LostSalesInLast30Days.
	 *
	 * @return The value of LostSalesInLast30Days.
	 */
	public Integer getLostSalesInLast30Days() {
		return lostSalesInLast30Days;
	}

	/**
	 * Set the value of LostSalesInLast30Days.
	 *
	 * @param lostSalesInLast30Days
	 *            The new value to set.
	 */
	public void setLostSalesInLast30Days(Integer lostSalesInLast30Days) {
		this.lostSalesInLast30Days = lostSalesInLast30Days;
	}

	/**
	 * Check to see if LostSalesInLast30Days is set.
	 *
	 * @return true if LostSalesInLast30Days is set.
	 */
	public boolean isSetLostSalesInLast30Days() {
		return lostSalesInLast30Days != null;
	}

	/**
	 * Set the value of LostSalesInLast30Days, return this.
	 *
	 * @param lostSalesInLast30Days
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public InventoryRecommendation withLostSalesInLast30Days(
			Integer lostSalesInLast30Days) {
		this.lostSalesInLast30Days = lostSalesInLast30Days;
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
	public InventoryRecommendation withRecommendationId(String recommendationId) {
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
	public InventoryRecommendation withRecommendationReason(
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
		fulfillmentChannel = r.read("FulfillmentChannel", String.class);
		salesForTheLast14Days = r.read("SalesForTheLast14Days", Integer.class);
		salesForTheLast30Days = r.read("SalesForTheLast30Days", Integer.class);
		availableQuantity = r.read("AvailableQuantity", Integer.class);
		daysUntilStockRunsOut = r.read("DaysUntilStockRunsOut", Integer.class);
		inboundQuantity = r.read("InboundQuantity", Integer.class);
		recommendedInboundQuantity = r.read("RecommendedInboundQuantity",
				Integer.class);
		daysOutOfStockLast30Days = r.read("DaysOutOfStockLast30Days",
				Integer.class);
		lostSalesInLast30Days = r.read("LostSalesInLast30Days", Integer.class);
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
		w.write("FulfillmentChannel", fulfillmentChannel);
		w.write("SalesForTheLast14Days", salesForTheLast14Days);
		w.write("SalesForTheLast30Days", salesForTheLast30Days);
		w.write("AvailableQuantity", availableQuantity);
		w.write("DaysUntilStockRunsOut", daysUntilStockRunsOut);
		w.write("InboundQuantity", inboundQuantity);
		w.write("RecommendedInboundQuantity", recommendedInboundQuantity);
		w.write("DaysOutOfStockLast30Days", daysOutOfStockLast30Days);
		w.write("LostSalesInLast30Days", lostSalesInLast30Days);
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
				"InventoryRecommendation", this);
	}

	/** Value constructor. */
	public InventoryRecommendation(XMLGregorianCalendar lastUpdated,
			ProductIdentifier itemIdentifier, String itemName,
			String fulfillmentChannel, Integer salesForTheLast14Days,
			Integer salesForTheLast30Days, Integer availableQuantity,
			Integer daysUntilStockRunsOut, Integer inboundQuantity,
			Integer recommendedInboundQuantity,
			Integer daysOutOfStockLast30Days, Integer lostSalesInLast30Days,
			String recommendationId, String recommendationReason) {
		this.lastUpdated = lastUpdated;
		this.itemIdentifier = itemIdentifier;
		this.itemName = itemName;
		this.fulfillmentChannel = fulfillmentChannel;
		this.salesForTheLast14Days = salesForTheLast14Days;
		this.salesForTheLast30Days = salesForTheLast30Days;
		this.availableQuantity = availableQuantity;
		this.daysUntilStockRunsOut = daysUntilStockRunsOut;
		this.inboundQuantity = inboundQuantity;
		this.recommendedInboundQuantity = recommendedInboundQuantity;
		this.daysOutOfStockLast30Days = daysOutOfStockLast30Days;
		this.lostSalesInLast30Days = lostSalesInLast30Days;
		this.recommendationId = recommendationId;
		this.recommendationReason = recommendationReason;
	}

	/** Default constructor. */
	public InventoryRecommendation() {
		super();
	}

	public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
		return null;
	}

	public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd) {
	}

}
