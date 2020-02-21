package sft.navigation;

import sft.auth.SftSetup;
import sft.sfApps.GetSFApps;
import sft.sfApps.describeAppsPOJO.App;
import sft.sfApps.describeAppsPOJO.Apps;
import sft.sfApps.describeAppsPOJO.NavItem;

import java.util.HashMap;
import java.util.Map;

public class AppNavigation {
    Map<String, String> appsId = new HashMap<String, String>();
    Map<String, String> appNavItemsLink = new HashMap<String, String>();
    final String baseUrl = SftSetup.getSftSetup().get("domain_url");
    final GetSFApps getAppData = new GetSFApps();
    Apps apps = new Apps();

    AppNavigation(){
        this.apps = getAppData.get();
    }

    public static void main(String[] args){
        AppNavigation test = new AppNavigation();
        System.out.println(test.apps.getApps().size());
        System.out.println(test.getAppLink("lightning","Marketing"));
    }

    private Map<String, String> getAppsId(){
        Map<String, String> appsId = new HashMap<String, String>();
        for(App app : apps.getApps()){
            appsId.put(app.getLabel(),app.getAppId());
        }
        return appsId;
    }

    private String getAppLink(String theme, String appLabel){
        appsId = getAppsId();
        return baseUrl+"/"+theme.toLowerCase()+"/app/"+appsId.get(appLabel);
    }

    private Map<String, String> getAppNavItemsLink(String appName){
        Map<String, String> appsId = new HashMap<String, String>();
        for (App app : apps.getApps()){
            if(app.getLabel().equalsIgnoreCase(appName)){
                for(NavItem navItem : app.getNavItems())
                    appNavItemsLink.put(navItem.getLabel(),navItem.getContent());
            }
        }
        return appNavItemsLink;
    }


}
