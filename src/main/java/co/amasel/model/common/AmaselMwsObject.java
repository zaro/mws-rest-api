package co.amasel.model.common;

import com.amazonservices.mws.client.MwsObject;
import com.amazonservices.mws.client.MwsResponseHeaderMetadata;

/**
 * Created by zaro on 5/14/16.
 */
public interface AmaselMwsObject extends MwsObject{
    MwsResponseHeaderMetadata getMwsHeaderMetadata();
    void setMwsHeaderMetadata(MwsResponseHeaderMetadata hdm);
}
