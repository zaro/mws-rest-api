package co.amasel.model.products;
import com.amazonservices.mws.client.MwsResponseHeaderMetadata;
import co.amasel.model.common.AmaselMwsObject;
import com.amazonservices.mws.products.model.ResponseHeaderMetadata;


public class GetServiceStatusResponse extends com.amazonservices.mws.products.model.GetServiceStatusResponse implements AmaselMwsObject {
    public GetServiceStatusResponse() {
        super();
    }

    
    public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
        return getResponseHeaderMetadata();
    }
    public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd){
        setResponseHeaderMetadata(new ResponseHeaderMetadata(hmd));
    }
    
}
