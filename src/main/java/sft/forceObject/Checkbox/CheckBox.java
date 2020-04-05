package sft.forceObject.Checkbox;

import org.openqa.selenium.WebDriver;
import sft.forceObject.objField;
import sft.forceObject.Input.Input;

public class CheckBox extends Input{

	public CheckBox(objField field, WebDriver driver) {
		super(field, driver);
	}

	public void set(String value)
	{
		getWebElement().click();
	}

}
