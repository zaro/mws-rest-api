package co.amasel.model.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import co.amasel.model.common.AmaselMwsObject;
import co.amasel.model.common.ResponseHeaderMetadata;
import co.amasel.model.common.ResponseMetadata;
import com.amazonservices.mws.client.MwsReader;
import com.amazonservices.mws.client.MwsWriter;
import com.amazonservices.mws.client.MwsResponseHeaderMetadata;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://mws.amazonaws.com/doc/2009-01-01/}GetReportRequestListResult"/>
 *         &lt;element ref="{http://mws.amazonaws.com/doc/2009-01-01/}ResponseMetadata"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * Generated by AWS Code Generator
 * <p/>
 * Wed Feb 18 13:28:59 PST 2009
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"getReportRequestListResult",
		"responseMetadata"})
@XmlRootElement(name = "GetReportRequestListResponse")
public class GetReportRequestListResponse extends AmaselMwsObject {

	@XmlElement(name = "GetReportRequestListResult", required = true)
	protected GetReportRequestListResult getReportRequestListResult;
	@XmlElement(name = "ResponseMetadata", required = true)
	protected ResponseMetadata responseMetadata;

	protected MwsResponseHeaderMetadata mwsResponseHeaderMetadata;

	/**
	 * Default constructor
	 * 
	 */
	public GetReportRequestListResponse() {
		super();
	}

	/**
	 * Value constructor
	 * 
	 */
	public GetReportRequestListResponse(
			final GetReportRequestListResult getReportRequestListResult,
			final ResponseMetadata responseMetadata) {
		this.getReportRequestListResult = getReportRequestListResult;
		this.responseMetadata = responseMetadata;
	}

	/**
	 * Gets the value of the getReportRequestListResult property.
	 * 
	 * @return possible object is {@link GetReportRequestListResult }
	 * 
	 */
	public GetReportRequestListResult getGetReportRequestListResult() {
		return getReportRequestListResult;
	}

	/**
	 * Sets the value of the getReportRequestListResult property.
	 * 
	 * @param value
	 *            allowed object is {@link GetReportRequestListResult }
	 * 
	 */
	public void setGetReportRequestListResult(GetReportRequestListResult value) {
		this.getReportRequestListResult = value;
	}

	public boolean isSetGetReportRequestListResult() {
		return (this.getReportRequestListResult != null);
	}

	/**
	 * Gets the value of the responseMetadata property.
	 * 
	 * @return possible object is {@link ResponseMetadata }
	 * 
	 */
	public ResponseMetadata getResponseMetadata() {
		return responseMetadata;
	}

	/**
	 * Sets the value of the responseMetadata property.
	 * 
	 * @param value
	 *            allowed object is {@link ResponseMetadata }
	 * 
	 */
	public void setResponseMetadata(ResponseMetadata value) {
		this.responseMetadata = value;
	}

	public boolean isSetResponseMetadata() {
		return (this.responseMetadata != null);
	}

	/**
	 * Sets the value of the GetReportRequestListResult property.
	 * 
	 * @param value
	 * @return this instance
	 */
	public GetReportRequestListResponse withGetReportRequestListResult(
			GetReportRequestListResult value) {
		setGetReportRequestListResult(value);
		return this;
	}

	/**
	 * Sets the value of the ResponseMetadata property.
	 * 
	 * @param value
	 * @return this instance
	 */
	public GetReportRequestListResponse withResponseMetadata(
			ResponseMetadata value) {
		setResponseMetadata(value);
		return this;
	}

	@javax.xml.bind.annotation.XmlTransient
	private ResponseHeaderMetadata responseHeaderMetadata;

	public boolean isSetResponseHeaderMetadata() {
		return this.responseHeaderMetadata != null;
	}

	public void setResponseHeaderMetadata(
			ResponseHeaderMetadata responseHeaderMetadata) {
		this.responseHeaderMetadata = responseHeaderMetadata;
	}

	public ResponseHeaderMetadata getResponseHeaderMetadata() {
		return responseHeaderMetadata;
	}

