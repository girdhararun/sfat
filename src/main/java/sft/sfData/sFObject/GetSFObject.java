package sft.sfData.sFObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import sft.httpclient.GetRequest;
import sft.sfData.sFObject.describeLayoutPOJO.SFVFDescription;

import java.io.IOException;

public class GetSFObject
{
	public static String getDescribeLayout(final String obj)
	{
		String endpoint = "sobjects" + "/" +obj+ "/" + "describe" + "/" + "layouts";
		GetRequest getRequest = new GetRequest();
		return getRequest.getResponseWithOauth(endpoint).getBody().asString();
	}
// SalesForce VisualForce
	public static SFVFDescription get(String obj)
	{
		SFVFDescription t = new SFVFDescription();
		ObjectMapper mapper = new ObjectMapper();
		try {
			t = mapper.readValue(getDescribeLayout(obj), SFVFDescription.class);
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
//		String res1 = lead.getLayouts().get(0).getEditLayoutSections().get(0).getHeading();
        String quickAction = lead.getLayouts().get(0).getQuickActionList().getQuickActionListItems().get(2).getLabel().toString();
        String quickActionURL = lead.getLayouts().get(0).getQuickActionList().getQuickActionListItems().get(2).getUrls().getDescribe();
	    System.out.println(quickAction+"---"+quickActionURL);
	}

}
