package co.amasel.model.products;
import com.amazonservices.mws.client.MwsResponseHeaderMetadata;
import co.amasel.model.common.AmaselMwsObject;
import com.amazonservices.mws.products.model.ResponseHeaderMetadata;


public class GetProductCategoriesForSKUResponse extends com.amazonservices.mws.products.model.GetProductCategoriesForSKUResponse implements AmaselMwsObject {
    public GetProductCategoriesForSKUResponse() {
        super();
    }

    
    public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
        return getResponseHeaderMetadata();
    }
    public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd){
        setResponseHeaderMetadata(new ResponseHeaderMetadata(hmd));
    }
    
}
