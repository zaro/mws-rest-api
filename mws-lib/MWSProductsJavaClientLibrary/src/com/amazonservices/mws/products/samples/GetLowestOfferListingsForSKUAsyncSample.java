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
 * Marketplace Web Service Products
 * API Version: 2011-10-01
 * Library Version: 2015-09-01
 * Generated: Thu Sep 10 06:52:13 PDT 2015
 */
package com.amazonservices.mws.products.samples;

import java.util.*;
import java.util.concurrent.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;

import com.amazonservices.mws.client.*;
import com.amazonservices.mws.products.*;
import com.amazonservices.mws.products.model.*;

/** Sample async call for GetLowestOfferListingsForSKU. */
public class GetLowestOfferListingsForSKUAsyncSample {

    /**
     * Call the service, log response and exceptions.
     *
     * @param client
     * @param request
     *
     * @return The response.
     */
    public static List<Object> invokeGetLowestOfferListingsForSKU(
            MarketplaceWebServiceProductsAsync client, 
            List<GetLowestOfferListingsForSKURequest> requestList) {
        // Call the service async.
        List<Future<GetLowestOfferListingsForSKUResponse>> futureList = 
            new ArrayList<Future<GetLowestOfferListingsForSKUResponse>>();
        for (GetLowestOfferListingsForSKURequest request : requestList) {
            Future<GetLowestOfferListingsForSKUResponse> future = 
                client.getLowestOfferListingsForSKUAsync(request);
            futureList.add(future);
        }
        List<Object> responseList = new ArrayList<Object>();
        for (Future<GetLowestOfferListingsForSKUResponse> future : futureList) {
            Object xresponse;
            try {
                GetLowestOfferListingsForSKUResponse response = future.get();
                ResponseHeaderMetadata rhmd = response.getResponseHeaderMetadata();
                // We recommend logging every the request id and timestamp of every call.
                System.out.println("Response:");
                System.out.println("RequestId: "+rhmd.getRequestId());
                System.out.println("Timestamp: "+rhmd.getTimestamp());
                String responseXml = response.toXML();
                System.out.println(responseXml);
                xresponse = response;
            } catch (ExecutionException ee) {
                Throwable cause = ee.getCause();
                if (cause instanceof MarketplaceWebServiceProductsException) {
                    // Exception properties are important for diagnostics.
                    MarketplaceWebServiceProductsException ex = 
                        (MarketplaceWebServiceProductsException)cause;
                    ResponseHeaderMetadata rhmd = ex.getResponseHeaderMetadata();
                    System.out.println("Service Exception:");
                    System.out.println("RequestId: "+rhmd.getRequestId());
                    System.out.println("Timestamp: "+rhmd.getTimestamp());
                    System.out.println("Message: "+ex.getMessage());
                    System.out.println("StatusCode: "+ex.getStatusCode());
                    System.out.println("ErrorCode: "+ex.getErrorCode());
                    System.out.println("ErrorType: "+ex.getErrorType());
                    xresponse = ex;
                } else {
                    xresponse = cause;
                }
            } catch (Exception e) {
                xresponse = e;
            }
            responseList.add(xresponse);
        }
        return responseList;
    }

    /**
     *  Command line entry point.
     */
    public static void main(String[] args) {

        // Get a client connection.
        MarketplaceWebServiceProductsAsyncClient client = MarketplaceWebServiceProductsSampleConfig.getAsyncClient();

        // Create a request list.
        List<GetLowestOfferListingsForSKURequest> requestList = new ArrayList<GetLowestOfferListingsForSKURequest>();
        GetLowestOfferListingsForSKURequest request = new GetLowestOfferListingsForSKURequest();
        String sellerId = "example";
        request.setSellerId(sellerId);
        String mwsAuthToken = "example";
        request.setMWSAuthToken(mwsAuthToken);
        String marketplaceId = "example";
        request.setMarketplaceId(marketplaceId);
        SellerSKUListType sellerSKUList = new SellerSKUListType();
        request.setSellerSKUList(sellerSKUList);
        String itemCondition = "example";
        request.setItemCondition(itemCondition);
        Boolean excludeMe = Boolean.valueOf(true);
        request.setExcludeMe(excludeMe);
        requestList.add(request);

        // Make the calls.
        GetLowestOfferListingsForSKUAsyncSample.invokeGetLowestOfferListingsForSKU(client, requestList);

    }

}
