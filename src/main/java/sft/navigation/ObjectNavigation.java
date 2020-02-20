package sft.navigation;

import io.restassured.response.Response;
import sft.httpclient.GetRequest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ObjectNavigation {

    final Map<String, String> ObjectData = new HashMap<String, String>();
//    final String baseUrl = SftSetup.getSftSetup().get("domain_url");



    private Map<String, String>  getObjectLinks(){
        String endpoint = "tabs";
        GetRequest getRequest = new GetRequest();
        Response tabsData = getRequest.getResponseWithOauth(endpoint);
        List<String> navItem = tabsData.jsonPath().getList("appMenuItems.label");
        List<String> navItemContent =tabsData.jsonPath().getList("appMenuItems.name");
        Iterator<String> label = navItem.iterator();
        Iterator<String> labelContent = navItemContent.iterator();
        while (label.hasNext() && labelContent.hasNext()) ObjectData.put(label.next(), labelContent.next());
        return ObjectData;
    }
}
