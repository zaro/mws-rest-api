package co.amasel.client.common;

import co.amasel.ApiRequestParams;
import co.amasel.MwsJsonObjectWriter;
import co.amasel.misc.BeanAccess;
import co.amasel.misc.RuntimeConfiguration;
import co.amasel.model.common.AmaselMwsObject;
import com.amazonservices.mws.client.MwsObject;
import com.amazonservices.mws.client.MwsResponseHeaderMetadata;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zaro on 5/30/16.
 */
public class MwsApiResponse {
    static List<String> allowedContentTypes = Arrays.asList("application/octet-stream" , "text", "text/plain");

    public MwsResponseHeaderMetadata meta;
    public AmaselMwsObject response;
    public final MwsObject result;
    public final List<MwsObject> resultList;
    public final boolean isReport;
    public final Buffer rawResponse;
    public final boolean isXml;
    public final String contentType;
    public final String encoding;

    public JsonObject xmlReport;
    public JsonArray  tabReport;

    public String error;

    public MwsApiResponse(MwsResponseHeaderMetadata meta, String error) {
        this.meta = meta;
        this.error = error;
        this.response = null;
        this.result = null;
        this.resultList = null;
        this.isReport = false;
        this.rawResponse = null;
        this.contentType = null;
        this.isXml = false;
        this.encoding = "utf-8";
    }

    static Pattern charset = Pattern.compile("charset=(\\S+)");
    public MwsApiResponse(MwsResponseHeaderMetadata meta, AmaselMwsObject response, MwsObject result, List<MwsObject> resultList, boolean isReport, Buffer rawResponse, String contentType) {
        this.meta = meta;
        this.response = response;
        this.result = result;
        this.resultList = resultList;
        this.isReport =isReport;
        this.rawResponse = rawResponse;
        this.contentType = contentType;
        Matcher m = charset.matcher(contentType);
        if( m.find() ) {
            this.encoding = m.group(1);
        } else {
            this.encoding = "utf-8";
        }

        boolean isXml1;
        isXml1 = contentType.indexOf("text/xml") == 0;
        if(!isXml1){
            String bodyAsString = rawResponse.getString(0,5);
            if(allowedContentTypes.indexOf(contentType) >=0 ){
                isXml1 = bodyAsString.indexOf("<?xml") == 0;
            }
        }

        isXml = isXml1;
    }

    public MwsApiResponse(MwsResponseHeaderMetadata meta, boolean isReport, Buffer rawResponse, String contentType) {
        this(meta, null, null, null, isReport, rawResponse, contentType);
    }

    public boolean isArray(){
        if(response != null){
            return resultList != null;
        }
        return !isXml;
    }

    public JsonObject asJsonObject(ApiRequestParams params) {
        if(error != null) {
            JsonObject o = new JsonObject();
            o.put("error", error);
            return o;
        }
        if(result != null){
            MwsJsonObjectWriter out = new MwsJsonObjectWriter();
            result.writeFragmentTo(out);
            return  out.getJsonObject();
        }
        if(xmlReport!=null){
            return xmlReport;
        }
        String bodyAsString = rawResponse.toString();

        try {
            return xmlReport = AmaselXmlToJson.convert(bodyAsString);
        } catch (IOException | ParserConfigurationException | SAXException  e) {
            e.printStackTrace();
            JsonObject o = new JsonObject();
            o.put("error", e);
            return o;
        }
    }

    public JsonArray asJsonArray(ApiRequestParams params) {
        boolean toNumbers = params.numbers;
        if (resultList != null) {
            JsonArray arr = new JsonArray();
            for (MwsObject result : resultList) {
                MwsJsonObjectWriter out = new MwsJsonObjectWriter();
                result.writeFragmentTo(out);
                arr.add(out.getJsonObject());
            }
            return arr;
        }
        if(tabReport!=null){
            return tabReport;
        }
        tabReport = new JsonArray();
        CSVParser parser = null;
        try {
            String bodyAsString = rawResponse.toString(encoding);
            parser = CSVParser.parse(bodyAsString, CSVFormat.TDF);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (CSVRecord line : parser) {
            JsonArray row = new JsonArray();
            for(int i=0; i < line.size(); ++i){
                String column = line.get(i);
                if(toNumbers){
                    if(RuntimeConfiguration.isNumber.matcher(column).find()){
                        row.add(Float.valueOf(column));
                    } else {
                        row.add(column);
                    }
                } else {
                    row.add(column);
                }
            }
            tabReport.add(row);
        }

        return tabReport;
    }

    public Object asJsonObjectOrArray(ApiRequestParams params){
        if(isArray()){
            return asJsonArray(params);
        }
        return asJsonObject(params);
    }
}
