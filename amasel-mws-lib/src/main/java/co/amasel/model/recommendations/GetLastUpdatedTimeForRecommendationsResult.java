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
 * Get Last Updated Time For Recommendations Result
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
 * GetLastUpdatedTimeForRecommendationsResult complex type.
 *
 * XML schema:
 *
 * <pre>
 * &lt;complexType name="GetLastUpdatedTimeForRecommendationsResult"&gt;
 *    &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *          &lt;sequence&gt;
 *             &lt;element name="InventoryRecommendationsLastUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *             &lt;element name="SelectionRecommendationsLastUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *             &lt;element name="FulfillmentRecommendationsLastUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *             &lt;element name="PricingRecommendationsLastUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *             &lt;element name="GlobalSellingRecommendationsLastUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *             &lt;element name="AdvertisingRecommendationsLastUpdated" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *          &lt;/sequence&gt;
 *       &lt;/restriction&gt;
 *    &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class GetLastUpdatedTimeForRecommendationsResult extends AmaselMwsObject {

	private XMLGregorianCalendar inventoryRecommendationsLastUpdated;

	private XMLGregorianCalendar selectionRecommendationsLastUpdated;

	private XMLGregorianCalendar fulfillmentRecommendationsLastUpdated;

	private XMLGregorianCalendar pricingRecommendationsLastUpdated;

	private XMLGregorianCalendar globalSellingRecommendationsLastUpdated;

	private XMLGregorianCalendar advertisingRecommendationsLastUpdated;

	/**
	 * Get the value of InventoryRecommendationsLastUpdated.
	 *
	 * @return The value of InventoryRecommendationsLastUpdated.
	 */
	public XMLGregorianCalendar getInventoryRecommendationsLastUpdated() {
		return inventoryRecommendationsLastUpdated;
	}

	/**
	 * Set the value of InventoryRecommendationsLastUpdated.
	 *
	 * @param inventoryRecommendationsLastUpdated
	 *            The new value to set.
	 */
	public void setInventoryRecommendationsLastUpdated(
			XMLGregorianCalendar inventoryRecommendationsLastUpdated) {
		this.inventoryRecommendationsLastUpdated = inventoryRecommendationsLastUpdated;
	}

	/**
	 * Check to see if InventoryRecommendationsLastUpdated is set.
	 *
	 * @return true if InventoryRecommendationsLastUpdated is set.
	 */
	public boolean isSetInventoryRecommendationsLastUpdated() {
		return inventoryRecommendationsLastUpdated != null;
	}

	/**
	 * Set the value of InventoryRecommendationsLastUpdated, return this.
	 *
	 * @param inventoryRecommendationsLastUpdated
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public GetLastUpdatedTimeForRecommendationsResult withInventoryRecommendationsLastUpdated(
			XMLGregorianCalendar inventoryRecommendationsLastUpdated) {
		this.inventoryRecommendationsLastUpdated = inventoryRecommendationsLastUpdated;
		return this;
	}

	/**
	 * Get the value of SelectionRecommendationsLastUpdated.
	 *
	 * @return The value of SelectionRecommendationsLastUpdated.
	 */
	public XMLGregorianCalendar getSelectionRecommendationsLastUpdated() {
		return selectionRecommendationsLastUpdated;
	}

	/**
	 * Set the value of SelectionRecommendationsLastUpdated.
	 *
	 * @param selectionRecommendationsLastUpdated
	 *            The new value to set.
	 */
	public void setSelectionRecommendationsLastUpdated(
			XMLGregorianCalendar selectionRecommendationsLastUpdated) {
		this.selectionRecommendationsLastUpdated = selectionRecommendationsLastUpdated;
	}

	/**
	 * Check to see if SelectionRecommendationsLastUpdated is set.
	 *
	 * @return true if SelectionRecommendationsLastUpdated is set.
	 */
	public boolean isSetSelectionRecommendationsLastUpdated() {
		return selectionRecommendationsLastUpdated != null;
	}

	/**
	 * Set the value of SelectionRecommendationsLastUpdated, return this.
	 *
	 * @param selectionRecommendationsLastUpdated
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public GetLastUpdatedTimeForRecommendationsResult withSelectionRecommendationsLastUpdated(
			XMLGregorianCalendar selectionRecommendationsLastUpdated) {
		this.selectionRecommendationsLastUpdated = selectionRecommendationsLastUpdated;
		return this;
	}

	/**
	 * Get the value of FulfillmentRecommendationsLastUpdated.
	 *
	 * @return The value of FulfillmentRecommendationsLastUpdated.
	 */
	public XMLGregorianCalendar getFulfillmentRecommendationsLastUpdated() {
		return fulfillmentRecommendationsLastUpdated;
	}

	/**
	 * Set the value of FulfillmentRecommendationsLastUpdated.
	 *
	 * @param fulfillmentRecommendationsLastUpdated
	 *            The new value to set.
	 */
	public void setFulfillmentRecommendationsLastUpdated(
			XMLGregorianCalendar fulfillmentRecommendationsLastUpdated) {
		this.fulfillmentRecommendationsLastUpdated = fulfillmentRecommendationsLastUpdated;
	}

	/**
	 * Check to see if FulfillmentRecommendationsLastUpdated is set.
	 *
	 * @return true if FulfillmentRecommendationsLastUpdated is set.
	 */
	public boolean isSetFulfillmentRecommendationsLastUpdated() {
		return fulfillmentRecommendationsLastUpdated != null;
	}

	/**
	 * Set the value of FulfillmentRecommendationsLastUpdated, return this.
	 *
	 * @param fulfillmentRecommendationsLastUpdated
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public GetLastUpdatedTimeForRecommendationsResult withFulfillmentRecommendationsLastUpdated(
			XMLGregorianCalendar fulfillmentRecommendationsLastUpdated) {
		this.fulfillmentRecommendationsLastUpdated = fulfillmentRecommendationsLastUpdated;
		return this;
	}

	/**
	 * Get the value of PricingRecommendationsLastUpdated.
	 *
	 * @return The value of PricingRecommendationsLastUpdated.
	 */
	public XMLGregorianCalendar getPricingRecommendationsLastUpdated() {
		return pricingRecommendationsLastUpdated;
	}

	/**
	 * Set the value of PricingRecommendationsLastUpdated.
	 *
	 * @param pricingRecommendationsLastUpdated
	 *            The new value to set.
	 */
	public void setPricingRecommendationsLastUpdated(
			XMLGregorianCalendar pricingRecommendationsLastUpdated) {
		this.pricingRecommendationsLastUpdated = pricingRecommendationsLastUpdated;
	}

	/**
	 * Check to see if PricingRecommendationsLastUpdated is set.
	 *
	 * @return true if PricingRecommendationsLastUpdated is set.
	 */
	public boolean isSetPricingRecommendationsLastUpdated() {
		return pricingRecommendationsLastUpdated != null;
	}

	/**
	 * Set the value of PricingRecommendationsLastUpdated, return this.
	 *
	 * @param pricingRecommendationsLastUpdated
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public GetLastUpdatedTimeForRecommendationsResult withPricingRecommendationsLastUpdated(
			XMLGregorianCalendar pricingRecommendationsLastUpdated) {
		this.pricingRecommendationsLastUpdated = pricingRecommendationsLastUpdated;
		return this;
	}

	/**
	 * Get the value of GlobalSellingRecommendationsLastUpdated.
	 *
	 * @return The value of GlobalSellingRecommendationsLastUpdated.
	 */
	public XMLGregorianCalendar getGlobalSellingRecommendationsLastUpdated() {
		return globalSellingRecommendationsLastUpdated;
	}

	/**
	 * Set the value of GlobalSellingRecommendationsLastUpdated.
	 *
	 * @param globalSellingRecommendationsLastUpdated
	 *            The new value to set.
	 */
	public void setGlobalSellingRecommendationsLastUpdated(
			XMLGregorianCalendar globalSellingRecommendationsLastUpdated) {
		this.globalSellingRecommendationsLastUpdated = globalSellingRecommendationsLastUpdated;
	}

	/**
	 * Check to see if GlobalSellingRecommendationsLastUpdated is set.
	 *
	 * @return true if GlobalSellingRecommendationsLastUpdated is set.
	 */
	public boolean isSetGlobalSellingRecommendationsLastUpdated() {
		return globalSellingRecommendationsLastUpdated != null;
	}

	/**
	 * Set the value of GlobalSellingRecommendationsLastUpdated, return this.
	 *
	 * @param globalSellingRecommendationsLastUpdated
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public GetLastUpdatedTimeForRecommendationsResult withGlobalSellingRecommendationsLastUpdated(
			XMLGregorianCalendar globalSellingRecommendationsLastUpdated) {
		this.globalSellingRecommendationsLastUpdated = globalSellingRecommendationsLastUpdated;
		return this;
	}

	/**
	 * Get the value of AdvertisingRecommendationsLastUpdated.
	 *
	 * @return The value of AdvertisingRecommendationsLastUpdated.
	 */
	public XMLGregorianCalendar getAdvertisingRecommendationsLastUpdated() {
		return advertisingRecommendationsLastUpdated;
	}

	/**
	 * Set the value of AdvertisingRecommendationsLastUpdated.
	 *
	 * @param advertisingRecommendationsLastUpdated
	 *            The new value to set.
	 */
	public void setAdvertisingRecommendationsLastUpdated(
			XMLGregorianCalendar advertisingRecommendationsLastUpdated) {
		this.advertisingRecommendationsLastUpdated = advertisingRecommendationsLastUpdated;
	}

	/**
	 * Check to see if AdvertisingRecommendationsLastUpdated is set.
	 *
	 * @return true if AdvertisingRecommendationsLastUpdated is set.
	 */
	public boolean isSetAdvertisingRecommendationsLastUpdated() {
		return advertisingRecommendationsLastUpdated != null;
	}

	/**
	 * Set the value of AdvertisingRecommendationsLastUpdated, return this.
	 *
	 * @param advertisingRecommendationsLastUpdated
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public GetLastUpdatedTimeForRecommendationsResult withAdvertisingRecommendationsLastUpdated(
			XMLGregorianCalendar advertisingRecommendationsLastUpdated) {
		this.advertisingRecommendationsLastUpdated = advertisingRecommendationsLastUpdated;
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
		inventoryRecommendationsLastUpdated = r.read(
				"InventoryRecommendationsLastUpdated",
				XMLGregorianCalendar.class);
		selectionRecommendationsLastUpdated = r.read(
				"SelectionRecommendationsLastUpdated",
				XMLGregorianCalendar.class);
		fulfillmentRecommendationsLastUpdated = r.read(
				"FulfillmentRecommendationsLastUpdated",
				XMLGregorianCalendar.class);
		pricingRecommendationsLastUpdated = r
				.read("PricingRecommendationsLastUpdated",
						XMLGregorianCalendar.class);
		globalSellingRecommendationsLastUpdated = r.read(
				"GlobalSellingRecommendationsLastUpdated",
				XMLGregorianCalendar.class);
		advertisingRecommendationsLastUpdated = r.read(
				"AdvertisingRecommendationsLastUpdated",
				XMLGregorianCalendar.class);
	}

	/**
	 * Write members to a MwsWriter.
	 *
	 * @param w
	 *            The writer to write to.
	 */
	@Override
	public void writeFragmentTo(MwsWriter w) {
		w.write("InventoryRecommendationsLastUpdated",
				inventoryRecommendationsLastUpdated);
		w.write("SelectionRecommendationsLastUpdated",
				selectionRecommendationsLastUpdated);
		w.write("FulfillmentRecommendationsLastUpdated",
				fulfillmentRecommendationsLastUpdated);
		w.write("PricingRecommendationsLastUpdated",
				pricingRecommendationsLastUpdated);
		w.write("GlobalSellingRecommendationsLastUpdated",
				globalSellingRecommendationsLastUpdated);
		w.write("AdvertisingRecommendationsLastUpdated",
				advertisingRecommendationsLastUpdated);
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
				"GetLastUpdatedTimeForRecommendationsResult", this);
	}

	/** Value constructor. */
	public GetLastUpdatedTimeForRecommendationsResult(
			XMLGregorianCalendar inventoryRecommendationsLastUpdated,
			XMLGregorianCalendar selectionRecommendationsLastUpdated,
			XMLGregorianCalendar fulfillmentRecommendationsLastUpdated,
			XMLGregorianCalendar pricingRecommendationsLastUpdated,
			XMLGregorianCalendar globalSellingRecommendationsLastUpdated,
			XMLGregorianCalendar advertisingRecommendationsLastUpdated) {
		this.inventoryRecommendationsLastUpdated = inventoryRecommendationsLastUpdated;
		this.selectionRecommendationsLastUpdated = selectionRecommendationsLastUpdated;
		this.fulfillmentRecommendationsLastUpdated = fulfillmentRecommendationsLastUpdated;
		this.pricingRecommendationsLastUpdated = pricingRecommendationsLastUpdated;
		this.globalSellingRecommendationsLastUpdated = globalSellingRecommendationsLastUpdated;
		this.advertisingRecommendationsLastUpdated = advertisingRecommendationsLastUpdated;
	}

	/** Default constructor. */
	public GetLastUpdatedTimeForRecommendationsResult() {
		super();
	}

	public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
		return null;
	}

	public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd) {
	}

}
