package sft.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SFBase 
{
	protected WebDriver driver = null;
	protected WebDriverWait wait=null;
	protected JavascriptExecutor executor=null;
	
	private int explicitWait = 30000;
	public SFBase(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver,explicitWait);
		executor = (JavascriptExecutor) driver;
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
	}
	
	protected void click(By locator)
	{
		WebElement element = driver.findElement(locator);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	protected void clickUsingJavaScript(WebElement element)
	{
		executor.executeScript("arguments[0].click()", element);
	}

	protected void click_js(String locator)
	{
		String script = "document.querySelector(\"html\").querySelector(\""+locator+"\").click()";
		executor.executeScript(script);
	}

	//-------------------------------------------------------------Click functions end------------------------------------------------------------------------//

	
	protected void send_keys(WebElement element, String k)
	{
		if(element != null)
		{
			element.clear(); element.sendKeys(k);
		}
	}

}
