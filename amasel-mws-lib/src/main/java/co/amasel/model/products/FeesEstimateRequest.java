/*******************************************************************************
 * Copyright 2009-2016 Amazon Services. All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 *
 * You may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at: http://aws.amazon.com/apache2.0
 * This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR 
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the 
 * specific language governing permissions and limitations under the License.
 *******************************************************************************
 * Fees Estimate Request
 * API Version: 2011-10-01
 * Library Version: 2016-06-01
 * Generated: Mon Jun 13 10:07:47 PDT 2016
 */
package co.amasel.model.products;

import javax.xml.bind.annotation.*;

import com.amazonservices.mws.client.*;
import co.amasel.model.common.AmaselMwsObject;
import co.amasel.model.common.ResponseHeaderMetadata;
import co.amasel.model.common.ResponseMetadata;
import com.amazonservices.mws.client.MwsReader;
import com.amazonservices.mws.client.MwsWriter;
import com.amazonservices.mws.client.MwsResponseHeaderMetadata;

/**
 * FeesEstimateRequest complex type.
 *
 * XML schema:
 *
 * <pre>
 * &lt;complexType name="FeesEstimateRequest"&gt;
 *    &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *          &lt;sequence&gt;
 *             &lt;element name="MarketplaceId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *             &lt;element name="IdType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *             &lt;element name="IdValue" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *             &lt;element name="IsAmazonFulfilled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *             &lt;element name="PriceToEstimateFees" type="{http://mws.amazonservices.com/schema/Products/2011-10-01}PriceToEstimateFees"/&gt;
 *             &lt;element name="Identifier" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *          &lt;/sequence&gt;
 *       &lt;/restriction&gt;
 *    &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeesEstimateRequest", propOrder = {"marketplaceId", "idType",
		"idValue", "isAmazonFulfilled", "priceToEstimateFees", "identifier"})
@XmlRootElement(name = "FeesEstimateRequest")
public class FeesEstimateRequest extends AmaselMwsObject {

	@XmlElement(name = "MarketplaceId", required = true)
	private String marketplaceId;

	@XmlElement(name = "IdType", required = true)
	private String idType;

	@XmlElement(name = "IdValue", required = true)
	private String idValue;

	@XmlElement(name = "IsAmazonFulfilled")
	private Boolean isAmazonFulfilled;

	@XmlElement(name = "PriceToEstimateFees", required = true)
	private PriceToEstimateFees priceToEstimateFees;

	@XmlElement(name = "Identifier", required = true)
	private String identifier;

	/**
	 * Get the value of MarketplaceId.
	 *
	 * @return The value of MarketplaceId.
	 */
	public String getMarketplaceId() {
		return marketplaceId;
	}

	/**
	 * Set the value of MarketplaceId.
	 *
	 * @param marketplaceId
	 *            The new value to set.
	 */
	public void setMarketplaceId(String marketplaceId) {
		this.marketplaceId = marketplaceId;
	}

	/**
	 * Check to see if MarketplaceId is set.
	 *
	 * @return true if MarketplaceId is set.
	 */
	public boolean isSetMarketplaceId() {
		return marketplaceId != null;
	}

	/**
	 * Set the value of MarketplaceId, return this.
	 *
	 * @param marketplaceId
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public FeesEstimateRequest withMarketplaceId(String marketplaceId) {
		this.marketplaceId = marketplaceId;
		return this;
	}

	/**
	 * Get the value of IdType.
	 *
	 * @return The value of IdType.
	 */
	public String getIdType() {
		return idType;
	}

	/**
	 * Set the value of IdType.
	 *
	 * @param idType
	 *            The new value to set.
	 */
	public void setIdType(String idType) {
		this.idType = idType;
	}

	/**
	 * Check to see if IdType is set.
	 *
	 * @return true if IdType is set.
	 */
	public boolean isSetIdType() {
		return idType != null;
	}

	/**
	 * Set the value of IdType, return this.
	 *
	 * @param idType
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public FeesEstimateRequest withIdType(String idType) {
		this.idType = idType;
		return this;
	}

	/**
	 * Get the value of IdValue.
	 *
	 * @return The value of IdValue.
	 */
	public String getIdValue() {
		return idValue;
	}

	/**
	 * Set the value of IdValue.
	 *
	 * @param idValue
	 *            The new value to set.
	 */
	public void setIdValue(String idValue) {
		this.idValue = idValue;
	}

	/**
	 * Check to see if IdValue is set.
	 *
	 * @return true if IdValue is set.
	 */
	public boolean isSetIdValue() {
		return idValue != null;
	}

	/**
	 * Set the value of IdValue, return this.
	 *
	 * @param idValue
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public FeesEstimateRequest withIdValue(String idValue) {
		this.idValue = idValue;
		return this;
	}

	/**
	 * Check the value of IsAmazonFulfilled.
	 *
	 * @return true if IsAmazonFulfilled is set to true.
	 */
	public boolean isIsAmazonFulfilled() {
		return isAmazonFulfilled != null && isAmazonFulfilled.booleanValue();
	}

	/**
	 * Get the value of IsAmazonFulfilled.
	 *
	 * @return The value of IsAmazonFulfilled.
	 */
	public Boolean getIsAmazonFulfilled() {
		return isAmazonFulfilled;
	}

	/**
	 * Set the value of IsAmazonFulfilled.
	 *
	 * @param isAmazonFulfilled
	 *            The new value to set.
	 */
	public void setIsAmazonFulfilled(Boolean isAmazonFulfilled) {
		this.isAmazonFulfilled = isAmazonFulfilled;
	}

	/**
	 * Check to see if IsAmazonFulfilled is set.
	 *
	 * @return true if IsAmazonFulfilled is set.
	 */
	public boolean isSetIsAmazonFulfilled() {
		return isAmazonFulfilled != null;
	}

	/**
	 * Set the value of IsAmazonFulfilled, return this.
	 *
	 * @param isAmazonFulfilled
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public FeesEstimateRequest withIsAmazonFulfilled(Boolean isAmazonFulfilled) {
		this.isAmazonFulfilled = isAmazonFulfilled;
		return this;
	}

	/**
	 * Get the value of PriceToEstimateFees.
	 *
	 * @return The value of PriceToEstimateFees.
	 */
	public PriceToEstimateFees getPriceToEstimateFees() {
		return priceToEstimateFees;
	}

	/**
	 * Set the value of PriceToEstimateFees.
	 *
	 * @param priceToEstimateFees
	 *            The new value to set.
	 */
	public void setPriceToEstimateFees(PriceToEstimateFees priceToEstimateFees) {
		this.priceToEstimateFees = priceToEstimateFees;
	}

	/**
	 * Check to see if PriceToEstimateFees is set.
	 *
	 * @return true if PriceToEstimateFees is set.
	 */
	public boolean isSetPriceToEstimateFees() {
		return priceToEstimateFees != null;
	}

	/**
	 * Set the value of PriceToEstimateFees, return this.
	 *
	 * @param priceToEstimateFees
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public FeesEstimateRequest withPriceToEstimateFees(
			PriceToEstimateFees priceToEstimateFees) {
		this.priceToEstimateFees = priceToEstimateFees;
		return this;
	}

	/**
	 * Get the value of Identifier.
	 *
	 * @return The value of Identifier.
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * Set the value of Identifier.
	 *
	 * @param identifier
	 *            The new value to set.
	 */
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	/**
	 * Check to see if Identifier is set.
	 *
	 * @return true if Identifier is set.
	 */
	public boolean isSetIdentifier() {
		return identifier != null;
	}

	/**
	 * Set the value of Identifier, return this.
	 *
	 * @param identifier
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public FeesEstimateRequest withIdentifier(String identifier) {
		this.identifier = identifier;
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
		marketplaceId = r.read("MarketplaceId", String.class);
		idType = r.read("IdType", String.class);
		idValue = r.read("IdValue", String.class);
		isAmazonFulfilled = r.read("IsAmazonFulfilled", Boolean.class);
		priceToEstimateFees = r.read("PriceToEstimateFees",
				PriceToEstimateFees.class);
		identifier = r.read("Identifier", String.class);
	}

	/**
	 * Write members to a MwsWriter.
	 *
	 * @param w
	 *            The writer to write to.
	 */
	@Override
	public void writeFragmentTo(MwsWriter w) {
		w.write("MarketplaceId", marketplaceId);
		w.write("IdType", idType);
		w.write("IdValue", idValue);
		w.write("IsAmazonFulfilled", isAmazonFulfilled);
		w.write("PriceToEstimateFees", priceToEstimateFees);
		w.write("Identifier", identifier);
	}

	/**
	 * Write tag, xmlns and members to a MwsWriter.
	 *
	 * @param w
	 *            The Writer to write to.
	 */
	@Override
	public void writeTo(MwsWriter w) {
		w.write("http://mws.amazonservices.com/schema/Products/2011-10-01",
				"FeesEstimateRequest", this);
	}

	/** Value constructor. */
	public FeesEstimateRequest(String marketplaceId, String idType,
			String idValue, Boolean isAmazonFulfilled,
			PriceToEstimateFees priceToEstimateFees, String identifier) {
		this.marketplaceId = marketplaceId;
		this.idType = idType;
		this.idValue = idValue;
		this.isAmazonFulfilled = isAmazonFulfilled;
		this.priceToEstimateFees = priceToEstimateFees;
		this.identifier = identifier;
	}

	/** Default constructor. */
	public FeesEstimateRequest() {
		super();
	}

	public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
		return null;
	}

	public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd) {
	}

}
