package sft.sfActions;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import sft.locators.Locators_ObjectHeader;
import sft.utils.BaseActions;

import java.util.List;

public class headerActions extends BaseActions {
    private WebDriver driver;

    public headerActions(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public WebElement getAction(String action) {
        try {
            List<WebElement> actions = webelements(Locators_ObjectHeader.action_ribbon);
            System.out.println(actions.size());
            for (WebElement forceAction : actions) {
                if (forceAction.getAttribute("title").equalsIgnoreCase(action)) ;
                return forceAction;
            }
        } catch (ElementNotVisibleException e) {
            Assert.fail("Unable to find action : " + action);
        }
        return null;
    }
}
