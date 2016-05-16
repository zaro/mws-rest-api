package co.amasel.model.orders;
import com.amazonservices.mws.client.MwsResponseHeaderMetadata;
import co.amasel.model.common.AmaselMwsObject;
import com.amazonservices.mws.orders._2013_09_01.model.ResponseHeaderMetadata;


public class ListOrderItemsByNextTokenResponse extends com.amazonservices.mws.orders._2013_09_01.model.ListOrderItemsByNextTokenResponse implements AmaselMwsObject {
    public ListOrderItemsByNextTokenResponse() {
        super();
    }

    
    public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
        return getResponseHeaderMetadata();
    }
    public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd){
        setResponseHeaderMetadata(new ResponseHeaderMetadata(hmd));
    }
    
}
