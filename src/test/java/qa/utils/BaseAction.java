package qa.utils;

import java.util.List;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import qa.resources.locators.Locator;
import sft.GetFields;

public class BaseAction
{
	protected WebDriver driver = null;
	protected WebDriverWait wait = null;
	protected static int explicitWait = 30000;
	protected JavascriptExecutor executor;
	public BaseAction()
	{
		driver = new  WebDriverGenerator().getChromeDriver();
		wait = new WebDriverWait(driver,explicitWait);
		executor = (JavascriptExecutor) driver;
	}

	protected void launchUrl(String url)
	{
		driver.navigate().to(url);
		waitForPageToLoadCompletely();
	}

	public String getPageTitle()
	{
		return driver.getTitle();
	}

	protected void hardwait(int sec)
	{
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected void send_keys(WebElement element, String k)
	{
		if(element != null)
		{
			element.clear(); element.sendKeys(k);
		}
	}

	protected void waitForPageToLoadCompletely()
	{
		while(!executor.executeScript("return document.readyState").equals("complete"))
			hardwait(1);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("*")));
	}


	//-------------------------------------------------------------webelments and locators functions start------------------------------------------------------------------------//
	protected WebElement webelement(Locator locator, String... replacements)	//Done
	{
		return driver.findElement(By.cssSelector("html")).findElement(getLocator(locator,replacements));
	}
	
	protected List<WebElement> webelements(Locator locator,String... replacements)	//Done
	{	
		return driver.findElement(By.cssSelector("html")).findElements(getLocator(locator,replacements));
	}
	protected By getLocator(Locator locator, String... replacements)	//Done
	{
		By loc=null;
		for(String replacement : replacements)
			locator.value = locator.value.replaceFirst("\\$\\{.+?\\}", replacement);
		switch(locator.type)
		{
		case "css":
			loc = By.cssSelector(locator.value);	break;
		case "xpath":
			loc = By.xpath(locator.value);			break;
		case "id":
			loc = By.id(locator.value);				break;
		case "linktext":
			loc = By.linkText(locator.value);		break;
		}
		return loc;
	}
	//-------------------------------------------------------------webelments and locators functions end------------------------------------------------------------------------//

	//-------------------------------------------------------------Click functions start------------------------------------------------------------------------//

	protected void click(WebElement element)
	{
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		waitForPageToLoadCompletely();
	}
	protected void click(Locator locator, String... replacements)
	{
		WebElement element = webelement(locator,replacements);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		waitForPageToLoadCompletely();
		hardwait(1);
	}
	protected void clickUsingJavaScript(WebElement element)
	{
		executor.executeScript("arguments[0].click()", element);
		waitForPageToLoadCompletely();
		hardwait(1);
	}
	//-------------------------------------------------------------Click functions end------------------------------------------------------------------------//

	protected void fillCompleteForm(List<JSONObject> fields, GetFields formField)
	{
		for(JSONObject field : fields)
		{
			System.out.println(field.get("label") + "  " + field.get("value"));
			formField.getObject(field.getString("label")).set(field.getString("value"));
		}
	}

}