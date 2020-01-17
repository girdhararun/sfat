package qa.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

	//-------------------------------------------------------------Click functions start------------------------------------------------------------------------//
	
	protected void click(WebElement element)
	{
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		waitForPageToLoadCompletely();
	}
	
	protected void click(By locator)
	{
		WebElement element = driver.findElement(locator);
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

	protected void click_js(String locator)
	{
		executor = (JavascriptExecutor) driver;
		String script = "document.querySelector(\"html\").querySelector(\""+locator+"\").click()";
		executor.executeScript(script);
		waitForPageToLoadCompletely();
		hardwait(1);
	}

	//-------------------------------------------------------------Click functions end------------------------------------------------------------------------//

	
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
	
	
	protected List<JSONObject> fillCompleteForm(JSONObject complete, GetFields formField)
	{
		List<JSONObject> fieldsets = new ArrayList<JSONObject>();
		List<JSONObject> fields = new ArrayList<JSONObject>();
		
		Iterator<String> itr = complete.keys();
		while(itr.hasNext())
		{
			fieldsets.add(complete.getJSONObject(itr.next()));
		}
		
		for(JSONObject fieldset : fieldsets)
		{
			itr = fieldset.keys();
			while(itr.hasNext())
			{
				fields.add(fieldset.getJSONObject(itr.next()));
			}
		}
		
		for(JSONObject field : fields)
		{
			System.out.println(field.get("label") + "  " + field.get("value")); 
			formField.getObject(field.get("label").toString()).set(field.get("value").toString());
		}
		
		return fields;
	}
	
}
