package co.amasel.model.sellers;
import com.amazonservices.mws.client.MwsResponseHeaderMetadata;
import co.amasel.model.common.AmaselMwsObject;
import com.amazonservices.mws.sellers.model.ResponseHeaderMetadata;


public class ListMarketplaceParticipationsResponse extends com.amazonservices.mws.sellers.model.ListMarketplaceParticipationsResponse implements AmaselMwsObject {
    public ListMarketplaceParticipationsResponse() {
        super();
    }

    
    public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
        return getResponseHeaderMetadata();
    }
    public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd){
        setResponseHeaderMetadata(new ResponseHeaderMetadata(hmd));
    }
    
}
