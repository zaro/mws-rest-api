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
 * List Recommendations By Next Token Request
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
 * ListRecommendationsByNextTokenRequest complex type.
 *
 * XML schema:
 *
 * <pre>
 * &lt;complexType name="ListRecommendationsByNextTokenRequest"&gt;
 *    &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *          &lt;sequence&gt;
 *             &lt;element name="SellerId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *             &lt;element name="MWSAuthToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="NextToken" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *          &lt;/sequence&gt;
 *       &lt;/restriction&gt;
 *    &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class ListRecommendationsByNextTokenRequest extends AmaselMwsObject {

	private String sellerId;

	private String mwsAuthToken;

	private String nextToken;

	/**
	 * Get the value of SellerId.
	 *
	 * @return The value of SellerId.
	 */
	public String getSellerId() {
		return sellerId;
	}

	/**
	 * Set the value of SellerId.
	 *
	 * @param sellerId
	 *            The new value to set.
	 */
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	/**
	 * Check to see if SellerId is set.
	 *
	 * @return true if SellerId is set.
	 */
	public boolean isSetSellerId() {
		return sellerId != null;
	}

	/**
	 * Set the value of SellerId, return this.
	 *
	 * @param sellerId
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public ListRecommendationsByNextTokenRequest withSellerId(String sellerId) {
		this.sellerId = sellerId;
		return this;
	}

	/**
	 * Get the value of MWSAuthToken.
	 *
	 * @return The value of MWSAuthToken.
	 */
	public String getMWSAuthToken() {
		return mwsAuthToken;
	}

	/**
	 * Set the value of MWSAuthToken.
	 *
	 * @param mwsAuthToken
	 *            The new value to set.
	 */
	public void setMWSAuthToken(String mwsAuthToken) {
		this.mwsAuthToken = mwsAuthToken;
	}

	/**
	 * Check to see if MWSAuthToken is set.
	 *
	 * @return true if MWSAuthToken is set.
	 */
	public boolean isSetMWSAuthToken() {
		return mwsAuthToken != null;
	}

	/**
	 * Set the value of MWSAuthToken, return this.
	 *
	 * @param mwsAuthToken
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public ListRecommendationsByNextTokenRequest withMWSAuthToken(
			String mwsAuthToken) {
		this.mwsAuthToken = mwsAuthToken;
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
	public ListRecommendationsByNextTokenRequest withNextToken(String nextToken) {
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
		sellerId = r.read("SellerId", String.class);
		mwsAuthToken = r.read("MWSAuthToken", String.class);
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
		w.write("SellerId", sellerId);
		w.write("MWSAuthToken", mwsAuthToken);
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
				"ListRecommendationsByNextTokenRequest", this);
	}

	/** Value constructor. */
	public ListRecommendationsByNextTokenRequest(String sellerId,
			String mwsAuthToken, String nextToken) {
		this.sellerId = sellerId;
		this.mwsAuthToken = mwsAuthToken;
		this.nextToken = nextToken;
	}

	/** Legacy value constructor. */
	public ListRecommendationsByNextTokenRequest(String sellerId,
			String nextToken) {
		this.sellerId = sellerId;
		this.nextToken = nextToken;
	}

	/** Default constructor. */
	public ListRecommendationsByNextTokenRequest() {
		super();
	}

	public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
		return null;
	}

	public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd) {
	}

}
