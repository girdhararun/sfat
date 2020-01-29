package sft.utils;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonFind 
{
	protected String ojson="";
	
	public JsonFind() {}
	
	public JsonFind(Object json)
	{
		ojson = (String) json;
	}
	
	
	public Object find(String path)
	{
		DocumentContext jsonContext = JsonPath.parse(ojson);
		return jsonContext.read(path);
	}
}
