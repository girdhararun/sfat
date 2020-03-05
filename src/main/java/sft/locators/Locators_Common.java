package sft.locators;

import sft.utils.Locator;

public class Locators_Common extends Locator {
    public static Locator pageHeading = new Locator(XPATH, "//nav[@aria-label='Breadcrumbs']//span[text()='${page}']");
    public static Locator newForm = new Locator(CSS, "a[title='New']");
    public static Locator formTitle = new Locator(CSS, "article h2");
    public static Locator saveForm = new Locator(CSS, "button[title='Save']");
    public static Locator newFormBearer = new Locator(CSS, "h1 lightning-formatted-name");
    public static Locator tabBar = new Locator(CSS, "lightning-tab-bar [title='${tab}']");
    public static Locator formDetailsActionToggle = new Locator(CSS, ".forceActionsContainer .slds-icon-utility-down");
    public static Locator formDetailsActionToggleActions = new Locator(CSS, "div[role='menu'] a[title='${action}']");
}
