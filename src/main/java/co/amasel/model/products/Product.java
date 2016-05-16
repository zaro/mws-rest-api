package co.amasel.model.products;
import com.amazonservices.mws.client.MwsResponseHeaderMetadata;
import co.amasel.model.common.AmaselMwsObject;
import com.amazonservices.mws.products.model.ResponseHeaderMetadata;


public class Product extends com.amazonservices.mws.products.model.Product implements AmaselMwsObject {
    public Product() {
        super();
    }

    
    public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
        return null;
    }
    public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd){
    }
    
}
