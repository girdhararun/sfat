package qa;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import sft.SFObject.GetSFObject;
import sft.SFObject.describeLayoutPOJO.SFVFDescription;

public class AppTest 
{
	
	public static void main(String []args)
	{
		SFVFDescription t = new SFVFDescription();
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			t = mapper.readValue(GetSFObject.getDescribeLayout("Lead"), SFVFDescription.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(t.getLayouts().get(0).getEditLayoutSections().get(0).getHeading());
	}
	
}
