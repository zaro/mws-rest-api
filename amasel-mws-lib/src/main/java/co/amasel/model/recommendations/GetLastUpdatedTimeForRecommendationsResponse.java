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
 * Get Last Updated Time For Recommendations Response
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
 * GetLastUpdatedTimeForRecommendationsResponse complex type.
 *
 * XML schema:
 *
 * <pre>
 * &lt;complexType name="GetLastUpdatedTimeForRecommendationsResponse"&gt;
 *    &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *          &lt;sequence&gt;
 *             &lt;element name="GetLastUpdatedTimeForRecommendationsResult" type="{https://mws.amazonservices.com/Recommendations/2013-04-01}GetLastUpdatedTimeForRecommendationsResult" minOccurs="0"/&gt;
 *             &lt;element name="ResponseMetadata" type="{https://mws.amazonservices.com/Recommendations/2013-04-01}ResponseMetadata" minOccurs="0"/&gt;
 *          &lt;/sequence&gt;
 *       &lt;/restriction&gt;
 *    &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class GetLastUpdatedTimeForRecommendationsResponse
		extends
			AmaselMwsObject {

	private GetLastUpdatedTimeForRecommendationsResult getLastUpdatedTimeForRecommendationsResult;

	private ResponseMetadata responseMetadata;

	private ResponseHeaderMetadata responseHeaderMetadata;

	/**
	 * Get the value of GetLastUpdatedTimeForRecommendationsResult.
	 *
	 * @return The value of GetLastUpdatedTimeForRecommendationsResult.
	 */
	public GetLastUpdatedTimeForRecommendationsResult getGetLastUpdatedTimeForRecommendationsResult() {
		return getLastUpdatedTimeForRecommendationsResult;
	}

	/**
	 * Set the value of GetLastUpdatedTimeForRecommendationsResult.
	 *
	 * @param getLastUpdatedTimeForRecommendationsResult
	 *            The new value to set.
	 */
	public void setGetLastUpdatedTimeForRecommendationsResult(
			GetLastUpdatedTimeForRecommendationsResult getLastUpdatedTimeForRecommendationsResult) {
		this.getLastUpdatedTimeForRecommendationsResult = getLastUpdatedTimeForRecommendationsResult;
	}

	/**
	 * Check to see if GetLastUpdatedTimeForRecommendationsResult is set.
	 *
	 * @return true if GetLastUpdatedTimeForRecommendationsResult is set.
	 */
	public boolean isSetGetLastUpdatedTimeForRecommendationsResult() {
		return getLastUpdatedTimeForRecommendationsResult != null;
	}

	/**
	 * Set the value of GetLastUpdatedTimeForRecommendationsResult, return this.
	 *
	 * @param getLastUpdatedTimeForRecommendationsResult
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public GetLastUpdatedTimeForRecommendationsResponse withGetLastUpdatedTimeForRecommendationsResult(
			GetLastUpdatedTimeForRecommendationsResult getLastUpdatedTimeForRecommendationsResult) {
		this.getLastUpdatedTimeForRecommendationsResult = getLastUpdatedTimeForRecommendationsResult;
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
	public GetLastUpdatedTimeForRecommendationsResponse withResponseMetadata(
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
	public GetLastUpdatedTimeForRecommendationsResponse withResponseHeaderMetadata(
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
		getLastUpdatedTimeForRecommendationsResult = r.read(
				"GetLastUpdatedTimeForRecommendationsResult",
				GetLastUpdatedTimeForRecommendationsResult.class);
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
		w.write("GetLastUpdatedTimeForRecommendationsResult",
				getLastUpdatedTimeForRecommendationsResult);
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
				"GetLastUpdatedTimeForRecommendationsResponse", this);
	}

	/** Value constructor. */
	public GetLastUpdatedTimeForRecommendationsResponse(
			GetLastUpdatedTimeForRecommendationsResult getLastUpdatedTimeForRecommendationsResult,
			ResponseMetadata responseMetadata) {
		this.getLastUpdatedTimeForRecommendationsResult = getLastUpdatedTimeForRecommendationsResult;
		this.responseMetadata = responseMetadata;
	}

	/** Default constructor. */
	public GetLastUpdatedTimeForRecommendationsResponse() {
		super();
	}

	public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
		return getResponseHeaderMetadata();
	}

	public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd) {
		setResponseHeaderMetadata(new ResponseHeaderMetadata(hmd));
	}

}
