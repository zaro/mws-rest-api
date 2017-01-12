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
 * List Recommendations By Next Token Result
 * API Version: 2013-04-01
 * Library Version: 2014-10-01
 * Generated: Fri Oct 10 17:55:39 GMT 2014
 */
package co.amasel.model.recommendations;

import java.util.List;
import java.util.ArrayList;

import com.amazonservices.mws.client.*;
import co.amasel.model.common.AmaselMwsObject;
import co.amasel.model.common.ResponseHeaderMetadata;
import co.amasel.model.common.ResponseMetadata;
import com.amazonservices.mws.client.MwsReader;
import com.amazonservices.mws.client.MwsWriter;
import com.amazonservices.mws.client.MwsResponseHeaderMetadata;

/**
 * ListRecommendationsByNextTokenResult complex type.
 *
 * XML schema:
 *
 * <pre>
 * &lt;complexType name="ListRecommendationsByNextTokenResult"&gt;
 *    &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *          &lt;sequence&gt;
 *             &lt;element name="InventoryRecommendations" type="{https://mws.amazonservices.com/Recommendations/2013-04-01}InventoryRecommendation" maxOccurs="unbounded"/&gt;
 *             &lt;element name="SelectionRecommendations" type="{https://mws.amazonservices.com/Recommendations/2013-04-01}SelectionRecommendation" maxOccurs="unbounded"/&gt;
 *             &lt;element name="PricingRecommendations" type="{https://mws.amazonservices.com/Recommendations/2013-04-01}PricingRecommendation" maxOccurs="unbounded"/&gt;
 *             &lt;element name="FulfillmentRecommendations" type="{https://mws.amazonservices.com/Recommendations/2013-04-01}FulfillmentRecommendation" maxOccurs="unbounded"/&gt;
 *             &lt;element name="ListingQualityRecommendations" type="{https://mws.amazonservices.com/Recommendations/2013-04-01}ListingQualityRecommendation" maxOccurs="unbounded"/&gt;
 *             &lt;element name="GlobalSellingRecommendations" type="{https://mws.amazonservices.com/Recommendations/2013-04-01}GlobalSellingRecommendation" maxOccurs="unbounded"/&gt;
 *             &lt;element name="AdvertisingRecommendations" type="{https://mws.amazonservices.com/Recommendations/2013-04-01}AdvertisingRecommendation" maxOccurs="unbounded"/&gt;
 *             &lt;element name="NextToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *          &lt;/sequence&gt;
 *       &lt;/restriction&gt;
 *    &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class ListRecommendationsByNextTokenResult extends AmaselMwsObject {

	private List<InventoryRecommendation> inventoryRecommendations;

	private List<SelectionRecommendation> selectionRecommendations;

	private List<PricingRecommendation> pricingRecommendations;

	private List<FulfillmentRecommendation> fulfillmentRecommendations;

	private List<ListingQualityRecommendation> listingQualityRecommendations;

	private List<GlobalSellingRecommendation> globalSellingRecommendations;

	private List<AdvertisingRecommendation> advertisingRecommendations;

	private String nextToken;

	/**
	 * Get the value of InventoryRecommendations.
	 *
	 * @return The value of InventoryRecommendations.
	 */
	public List<InventoryRecommendation> getInventoryRecommendations() {
		if (inventoryRecommendations == null) {
			inventoryRecommendations = new ArrayList<InventoryRecommendation>();
		}
		return inventoryRecommendations;
	}

	/**
	 * Set the value of InventoryRecommendations.
	 *
	 * @param inventoryRecommendations
	 *            The new value to set.
	 */
	public void setInventoryRecommendations(
			List<InventoryRecommendation> inventoryRecommendations) {
		this.inventoryRecommendations = inventoryRecommendations;
	}

	/**
	 * Clear InventoryRecommendations.
	 */
	public void unsetInventoryRecommendations() {
		this.inventoryRecommendations = null;
	}

	/**
	 * Check to see if InventoryRecommendations is set.
	 *
	 * @return true if InventoryRecommendations is set.
	 */
	public boolean isSetInventoryRecommendations() {
		return inventoryRecommendations != null
				&& !inventoryRecommendations.isEmpty();
	}

	/**
	 * Add values for InventoryRecommendations, return this.
	 *
	 * @param inventoryRecommendations
	 *            New values to add.
	 *
	 * @return This instance.
	 */
	public ListRecommendationsByNextTokenResult withInventoryRecommendations(
			InventoryRecommendation... values) {
		List<InventoryRecommendation> list = getInventoryRecommendations();
		for (InventoryRecommendation value : values) {
			list.add(value);
		}
		return this;
	}

	/**
	 * Get the value of SelectionRecommendations.
	 *
	 * @return The value of SelectionRecommendations.
	 */
	public List<SelectionRecommendation> getSelectionRecommendations() {
		if (selectionRecommendations == null) {
			selectionRecommendations = new ArrayList<SelectionRecommendation>();
		}
		return selectionRecommendations;
	}

	/**
	 * Set the value of SelectionRecommendations.
	 *
	 * @param selectionRecommendations
	 *            The new value to set.
	 */
	public void setSelectionRecommendations(
			List<SelectionRecommendation> selectionRecommendations) {
		this.selectionRecommendations = selectionRecommendations;
	}

	/**
	 * Clear SelectionRecommendations.
	 */
	public void unsetSelectionRecommendations() {
		this.selectionRecommendations = null;
	}

	/**
	 * Check to see if SelectionRecommendations is set.
	 *
	 * @return true if SelectionRecommendations is set.
	 */
	public boolean isSetSelectionRecommendations() {
		return selectionRecommendations != null
				&& !selectionRecommendations.isEmpty();
	}

	/**
	 * Add values for SelectionRecommendations, return this.
	 *
	 * @param selectionRecommendations
	 *            New values to add.
	 *
	 * @return This instance.
	 */
	public ListRecommendationsByNextTokenResult withSelectionRecommendations(
			SelectionRecommendation... values) {
		List<SelectionRecommendation> list = getSelectionRecommendations();
		for (SelectionRecommendation value : values) {
			list.add(value);
		}
		return this;
	}

	/**
	 * Get the value of PricingRecommendations.
	 *
	 * @return The value of PricingRecommendations.
	 */
	public List<PricingRecommendation> getPricingRecommendations() {
		if (pricingRecommendations == null) {
			pricingRecommendations = new ArrayList<PricingRecommendation>();
		}
		return pricingRecommendations;
	}

	/**
	 * Set the value of PricingRecommendations.
	 *
	 * @param pricingRecommendations
	 *            The new value to set.
	 */
	public void setPricingRecommendations(
			List<PricingRecommendation> pricingRecommendations) {
		this.pricingRecommendations = pricingRecommendations;
	}

	/**
	 * Clear PricingRecommendations.
	 */
	public void unsetPricingRecommendations() {
		this.pricingRecommendations = null;
	}

	/**
	 * Check to see if PricingRecommendations is set.
	 *
	 * @return true if PricingRecommendations is set.
	 */
	public boolean isSetPricingRecommendations() {
		return pricingRecommendations != null
				&& !pricingRecommendations.isEmpty();
	}

	/**
	 * Add values for PricingRecommendations, return this.
	 *
	 * @param pricingRecommendations
	 *            New values to add.
	 *
	 * @return This instance.
	 */
	public ListRecommendationsByNextTokenResult withPricingRecommendations(
			PricingRecommendation... values) {
		List<PricingRecommendation> list = getPricingRecommendations();
		for (PricingRecommendation value : values) {
			list.add(value);
		}
		return this;
	}

	/**
	 * Get the value of FulfillmentRecommendations.
	 *
	 * @return The value of FulfillmentRecommendations.
	 */
	public List<FulfillmentRecommendation> getFulfillmentRecommendations() {
		if (fulfillmentRecommendations == null) {
			fulfillmentRecommendations = new ArrayList<FulfillmentRecommendation>();
		}
		return fulfillmentRecommendations;
	}

	/**
	 * Set the value of FulfillmentRecommendations.
	 *
	 * @param fulfillmentRecommendations
	 *            The new value to set.
	 */
	public void setFulfillmentRecommendations(
			List<FulfillmentRecommendation> fulfillmentRecommendations) {
		this.fulfillmentRecommendations = fulfillmentRecommendations;
	}

	/**
	 * Clear FulfillmentRecommendations.
	 */
	public void unsetFulfillmentRecommendations() {
		this.fulfillmentRecommendations = null;
	}

	/**
	 * Check to see if FulfillmentRecommendations is set.
	 *
	 * @return true if FulfillmentRecommendations is set.
	 */
	public boolean isSetFulfillmentRecommendations() {
		return fulfillmentRecommendations != null
				&& !fulfillmentRecommendations.isEmpty();
	}

	/**
	 * Add values for FulfillmentRecommendations, return this.
	 *
	 * @param fulfillmentRecommendations
	 *            New values to add.
	 *
	 * @return This instance.
	 */
	public ListRecommendationsByNextTokenResult withFulfillmentRecommendations(
			FulfillmentRecommendation... values) {
		List<FulfillmentRecommendation> list = getFulfillmentRecommendations();
		for (FulfillmentRecommendation value : values) {
			list.add(value);
		}
		return this;
	}

	/**
	 * Get the value of ListingQualityRecommendations.
	 *
	 * @return The value of ListingQualityRecommendations.
	 */
	public List<ListingQualityRecommendation> getListingQualityRecommendations() {
		if (listingQualityRecommendations == null) {
			listingQualityRecommendations = new ArrayList<ListingQualityRecommendation>();
		}
		return listingQualityRecommendations;
	}

	/**
	 * Set the value of ListingQualityRecommendations.
	 *
	 * @param listingQualityRecommendations
	 *            The new value to set.
	 */
	public void setListingQualityRecommendations(
			List<ListingQualityRecommendation> listingQualityRecommendations) {
		this.listingQualityRecommendations = listingQualityRecommendations;
	}

	/**
	 * Clear ListingQualityRecommendations.
	 */
	public void unsetListingQualityRecommendations() {
		this.listingQualityRecommendations = null;
	}

	/**
	 * Check to see if ListingQualityRecommendations is set.
	 *
	 * @return true if ListingQualityRecommendations is set.
	 */
	public boolean isSetListingQualityRecommendations() {
		return listingQualityRecommendations != null
				&& !listingQualityRecommendations.isEmpty();
	}

	/**
	 * Add values for ListingQualityRecommendations, return this.
	 *
	 * @param listingQualityRecommendations
	 *            New values to add.
	 *
	 * @return This instance.
	 */
	public ListRecommendationsByNextTokenResult withListingQualityRecommendations(
			ListingQualityRecommendation... values) {
		List<ListingQualityRecommendation> list = getListingQualityRecommendations();
		for (ListingQualityRecommendation value : values) {
			list.add(value);
		}
		return this;
	}

	/**
	 * Get the value of GlobalSellingRecommendations.
	 *
	 * @return The value of GlobalSellingRecommendations.
	 */
	public List<GlobalSellingRecommendation> getGlobalSellingRecommendations() {
		if (globalSellingRecommendations == null) {
			globalSellingRecommendations = new ArrayList<GlobalSellingRecommendation>();
		}
		return globalSellingRecommendations;
	}

	/**
	 * Set the value of GlobalSellingRecommendations.
	 *
	 * @param globalSellingRecommendations
	 *            The new value to set.
	 */
	public void setGlobalSellingRecommendations(
			List<GlobalSellingRecommendation> globalSellingRecommendations) {
		this.globalSellingRecommendations = globalSellingRecommendations;
	}

	/**
	 * Clear GlobalSellingRecommendations.
	 */
	public void unsetGlobalSellingRecommendations() {
		this.globalSellingRecommendations = null;
	}

	/**
	 * Check to see if GlobalSellingRecommendations is set.
	 *
	 * @return true if GlobalSellingRecommendations is set.
	 */
	public boolean isSetGlobalSellingRecommendations() {
		return globalSellingRecommendations != null
				&& !globalSellingRecommendations.isEmpty();
	}

	/**
	 * Add values for GlobalSellingRecommendations, return this.
	 *
	 * @param globalSellingRecommendations
	 *            New values to add.
	 *
	 * @return This instance.
	 */
	public ListRecommendationsByNextTokenResult withGlobalSellingRecommendations(
			GlobalSellingRecommendation... values) {
		List<GlobalSellingRecommendation> list = getGlobalSellingRecommendations();
		for (GlobalSellingRecommendation value : values) {
			list.add(value);
		}
		return this;
	}

	/**
	 * Get the value of AdvertisingRecommendations.
	 *
	 * @return The value of AdvertisingRecommendations.
	 */
	public List<AdvertisingRecommendation> getAdvertisingRecommendations() {
		if (advertisingRecommendations == null) {
			advertisingRecommendations = new ArrayList<AdvertisingRecommendation>();
		}
		return advertisingRecommendations;
	}

	/**
	 * Set the value of AdvertisingRecommendations.
	 *
	 * @param advertisingRecommendations
	 *            The new value to set.
	 */
	public void setAdvertisingRecommendations(
			List<AdvertisingRecommendation> advertisingRecommendations) {
		this.advertisingRecommendations = advertisingRecommendations;
	}

	/**
	 * Clear AdvertisingRecommendations.
	 */
	public void unsetAdvertisingRecommendations() {
		this.advertisingRecommendations = null;
	}

	/**
	 * Check to see if AdvertisingRecommendations is set.
	 *
	 * @return true if AdvertisingRecommendations is set.
	 */
	public boolean isSetAdvertisingRecommendations() {
		return advertisingRecommendations != null
				&& !advertisingRecommendations.isEmpty();
	}

	/**
	 * Add values for AdvertisingRecommendations, return this.
	 *
	 * @param advertisingRecommendations
	 *            New values to add.
	 *
	 * @return This instance.
	 */
	public ListRecommendationsByNextTokenResult withAdvertisingRecommendations(
			AdvertisingRecommendation... values) {
		List<AdvertisingRecommendation> list = getAdvertisingRecommendations();
		for (AdvertisingRecommendation value : values) {
			list.add(value);
		}
		return this;
	}

	/**
	 * Get the value of NextToken.
	 *
	 * @return The value of NextToken.
	 */
	public String getNextToken() {
		return nextToken;
	}

	/**
	 * Set the value of NextToken.
	 *
	 * @param nextToken
	 *            The new value to set.
	 */
	public void setNextToken(String nextToken) {
		this.nextToken = nextToken;
	}

	/**
	 * Check to see if NextToken is set.
	 *
	 * @return true if NextToken is set.
	 */
	public boolean isSetNextToken() {
		return nextToken != null;
	}

	/**
	 * Set the value of NextToken, return this.
	 *
	 * @param nextToken
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public ListRecommendationsByNextTokenResult withNextToken(String nextToken) {
		this.nextToken = nextToken;
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
		inventoryRecommendations = r.readList("InventoryRecommendations",
				"member", InventoryRecommendation.class);
		selectionRecommendations = r.readList("SelectionRecommendations",
				"member", SelectionRecommendation.class);
		pricingRecommendations = r.readList("PricingRecommendations", "member",
				PricingRecommendation.class);
		fulfillmentRecommendations = r.readList("FulfillmentRecommendations",
				"member", FulfillmentRecommendation.class);
		listingQualityRecommendations = r.readList(
				"ListingQualityRecommendations", "member",
				ListingQualityRecommendation.class);
		globalSellingRecommendations = r.readList(
				"GlobalSellingRecommendations", "member",
				GlobalSellingRecommendation.class);
		advertisingRecommendations = r.readList("AdvertisingRecommendations",
				"member", AdvertisingRecommendation.class);
		nextToken = r.read("NextToken", String.class);
	}

	/**
	 * Write members to a MwsWriter.
	 *
	 * @param w
	 *            The writer to write to.
	 */
	@Override
	public void writeFragmentTo(MwsWriter w) {
		w.writeList("InventoryRecommendations", "member",
				inventoryRecommendations);
		w.writeList("SelectionRecommendations", "member",
				selectionRecommendations);
		w.writeList("PricingRecommendations", "member", pricingRecommendations);
		w.writeList("FulfillmentRecommendations", "member",
				fulfillmentRecommendations);
		w.writeList("ListingQualityRecommendations", "member",
				listingQualityRecommendations);
		w.writeList("GlobalSellingRecommendations", "member",
				globalSellingRecommendations);
		w.writeList("AdvertisingRecommendations", "member",
				advertisingRecommendations);
		w.write("NextToken", nextToken);
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
				"ListRecommendationsByNextTokenResult", this);
	}

	/** Value constructor. */
	public ListRecommendationsByNextTokenResult(
			List<InventoryRecommendation> inventoryRecommendations,
			List<SelectionRecommendation> selectionRecommendations,
			List<PricingRecommendation> pricingRecommendations,
			List<FulfillmentRecommendation> fulfillmentRecommendations,
			List<ListingQualityRecommendation> listingQualityRecommendations,
			List<GlobalSellingRecommendation> globalSellingRecommendations,
			List<AdvertisingRecommendation> advertisingRecommendations,
			String nextToken) {
		this.inventoryRecommendations = inventoryRecommendations;
		this.selectionRecommendations = selectionRecommendations;
		this.pricingRecommendations = pricingRecommendations;
		this.fulfillmentRecommendations = fulfillmentRecommendations;
		this.listingQualityRecommendations = listingQualityRecommendations;
		this.globalSellingRecommendations = globalSellingRecommendations;
		this.advertisingRecommendations = advertisingRecommendations;
		this.nextToken = nextToken;
	}

	/** Default constructor. */
	public ListRecommendationsByNextTokenResult() {
		super();
	}

	public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
		return null;
	}

	public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd) {
	}

}
