package sft.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sft.utils.BaseActions;

import java.util.List;

public class getOneActions extends BaseActions {

    private Locators_ObjectHeader objectHeader = new Locators_ObjectHeader();

    public getOneActions(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void getAction(String action) {
        waitForPageToLoadCompletely();
        waitForVisibilityOfElement(objectHeader.action_ribbon);
        webelement(objectHeader.action_ribbon); //wait for header
        WebElement actionElement = getActionElement(action);
        if (actionElement != null)
            click(actionElement);
        else
            getMoreActionElements(action);
    }

    private WebElement getActionElement(String actions) {
        String title;
        List<WebElement> ulActions = webelements(objectHeader.actionRibbon_links);
        for (WebElement ulAction : ulActions) {
            title = ulAction.getAttribute("title");
            if (title.equalsIgnoreCase(actions))
                return ulAction;
        }
        return null;
    }

    private WebElement getMoreActionElements(String action){
        click(webelement(objectHeader.actionRibbon_dropDownLink));
        click(webelement(objectHeader.actionRibbon_moreActions,action));
        return null;
    }
}
