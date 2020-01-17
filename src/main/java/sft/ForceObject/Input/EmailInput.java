package sft.ForceObject.Input;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import sft.ForceObject.SFField;

public class EmailInput extends Input {

	public EmailInput(SFField field, WebDriver driver) {
		super(field, driver);
	}

	@Override
	public String get() {
		WebElement textNode = null;
		textNode = driver.findElement(By.xpath(span + "//a"));
		return textNode.getText();
	}
	
	
}
