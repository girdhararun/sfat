package sft.ForceObject.Input;

import org.openqa.selenium.WebDriver;
import sft.ForceObject.SFField;
import sft.locators.Locators_Get;

public class EmailInput extends Input {

	public EmailInput(SFField field, WebDriver driver) {
		super(field, driver);
	}

	@Override
	public String get() {
		return webelementWithoutVisibility(Locators_Get.getEmail_ReferenceDetailUI,fieldName).getText();
	}
	
	
}
