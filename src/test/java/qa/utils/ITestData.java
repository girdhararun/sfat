package qa.utils;

import java.util.Map;

public interface ITestData 
{
	public Map<String,String> getFieldset(String fieldset);	//Done
	public String getField(String path);
}
