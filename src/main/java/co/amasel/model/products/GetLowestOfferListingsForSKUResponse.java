package co.amasel.model.products;
import com.amazonservices.mws.client.MwsResponseHeaderMetadata;
import co.amasel.model.common.AmaselMwsObject;
import com.amazonservices.mws.products.model.ResponseHeaderMetadata;


public class GetLowestOfferListingsForSKUResponse extends com.amazonservices.mws.products.model.GetLowestOfferListingsForSKUResponse implements AmaselMwsObject {
    public GetLowestOfferListingsForSKUResponse() {
        super();
    }

    
    public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
        return getResponseHeaderMetadata();
    }
    public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd){
        setResponseHeaderMetadata(new ResponseHeaderMetadata(hmd));
    }
    
}
