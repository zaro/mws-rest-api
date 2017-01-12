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
 * Product Identifier
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
 * ProductIdentifier complex type.
 *
 * XML schema:
 *
 * <pre>
 * &lt;complexType name="ProductIdentifier"&gt;
 *    &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *          &lt;sequence&gt;
 *             &lt;element name="Asin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="Sku" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="Upc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *          &lt;/sequence&gt;
 *       &lt;/restriction&gt;
 *    &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class ProductIdentifier extends AmaselMwsObject {

	private String asin;

	private String sku;

	private String upc;

	/**
	 * Get the value of Asin.
	 *
	 * @return The value of Asin.
	 */
	public String getAsin() {
		return asin;
	}

	/**
	 * Set the value of Asin.
	 *
	 * @param asin
	 *            The new value to set.
	 */
	public void setAsin(String asin) {
		this.asin = asin;
	}

	/**
	 * Check to see if Asin is set.
	 *
	 * @return true if Asin is set.
	 */
	public boolean isSetAsin() {
		return asin != null;
	}

	/**
	 * Set the value of Asin, return this.
	 *
	 * @param asin
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public ProductIdentifier withAsin(String asin) {
		this.asin = asin;
		return this;
	}

	/**
	 * Get the value of Sku.
	 *
	 * @return The value of Sku.
	 */
	public String getSku() {
		return sku;
	}

	/**
	 * Set the value of Sku.
	 *
	 * @param sku
	 *            The new value to set.
	 */
	public void setSku(String sku) {
		this.sku = sku;
	}

	/**
	 * Check to see if Sku is set.
	 *
	 * @return true if Sku is set.
	 */
	public boolean isSetSku() {
		return sku != null;
	}

	/**
	 * Set the value of Sku, return this.
	 *
	 * @param sku
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public ProductIdentifier withSku(String sku) {
		this.sku = sku;
		return this;
	}

	/**
	 * Get the value of Upc.
	 *
	 * @return The value of Upc.
	 */
	public String getUpc() {
		return upc;
	}

	/**
	 * Set the value of Upc.
	 *
	 * @param upc
	 *            The new value to set.
	 */
	public void setUpc(String upc) {
		this.upc = upc;
	}

	/**
	 * Check to see if Upc is set.
	 *
	 * @return true if Upc is set.
	 */
	public boolean isSetUpc() {
		return upc != null;
	}

	/**
	 * Set the value of Upc, return this.
	 *
	 * @param upc
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public ProductIdentifier withUpc(String upc) {
		this.upc = upc;
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
		asin = r.read("Asin", String.class);
		sku = r.read("Sku", String.class);
		upc = r.read("Upc", String.class);
	}

	/**
	 * Write members to a MwsWriter.
	 *
	 * @param w
	 *            The writer to write to.
	 */
	@Override
	public void writeFragmentTo(MwsWriter w) {
		w.write("Asin", asin);
		w.write("Sku", sku);
		w.write("Upc", upc);
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
				"ProductIdentifier", this);
	}

	/** Value constructor. */
	public ProductIdentifier(String asin, String sku, String upc) {
		this.asin = asin;
		this.sku = sku;
		this.upc = upc;
	}

	/** Default constructor. */
	public ProductIdentifier() {
		super();
	}

	public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
		return null;
	}

	public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd) {
	}

}
