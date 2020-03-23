package sft.locators;

import sft.utils.Locator;

public class Locators_Modal extends Locator {

    static String modal = ".isModal";
    static String ModalContainer = ".modal-container";
    static String closeIcon = ".closeIcon";
    public static Locator modalContainer = new Locator(CSS,ModalContainer);
    public static Locator headingH2 = new Locator(CSS,ModalContainer+" h2");
    public static Locator close = new Locator(CSS,ModalContainer+" "+closeIcon);
}
