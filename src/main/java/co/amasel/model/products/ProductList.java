package co.amasel.model.products;
import com.amazonservices.mws.client.MwsResponseHeaderMetadata;
import co.amasel.model.common.AmaselMwsObject;
import com.amazonservices.mws.products.model.ResponseHeaderMetadata;


public class ProductList extends com.amazonservices.mws.products.model.ProductList implements AmaselMwsObject {
    public ProductList() {
        super();
    }

    
    public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
        return null;
    }
    public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd){
    }
    
}
