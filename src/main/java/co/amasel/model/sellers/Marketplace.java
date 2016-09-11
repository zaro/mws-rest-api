package co.amasel.model.sellers;
import com.amazonservices.mws.client.MwsResponseHeaderMetadata;
import co.amasel.model.common.AmaselMwsObject;
import com.amazonservices.mws.sellers.model.ResponseHeaderMetadata;


public class Marketplace extends com.amazonservices.mws.sellers.model.Marketplace implements AmaselMwsObject {
    public Marketplace() {
        super();
    }

    
    public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
        return null;
    }
    public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd){
    }
    
}
