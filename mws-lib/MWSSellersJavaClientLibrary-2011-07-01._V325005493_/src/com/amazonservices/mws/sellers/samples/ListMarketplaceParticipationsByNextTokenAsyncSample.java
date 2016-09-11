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
 * Marketplace Web Service Sellers
 * API Version: 2011-07-01
 * Library Version: 2014-09-30
 * Generated: Mon Sep 15 19:38:38 GMT 2014
 */
package com.amazonservices.mws.sellers.samples;

import java.util.*;
import java.util.concurrent.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;

import com.amazonservices.mws.client.*;
import com.amazonservices.mws.sellers.*;
import com.amazonservices.mws.sellers.model.*;

/** Sample async call for ListMarketplaceParticipationsByNextToken. */
public class ListMarketplaceParticipationsByNextTokenAsyncSample {

    /**
     * Call the service, log response and exceptions.
     *
     * @param client
     * @param request
     *
     * @return The response.
     */
    public static List<Object> invokeListMarketplaceParticipationsByNextToken(
            MarketplaceWebServiceSellersAsync client, 
            List<ListMarketplaceParticipationsByNextTokenRequest> requestList) {
        // Call the service async.
        List<Future<ListMarketplaceParticipationsByNextTokenResponse>> futureList = 
            new ArrayList<Future<ListMarketplaceParticipationsByNextTokenResponse>>();
        for (ListMarketplaceParticipationsByNextTokenRequest request : requestList) {
            Future<ListMarketplaceParticipationsByNextTokenResponse> future = 
                client.listMarketplaceParticipationsByNextTokenAsync(request);
            futureList.add(future);
        }
        List<Object> responseList = new ArrayList<Object>();
        for (Future<ListMarketplaceParticipationsByNextTokenResponse> future : futureList) {
            Object xresponse;
            try {
                ListMarketplaceParticipationsByNextTokenResponse response = future.get();
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
                if (cause instanceof MarketplaceWebServiceSellersException) {
                    // Exception properties are important for diagnostics.
                    MarketplaceWebServiceSellersException ex = 
                        (MarketplaceWebServiceSellersException)cause;
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
        MarketplaceWebServiceSellersAsyncClient client = MarketplaceWebServiceSellersSampleConfig.getAsyncClient();

        // Create a request list.
        List<ListMarketplaceParticipationsByNextTokenRequest> requestList = new ArrayList<ListMarketplaceParticipationsByNextTokenRequest>();
        ListMarketplaceParticipationsByNextTokenRequest request = new ListMarketplaceParticipationsByNextTokenRequest();
        String sellerId = "example";
        request.setSellerId(sellerId);
        String mwsAuthToken = "example";
        request.setMWSAuthToken(mwsAuthToken);
        String nextToken = "example";
        request.setNextToken(nextToken);
        requestList.add(request);

        // Make the calls.
        ListMarketplaceParticipationsByNextTokenAsyncSample.invokeListMarketplaceParticipationsByNextToken(client, requestList);

    }

}
