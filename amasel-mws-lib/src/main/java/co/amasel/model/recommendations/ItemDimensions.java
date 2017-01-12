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
 * Item Dimensions
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
 * ItemDimensions complex type.
 *
 * XML schema:
 *
 * <pre>
 * &lt;complexType name="ItemDimensions"&gt;
 *    &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *          &lt;sequence&gt;
 *             &lt;element name="Height" type="{https://mws.amazonservices.com/Recommendations/2013-04-01}DimensionMeasure" minOccurs="0"/&gt;
 *             &lt;element name="Width" type="{https://mws.amazonservices.com/Recommendations/2013-04-01}DimensionMeasure" minOccurs="0"/&gt;
 *             &lt;element name="Length" type="{https://mws.amazonservices.com/Recommendations/2013-04-01}DimensionMeasure" minOccurs="0"/&gt;
 *             &lt;element name="Weight" type="{https://mws.amazonservices.com/Recommendations/2013-04-01}WeightMeasure" minOccurs="0"/&gt;
 *          &lt;/sequence&gt;
 *       &lt;/restriction&gt;
 *    &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class ItemDimensions extends AmaselMwsObject {

	private DimensionMeasure height;

	private DimensionMeasure width;

	private DimensionMeasure length;

	private WeightMeasure weight;

	/**
	 * Get the value of Height.
	 *
	 * @return The value of Height.
	 */
	public DimensionMeasure getHeight() {
		return height;
	}

	/**
	 * Set the value of Height.
	 *
	 * @param height
	 *            The new value to set.
	 */
	public void setHeight(DimensionMeasure height) {
		this.height = height;
	}

	/**
	 * Check to see if Height is set.
	 *
	 * @return true if Height is set.
	 */
	public boolean isSetHeight() {
		return height != null;
	}

	/**
	 * Set the value of Height, return this.
	 *
	 * @param height
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public ItemDimensions withHeight(DimensionMeasure height) {
		this.height = height;
		return this;
	}

	/**
	 * Get the value of Width.
	 *
	 * @return The value of Width.
	 */
	public DimensionMeasure getWidth() {
		return width;
	}

	/**
	 * Set the value of Width.
	 *
	 * @param width
	 *            The new value to set.
	 */
	public void setWidth(DimensionMeasure width) {
		this.width = width;
	}

	/**
	 * Check to see if Width is set.
	 *
	 * @return true if Width is set.
	 */
	public boolean isSetWidth() {
		return width != null;
	}

	/**
	 * Set the value of Width, return this.
	 *
	 * @param width
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public ItemDimensions withWidth(DimensionMeasure width) {
		this.width = width;
		return this;
	}

	/**
	 * Get the value of Length.
	 *
	 * @return The value of Length.
	 */
	public DimensionMeasure getLength() {
		return length;
	}

	/**
	 * Set the value of Length.
	 *
	 * @param length
	 *            The new value to set.
	 */
	public void setLength(DimensionMeasure length) {
		this.length = length;
	}

	/**
	 * Check to see if Length is set.
	 *
	 * @return true if Length is set.
	 */
	public boolean isSetLength() {
		return length != null;
	}

	/**
	 * Set the value of Length, return this.
	 *
	 * @param length
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public ItemDimensions withLength(DimensionMeasure length) {
		this.length = length;
		return this;
	}

	/**
	 * Get the value of Weight.
	 *
	 * @return The value of Weight.
	 */
	public WeightMeasure getWeight() {
		return weight;
	}

	/**
	 * Set the value of Weight.
	 *
	 * @param weight
	 *            The new value to set.
	 */
	public void setWeight(WeightMeasure weight) {
		this.weight = weight;
	}

	/**
	 * Check to see if Weight is set.
	 *
	 * @return true if Weight is set.
	 */
	public boolean isSetWeight() {
		return weight != null;
	}

	/**
	 * Set the value of Weight, return this.
	 *
	 * @param weight
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public ItemDimensions withWeight(WeightMeasure weight) {
		this.weight = weight;
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
		height = r.read("Height", DimensionMeasure.class);
		width = r.read("Width", DimensionMeasure.class);
		length = r.read("Length", DimensionMeasure.class);
		weight = r.read("Weight", WeightMeasure.class);
	}

	/**
	 * Write members to a MwsWriter.
	 *
	 * @param w
	 *            The writer to write to.
	 */
	@Override
	public void writeFragmentTo(MwsWriter w) {
		w.write("Height", height);
		w.write("Width", width);
		w.write("Length", length);
		w.write("Weight", weight);
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
				"ItemDimensions", this);
	}

	/** Value constructor. */
	public ItemDimensions(DimensionMeasure height, DimensionMeasure width,
			DimensionMeasure length, WeightMeasure weight) {
		this.height = height;
		this.width = width;
		this.length = length;
		this.weight = weight;
	}

	/** Default constructor. */
	public ItemDimensions() {
		super();
	}

	public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
		return null;
	}

	public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd) {
	}

}
