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
 * List Recommendations By Next Token Response
 * API Version: 2013-04-01
 * Library Version: 2014-10-01
 * Generated: Fri Oct 10 17:55:39 GMT 2014
 */
package co.amasel.model.recommendations;

import com.amazonservices.mws.client.*;
import co.amasel.model.common.AmaselMwsObject;
import co.amasel.model.common.ResponseHeaderMetadata;
import co.amasel.model.common.ResponseMetadata;
import com.amazonservices.mws.client.MwsReader;
import com.amazonservices.mws.client.MwsWriter;
import com.amazonservices.mws.client.MwsResponseHeaderMetadata;

/**
 * ListRecommendationsByNextTokenResponse complex type.
 *
 * XML schema:
 *
 * <pre>
 * &lt;complexType name="ListRecommendationsByNextTokenResponse"&gt;
 *    &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *          &lt;sequence&gt;
 *             &lt;element name="ListRecommendationsByNextTokenResult" type="{https://mws.amazonservices.com/Recommendations/2013-04-01}ListRecommendationsByNextTokenResult" minOccurs="0"/&gt;
 *             &lt;element name="ResponseMetadata" type="{https://mws.amazonservices.com/Recommendations/2013-04-01}ResponseMetadata" minOccurs="0"/&gt;
 *          &lt;/sequence&gt;
 *       &lt;/restriction&gt;
 *    &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class ListRecommendationsByNextTokenResponse extends AmaselMwsObject {

	private ListRecommendationsByNextTokenResult listRecommendationsByNextTokenResult;

	private ResponseMetadata responseMetadata;

	private ResponseHeaderMetadata responseHeaderMetadata;

	/**
	 * Get the value of ListRecommendationsByNextTokenResult.
	 *
	 * @return The value of ListRecommendationsByNextTokenResult.
	 */
	public ListRecommendationsByNextTokenResult getListRecommendationsByNextTokenResult() {
		return listRecommendationsByNextTokenResult;
	}

	/**
	 * Set the value of ListRecommendationsByNextTokenResult.
	 *
	 * @param listRecommendationsByNextTokenResult
	 *            The new value to set.
	 */
	public void setListRecommendationsByNextTokenResult(
			ListRecommendationsByNextTokenResult listRecommendationsByNextTokenResult) {
		this.listRecommendationsByNextTokenResult = listRecommendationsByNextTokenResult;
	}

	/**
	 * Check to see if ListRecommendationsByNextTokenResult is set.
	 *
	 * @return true if ListRecommendationsByNextTokenResult is set.
	 */
	public boolean isSetListRecommendationsByNextTokenResult() {
		return listRecommendationsByNextTokenResult != null;
	}

	/**
	 * Set the value of ListRecommendationsByNextTokenResult, return this.
	 *
	 * @param listRecommendationsByNextTokenResult
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public ListRecommendationsByNextTokenResponse withListRecommendationsByNextTokenResult(
			ListRecommendationsByNextTokenResult listRecommendationsByNextTokenResult) {
		this.listRecommendationsByNextTokenResult = listRecommendationsByNextTokenResult;
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
	public ListRecommendationsByNextTokenResponse withResponseMetadata(
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
	public ListRecommendationsByNextTokenResponse withResponseHeaderMetadata(
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
		listRecommendationsByNextTokenResult = r.read(
				"ListRecommendationsByNextTokenResult",
				ListRecommendationsByNextTokenResult.class);
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
		w.write("ListRecommendationsByNextTokenResult",
				listRecommendationsByNextTokenResult);
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
		w.write("https://mws.amazonservices.com/Recommendations/2013-04-01",
				"ListRecommendationsByNextTokenResponse", this);
	}

	/** Value constructor. */
	public ListRecommendationsByNextTokenResponse(
			ListRecommendationsByNextTokenResult listRecommendationsByNextTokenResult,
			ResponseMetadata responseMetadata) {
		this.listRecommendationsByNextTokenResult = listRecommendationsByNextTokenResult;
		this.responseMetadata = responseMetadata;
	}

	/** Default constructor. */
	public ListRecommendationsByNextTokenResponse() {
		super();
	}

	public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
		return getResponseHeaderMetadata();
	}

	public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd) {
		setResponseHeaderMetadata(new ResponseHeaderMetadata(hmd));
	}

}
