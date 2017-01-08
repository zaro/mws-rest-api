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
 * Get Product Categories For ASIN Result
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
 * GetProductCategoriesForASINResult complex type.
 *
 * XML schema:
 *
 * <pre>
 * &lt;complexType name="GetProductCategoriesForASINResult"&gt;
 *    &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *          &lt;sequence&gt;
 *             &lt;element name="Self" type="{http://mws.amazonservices.com/schema/Products/2011-10-01}Categories" maxOccurs="unbounded"/&gt;
 *          &lt;/sequence&gt;
 *       &lt;/restriction&gt;
 *    &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetProductCategoriesForASINResult", propOrder = {"self"})
@XmlRootElement(name = "GetProductCategoriesForASINResult")
public class GetProductCategoriesForASINResult extends AmaselMwsObject {

	@XmlElement(name = "Self")
	private List<Categories> self;

	/**
	 * Get the value of Self.
	 *
	 * @return The value of Self.
	 */
	public List<Categories> getSelf() {
		if (self == null) {
			self = new ArrayList<Categories>();
		}
		return self;
	}

	/**
	 * Set the value of Self.
	 *
	 * @param self
	 *            The new value to set.
	 */
	public void setSelf(List<Categories> self) {
		this.self = self;
	}

	/**
	 * Clear Self.
	 */
	public void unsetSelf() {
		this.self = null;
	}

	/**
	 * Check to see if Self is set.
	 *
	 * @return true if Self is set.
	 */
	public boolean isSetSelf() {
		return self != null && !self.isEmpty();
	}

	/**
	 * Add values for Self, return this.
	 *
	 * @param self
	 *            New values to add.
	 *
	 * @return This instance.
	 */
	public GetProductCategoriesForASINResult withSelf(Categories... values) {
		List<Categories> list = getSelf();
		for (Categories value : values) {
			list.add(value);
		}
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
		self = r.readList("Self", Categories.class);
	}

	/**
	 * Write members to a MwsWriter.
	 *
	 * @param w
	 *            The writer to write to.
	 */
	@Override
	public void writeFragmentTo(MwsWriter w) {
		w.writeList("Self", self);
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
				"GetProductCategoriesForASINResult", this);
	}

	/** Value constructor. */
	public GetProductCategoriesForASINResult(List<Categories> self) {
		this.self = self;
	}

	/** Default constructor. */
	public GetProductCategoriesForASINResult() {
		super();
	}

	public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
		return null;
	}

	public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd) {
	}

}
