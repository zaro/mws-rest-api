Some Vertx resources: https://github.com/vert-x3/vertx-awesome

Preset for amazon connection:

```json
    "result": {
        "MarketplaceIdList": [
            "A1F83G8C2ARO7P"
        ],
        "SellerId": "A1TTZQBWYZU16L",
        "_awsAccessKey": "XXXXXXXXXXXXXXX",
        "_awsSecretKey": "XXXXXXXXXXXXXXX"
    }
```

```shell
curl -d '{"MarketplaceId":"A1F83G8C2ARO7P","MarketplaceIdList":["A1F83G8C2ARO7P"],"SellerId":"A1TTZQBWYZU16L","_awsAccessKey":"XXXXXXXXXXXXXXX","_awsSecretKey":"XXXXXXXXXXXXXXX"}' localhost:8181/presets/funnyjunk
```

