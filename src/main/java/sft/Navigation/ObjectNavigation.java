package sft.Navigation;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.json.JSONArray;
import org.json.JSONObject;
import sft.httpclient.GetRequest;

public class ObjectNavigation {

    public void navigateObject(String sfObject){
        String result ="";
        String output = null;
        while ((result = getTabData()) != null) {
            output = result.replace("[", "").replace("]", "");

            JSONObject jsonObject = new JSONObject(output);
            JSONArray jsonArray = new JSONArray(output);
        }
        JSONObject obj = new JSONObject(output);
        JSONArray arr = obj.getJSONArray("posts");

        System.out.println("----"+arr.length());
    }

    private String getTabData(){
        String endpoint = "tabs";
        GetRequest getRequest = new GetRequest();
        String tabsData = getRequest.getRequestWithOauth(endpoint);
        DocumentContext jsonContext = JsonPath.parse(tabsData);


//        JSONParser parser = new JSONParser();
//        JSONObject json = (JSONObject) parser.parse(tabsData);
//        JSONObject tab = tabsData.
        String firstName = (String) tab.get("label");

        return firstName;
    }

    public static void main(String[] args){
        ObjectNavigation test = new ObjectNavigation();
        String testData =  test.getTabData();
        System.out.println(testData);
        test.navigateObject("");
    }
}
