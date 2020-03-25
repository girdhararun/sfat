package sft.navigation;

import org.junit.Assert;
import sft.auth.SftSetup;
import sft.sfData.apps.GetSFApps;
import sft.sfData.apps.describeAppsPOJO.App;
import sft.sfData.apps.describeAppsPOJO.Apps;
import sft.sfData.apps.describeAppsPOJO.NavItem;

import java.util.HashMap;
import java.util.Map;

public class AppNavigation {
    Map<String, String> appsId = new HashMap<String, String>();
    Map<String, String> appNavItemsLink = new HashMap<String, String>();
    final String baseUrl = SftSetup.getSftSetup().get("domain_url");
    final GetSFApps getAppData = new GetSFApps();
    Apps apps = new Apps();

    public AppNavigation() {
        this.apps = getAppData.get();
    }

    public static void main(String[] args) {
        AppNavigation test = new AppNavigation();
        System.out.println(test.apps.getApps().size());
//        System.out.println(test.getAppLink("lightning", "Marketing"));
//        System.out.println(test.getAppNavItemsLink("Marketing").get("Leads"));
    }

    private Map<String, String> getAppsId() {
        Map<String, String> appsId = new HashMap<String, String>();
        for (App app : apps.getApps()) {
            appsId.put(app.getLabel(), app.getAppId());
        }
        return appsId;
    }

    private String getAppLink(String theme, String appLabel) {
        appsId = getAppsId();
        return baseUrl + "/" + theme.toLowerCase() + "/app/" + appsId.get(appLabel);
    }

    private Map<String, String> getAppNavItemsLink(String appName) {
        Map<String, String> appsId = new HashMap<String, String>();
        for (App app : apps.getApps()) {
            if (app.getLabel().equalsIgnoreCase(appName)) {
                {
                    if (app.getSelected())
                        for (NavItem navItem : app.getNavItems()) {
                            appNavItemsLink.put(navItem.getLabel(), navItem.getContent());
                            System.out.println(navItem.getLabel() + " -- " + navItem.getContent());
                        }
                    else
                        Assert.assertFalse("Application is not selected for API user", true);
                }
            }
        }
        return appNavItemsLink;
    }

    public String getObjNavLink(String sfObject) {
        return getAppNavItemsLink("Sales").get(sfObject);
    }

    public String getAppNavLink(String sfApp) {
        return getAppLink("Lightning", sfApp);
    }
}
