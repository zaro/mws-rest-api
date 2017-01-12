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
 * List Recommendations Request
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
 * ListRecommendationsRequest complex type.
 *
 * XML schema:
 *
 * <pre>
 * &lt;complexType name="ListRecommendationsRequest"&gt;
 *    &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *          &lt;sequence&gt;
 *             &lt;element name="MarketplaceId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *             &lt;element name="MWSAuthToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="SellerId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *             &lt;element name="RecommendationCategory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="CategoryQueryList" type="{https://mws.amazonservices.com/Recommendations/2013-04-01}CategoryQuery" maxOccurs="unbounded"/&gt;
 *          &lt;/sequence&gt;
 *       &lt;/restriction&gt;
 *    &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class ListRecommendationsRequest extends AmaselMwsObject {

	private String marketplaceId;

	private String mwsAuthToken;

	private String sellerId;

	private String recommendationCategory;

	private List<CategoryQuery> categoryQueryList;

	/**
	 * Get the value of MarketplaceId.
	 *
	 * @return The value of MarketplaceId.
	 */
	public String getMarketplaceId() {
		return marketplaceId;
	}

	/**
	 * Set the value of MarketplaceId.
	 *
	 * @param marketplaceId
	 *            The new value to set.
	 */
	public void setMarketplaceId(String marketplaceId) {
		this.marketplaceId = marketplaceId;
	}

	/**
	 * Check to see if MarketplaceId is set.
	 *
	 * @return true if MarketplaceId is set.
	 */
	public boolean isSetMarketplaceId() {
		return marketplaceId != null;
	}

	/**
	 * Set the value of MarketplaceId, return this.
	 *
	 * @param marketplaceId
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public ListRecommendationsRequest withMarketplaceId(String marketplaceId) {
		this.marketplaceId = marketplaceId;
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
	public ListRecommendationsRequest withMWSAuthToken(String mwsAuthToken) {
		this.mwsAuthToken = mwsAuthToken;
		return this;
	}

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
	public ListRecommendationsRequest withSellerId(String sellerId) {
		this.sellerId = sellerId;
		return this;
	}

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
	public ListRecommendationsRequest withRecommendationCategory(
			String recommendationCategory) {
		this.recommendationCategory = recommendationCategory;
		return this;
	}

	/**
	 * Get the value of CategoryQueryList.
	 *
	 * @return The value of CategoryQueryList.
	 */
	public List<CategoryQuery> getCategoryQueryList() {
		if (categoryQueryList == null) {
			categoryQueryList = new ArrayList<CategoryQuery>();
		}
		return categoryQueryList;
	}

	/**
	 * Set the value of CategoryQueryList.
	 *
	 * @param categoryQueryList
	 *            The new value to set.
	 */
	public void setCategoryQueryList(List<CategoryQuery> categoryQueryList) {
		this.categoryQueryList = categoryQueryList;
	}

	/**
	 * Clear CategoryQueryList.
	 */
	public void unsetCategoryQueryList() {
		this.categoryQueryList = null;
	}

	/**
	 * Check to see if CategoryQueryList is set.
	 *
	 * @return true if CategoryQueryList is set.
	 */
	public boolean isSetCategoryQueryList() {
		return categoryQueryList != null && !categoryQueryList.isEmpty();
	}

	/**
	 * Add values for CategoryQueryList, return this.
	 *
	 * @param categoryQueryList
	 *            New values to add.
	 *
	 * @return This instance.
	 */
	public ListRecommendationsRequest withCategoryQueryList(
			CategoryQuery... values) {
		List<CategoryQuery> list = getCategoryQueryList();
		for (CategoryQuery value : values) {
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
		marketplaceId = r.read("MarketplaceId", String.class);
		mwsAuthToken = r.read("MWSAuthToken", String.class);
		sellerId = r.read("SellerId", String.class);
		recommendationCategory = r.read("RecommendationCategory", String.class);
		categoryQueryList = r.readList("CategoryQueryList", "CategoryQuery",
				CategoryQuery.class);
	}

	/**
	 * Write members to a MwsWriter.
	 *
	 * @param w
	 *            The writer to write to.
	 */
	@Override
	public void writeFragmentTo(MwsWriter w) {
		w.write("MarketplaceId", marketplaceId);
		w.write("MWSAuthToken", mwsAuthToken);
		w.write("SellerId", sellerId);
		w.write("RecommendationCategory", recommendationCategory);
		w.writeList("CategoryQueryList", "CategoryQuery", categoryQueryList);
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
				"ListRecommendationsRequest", this);
	}

	/** Value constructor. */
	public ListRecommendationsRequest(String marketplaceId,
			String mwsAuthToken, String sellerId,
			String recommendationCategory, List<CategoryQuery> categoryQueryList) {
		this.marketplaceId = marketplaceId;
		this.mwsAuthToken = mwsAuthToken;
		this.sellerId = sellerId;
		this.recommendationCategory = recommendationCategory;
		this.categoryQueryList = categoryQueryList;
	}

	/** Legacy value constructor. */
	public ListRecommendationsRequest(String marketplaceId, String sellerId,
			String recommendationCategory, List<CategoryQuery> categoryQueryList) {
		this.marketplaceId = marketplaceId;
		this.sellerId = sellerId;
		this.recommendationCategory = recommendationCategory;
		this.categoryQueryList = categoryQueryList;
	}

	/** Default constructor. */
	public ListRecommendationsRequest() {
		super();
	}

	public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
		return null;
	}

	public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd) {
	}

}
