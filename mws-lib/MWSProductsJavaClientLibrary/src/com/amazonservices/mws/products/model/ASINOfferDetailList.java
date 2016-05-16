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
 * ASIN Offer Detail List
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
 * ASINOfferDetailList complex type.
 *
 * XML schema:
 *
 * <pre>
 * &lt;complexType name="ASINOfferDetailList"&gt;
 *    &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *          &lt;sequence&gt;
 *             &lt;element name="Offer" type="{http://mws.amazonservices.com/schema/Products/2011-10-01}ASINOfferDetail" maxOccurs="unbounded"/&gt;
 *          &lt;/sequence&gt;
 *       &lt;/restriction&gt;
 *    &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ASINOfferDetailList", propOrder={
    "offer"
})
@XmlRootElement(name = "ASINOfferDetailList")
public class ASINOfferDetailList extends AbstractMwsObject {

    @XmlElement(name="Offer")
    private List<ASINOfferDetail> offer;

    /**
     * Get the value of Offer.
     *
     * @return The value of Offer.
     */
    public List<ASINOfferDetail> getOffer() {
        if (offer==null) {
            offer = new ArrayList<ASINOfferDetail>();
        }
        return offer;
    }

    /**
     * Set the value of Offer.
     *
     * @param offer
     *            The new value to set.
     */
    public void setOffer(List<ASINOfferDetail> offer) {
        this.offer = offer;
    }

    /**
     * Clear Offer.
     */
    public void unsetOffer() {
        this.offer = null;
    }

    /**
     * Check to see if Offer is set.
     *
     * @return true if Offer is set.
     */
    public boolean isSetOffer() {
        return offer != null && !offer.isEmpty();
    }

    /**
     * Add values for Offer, return this.
     *
     * @param offer
     *             New values to add.
     *
     * @return This instance.
     */
    public ASINOfferDetailList withOffer(ASINOfferDetail... values) {
        List<ASINOfferDetail> list = getOffer();
        for (ASINOfferDetail value : values) {
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
        offer = r.readList("Offer", ASINOfferDetail.class);
    }

    /**
     * Write members to a MwsWriter.
     *
     * @param w
     *      The writer to write to.
     */
    @Override
    public void writeFragmentTo(MwsWriter w) {
        w.writeList("Offer", offer);
    }

    /**
     * Write tag, xmlns and members to a MwsWriter.
     *
     * @param w
     *         The Writer to write to.
     */
    @Override
    public void writeTo(MwsWriter w) {
        w.write("http://mws.amazonservices.com/schema/Products/2011-10-01", "ASINOfferDetailList",this);
    }

    /** Value constructor. */
    public ASINOfferDetailList(List<ASINOfferDetail> offer) {
        this.offer = offer;
    }    
    

    /** Default constructor. */
    public ASINOfferDetailList() {
        super();
    }

}
