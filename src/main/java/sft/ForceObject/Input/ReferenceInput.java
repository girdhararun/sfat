package sft.ForceObject.Input;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import sft.SFField;

public class ReferenceInput extends Input{

	public ReferenceInput(SFField field, WebDriver driver) {
		super(field, driver);
	}
	
	public void set(String value) 
	{
		WebElement referenceInput = getWebElement();
		referenceInput.sendKeys(value);
		hardwait(1);
		referenceInput.sendKeys(Keys.ARROW_DOWN);
		hardwait(1);
		referenceInput.sendKeys(Keys.ENTER);
		hardwait(1);
	}
	
}
