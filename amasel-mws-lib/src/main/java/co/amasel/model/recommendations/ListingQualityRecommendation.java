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
 * Listing Quality Recommendation
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
 * ListingQualityRecommendation complex type.
 *
 * XML schema:
 *
 * <pre>
 * &lt;complexType name="ListingQualityRecommendation"&gt;
 *    &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *          &lt;sequence&gt;
 *             &lt;element name="QualitySet" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *             &lt;element name="DefectGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="DefectAttribute" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="ItemIdentifier" type="{https://mws.amazonservices.com/Recommendations/2013-04-01}ProductIdentifier"/&gt;
 *             &lt;element name="ItemName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="RecommendationId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *             &lt;element name="RecommendationReason" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *          &lt;/sequence&gt;
 *       &lt;/restriction&gt;
 *    &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class ListingQualityRecommendation extends AmaselMwsObject {

	private String qualitySet;

	private String defectGroup;

	private String defectAttribute;

	private ProductIdentifier itemIdentifier;

	private String itemName;

	private String recommendationId;

	private String recommendationReason;

	/**
	 * Get the value of QualitySet.
	 *
	 * @return The value of QualitySet.
	 */
	public String getQualitySet() {
		return qualitySet;
	}

	/**
	 * Set the value of QualitySet.
	 *
	 * @param qualitySet
	 *            The new value to set.
	 */
	public void setQualitySet(String qualitySet) {
		this.qualitySet = qualitySet;
	}

	/**
	 * Check to see if QualitySet is set.
	 *
	 * @return true if QualitySet is set.
	 */
	public boolean isSetQualitySet() {
		return qualitySet != null;
	}

	/**
	 * Set the value of QualitySet, return this.
	 *
	 * @param qualitySet
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public ListingQualityRecommendation withQualitySet(String qualitySet) {
		this.qualitySet = qualitySet;
		return this;
	}

	/**
	 * Get the value of DefectGroup.
	 *
	 * @return The value of DefectGroup.
	 */
	public String getDefectGroup() {
		return defectGroup;
	}

	/**
	 * Set the value of DefectGroup.
	 *
	 * @param defectGroup
	 *            The new value to set.
	 */
	public void setDefectGroup(String defectGroup) {
		this.defectGroup = defectGroup;
	}

	/**
	 * Check to see if DefectGroup is set.
	 *
	 * @return true if DefectGroup is set.
	 */
	public boolean isSetDefectGroup() {
		return defectGroup != null;
	}

	/**
	 * Set the value of DefectGroup, return this.
	 *
	 * @param defectGroup
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public ListingQualityRecommendation withDefectGroup(String defectGroup) {
		this.defectGroup = defectGroup;
		return this;
	}

	/**
	 * Get the value of DefectAttribute.
	 *
	 * @return The value of DefectAttribute.
	 */
	public String getDefectAttribute() {
		return defectAttribute;
	}

	/**
	 * Set the value of DefectAttribute.
	 *
	 * @param defectAttribute
	 *            The new value to set.
	 */
	public void setDefectAttribute(String defectAttribute) {
		this.defectAttribute = defectAttribute;
	}

	/**
	 * Check to see if DefectAttribute is set.
	 *
	 * @return true if DefectAttribute is set.
	 */
	public boolean isSetDefectAttribute() {
		return defectAttribute != null;
	}

	/**
	 * Set the value of DefectAttribute, return this.
	 *
	 * @param defectAttribute
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public ListingQualityRecommendation withDefectAttribute(
			String defectAttribute) {
		this.defectAttribute = defectAttribute;
		return this;
	}

	/**
	 * Get the value of ItemIdentifier.
	 *
	 * @return The value of ItemIdentifier.
	 */
	public ProductIdentifier getItemIdentifier() {
		return itemIdentifier;
	}

	/**
	 * Set the value of ItemIdentifier.
	 *
	 * @param itemIdentifier
	 *            The new value to set.
	 */
	public void setItemIdentifier(ProductIdentifier itemIdentifier) {
		this.itemIdentifier = itemIdentifier;
	}

	/**
	 * Check to see if ItemIdentifier is set.
	 *
	 * @return true if ItemIdentifier is set.
	 */
	public boolean isSetItemIdentifier() {
		return itemIdentifier != null;
	}

	/**
	 * Set the value of ItemIdentifier, return this.
	 *
	 * @param itemIdentifier
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public ListingQualityRecommendation withItemIdentifier(
			ProductIdentifier itemIdentifier) {
		this.itemIdentifier = itemIdentifier;
		return this;
	}

	/**
	 * Get the value of ItemName.
	 *
	 * @return The value of ItemName.
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * Set the value of ItemName.
	 *
	 * @param itemName
	 *            The new value to set.
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * Check to see if ItemName is set.
	 *
	 * @return true if ItemName is set.
	 */
	public boolean isSetItemName() {
		return itemName != null;
	}

	/**
	 * Set the value of ItemName, return this.
	 *
	 * @param itemName
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public ListingQualityRecommendation withItemName(String itemName) {
		this.itemName = itemName;
		return this;
	}

	/**
	 * Get the value of RecommendationId.
	 *
	 * @return The value of RecommendationId.
	 */
	public String getRecommendationId() {
		return recommendationId;
	}

	/**
	 * Set the value of RecommendationId.
	 *
	 * @param recommendationId
	 *            The new value to set.
	 */
	public void setRecommendationId(String recommendationId) {
		this.recommendationId = recommendationId;
	}

	/**
	 * Check to see if RecommendationId is set.
	 *
	 * @return true if RecommendationId is set.
	 */
	public boolean isSetRecommendationId() {
		return recommendationId != null;
	}

	/**
	 * Set the value of RecommendationId, return this.
	 *
	 * @param recommendationId
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public ListingQualityRecommendation withRecommendationId(
			String recommendationId) {
		this.recommendationId = recommendationId;
		return this;
	}

	/**
	 * Get the value of RecommendationReason.
	 *
	 * @return The value of RecommendationReason.
	 */
	public String getRecommendationReason() {
		return recommendationReason;
	}

	/**
	 * Set the value of RecommendationReason.
	 *
	 * @param recommendationReason
	 *            The new value to set.
	 */
	public void setRecommendationReason(String recommendationReason) {
		this.recommendationReason = recommendationReason;
	}

	/**
	 * Check to see if RecommendationReason is set.
	 *
	 * @return true if RecommendationReason is set.
	 */
	public boolean isSetRecommendationReason() {
		return recommendationReason != null;
	}

	/**
	 * Set the value of RecommendationReason, return this.
	 *
	 * @param recommendationReason
	 *            The new value to set.
	 *
	 * @return This instance.
	 */
	public ListingQualityRecommendation withRecommendationReason(
			String recommendationReason) {
		this.recommendationReason = recommendationReason;
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
		qualitySet = r.read("QualitySet", String.class);
		defectGroup = r.read("DefectGroup", String.class);
		defectAttribute = r.read("DefectAttribute", String.class);
		itemIdentifier = r.read("ItemIdentifier", ProductIdentifier.class);
		itemName = r.read("ItemName", String.class);
		recommendationId = r.read("RecommendationId", String.class);
		recommendationReason = r.read("RecommendationReason", String.class);
	}

	/**
	 * Write members to a MwsWriter.
	 *
	 * @param w
	 *            The writer to write to.
	 */
	@Override
	public void writeFragmentTo(MwsWriter w) {
		w.write("QualitySet", qualitySet);
		w.write("DefectGroup", defectGroup);
		w.write("DefectAttribute", defectAttribute);
		w.write("ItemIdentifier", itemIdentifier);
		w.write("ItemName", itemName);
		w.write("RecommendationId", recommendationId);
		w.write("RecommendationReason", recommendationReason);
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
				"ListingQualityRecommendation", this);
	}

	/** Value constructor. */
	public ListingQualityRecommendation(String qualitySet, String defectGroup,
			String defectAttribute, ProductIdentifier itemIdentifier,
			String itemName, String recommendationId,
			String recommendationReason) {
		this.qualitySet = qualitySet;
		this.defectGroup = defectGroup;
		this.defectAttribute = defectAttribute;
		this.itemIdentifier = itemIdentifier;
		this.itemName = itemName;
		this.recommendationId = recommendationId;
		this.recommendationReason = recommendationReason;
	}

	/** Default constructor. */
	public ListingQualityRecommendation() {
		super();
	}

	public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
		return null;
	}

	public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd) {
	}

}
