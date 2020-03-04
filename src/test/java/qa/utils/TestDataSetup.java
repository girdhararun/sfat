package qa.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import sft.utils.JsonIO;

import java.io.IOException;
import java.util.*;

public class TestDataSetup implements ITestData {
    private List<JSONObject> fieldsets = new ArrayList<JSONObject>();
    private List<JSONObject> fields = new ArrayList<JSONObject>();
    private JSONObject data;
    private JsonIO rw;

    public TestDataSetup(String filename) {
        rw = new JsonIO(filename);
        data = rw.read_asJSONObject();
        process();
    }

    public Map<String, String> getFieldset(String fieldset)    //Done
    {
        Map<String, String> map = new HashMap<String, String>();
        JSONObject obj = (data.getJSONObject(fieldset));
        Iterator<String> itr = obj.keys();
        while (itr.hasNext()) {
            String item = itr.next();
            map.put(obj.getJSONObject(item).getString("label"), obj.getJSONObject(item).getString("value"));
        }
        return map;
    }

    public String getField(String path) {
        String str = rw.find(path).toString();
        if (!str.contains("{"))
            return str;
        return null;
    }

    public List<JSONObject> getFields() {
        return fields;
    }

    public List<JSONObject> getFieldsets() {
        return fieldsets;
    }

    public String getFieldValue(String fieldSet, String label) {
        return getFieldProperty(fieldSet, label, "value");
    }

    public String getFieldProperty(String fieldSet, String label, String property) {
        return ((JSONObject) ((JSONObject) data.get(fieldSet)).get(label)).getString(property);
    }

    public void updateDataValue(String fieldSet, String label, String value) {
        data.put(fieldSet, ((JSONObject) data.get(fieldSet)).put(label, ((JSONObject) ((JSONObject) data.get(fieldSet)).get(label)).put("value", value)));
    }

    public void updateTestData(JSONObject data) {
//        rw.writeToFile(data.toString());
    }

    public void process() {
        Iterator<String> itr = data.keys();
        while (itr.hasNext()) {
            fieldsets.add(data.getJSONObject(itr.next()));
        }

        for (JSONObject fieldset : fieldsets) {
            itr = fieldset.keys();
            while (itr.hasNext()) {
                fields.add(fieldset.getJSONObject(itr.next()));
            }
        }
    }

    public static <T> T getData(String filename, Class<T> value) {
        try {
            return new ObjectMapper().readValue(new JsonIO(filename).read_asString(), value);
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
        return null;
    }
}

