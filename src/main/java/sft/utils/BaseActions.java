package sft.utils;

import org.json.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sft.GetFields;
import sft.navigation.AppNavigation;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class BaseActions {
    protected WebDriver driver = null;
    protected WebDriverWait wait = null;
    public  ConfigReader driverConfig = new ConfigReader(System.getProperty("user.dir") + File.separator + "autoSetup.json");
    protected  int explicitWait = Integer.parseInt(driverConfig.getSetupDetails().get("explicitWait"));
    protected JavascriptExecutor executor;

    public BaseActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, explicitWait * 1000);
        executor = (JavascriptExecutor) driver;
    }

    public void launchUrl(String url) {
        driver.navigate().to(url);
        waitForPageToLoadCompletely();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void hardwait(int sec) {
        try {
            Thread.sleep(sec * 1000);
            System.out.println("Waiting.....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void send_keys(WebElement element, String k) {
        if (element != null) {
            element.clear();
            element.sendKeys(k);
        }
    }

    public void waitForPageToLoadCompletely() {
        while (!executor.executeScript("return document.readyState").equals("complete"))
            hardwait(1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("*")));
        hardwait(1);
    }


    //-------------------------------------------------------------webelments and locators functions start------------------------------------------------------------------------//
    public WebElement webelement(Locator locator, String... replacements) {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("html")).findElement(getLocator(locator, replacements))));
    }

    public WebElement webelementWithoutVisibility(Locator locator, String... replacements) {
        return driver.findElement(By.cssSelector("html")).findElement(getLocator(locator, replacements));
    }

    public WebElement webelement(By locator) {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("html")).findElement(locator)));
    }

    public WebElement webelementWithoutVisibility(By locator) {
        return (driver.findElement(By.cssSelector("html")).findElement(locator));
    }

    public WebElement webelement(WebElement element, By locator) {
        return wait.until(ExpectedConditions.visibilityOf(element.findElement(locator)));
    }

    public WebElement webelementWithoutVisibility(WebElement element, By locator) {
        return (element.findElement(locator));
    }

    public List<WebElement> webelements(Locator locator, String... replacements) {
        return wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.cssSelector("html")).findElements(getLocator(locator, replacements))));
    }

    public List<WebElement> webelementsWithoutVisibility(Locator locator, String... replacements) {
        return driver.findElement(By.cssSelector("html")).findElements(getLocator(locator, replacements));
    }

    public List<WebElement> webelements(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.cssSelector("html")).findElements(locator)));
    }

    public List<WebElement> webelementsWithoutVisibility(By locator) {
        return (driver.findElement(By.cssSelector("html")).findElements(locator));
    }

    public By getLocator(Locator locator, String... replacements) {
        Locator temp = new Locator(locator);
        By loc = null;
        for (String replacement : replacements)
            temp.value = temp.value.replaceFirst("\\$\\{.+?\\}", replacement);
        switch (temp.type) {
            case "css":
                loc = By.cssSelector(temp.value);
                break;
            case "xpath":
                loc = By.xpath(temp.value);
                break;
            case "id":
                loc = By.id(temp.value);
                break;
            case "linktext":
                loc = By.linkText(temp.value);
                break;
        }
        return loc;
    }
    //-------------------------------------------------------------webelments and locators functions end------------------------------------------------------------------------//

    //-------------------------------------------------------------Click functions start------------------------------------------------------------------------//

    public void click(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        waitForPageToLoadCompletely();
    }

    public void click(Locator locator, String... replacements) {
        WebElement element = webelement(locator, replacements);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        waitForPageToLoadCompletely();

    }

    public void clickUsingJavaScript(WebElement element) {
        executor.executeScript("arguments[0].click()", element);
        waitForPageToLoadCompletely();
    }
    //-------------------------------------------------------------Click functions end------------------------------------------------------------------------//

    public void waitForVisibilityOfElement(Locator locator) {
        try {
            wait.until(ExpectedConditions.visibilityOf(webelement(locator)));
        } catch (StaleElementReferenceException e) {
            for (int i = 0; i < 5; i++) {
                if (webelement(locator).isDisplayed())
                    return;
                else
                    hardwait(3);
            }
            throw new StaleElementReferenceException("Stale element");
        }
    }

    public void fillCompleteForm(List<JSONObject> fields, GetFields formField) {
        for (JSONObject field : fields) {
            System.out.println(field.get("label") + "  " + field.get("value"));
            formField.getObject(field.getString("label")).set(field.getString("value"));
        }
    }

    public void fillFormByParts(Map<String, String> fields, GetFields formField) {
        for (Entry<String, String> field : fields.entrySet()) {
            System.out.println(field.getKey() + "  " + field.getValue());
            formField.getObject(field.getKey()).set(field.getValue());
        }
        hardwait(1);
    }

    //-----------------------navigation-----------------------
    public void navApp(String sfObject) {
        AppNavigation nav = new AppNavigation();
        launchUrl(nav.getAppNavLink("Sales"));
        waitForPageToLoadCompletely();
    }

    public void navObject(String sfObject) {
        AppNavigation nav = new AppNavigation();
        launchUrl(nav.getObjNavLink(sfObject));
        waitForPageToLoadCompletely();
    }
}
