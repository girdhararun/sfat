package sft.locators;

import sft.utils.Locator;

public class Locators_Header extends Locator {
    public static Locator search_input = new Locator(CSS,".forceSearchDesktopHeader input.uiInput");
    public static Locator action_ribbon = new Locator(CSS,".forceActionLink");
}
