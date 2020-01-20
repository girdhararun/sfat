package qa.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonIO 
{
	private String ojson="";
	private File file;
	public JsonIO(String file_name)
	{
		String filepath = System.getProperty("user.dir")+File.separator+
				"src"+File.separator+
				"test"+File.separator+
				"java"+File.separator+
				"qa"+File.separator+
				"resources"+File.separator+
				file_name;
		file = new File(filepath);
		ojson = readJson();
	}
	
	
	public static void main(String []args)
	{
		JsonIO reader = new JsonIO("LeadData.json");
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
	
	private String readJson()
	{
		String line = "";
		StringBuffer json = new StringBuffer();
		BufferedReader reader=null;
		try {
			reader = new BufferedReader(new FileReader(file));
			while( (line=reader.readLine())!=null )
				json.append(line);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json.toString();
	}
	
	public void writeToFile(String json)
	{
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			 writer.write(json);
			 writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
