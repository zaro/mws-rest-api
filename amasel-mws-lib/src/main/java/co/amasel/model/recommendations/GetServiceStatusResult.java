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
 * Get Service Status Result
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
 * GetServiceStatusResult complex type.
 *
 * XML schema:
 *
 * <pre>
 * &lt;complexType name="GetServiceStatusResult"&gt;
 *    &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *          &lt;sequence&gt;
 *             &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="Timestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *          &lt;/sequence&gt;
 *       &lt;/restriction&gt;
 *    &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class GetServiceStatusResult extends AmaselMwsObject {

	private String status;

	private XMLGregorianCalendar timestamp;

	/**
	 * Get the value of Status.
	 *
	 * @return The value of Status.
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Set the value of Status.
	 *
	 * @param status
	 *            The new value to set.
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Check to see if Status is set.
	 *
	 * @return true if Status is set.
	 */
	public boolean isSetStatus() {
		return status != null;
	}

	/**
	 * Set the value of Status, return this.
	 *
	 * @param status
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public GetServiceStatusResult withStatus(String status) {
		this.status = status;
		return this;
	}

	/**
	 * Get the value of Timestamp.
	 *
	 * @return The value of Timestamp.
	 */
	public XMLGregorianCalendar getTimestamp() {
		return timestamp;
	}

	/**
	 * Set the value of Timestamp.
	 *
	 * @param timestamp
	 *            The new value to set.
	 */
	public void setTimestamp(XMLGregorianCalendar timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * Check to see if Timestamp is set.
	 *
	 * @return true if Timestamp is set.
	 */
	public boolean isSetTimestamp() {
		return timestamp != null;
	}

	/**
	 * Set the value of Timestamp, return this.
	 *
	 * @param timestamp
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public GetServiceStatusResult withTimestamp(XMLGregorianCalendar timestamp) {
		this.timestamp = timestamp;
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
		status = r.read("Status", String.class);
		timestamp = r.read("Timestamp", XMLGregorianCalendar.class);
	}

	/**
	 * Write members to a MwsWriter.
	 *
	 * @param w
	 *            The writer to write to.
	 */
	@Override
	public void writeFragmentTo(MwsWriter w) {
		w.write("Status", status);
		w.write("Timestamp", timestamp);
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
				"GetServiceStatusResult", this);
	}

	/** Value constructor. */
	public GetServiceStatusResult(String status, XMLGregorianCalendar timestamp) {
		this.status = status;
		this.timestamp = timestamp;
	}

	/** Default constructor. */
	public GetServiceStatusResult() {
		super();
	}

	public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
		return null;
	}

	public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd) {
	}

}
