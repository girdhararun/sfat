package sft.SFObject;

import sft.httpclient.GetRequest;

public class GetSFObject 
{
	
	public static String getDescribeLayout(final String obj)
	{
		String endpoint = "sobjects" + "/" +obj+ "/" + "describe" + "/" + "layouts";
		GetRequest getRequest = new GetRequest();
		return getRequest.getRequestWithOauth(endpoint);
	}
	
	
	//Testing
	public static void main(String []args)
	{
		String res = GetSFObject.getDescribeLayout("Lead");
		System.out.println(res);
	}
	
}
