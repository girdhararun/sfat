package sft.SFObject;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import sft.SFObject.describeLayoutPOJO.SFVFDescription;
import sft.httpclient.GetRequest;

public class GetSFObject 
{
	public static String getDescribeLayout(final String obj)
	{
		String endpoint = "sobjects" + "/" +obj+ "/" + "describe" + "/" + "layouts";
		GetRequest getRequest = new GetRequest();
		return getRequest.getRequestWithOauth(endpoint);
	}

	public static SFVFDescription get(String obj)
	{
		SFVFDescription t = new SFVFDescription();
		ObjectMapper mapper = new ObjectMapper();
		try {
			t = mapper.readValue(GetSFObject.getDescribeLayout(obj), SFVFDescription.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return t;
	}

	//Testing
	public static void main(String []args)
	{
		SFVFDescription lead = GetSFObject.get("Lead");
		String res1 = lead.getLayouts().get(0).getEditLayoutSections().get(0).getHeading();
	}

}
