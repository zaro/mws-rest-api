/*******************************************************************************
 * Copyright 2009-2015 Amazon Services. All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 *
 * You may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at: http://aws.amazon.com/apache2.0
 * This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR 
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the 
 * specific language governing permissions and limitations under the License.
 *******************************************************************************
 * List Order Items Response
 * API Version: 2013-09-01
 * Library Version: 2015-09-24
 * Generated: Fri Sep 25 20:06:20 GMT 2015
 */
package co.amasel.model.orders;

import com.amazonservices.mws.client.*;
import co.amasel.model.common.AmaselMwsObject;
import co.amasel.model.common.ResponseHeaderMetadata;
import co.amasel.model.common.ResponseMetadata;
import com.amazonservices.mws.client.MwsReader;
import com.amazonservices.mws.client.MwsWriter;
import com.amazonservices.mws.client.MwsResponseHeaderMetadata;

/**
 * ListOrderItemsResponse complex type.
 *
 * XML schema:
 *
 * <pre>
 * &lt;complexType name="ListOrderItemsResponse"&gt;
 *    &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *          &lt;sequence&gt;
 *             &lt;element name="ListOrderItemsResult" type="{https://mws.amazonservices.com/Orders/2013-09-01}ListOrderItemsResult" minOccurs="0"/&gt;
 *             &lt;element name="ResponseMetadata" type="{https://mws.amazonservices.com/Orders/2013-09-01}ResponseMetadata" minOccurs="0"/&gt;
 *          &lt;/sequence&gt;
 *       &lt;/restriction&gt;
 *    &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class ListOrderItemsResponse extends AmaselMwsObject {

	private ListOrderItemsResult listOrderItemsResult;

	private ResponseMetadata responseMetadata;

	private ResponseHeaderMetadata responseHeaderMetadata;

	/**
	 * Get the value of ListOrderItemsResult.
	 *
	 * @return The value of ListOrderItemsResult.
	 */
	public ListOrderItemsResult getListOrderItemsResult() {
		return listOrderItemsResult;
	}

	/**
	 * Set the value of ListOrderItemsResult.
	 *
	 * @param listOrderItemsResult
	 *            The new value to set.
	 */
	public void setListOrderItemsResult(
			ListOrderItemsResult listOrderItemsResult) {
		this.listOrderItemsResult = listOrderItemsResult;
	}

	/**
	 * Check to see if ListOrderItemsResult is set.
	 *
	 * @return true if ListOrderItemsResult is set.
	 */
	public boolean isSetListOrderItemsResult() {
		return listOrderItemsResult != null;
	}

	/**
	 * Set the value of ListOrderItemsResult, return this.
	 *
	 * @param listOrderItemsResult
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public ListOrderItemsResponse withListOrderItemsResult(
			ListOrderItemsResult listOrderItemsResult) {
		this.listOrderItemsResult = listOrderItemsResult;
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
	public ListOrderItemsResponse withResponseMetadata(
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
	public ListOrderItemsResponse withResponseHeaderMetadata(
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
		listOrderItemsResult = r.read("ListOrderItemsResult",
				ListOrderItemsResult.class);
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
		w.write("ListOrderItemsResult", listOrderItemsResult);
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
		w.write("https://mws.amazonservices.com/Orders/2013-09-01",
				"ListOrderItemsResponse", this);
	}

	/** Value constructor. */
	public ListOrderItemsResponse(ListOrderItemsResult listOrderItemsResult,
			ResponseMetadata responseMetadata) {
		this.listOrderItemsResult = listOrderItemsResult;
		this.responseMetadata = responseMetadata;
	}

	/** Default constructor. */
	public ListOrderItemsResponse() {
		super();
	}

	public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
		return getResponseHeaderMetadata();
	}

	public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd) {
		setResponseHeaderMetadata(new ResponseHeaderMetadata(hmd));
	}

}
