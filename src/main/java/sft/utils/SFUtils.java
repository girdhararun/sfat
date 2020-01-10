package sft.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SFUtils 
{
	private WebDriver driver = null;
	WebDriverWait wait=null;
	
	public SFUtils(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver,30000);
	}
	
	protected void hardwait(int sec)
	{
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	protected void click(By locator)
	{
		WebElement element = driver.findElement(locator);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}
	
	protected void click_js(String locator)
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		String script = "document.querySelector(\"html\").querySelector(\""+locator+"\").click()";
		executor.executeScript(script);
	}

	protected void writeToFile(String s, String filename)
	{
		File file = new File(filename);
		FileWriter filewriter;
		try {
			filewriter = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(filewriter);
			writer.write(s);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	protected void send_keys(WebElement e, String k)
	{
		if(e != null)
			e.sendKeys(k);
	}

}
