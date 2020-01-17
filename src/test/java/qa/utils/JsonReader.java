package qa.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonReader 
{
	private String ojson="";
	private String filename;
	public JsonReader(String file_name)
	{
		filename = System.getProperty("user.dir")+File.separator+
				"src"+File.separator+
				"test"+File.separator+
				"java"+File.separator+
				"qa"+File.separator+
				"resources"+File.separator+
				file_name;
		ojson = readJson(filename);
	}
	
	
	public static void main(String []args) throws JsonProcessingException, IOException
	{
		JsonReader reader = new JsonReader("LeadData.json");
		System.out.println(reader.find("['Lead']['Lead Information']['Phone']"));
	}
	
	public Object find(String path)
	{
		DocumentContext jsonContext = JsonPath.parse(ojson);
		return jsonContext.read(path);
	}
	
	
	public JSONObject read_asJSONObject()
	{
		JSONObject jobj = new JSONObject(ojson);
		ojson = jobj.toString();
		return jobj;
	}
	
	public String read_asString()
	{
		return ojson;
	}
	
	private String readJson(String filename)
	{
		String line = "";
		StringBuffer json = new StringBuffer();
		System.out.println(filename);
		File file = new File(filename);
		FileReader file_reader=null;
		BufferedReader reader=null;
			
		try {
			file_reader = new FileReader(file);
			reader = new BufferedReader(file_reader);
			while( (line=reader.readLine())!=null )
			{
				json.append(line);
			}
			reader.close(); file_reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return json.toString();
	}
}
