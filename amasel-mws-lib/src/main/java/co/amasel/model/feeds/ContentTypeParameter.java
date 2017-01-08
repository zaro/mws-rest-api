package co.amasel.model.feeds;

import co.amasel.model.common.AmaselMwsObject;
import co.amasel.model.common.ResponseHeaderMetadata;
import co.amasel.model.common.ResponseMetadata;
import com.amazonservices.mws.client.MwsReader;
import com.amazonservices.mws.client.MwsWriter;
import com.amazonservices.mws.client.MwsResponseHeaderMetadata;

/*
 * Interface for Content-Type parameters that are appended to the Content-Type;
 * e.g. "charset=utf-8".
 * 
 * The toString method should be overriden to output the correct value in
 * key/value pair format separated by an equals sign.
 */
public interface ContentTypeParameter {

}
