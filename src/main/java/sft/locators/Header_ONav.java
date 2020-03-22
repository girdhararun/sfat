package sft.locators;

import sft.utils.Locator;

// Salesforce Object Navigation

public class Header_ONav extends Locators_ObjectHeader {
    public static Locator navigation_tab = new Locator(CSS,".oneAppNavContainer a[title='${tab}']");
}
