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
	private JsonIO rw;
	public TestDataSetup(String filename)
	{
		 rw = new JsonIO(filename);
		 data = rw.read_asJSONObject();
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
	
	public String getFieldValue(String fieldSet , String label)
	{
		return ((JSONObject)((JSONObject)data.get(fieldSet)).get(label)).getString("value");
	}
	public void updateFieldValue(String fieldSet , String label, String value)
	{
		data.put(fieldSet, ((JSONObject)data.get(fieldSet)).put(label, ((JSONObject)((JSONObject)data.get(fieldSet)).get(label)).put("value", value)));
		rw.writeToFile(data.toString());
	}
	
	//No need: keep it for internal efficiency for getFieldValue(String label)
	// may remove after changing the fill complete form logic : AKASH VERMA
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
