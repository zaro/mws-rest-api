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
 * Number Of Offers
 * API Version: 2011-10-01
 * Library Version: 2015-09-01
 * Generated: Thu Sep 10 06:52:13 PDT 2015
 */
package com.amazonservices.mws.products.model;

import java.util.List;
import java.util.ArrayList;

import javax.xml.bind.annotation.*;

import com.amazonservices.mws.client.*;

/**
 * NumberOfOffers complex type.
 *
 * XML schema:
 *
 * <pre>
 * &lt;complexType name="NumberOfOffers"&gt;
 *    &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *          &lt;sequence&gt;
 *             &lt;element name="OfferCount" type="{http://mws.amazonservices.com/schema/Products/2011-10-01}OfferCountType" maxOccurs="unbounded"/&gt;
 *          &lt;/sequence&gt;
 *       &lt;/restriction&gt;
 *    &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="NumberOfOffers", propOrder={
    "offerCount"
})
@XmlRootElement(name = "NumberOfOffers")
public class NumberOfOffers extends AbstractMwsObject {

    @XmlElement(name="OfferCount")
    private List<OfferCountType> offerCount;

    /**
     * Get the value of OfferCount.
     *
     * @return The value of OfferCount.
     */
    public List<OfferCountType> getOfferCount() {
        if (offerCount==null) {
            offerCount = new ArrayList<OfferCountType>();
        }
        return offerCount;
    }

    /**
     * Set the value of OfferCount.
     *
     * @param offerCount
     *            The new value to set.
     */
    public void setOfferCount(List<OfferCountType> offerCount) {
        this.offerCount = offerCount;
    }

    /**
     * Clear OfferCount.
     */
    public void unsetOfferCount() {
        this.offerCount = null;
    }

    /**
     * Check to see if OfferCount is set.
     *
     * @return true if OfferCount is set.
     */
    public boolean isSetOfferCount() {
        return offerCount != null && !offerCount.isEmpty();
    }

    /**
     * Add values for OfferCount, return this.
     *
     * @param offerCount
     *             New values to add.
     *
     * @return This instance.
     */
    public NumberOfOffers withOfferCount(OfferCountType... values) {
        List<OfferCountType> list = getOfferCount();
        for (OfferCountType value : values) {
            list.add(value);
        }
        return this;
    }

    /**
     * Read members from a MwsReader.
     *
     * @param r
     *      The reader to read from.
     */
    @Override
    public void readFragmentFrom(MwsReader r) {
        offerCount = r.readList("OfferCount", OfferCountType.class);
    }

    /**
     * Write members to a MwsWriter.
     *
     * @param w
     *      The writer to write to.
     */
    @Override
    public void writeFragmentTo(MwsWriter w) {
        w.writeList("OfferCount", offerCount);
    }

    /**
     * Write tag, xmlns and members to a MwsWriter.
     *
     * @param w
     *         The Writer to write to.
     */
    @Override
    public void writeTo(MwsWriter w) {
        w.write("http://mws.amazonservices.com/schema/Products/2011-10-01", "NumberOfOffers",this);
    }

    /** Value constructor. */
    public NumberOfOffers(List<OfferCountType> offerCount) {
        this.offerCount = offerCount;
    }    
    

    /** Default constructor. */
    public NumberOfOffers() {
        super();
    }

}
