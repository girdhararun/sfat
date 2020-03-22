package sft.locators;

import sft.utils.Locator;

// Object Header

public class Locators_ObjectHeader extends Locator {
    public static Locator search_input = new Locator(CSS,".forceSearchDesktopHeader input.uiInput");
    public static Locator action_ribbon = new Locator(CSS,".forceActionLink");
    public static Locator actionRibbon_links = new Locator(CSS,".oneActionsRibbon a");
    public static Locator actionRibbon_dropDownLink = new Locator(CSS,".oneActionsRibbon li[data-aura-class='oneActionsDropDown']>div>div a");
    public static Locator actionRibbon_moreActions = new Locator(CSS,".uiMenuItem a[title='${actionTitle}']");
}
