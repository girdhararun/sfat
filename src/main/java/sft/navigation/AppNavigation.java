package sft.navigation;

import io.restassured.response.Response;
import sft.auth.SftSetup;
import sft.httpclient.GetRequest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AppNavigation {
    final Map<String, String> appsId = new HashMap<String, String>();
    final String baseUrl = SftSetup.getSftSetup().get("domain_url");



    private String getObjectLinks(){
        String endpoint = "tabs";
        GetRequest getRequest = new GetRequest();
        Response tabsData = getRequest.getResponseWithOauth(endpoint);
        return null;
    }

    public static void main(String[] args){
        AppNavigation test = new AppNavigation();
        test.getAppsId();
        System.out.println(test.appsId.get("Sales"));
    }


    private Map<String, String> getAppsId(){
        String endpoint = "appMenu/AppSwitcher";
        GetRequest getRequest = new GetRequest();
        Response appData = getRequest.getResponseWithOauth(endpoint);
        List<String> navItem = appData.jsonPath().getList("appMenuItems.label");
        List<String> navItemContent =appData.jsonPath().getList("appMenuItems.name");
        Iterator<String> label = navItem.iterator();
        Iterator<String> labelContent = navItemContent.iterator();
        while (label.hasNext() && labelContent.hasNext()) appsId.put(label.next(), labelContent.next());
        return appsId;
    }

}
