package qa.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONObject;

public class TestDataSetup
{
	private List<JSONObject> fieldsets = new ArrayList<JSONObject>();
	private List<JSONObject> fields = new ArrayList<JSONObject>();
	private JSONObject data;
	public TestDataSetup(String filename)
	{
		 data  = new JsonReader(filename).read_asJSONObject();
		 process();
	}
	
	public  List<JSONObject> getFields()
	{
		return fields;
	}
	
	public  List<JSONObject> getFieldsets()
	{
		return fieldsets;
	}
	
	public String getFieldValue(String label)
	{
		for(JSONObject field : fields)
		{
			if(field.getString("label").equals(label))
				return field.getString("value");
		}
		return null;
	}
	
	
	public void process()
	{
		Iterator<String> itr = data.keys();
		while(itr.hasNext())
		{
			fieldsets.add(data.getJSONObject(itr.next()));
		}
		
		for(JSONObject fieldset : fieldsets)
		{
			itr = fieldset.keys();
			while(itr.hasNext())
			{
				fields.add(fieldset.getJSONObject(itr.next()));
			}
		}
	}
}
