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
 * Relationship List
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
 * RelationshipList complex type.
 *
 * XML schema:
 *
 * <pre>
 * &lt;complexType name="RelationshipList"&gt;
 *    &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *          &lt;sequence&gt;
 *             &lt;any/&gt;
 *          &lt;/sequence&gt;
 *       &lt;/restriction&gt;
 *    &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="RelationshipList", propOrder={
    "any"
})
@XmlRootElement(name = "RelationshipList")
public class RelationshipList extends AbstractMwsObject {

    @XmlAnyElement(lax=true)
    private List<Object> any;

    /**
     * Get the value of Any.
     *
     * @return The value of Any.
     */
    public List<Object> getAny() {
        if (any==null) {
            any = new ArrayList<Object>();
        }
        return any;
    }

    /**
     * Set the value of Any.
     *
     * @param any
     *            The new value to set.
     */
    public void setAny(List<Object> any) {
        this.any = any;
    }

    /**
     * Clear Any.
     */
    public void unsetAny() {
        this.any = null;
    }

    /**
     * Check to see if Any is set.
     *
     * @return true if Any is set.
     */
    public boolean isSetAny() {
        return any != null && !any.isEmpty();
    }

    /**
     * Add values for Any, return this.
     *
     * @param any
     *             New values to add.
     *
     * @return This instance.
     */
    public RelationshipList withAny(Object... values) {
        List<Object> list = getAny();
        for (Object value : values) {
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
    @SuppressWarnings("unchecked")
    @Override
    public void readFragmentFrom(MwsReader r) {
        any = (List<Object>)(Object)r.readAny();
    }

    /**
     * Write members to a MwsWriter.
     *
     * @param w
     *      The writer to write to.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void writeFragmentTo(MwsWriter w) {
        w.writeAny((List<org.w3c.dom.Element>)(Object)any);
    }

    /**
     * Write tag, xmlns and members to a MwsWriter.
     *
     * @param w
     *         The Writer to write to.
     */
    @Override
    public void writeTo(MwsWriter w) {
        w.write("http://mws.amazonservices.com/schema/Products/2011-10-01", "RelationshipList",this);
    }

    /** Value constructor. */
    public RelationshipList(List<Object> any) {
        this.any = any;
    }    
    

    /** Default constructor. */
    public RelationshipList() {
        super();
    }

}
