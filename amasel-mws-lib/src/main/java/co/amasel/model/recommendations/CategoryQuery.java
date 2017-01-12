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
 * Category Query
 * API Version: 2013-04-01
 * Library Version: 2014-10-01
 * Generated: Fri Oct 10 17:55:39 GMT 2014
 */
package co.amasel.model.recommendations;

import java.util.List;
import java.util.ArrayList;

import com.amazonservices.mws.client.*;
import co.amasel.model.common.AmaselMwsObject;
import co.amasel.model.common.ResponseHeaderMetadata;
import co.amasel.model.common.ResponseMetadata;
import com.amazonservices.mws.client.MwsReader;
import com.amazonservices.mws.client.MwsWriter;
import com.amazonservices.mws.client.MwsResponseHeaderMetadata;

/**
 * CategoryQuery complex type.
 *
 * XML schema:
 *
 * <pre>
 * &lt;complexType name="CategoryQuery"&gt;
 *    &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *          &lt;sequence&gt;
 *             &lt;element name="RecommendationCategory" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *             &lt;element name="FilterOptions" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
 *          &lt;/sequence&gt;
 *       &lt;/restriction&gt;
 *    &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class CategoryQuery extends AmaselMwsObject {

	private String recommendationCategory;

	private List<String> filterOptions;

	/**
	 * Get the value of RecommendationCategory.
	 *
	 * @return The value of RecommendationCategory.
	 */
	public String getRecommendationCategory() {
		return recommendationCategory;
	}

	/**
	 * Set the value of RecommendationCategory.
	 *
	 * @param recommendationCategory
	 *            The new value to set.
	 */
	public void setRecommendationCategory(String recommendationCategory) {
		this.recommendationCategory = recommendationCategory;
	}

	/**
	 * Check to see if RecommendationCategory is set.
	 *
	 * @return true if RecommendationCategory is set.
	 */
	public boolean isSetRecommendationCategory() {
		return recommendationCategory != null;
	}

	/**
	 * Set the value of RecommendationCategory, return this.
	 *
	 * @param recommendationCategory
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public CategoryQuery withRecommendationCategory(
			String recommendationCategory) {
		this.recommendationCategory = recommendationCategory;
		return this;
	}

	/**
	 * Get the value of FilterOptions.
	 *
	 * @return The value of FilterOptions.
	 */
	public List<String> getFilterOptions() {
		if (filterOptions == null) {
			filterOptions = new ArrayList<String>();
		}
		return filterOptions;
	}

	/**
	 * Set the value of FilterOptions.
	 *
	 * @param filterOptions
	 *            The new value to set.
	 */
	public void setFilterOptions(List<String> filterOptions) {
		this.filterOptions = filterOptions;
	}

	/**
	 * Clear FilterOptions.
	 */
	public void unsetFilterOptions() {
		this.filterOptions = null;
	}

	/**
	 * Check to see if FilterOptions is set.
	 *
	 * @return true if FilterOptions is set.
	 */
	public boolean isSetFilterOptions() {
		return filterOptions != null && !filterOptions.isEmpty();
	}

	/**
	 * Add values for FilterOptions, return this.
	 *
	 * @param filterOptions
	 *            New values to add.
	 *
	 * @return This instance.
	 */
	public CategoryQuery withFilterOptions(String... values) {
		List<String> list = getFilterOptions();
		for (String value : values) {
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
		recommendationCategory = r.read("RecommendationCategory", String.class);
		filterOptions = r.readList("FilterOptions", "FilterOption",
				String.class);
	}

	/**
	 * Write members to a MwsWriter.
	 *
	 * @param w
	 *            The writer to write to.
	 */
	@Override
	public void writeFragmentTo(MwsWriter w) {
		w.write("RecommendationCategory", recommendationCategory);
		w.writeList("FilterOptions", "FilterOption", filterOptions);
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
				"CategoryQuery", this);
	}

	/** Value constructor. */
	public CategoryQuery(String recommendationCategory,
			List<String> filterOptions) {
		this.recommendationCategory = recommendationCategory;
		this.filterOptions = filterOptions;
	}

	/** Default constructor. */
	public CategoryQuery() {
		super();
	}

	public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
		return null;
	}

	public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd) {
	}

}
