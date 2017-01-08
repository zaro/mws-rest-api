package co.amasel.model.feeds;

import java.util.Collection;
import java.util.HashSet;
import co.amasel.model.common.AmaselMwsObject;
import co.amasel.model.common.ResponseHeaderMetadata;
import co.amasel.model.common.ResponseMetadata;
import com.amazonservices.mws.client.MwsReader;
import com.amazonservices.mws.client.MwsWriter;
import com.amazonservices.mws.client.MwsResponseHeaderMetadata;

/*
 * Enumeration of valid content types for a feed submission.
 */
public enum ContentType {
	/*
	 * Feed is sent as a stream of bytes ("application/octet-stream"). Currently
	 * this is the only content type supported by MWS.
	 */
	OctetStream("application/octet-stream");

	private String value;
	private Collection<ContentTypeParameter> parameters = new HashSet<ContentTypeParameter>();

	private ContentType(String s) {
		this.value = s;
	}

	@SuppressWarnings("unused")
	private void addParameter(ContentTypeParameter parameter) {
		parameters.add(parameter);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(this.value);

		for (ContentTypeParameter p : parameters) {
			sb.append(";").append(p);
		}

		return sb.toString();
	}

}
