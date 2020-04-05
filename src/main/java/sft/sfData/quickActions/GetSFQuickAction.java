package sft.sfData.quickActions;

import org.json.JSONArray;
import sft.httpclient.GetRequest;
import sft.sfData.BaseSFData;
import sft.sfData.quickActions.describeQuickActionsPOJO.AllActions;
import sft.sfData.quickActions.describeQuickActionsPOJO.Describe;

import java.util.HashMap;
import java.util.Map;

public class GetSFQuickAction {

    BaseSFData jsonMap = new BaseSFData();

    private JSONArray getQuickActionsData() {
        String endpoint = "quickActions";
        GetRequest getRequest = new GetRequest();
        String responseBody = getRequest.getResponseWithOauth(endpoint).getBody().asString();
        JSONArray responseArray = new JSONArray(responseBody);
        return responseArray;
    }

    private Map<String, String> getDescriptionLinks() {
        JSONArray actionsData = getQuickActionsData();
        Map<String, String> actionsURL = new HashMap<>();
        AllActions actions;
        for (Object actionData : actionsData) {
            actions = jsonMap.getDescriptionInstance(actionData.toString(), AllActions.class);
            actionsURL.put(actions.getLabel().toLowerCase(), actions.getUrls().getDescribe());
        }
        return actionsURL;
    }

    private String getActionData(String quickAction) {
        Map<String, String> actionsURLs;
        actionsURLs = getDescriptionLinks();
        String endpoint = null;
        try {
            endpoint = actionsURLs.get(quickAction.toLowerCase());
            if (endpoint.equalsIgnoreCase("null"))
                throw new NullPointerException();
        } catch (NullPointerException e) {
            System.out.println("Select from following actions only : ");
            for (Map.Entry<String, String> entry : actionsURLs.entrySet()) {
                    System.out.println(entry.getKey().toUpperCase() + " : " + entry.getValue());
            }
        }
        GetRequest getRequest = new GetRequest();
        endpoint = endpoint.split("quickActions")[1];
        String responseBody = getRequest.getResponseWithOauth("/quickActions"+endpoint).getBody().asString();
        return responseBody;
    }

    public Describe getAction(String quickAction){
        String actionData = getActionData(quickAction);
        Describe action = jsonMap.getDescriptionInstance(actionData, Describe.class);
        return action;
    }

    public static void main(String[] args) {
        GetSFQuickAction qAction = new GetSFQuickAction();
        qAction.getActionData("Log a Call");
    }

}
