package sft.ForceObject.Checkbox;

import org.openqa.selenium.WebDriver;
import sft.ForceObject.SFField;
import sft.ForceObject.Input.Input;

public class CheckBox extends Input{

	public CheckBox(SFField field, WebDriver driver) {
		super(field, driver);
	}

	public void set(String value) 
	{
		getWebElement().click();
	}

}
