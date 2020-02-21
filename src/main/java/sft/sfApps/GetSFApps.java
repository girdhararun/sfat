package sft.sfApps;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import sft.httpclient.GetRequest;
import sft.sfApps.describeAppsPOJO.Apps;

import java.io.IOException;

public class GetSFApps {
    Apps apps = new Apps();

    private String getAppsData()
    {
        String endpoint = "ui-api/apps?formFactor=Large";
        GetRequest getRequest = new GetRequest();
        return getRequest.getResponseWithOauth(endpoint).getBody().asString();
    }

    public Apps get()
    {
        GetSFApps getSfApps = new GetSFApps();
        ObjectMapper mapper = new ObjectMapper();
        try {
            apps = mapper.readValue(getAppsData(), Apps.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return apps;
    }

    //Testing
    public static void main(String []args)
    {
        GetSFApps getSfApps = new GetSFApps();
        Apps apps = getSfApps.get();
        System.out.println(apps.getApps().get(1).getLabel());
    }
}
