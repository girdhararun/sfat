package sft.locators;

import sft.utils.Locator;

public class Header_ONav extends Locators_Header{
    public static Locator navigation_tab = new Locator(CSS,".oneAppNavContainer a[title='${tab}']");
}
