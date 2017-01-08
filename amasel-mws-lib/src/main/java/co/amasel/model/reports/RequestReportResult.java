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
 *         &lt;element name="ReportRequestInfo" type="{http://mws.amazonaws.com/doc/2009-01-01/}ReportRequestInfo"/>
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
@XmlType(name = "", propOrder = {"reportRequestInfo"})
@XmlRootElement(name = "RequestReportResult")
public class RequestReportResult extends AmaselMwsObject {

	@XmlElement(name = "ReportRequestInfo", required = true)
	protected ReportRequestInfo reportRequestInfo;

	protected MwsResponseHeaderMetadata mwsResponseHeaderMetadata;

	/**
	 * Default constructor
	 * 
	 */
	public RequestReportResult() {
		super();
	}

	/**
	 * Value constructor
	 * 
	 */
	public RequestReportResult(final ReportRequestInfo reportRequestInfo) {
		this.reportRequestInfo = reportRequestInfo;
	}

	/**
	 * Gets the value of the reportRequestInfo property.
	 * 
	 * @return possible object is {@link ReportRequestInfo }
	 * 
	 */
	public ReportRequestInfo getReportRequestInfo() {
		return reportRequestInfo;
	}

	/**
	 * Sets the value of the reportRequestInfo property.
	 * 
	 * @param value
	 *            allowed object is {@link ReportRequestInfo }
	 * 
	 */
	public void setReportRequestInfo(ReportRequestInfo value) {
		this.reportRequestInfo = value;
	}

	public boolean isSetReportRequestInfo() {
		return (this.reportRequestInfo != null);
	}

	/**
	 * Sets the value of the ReportRequestInfo property.
	 * 
	 * @param value
	 * @return this instance
	 */
	public RequestReportResult withReportRequestInfo(ReportRequestInfo value) {
		setReportRequestInfo(value);
		return this;
	}

	/**
	 * 
	 * XML fragment representation of this object
	 * 
	 * @return XML fragment for this object. Name for outer tag expected to be
	 *         set by calling method. This fragment returns inner properties
	 *         representation only
	 */
	public String toXMLFragment() {
		StringBuffer xml = new StringBuffer();
		if (isSetReportRequestInfo()) {
			ReportRequestInfo reportRequestInfo = getReportRequestInfo();
			xml.append("<ReportRequestInfo>");
			xml.append(reportRequestInfo.toXMLFragment());
			xml.append("</ReportRequestInfo>");
		}
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
	 * JSON fragment representation of this object
	 *
	 * @return JSON fragment for this object. Name for outer object expected to
	 *         be set by calling method. This fragment returns inner properties
	 *         representation only
	 *
	 */
	public String toJSONFragment() {
		StringBuffer json = new StringBuffer();
		boolean first = true;
		if (isSetReportRequestInfo()) {
			if (!first)
				json.append(", ");
			json.append("\"ReportRequestInfo\" : {");
			ReportRequestInfo reportRequestInfo = getReportRequestInfo();

			json.append(reportRequestInfo.toJSONFragment());
			json.append("}");
			first = false;
		}
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
		reportRequestInfo = reader.read("ReportRequestInfo",
				ReportRequestInfo.class);
	}

	public void writeFragmentTo(MwsWriter writer) {
		writer.write("ReportRequestInfo", reportRequestInfo);
	}

	public MwsResponseHeaderMetadata getMwsHeaderMetadata() {
		return null;
	}

	public void setMwsHeaderMetadata(MwsResponseHeaderMetadata hmd) {
	}

}
