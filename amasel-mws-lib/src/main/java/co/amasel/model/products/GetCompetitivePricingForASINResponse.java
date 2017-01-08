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
 * Get Competitive Pricing For ASIN Response
 * API Version: 2011-10-01
 * Library Version: 2016-06-01
 * Generated: Mon Jun 13 10:07:47 PDT 2016
 */
package co.amasel.model.products;

import java.util.List;
import java.util.ArrayList;

import javax.xml.bind.annotation.*;

import com.amazonservices.mws.client.*;
import co.amasel.model.common.AmaselMwsObject;
import co.amasel.model.common.ResponseHeaderMetadata;
import co.amasel.model.common.ResponseMetadata;
import com.amazonservices.mws.client.MwsReader;
import com.amazonservices.mws.client.MwsWriter;
import com.amazonservices.mws.client.MwsResponseHeaderMetadata;

/**
 * GetCompetitivePricingForASINResponse complex type.
 *
 * XML schema:
 *
 * <pre>
 * &lt;complexType name="GetCompetitivePricingForASINResponse"&gt;
 *    &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *          &lt;sequence&gt;
 *             &lt;element name="GetCompetitivePricingForASINResult" type="{http://mws.amazonservices.com/schema/Products/2011-10-01}GetCompetitivePricingForASINResult" maxOccurs="unbounded"/&gt;
 *             &lt;element name="ResponseMetadata" type="{http://mws.amazonservices.com/schema/Products/2011-10-01}ResponseMetadata" minOccurs="0"/&gt;
 *          &lt;/sequence&gt;
 *       &lt;/restriction&gt;
 *    &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCompetitivePricingForASINResponse", propOrder = {
		"getCompetitivePricingForASINResult", "responseMetadata"})
@XmlRootElement(name = "GetCompetitivePricingForASINResponse")
public class GetCompetitivePricingForASINResponse extends AmaselMwsObject {

	@XmlElement(name = "GetCompetitivePricingForASINResult")
	private List<GetCompetitivePricingForASINResult> getCompetitivePricingForASINResult;

	@XmlElement(name = "ResponseMetadata")
	private ResponseMetadata responseMetadata;

	@XmlTransient
	private ResponseHeaderMetadata responseHeaderMetadata;

	/**
	 * Get the value of GetCompetitivePricingForASINResult.
	 *
	 * @return The value of GetCompetitivePricingForASINResult.
	 */
	public List<GetCompetitivePricingForASINResult> getGetCompetitivePricingForASINResult() {
		if (getCompetitivePricingForASINResult == null) {
			getCompetitivePricingForASINResult = new ArrayList<GetCompetitivePricingForASINResult>();
		}
		return getCompetitivePricingForASINResult;
	}

	/**
	 * Set the value of GetCompetitivePricingForASINResult.
	 *
	 * @param getCompetitivePricingForASINResult
	 *            The new value to set.
	 */
	public void setGetCompetitivePricingForASINResult(
			List<GetCompetitivePricingForASINResult> getCompetitivePricingForASINResult) {
		this.getCompetitivePricingForASINResult = getCompetitivePricingForASINResult;
	}

	/**
	 * Clear GetCompetitivePricingForASINResult.
	 */
	public void unsetGetCompetitivePricingForASINResult() {
		this.getCompetitivePricingForASINResult = null;
	}

	/**
	 * Check to see if GetCompetitivePricingForASINResult is set.
	 *
	 * @return true if GetCompetitivePricingForASINResult is set.
	 */
	public boolean isSetGetCompetitivePricingForASINResult() {
		return getCompetitivePricingForASINResult != null
				&& !getCompetitivePricingForASINResult.isEmpty();
	}

	/**
	 * Add values for GetCompetitivePricingForASINResult, return this.
	 *
	 * @param getCompetitivePricingForASINResult
	 *            New values to add.
	 *
	 * @return This instance.
	 */
	public GetCompetitivePricingForASINResponse withGetCompetitivePricingForASINResult(
			GetCompetitivePricingForASINResult... values) {
		List<GetCompetitivePricingForASINResult> list = getGetCompetitivePricingForASINResult();
		for (GetCompetitivePricingForASINResult value : values) {
			list.add(value);
		}
		return this;
	}

	/**
	 * Get the value of ResponseMetadata.
	 *
	 * @return The value of ResponseMetadata.
	 */
	public ResponseMetadata getResponseMetadata() {
		return responseMetadata;
	}

	/**
	 * Set the value of ResponseMetadata.
	 *
	 * @param responseMetadata
	 *            The new value to set.
	 */
	public void setResponseMetadata(ResponseMetadata responseMetadata) {
		this.responseMetadata = responseMetadata;
	}

	/**
	 * Check to see if ResponseMetadata is set.
	 *
	 * @return true if ResponseMetadata is set.
	 */
	public boolean isSetResponseMetadata() {
		return responseMetadata != null;
	}

	/**
	 * Set the value of ResponseMetadata, return this.
	 *
	 * @param responseMetadata
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public GetCompetitivePricingForASINResponse withResponseMetadata(
			ResponseMetadata responseMetadata) {
		this.responseMetadata = responseMetadata;
		return this;
	}

	/**
	 * Get the value of ResponseHeaderMetadata.
	 *
	 * @return The value of ResponseHeaderMetadata.
	 */
	public ResponseHeaderMetadata getResponseHeaderMetadata() {
		return responseHeaderMetadata;
	}

	/**
	 * Set the value of ResponseHeaderMetadata.
	 *
	 * @param responseHeaderMetadata
	 *            The new value to set.
	 */
	public void setResponseHeaderMetadata(
			ResponseHeaderMetadata responseHeaderMetadata) {
		this.responseHeaderMetadata = responseHeaderMetadata;
	}

	/**
	 * Check to see if ResponseHeaderMetadata is set.
	 *
	 * @return true if ResponseHeaderMetadata is set.
	 */
	public boolean isSetResponseHeaderMetadata() {
		return responseHeaderMetadata != null;
	}

	/**
	 * Set the value of ResponseHeaderMetadata, return this.
	 *
	 * @param responseHeaderMetadata
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public GetCompetitivePricingForASINResponse withResponseHeaderMetadata(
			ResponseHeaderMetadata responseHeaderMetadata) {
		this.responseHeaderMetadata = responseHeaderMetadata;
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
		getCompetitivePricingForASINResult = r.readList(
				"GetCompetitivePricingForASINResult",
				GetCompetitivePricingForASINResult.class);
		responseMetadata = r.read("ResponseMetadata", ResponseMetadata.class);
	}

	/**
	 * Write members to a MwsWriter.
	 *
	 * @param w
	 *            The writer to write to.
	 */
	@Override
	public void writeFragmentTo(MwsWriter w) {
		w.writeList("GetCompetitivePricingForASINResult",
				getCompetitivePricingForASINResult);
		w.write("ResponseMetadata", responseMetadata);
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
				"GetCompetitivePricingForASINResponse", this);
	}

	/** Value constructor. */
	public GetCompetitivePricingForASINResponse(
			List<GetCompetitivePricingForASINResult> getCompetitivePricingForASINResult,
			ResponseMetadata responseMetadata) {
		this.getCompetitivePricingForASINResult = getCompetitivePricingForASINResult;
		this.responseMetadata = responseMetadata;
	}

	/** Default constructor. */
	public GetCompetitivePricingForASINResponse() {
		super();
	}

	public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
		return getResponseHeaderMetadata();
	}

	public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd) {
		setResponseHeaderMetadata(new ResponseHeaderMetadata(hmd));
	}

}
