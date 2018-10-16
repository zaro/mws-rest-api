# mws-rest-api

mws-rest-api is a proxy that let's you use the legacy Amazon MWS API trough a modern UTF8 REST api.

# Building 

Building required Java 8 JDK. 

    ./gradlew :installDist

# Configuration

Configuration file is located at cfg/config.json.

Example:
```json
{
  "ssl" : {
  },
  "port" : 8181,
  "admins" : {
    "admin" : true
  }
}
```

This will start the proxy w/o ssl on port 8181 and with a single admin user admin, that can access the proxy w/o password.

# Running

Start with:

    build/install/mws-rest-api/bin/mws-rest-api

# Usage 

Create a preset with credentials. While this step is not strictly necessary, it allows to simply use the preset name and not pass the amazon credential on each request.


    curl -d '{"MarketplaceId":"A1F83G8C2ARO7P","MarketplaceIdList":["A1F83G8C2ARO7P"],"SellerId":"A1XXXX","_awsAccessKey":"XXX","_awsSecretKey":"XXX"}' admin@localhost:8181/presets/my-preset

List Orders:

    curl -d '{"CreatedAfter": "2018-10-12"}' 'admin@localhost:8181/mws/orders/ListOrders?preset=my-preset&pretty'

```json
    {
    "result" : {
        "NextToken" : null,
        "CreatedBefore" : "2018-10-16T18:19:14.267Z",
        "LastUpdatedBefore" : null,
        "Orders" : [ {
            "AmazonOrderId" : "204-4718648-3577129",
            "SellerOrderId" : null,
            "PurchaseDate" : "2018-10-12T09:29:55.731Z",
            "LastUpdateDate" : "2018-10-13T15:00:19.053Z",
            "OrderStatus" : "Shipped",
            "FulfillmentChannel" : "MFN",
            "SalesChannel" : "Amazon.co.uk",
            "OrderChannel" : null,
            "ShipServiceLevel" : "Std UK Dom_5",
            "ShippingAddress" : {
                "Name" : "XXXX XXXX",
                "AddressLine1" : "XX XXXXX",
                "AddressLine2" : "XXXXX, XXXXXXX",
                "AddressLine3" : null,
                "City" : "XXXXXXXXXX",
                "County" : null,
                "District" : null,
                "StateOrRegion" : "XXXXX",
                "PostalCode" : "XXXX XXX",
                "CountryCode" : "GB",
                "Phone" : "XXXXXXXXXX"
            },
            "OrderTotal" : {
                "CurrencyCode" : "GBP",
                "Amount" : "2.99"
            },
            "NumberOfItemsShipped" : 1,
            "NumberOfItemsUnshipped" : 0,
            "PaymentExecutionDetail" : [ ],
            "PaymentMethod" : "Other",
            "MarketplaceId" : "A1F83G8C2ARO7P",
            "BuyerEmail" : "xxxxxxxx@marketplace.amazon.co.uk",
            "BuyerName" : "xxxxxx xxxxx",
            "ShipmentServiceLevelCategory" : "Standard",
            "ShippedByAmazonTFM" : false,
            "TFMShipmentStatus" : null,
            "CbaDisplayableShippingLabel" : null,
            "OrderType" : "StandardOrder",
            "EarliestShipDate" : "2018-10-14T23:00:00Z",
            "LatestShipDate" : "2018-10-16T22:59:59Z",
            "EarliestDeliveryDate" : "2018-11-02T00:00:00Z",
            "LatestDeliveryDate" : "2018-11-14T23:59:59Z",
            "IsBusinessOrder" : false,
            "PurchaseOrderNumber" : null,
            "IsPrime" : false,
            "IsPremiumOrder" : false
            } ]
        }
    }
```

Supported APIS are :

- /mws/orders/{methodName}
- /mws/feeds/{methodName}
- /mws/products/{methodName}
- /mws/reports/{methodName}
- /mws/sellers/{methodName}
- /mws/recommendations/{methodName}

For list of the method names check the official MWS documentation: https://developer.amazonservices.com/

The arguments to the methods should be passed as JSON in the post request.

# Documentation

**TODO**

# Author

Svetlozar Argirov <zarrro@gmail.com>