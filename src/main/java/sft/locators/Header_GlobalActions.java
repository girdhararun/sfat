package sft.locators;

import sft.utils.Locator;

// user account actions, Like settings and notifications

public class Header_GlobalActions extends Locators_ObjectHeader {
    public static Locator notification_bell = new Locator(CSS, ".slds-global-actions button.unsNotificationsCounter");
}