	/**
	 * 
	 * XML string representation of this object
	 * 
	 * @return XML String
	 */
	public String toXML() {
		StringBuffer xml = new StringBuffer();
		xml.append("<GetReportRequestListResponse xmlns=\"http://mws.amazonaws.com/doc/2009-01-01/\">");
		if (isSetGetReportRequestListResult()) {
			GetReportRequestListResult getReportRequestListResult = getGetReportRequestListResult();
			xml.append("<GetReportRequestListResult>");
			xml.append(getReportRequestListResult.toXMLFragment());
			xml.append("</GetReportRequestListResult>");
		}
		if (isSetResponseMetadata()) {
			ResponseMetadata responseMetadata = getResponseMetadata();
			xml.append("<ResponseMetadata>");
			xml.append(responseMetadata.toXMLFragment());
			xml.append("</ResponseMetadata>");
		}
		xml.append("</GetReportRequestListResponse>");
		return xml.toString();
	}

	/**
	 * 
	 * Escape XML special characters
	 */
	private String escapeXML(String string) {
		StringBuffer sb = new StringBuffer();
		int length = string.length();
		for (int i = 0; i < length; ++i) {
			char c = string.charAt(i);
			switch (c) {
				case '&' :
					sb.append("&amp;");
					break;
				case '<' :
					sb.append("&lt;");
					break;
				case '>' :
					sb.append("&gt;");
					break;
				case '\'' :
					sb.append("&#039;");
					break;
				case '"' :
					sb.append("&quot;");
					break;
				default :
					sb.append(c);
			}
		}
		return sb.toString();
	}

	/**
	 * 
	 * JSON string representation of this object
	 * 
	 * @return JSON String
	 */
	public String toJSON() {
		StringBuffer json = new StringBuffer();
		json.append("{\"GetReportRequestListResponse\" : {");
		json.append(quoteJSON("@xmlns"));
		json.append(" : ");
		json.append(quoteJSON("http://mws.amazonaws.com/doc/2009-01-01/"));
		boolean first = true;
		json.append(", ");
		if (isSetGetReportRequestListResult()) {
			if (!first)
				json.append(", ");
			json.append("\"GetReportRequestListResult\" : {");
			GetReportRequestListResult getReportRequestListResult = getGetReportRequestListResult();

			json.append(getReportRequestListResult.toJSONFragment());
			json.append("}");
			first = false;
		}
		if (isSetResponseMetadata()) {
			if (!first)
				json.append(", ");
			json.append("\"ResponseMetadata\" : {");
			ResponseMetadata responseMetadata = getResponseMetadata();

			json.append(responseMetadata.toJSONFragment());
			json.append("}");
			first = false;
		}
		json.append("}");
		json.append("}");
		return json.toString();
	}

	/**
	 * 
	 * Quote JSON string
	 */
	private String quoteJSON(String string) {
		StringBuffer sb = new StringBuffer();
		sb.append("\"");
		int length = string.length();
		for (int i = 0; i < length; ++i) {
			char c = string.charAt(i);
			switch (c) {
				case '"' :
					sb.append("\\\"");
					break;
				case '\\' :
					sb.append("\\\\");
					break;
				case '/' :
					sb.append("\\/");
					break;
				case '\b' :
					sb.append("\\b");
					break;
				case '\f' :
					sb.append("\\f");
					break;
				case '\n' :
					sb.append("\\n");
					break;
				case '\r' :
					sb.append("\\r");
					break;
				case '\t' :
					sb.append("\\t");
					break;
				default :
					if (c < ' ') {
						sb.append("\\u"
								+ String.format("%03x", Integer.valueOf(c)));
					} else {
						sb.append(c);
					}
			}
		}
		sb.append("\"");
		return sb.toString();
	}

	public void readFragmentFrom(MwsReader reader) {
		getReportRequestListResult = reader.read("GetReportRequestListResult",
				GetReportRequestListResult.class);
		responseMetadata = reader.read("ResponseMetadata",
				ResponseMetadata.class);
	}

	public void writeFragmentTo(MwsWriter writer) {
		writer.write("GetReportRequestListResult", getReportRequestListResult);
		writer.write("ResponseMetadata", responseMetadata);
	}

	public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
		return this.mwsResponseHeaderMetadata;
	}

	public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd) {
		this.mwsResponseHeaderMetadata = hmd;
	}

}
