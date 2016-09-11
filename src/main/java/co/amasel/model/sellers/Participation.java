package co.amasel.model.sellers;
import com.amazonservices.mws.client.MwsResponseHeaderMetadata;
import co.amasel.model.common.AmaselMwsObject;
import com.amazonservices.mws.sellers.model.ResponseHeaderMetadata;


public class Participation extends com.amazonservices.mws.sellers.model.Participation implements AmaselMwsObject {
    public Participation() {
        super();
    }

    
    public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
        return null;
    }
    public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd){
    }
    
}
