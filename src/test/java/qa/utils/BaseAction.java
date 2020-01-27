package qa.utils;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import qa.resources.Config;
import qa.resources.locators.Locator;
import sft.GetFields;

import java.util.List;

public class BaseAction
{
	protected WebDriver driver = null;
	protected WebDriverWait wait = null;
	protected static int explicitWait = Config.explicittWait;
	protected JavascriptExecutor executor;
	
	public BaseAction(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver,explicitWait*1000);
		executor = (JavascriptExecutor) driver;
	}

	public void launchUrl(String url)
	{
		driver.navigate().to(url);
		waitForPageToLoadCompletely();
	}

	public String getPageTitle()
	{
		return driver.getTitle();
	}

	public void hardwait(int sec)
	{
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void send_keys(WebElement element, String k)
	{
		if(element != null)
		{
			element.clear(); element.sendKeys(k);
		}
	}

	public void waitForPageToLoadCompletely()
	{
		while(!executor.executeScript("return document.readyState").equals("complete"))
			hardwait(1);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("*")));
	}


	//-------------------------------------------------------------webelments and locators functions start------------------------------------------------------------------------//
	public WebElement webelement(Locator locator, String... replacements)
	{
		return driver.findElement(By.cssSelector("html")).findElement(getLocator(locator,replacements));
	}
	
	public List<WebElement> webelements(Locator locator,String... replacements)
	{	
		return driver.findElement(By.cssSelector("html")).findElements(getLocator(locator,replacements));
	}
	public By getLocator(Locator locator, String... replacements)
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

	public void click(WebElement element)
	{
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		waitForPageToLoadCompletely();
	}
	public void click(Locator locator, String... replacements)
	{
		WebElement element = webelement(locator,replacements);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		waitForPageToLoadCompletely();
		hardwait(2);
	}
	public void clickUsingJavaScript(WebElement element)
	{
		executor.executeScript("arguments[0].click()", element);
		waitForPageToLoadCompletely();
		hardwait(1);
	}
	//-------------------------------------------------------------Click functions end------------------------------------------------------------------------//

	public void fillCompleteForm(List<JSONObject> fields, GetFields formField)
	{
		for(JSONObject field : fields)
		{
			System.out.println(field.get("label") + "  " + field.get("value"));
			formField.getObject(field.getString("label")).set(field.getString("value"));
		}
	}
}
